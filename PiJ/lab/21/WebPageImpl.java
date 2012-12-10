import java.util.*;
import java.net.*;
import java.io.*;

public class WebPageImpl implements WebPage{
	private URL url = null;
	private Set<String> links = null;
	private Set<String> emails = null;
	
	public WebPageImpl(String url) throws MalformedURLException, IOException{
		this.url = new URL(url);
		this.links = new HashSet<String>();
		this.emails = new HashSet<String>();
		extractLinks();
		extractEmails();
	}

	public String getUrl(){
		return this.url.toString();
	}
	
	public Set<String> getLinks(){
		return Collections.unmodifiableSet(this.links);
	}
	
	public Set<String> getEmails(){
		return Collections.unmodifiableSet(this.emails);
	}
	
	private void extractLinks() throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(this.url.openStream()));
		String line = null;
		String link = "";
		boolean inURL = false;
		int pos1 = 0;
		int pos2 = 0;
		
		while ((line = in.readLine()) != null) {		
			if(inURL){
				if((pos2 = line.indexOf(URL_END)) != -1){ //url finishes within same line
					//this.links.add(link + line.substring(0, pos2));
					this.links.add(refineQuotedURL(link + line.substring(0, pos2)));
					inURL = false;
					link = "";
				}
				else{
					link += line;
				}
			}
			
			if(!inURL && (pos1 = line.indexOf(URL_START)) != -1){
				pos1 += URL_START.length(); 
				//System.out.print(pos1); //debug
				if((pos2 = line.substring(pos1).indexOf(URL_END)) != -1){ //url finishes within same line
					//System.out.println("pos2 " + pos2); //debug
					//this.links.add(line.substring(pos1, pos1+pos2));
					this.links.add(refineQuotedURL(line.substring(pos1, pos1+pos2)));
				}
				else{
					inURL = true;
					link += line.substring(pos1);
				}
			}
		}
	}
	
	private void extractEmails() throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(this.url.openStream()));
	}
	
	private String refineQuotedURL(String quoted){
		int pos1, pos2;
		pos1 = quoted.indexOf("\"") + 1;
		pos2 = pos1 + quoted.substring(pos1).indexOf("\"");
		return quoted.substring(pos1, pos2);
	}
	
	//test
	public static void main(String[] args){
		String addr = "http://www.dcs.bbk.ac.uk/~peng/";
		try{
			WebPageImpl page = new WebPageImpl(addr);
			System.out.println(page.getUrl());
			System.out.println(page.getLinks());
		} catch(MalformedURLException e){
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}
	}
}