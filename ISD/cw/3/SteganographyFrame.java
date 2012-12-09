import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.*;
import java.awt.GridLayout;
import java.awt.Graphics;
import java.io.File;
import java.awt.event.*;
import javax.imageio.*;
import java.io.IOException;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.image.*; // required for buffered image

public class SteganographyFrame extends JFrame{
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 350;
	private BufferedImage bi = null; //Do not store your buffered image reference here.
	private SteganImage image; //colour or grey
	private JPanel panel;
	private ImagePanel panel2;
	private JButton loadButton, saveButton, insertButton, readButton;
	private	JTextArea inputArea, outputArea;
	private JScrollPane inputScrollPane, outputScrollPane;
	private JLabel info;
	public SteganographyFrame()
	{
		this.setSize(FRAME_WIDTH,FRAME_HEIGHT);
		//for your components, right hand side is for the image
		panel = new JPanel();
		panel.setLayout(new GridLayout(7, 2));
		panel2 = new ImagePanel();
		loadButton = new JButton("Load / \u52A0\u8F7D");
		saveButton = new JButton("Save / \u4FDD\u5B58");
		insertButton = new JButton("Insert / \u5199\u5165");
		readButton = new JButton("Read / \u8BFB\u53D6");
		this.loadButton.addActionListener(new ClickLoadButton());
		this.saveButton.addActionListener(new ClickSaveButton());
		this.insertButton.addActionListener(new ClickInsertButton());
		this.readButton.addActionListener(new ClickReadButton());
		this.inputArea = new JTextArea(2,10);
		this.inputArea.setLineWrap(true);
		this.outputArea = new JTextArea(2,10);
		this.outputArea.setLineWrap(true);
		this.outputArea.setEditable(false);
		this.inputScrollPane = new JScrollPane(inputArea);
		this.outputScrollPane = new JScrollPane(outputArea);
		this.info = new JLabel();
		
		this.panel.add(loadButton); this.panel.add(saveButton);
		this.panel.add(insertButton); this.panel.add(readButton);
		this.panel.add(new JLabel("Message to insert / \u8F93\u5165\u4FE1\u606F")); this.panel.add(inputScrollPane);
		this.panel.add(new JSeparator(SwingConstants.HORIZONTAL));
		this.panel.add(new JSeparator(SwingConstants.HORIZONTAL));
		this.panel.add(new JLabel("Retrieved message /  \u8BFB\u5F97\u4FE1\u606F"));  this.panel.add(outputScrollPane);
		this.panel.add(new JSeparator(SwingConstants.HORIZONTAL));
		this.panel.add(new JSeparator(SwingConstants.HORIZONTAL));
		this.panel.add(new JLabel("<html>Status<br>\u72B6\u6001</html>", SwingConstants.LEFT));
		this.panel.add(info);
		
		this.panel.setBorder(new TitledBorder(new EtchedBorder(), "Control Area"));
		this.panel2.setBorder(new TitledBorder(new EtchedBorder(), "Display Area"));
		setLayout(new GridLayout(1, 2)); //Splits the frame vertically. Left hand side is
		add(panel2); // This panel is used to display the image
		add(panel); // add all your components to this panel
	}
	
	class ImagePanel extends JPanel{
		//This method needs to access the image, in order to display it.
		//You will need to edit this method so that it can access the reference
		// to the buffered image from wherever you have placed the object reference
		// in your code!
		// Your image will only appear on screen when a repaint event occurs. You can force
		// a repaint by using the command repaint();
		public void paintComponent(Graphics g){
			if (bi != null){
				g.drawImage(bi,0,0,getWidth(),getHeight(),null);
			}
			else{
				info.setText("<html>no loaded image<br>\u65E0\u56FE\u7247</html>");
			}
		}
	}
	
	class ClickLoadButton implements ActionListener{
		public void actionPerformed(ActionEvent event){
			try{
				bi = ImageIO.read(LoadDialog());
				repaint();
				if(bi.getType() == BufferedImage.TYPE_BYTE_GRAY){
					image = new StegGrey(bi);
				}
				else{ //TYPE_4BYTE_ABGR
					image = new StegColour(bi);
				}
			} catch(IllegalArgumentException e){
				info.setText("<html>none selected<br>\u672A\u52A0\u8F7D\u56FE\u7247</html>");
				JOptionPane.showMessageDialog(panel,"none selected / \u672A\u52A0\u8F7D\u56FE\u7247");
				//e.printStackTrace();
			} catch(IOException e){
				e.printStackTrace();
			}
		}
	}

	class ClickSaveButton implements ActionListener{
		public void actionPerformed(ActionEvent event){
			try{
				image.saveImage(SaveDialog());
				info.setText("<html>image saved<br>\u56FE\u7247\u5DF2\u4FDD\u5B58</html>");
				JOptionPane.showMessageDialog(panel,"image saved / \u56FE\u7247\u5DF2\u4FDD\u5B58");
			} catch(NullPointerException e){
				JOptionPane.showMessageDialog(panel,"none selected / \u672A\u52A0\u8F7D\u56FE\u7247");
				//e.printStackTrace();
			} catch(IllegalArgumentException e){
				JOptionPane.showMessageDialog(panel,"none selected / \u672A\u52A0\u8F7D\u56FE\u7247");
				//e.printStackTrace();
			} catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	
	class ClickInsertButton implements ActionListener{
		public void actionPerformed(ActionEvent event){
			image.writeMessage(inputArea.getText());
			info.setText("<html>message inserted<br>\u4FE1\u606F\u5199\u5165\u5B8C\u6210</html>");
			JOptionPane.showMessageDialog(panel,"message inserted / \u4FE1\u606F\u5199\u5165\u5B8C\u6210");
		}
	}
	
	class ClickReadButton implements ActionListener{
		public void actionPerformed(ActionEvent event){
			//outputField.setText(image.readMessage());
			//outputArea.setText(image.readMessage());
			String retrieved = image.readMessage();
			//output.setColumn(retrieved.length());
			outputArea.setText(retrieved);
			repaint();
			JOptionPane.showMessageDialog(panel,"message inserted / \u4FE1\u606F\u8BFB\u53D6\u5B8C\u6210");
		}	
	}	
	
	public static File LoadDialog() throws IOException{
		File f = null;
		JFileChooser selectfile= new JFileChooser(new File("."));
		int returnVal = selectfile.showOpenDialog(null);
		if (returnVal==JFileChooser.APPROVE_OPTION){
			f = selectfile.getSelectedFile();
		}
		return f;
	}
	
	public static File SaveDialog() throws IOException{
		File f = null;
		JFileChooser selectfile= new JFileChooser(new File("."));
		int returnVal = selectfile.showSaveDialog(null);
		if (returnVal==JFileChooser.APPROVE_OPTION){
			f = selectfile.getSelectedFile();
		}
		return f;
	}	
}