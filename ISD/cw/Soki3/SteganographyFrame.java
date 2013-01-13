import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.JOptionPane;

import javax.imageio.ImageIO;

import java.awt.GridLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.IOException;

public class SteganographyFrame extends JFrame
{
	private static final int IMG_WIDTH=250;
	private static final int IMG_HEIGHT=350;
	private SteganImage si = null; //Do not store your buffered image reference here.
	private JPanel leftPanel;
	private ImagePanel rightPanel;
	private JButton btnLoad;
	private JButton btnSave;
	private JButton btnEncode;
	private JButton btnDecode;
	private JTextField tfdMessage;
	private static JFileChooser selectfile;

	public SteganographyFrame()
	{		
		//Splits the frame vertically. Left hand side is
		setLayout(new GridLayout(1, 2));

		//for your components, right hand side is for the image
		leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout(5, 1));
		rightPanel = new ImagePanel();
		add(leftPanel); // add all your components to this panel
		add(rightPanel); // This panel is used to display the image

		ActionListener listener = new ClickListener();

		btnLoad = new JButton("load image file");
		btnLoad.addActionListener(listener);
		leftPanel.add(btnLoad);
		
		btnSave = new JButton("save image file");
		btnSave.addActionListener(listener);
		leftPanel.add(btnSave);		
		
		btnEncode = new JButton("encode message");
		btnEncode.addActionListener(listener);
		leftPanel.add(btnEncode);

		btnDecode = new JButton("decode message");
		btnDecode.addActionListener(listener);
		leftPanel.add(btnDecode);

		tfdMessage=new JTextField("type your message",20);
		tfdMessage.setHorizontalAlignment(JTextField.CENTER);
		tfdMessage.addActionListener(listener);
		leftPanel.add(tfdMessage);
	}
	
	static
	{
		initFileChooser();
	}
	
	private static void initFileChooser()
	{
		selectfile= new JFileChooser(".");
		ImageFilter filter = new ImageFilter();
		selectfile.setFileSelectionMode(JFileChooser.FILES_ONLY);
		selectfile.setFileFilter(filter);
	}
	
	public static File LoadDialog()
	{
		File f = null;
		int returnVal = selectfile.showOpenDialog(null);

		if (returnVal==JFileChooser.APPROVE_OPTION)
		{
			f = selectfile.getSelectedFile();
		}

		return f;
	}

	public static File SaveDialog()
	{
		File f = null;
		int returnVal = selectfile.showSaveDialog(null);

		if (returnVal==JFileChooser.APPROVE_OPTION)
		{
			f = selectfile.getSelectedFile();
		}

		return f;
	}
	
	public class ClickListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if(event.getSource()==tfdMessage)
			{
				String text=tfdMessage.getText();
				boolean invalid=false;
				
				invalid=invalid||text.indexOf(']')!=-1;
				invalid=invalid||text.indexOf('[')!=-1;
				
				if(invalid)
				{
					JOptionPane.showMessageDialog(null,"characters [ and ] are not allowed as part of the message!","invalid input",JOptionPane.ERROR_MESSAGE);
					System.out.println("characters [ and ] are not allowed as part of the message!");
					text=text.replace("[", " ");
					text=text.replace("]", " ");
				}
				
				tfdMessage.setText(text);
			}

			if(event.getSource()==btnEncode)
			{
				String message=tfdMessage.getText();
				
				if(message.equals(""))
				{
					JOptionPane.showMessageDialog(null,"no message to encode","warning",JOptionPane.WARNING_MESSAGE);
					System.out.println("no message to encode");
					return;
				}
				
				if(si==null)
				{
					JOptionPane.showMessageDialog(null,"no image available","warning",JOptionPane.WARNING_MESSAGE);
					System.out.println("no image available");
					return;
				}

				System.out.println("Message to be encoded:"+message);
				
				si.encode(message);
				JOptionPane.showMessageDialog(null,"encoding completed");
			}

			if(event.getSource()==btnDecode)
			{
				String message=si.decode();
				
				if(message.equals(""))
				{
					JOptionPane.showMessageDialog(null,"no message exists in the image");
					System.out.println("no message exists in the image");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"The message is: " + message);
					System.out.println("The message is: " + message);
				}			
			}
			
			if(event.getSource()==btnLoad)
			{
				File f = LoadDialog();
				
				if(f==null)
				{
					JOptionPane.showMessageDialog(null,"no file selected for opening!","warning",JOptionPane.WARNING_MESSAGE);
					System.out.println("no file selected for opening!");
					return;
				}
				
				try
				{
					BufferedImage bi = ImageIO.read(f);
					
					if(bi.getType()==BufferedImage.TYPE_4BYTE_ABGR)
					{
						si=new StegColour(bi);
					}

					if(bi.getType()==BufferedImage.TYPE_BYTE_GRAY)
					{
						si=new StegGrey(bi);
					}

					repaint();
				}
				catch (IOException e)
				{
					JOptionPane.showMessageDialog(null,"cannot read from selected file","warning",JOptionPane.WARNING_MESSAGE);
					System.out.println("cannot read file");
					return;
				}
			}
			
			if(event.getSource()==btnSave)
			{
				File f = SaveDialog();
				
				if(f==null)
				{
					JOptionPane.showMessageDialog(null,"no file selected for saving!","warning",JOptionPane.WARNING_MESSAGE);
					System.out.println("no file selected for saving!");
					return;
				}
				
				try
				{
					BufferedImage bi=si.getImage();
					ImageIO.write(bi, "png", f);
					JOptionPane.showMessageDialog(null,"save operation completed");
				}
				catch (IOException e)
				{
					JOptionPane.showMessageDialog(null,"cannot write to selected file","warning",JOptionPane.WARNING_MESSAGE);
					System.out.println("cannot write file");
					return;
				}
			}
		}
	}

	class ImagePanel extends JPanel
	{
		//This method needs to access the image, in order to display it.
		//You will need to edit this method so that it can access the reference
		// to the buffered image from wherever you have placed the object reference
		// in your code!
		// Your image will only appear on screen when a repaint event occurs. You can force
		// a repaint by using the command repaint();
		public void paintComponent(Graphics g)
		{
			if(si==null)
			{
				return;
			}
			
			BufferedImage bi=si.getImage();
			
			if (bi != null)
			{
				BufferedImage resized=resizeImage(bi);
				g.drawImage(resized, 0, 0,null);
			}
		}
		
		private BufferedImage resizeImage(BufferedImage original)
		{
			BufferedImage resized = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, original.getType());
			Graphics2D g = resized.createGraphics();
			g.drawImage(original, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
			g.dispose();
 
			return resized;
		}	
	}
	
	static class ImageFilter extends FileFilter
	{
		public boolean accept(File f)
		{
			if (f.isDirectory())
			{
				return true;
			}

			String extension = getExtension(f);
			if (extension != null)
			{
				if (extension.equals("png"))
				{
					return true;
				}
				else
				{
					return false;
				}
			}

			return false;
		}
	
		public static String getExtension(File f)
		{
			String ext = null;
			String s = f.getName();
			int i = s.lastIndexOf('.');

			if (i > 0 &&  i < s.length() - 1) {
				ext = s.substring(i+1).toLowerCase();
			}
			return ext;
		}

		//The description of this filter
		public String getDescription()
		{
			return "PNG Images";
		}
	}
}