import java.net.URI;
import java.net.URL;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import java.io.Reader;
import java.io.InputStreamReader;
import java.io.IOException;

import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTML.Attribute;
import javax.swing.text.html.HTML.Tag;
import javax.swing.text.AttributeSet;
import javax.swing.text.Element;
import javax.swing.text.ElementIterator;
import javax.swing.text.StyleConstants;
import javax.swing.text.BadLocationException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A class to analyze web pages and retrieve the 
 * emails addresses and the links to other pages. 
 */
public final class WebAnalyzer
{
	/**
         * A regular expression to identify email addresses
         */
	private final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	/**
         * The URL of the page
         */
	private URL url;

        /**
         * A representation of the HTML code of the page
         */
	private HTMLDocument document;

	/**
         * A new WebAnalyzer.
         * 
         * @param url the URL of the page to analyze
         * 
         * @throws MalformedURLException if the URL is not well formed
         * @throws BadLocationException if there are problems at the back-end
         * @throws IOException if there is other kind I/O problems
         */
	public WebAnalyzer(String url) throws MalformedURLException,IOException, BadLocationException 
	{
		this.url=new URL(url);
		document=getHTMLDocument();
	}

	public String getUrl() {
		return url.toString();
	}	

	private HTMLDocument getHTMLDocument() throws IOException, BadLocationException
	{
		HTMLEditorKit kit=new HTMLEditorKit(); 
		HTMLDocument document=(HTMLDocument) kit.createDefaultDocument(); 
		document.putProperty("IgnoreCharsetDirective", Boolean.TRUE);
		Reader reader=new InputStreamReader(url.openStream()); 
		kit.read(reader, document, 0);

		return document;		
	}

        /**
         * Returns the links pointing to other pages. 
         *	
         * @return the links pointing to other pages. 
         *	
         */
	public Set<String> getLinks()
	{
		Set<String> result=new HashSet<String>();

		for (HTMLDocument.Iterator iterator=document.getIterator(Tag.A);iterator.isValid();iterator.next())
		{
			AttributeSet attributes=iterator.getAttributes();
			String href=(String)attributes.getAttribute(Attribute.HREF);
			href=buildAbsoluteURL(href);

			if(!href.equals("") && !href.startsWith("javascript"))
			{
				result.add(href);
			}
		}

		return result;
	}

        /**
         * Returns the email addresses in this page
         *	
         * @return the email addresses in this page
         *	
         */
	public Set<String> getEmails()
	{
		Set<String> result=new HashSet<String>();

		ElementIterator iterator=new ElementIterator(document); 
		Element element; 
    
		while((element=iterator.next())!=null)
		{
			AttributeSet attributes=element.getAttributes();
			Object name=attributes.getAttribute(StyleConstants.NameAttribute);

			if (name instanceof Tag)
			{
				StringBuffer buffer=new StringBuffer();
				int count=element.getElementCount();
        
				for (int i=0; i<count; i++)
				{
					Element child=element.getElement(i);
					AttributeSet childAttributes=child.getAttributes();

					if (childAttributes.getAttribute(StyleConstants.NameAttribute)==Tag.CONTENT)
					{
						int startOffset = child.getStartOffset();
						int endOffset = child.getEndOffset();
						int length = endOffset - startOffset;

						try
						{
							buffer.append(document.getText(startOffset, length));
						}
						catch(BadLocationException e)
						{
							e.printStackTrace();
						}
					}
				}

				Pattern pattern=Pattern.compile(EMAIL_PATTERN);
				StringTokenizer tokenizer=new StringTokenizer(buffer.toString());

				while(tokenizer.hasMoreTokens())
				{
					String token=tokenizer.nextToken();
					Matcher matcher=pattern.matcher(token);

					if(matcher.matches())
					{
						result.add(token);
					}
				}
			}
		}

		return result;
	}

	private String buildAbsoluteURL(String href)
	{
		URI uri=null;

		try
		{
			uri=new URI(href);
		}
		catch(URISyntaxException e)
		{
			System.err.println("URI syntax problem: " + href);
			return "";
		}
		catch(Exception e)
		{
			System.err.println("URI problem: " + href);
			return "";
		}

		if(uri.isAbsolute())
		{
			return href;
		}

		String newUrl="";
		newUrl+=url.getProtocol()+"://";	
		newUrl+=url.getAuthority();

		String path=url.getPath();
		int position=path.lastIndexOf('/')+1;
		path=path.substring(0,position);

		if(path.equals(""))
		{
			newUrl+="/";
		}
		else
		{
			newUrl+=path;
		}

		return newUrl+href;
	}

	public static void main(String args[]) throws Exception {
		WebAnalyzer wa = new WebAnalyzer("http://www.bbk.ac.uk");
                /*for (String s : wa.getEmails()) 
 			System.out.println("email: " + s);*/
                for (String s : wa.getLinks()) 
 			System.out.println("Link: " + s);
        }
}