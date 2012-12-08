import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Graphics;
import java.io.File;
import java.awt.event.*;
import javax.imageio.*;
import javax.swing.JFileChooser;
import java.io.IOException;
import java.awt.Graphics2D;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.image.*; // required for buffered image

public class SteganographyFrame extends JFrame{
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 400;
	private BufferedImage bi = null; //Do not store your buffered image reference here.
	private SteganImage image; //colour or grey
	private JPanel panel;
	private ImagePanel panel2;
	private JButton loadButton, saveButton, insertButton, readButton;
	private	JTextArea inputArea, outputArea;
	//private JTextField outputField;
	private JLabel info;
	public SteganographyFrame()
	{
		this.setSize(FRAME_WIDTH,FRAME_HEIGHT);
		//for your components, right hand side is for the image
		panel = new JPanel();
		panel.setLayout(new GridLayout(6, 2));
		panel2 = new ImagePanel();
		loadButton = new JButton("Load");
		saveButton = new JButton("Save");
		insertButton = new JButton("Insert");
		readButton = new JButton("Read");
		this.loadButton.addActionListener(new ClickLoadButton());
		this.saveButton.addActionListener(new ClickSaveButton());
		this.insertButton.addActionListener(new ClickInsertButton());
		this.readButton.addActionListener(new ClickReadButton());
		this.inputArea = new JTextArea(3,10);
		this.inputArea.setLineWrap(true);
		this.outputArea = new JTextArea(3,10);
		this.outputArea.setLineWrap(true);
		this.outputArea.setEditable(false);
		this.info = new JLabel();
		/*this.outputField = new JTextField("message", 10);
		this.outputField.setEditable(false);
		this.panel.add(outputField);*/
		
		this.panel.add(loadButton); this.panel.add(saveButton);
		this.panel.add(insertButton); this.panel.add(readButton);
		this.panel.add(new JLabel("message to insert : ")); this.panel.add(inputArea);
		this.panel.add(new JLabel("system response : ")); this.panel.add(info);
		this.panel.add(new JLabel("retrieved message : "));  this.panel.add(outputArea);
		
		setLayout(new GridLayout(1, 2)); //Splits the frame vertically. Left hand side is
		add(panel); // add all your components to this panel
		add(panel2); // This panel is used to display the image
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
				g.drawImage(bi, 0, 0,null);
			}
			else{
				info.setText("no loaded image");
			}
		}
	}
	
	class ClickLoadButton implements ActionListener{
		public void actionPerformed(ActionEvent event){
			try{
				bi = ImageIO.read(LoadDialog());
				repaint();
				if(bi.getType() == BufferedImage.TYPE_4BYTE_ABGR){
					image = new StegColour(bi);
				}
				if(bi.getType() == BufferedImage.TYPE_BYTE_GRAY){
					image = new StegGrey(bi);
				}
			} catch(IllegalArgumentException e){
				info.setText("none selected");
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
			} catch(NullPointerException e){
				info.setText("none selected");
				//e.printStackTrace();
			} catch(IllegalArgumentException e){
				info.setText("none selected");
				//e.printStackTrace();
			} catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	
	class ClickInsertButton implements ActionListener{
		public void actionPerformed(ActionEvent event){
			image.writeMessage(inputArea.getText());
		}
	}
	
	class ClickReadButton implements ActionListener{
		public void actionPerformed(ActionEvent event){
			//outputField.setText(image.readMessage());
			outputArea.setText(image.readMessage());
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