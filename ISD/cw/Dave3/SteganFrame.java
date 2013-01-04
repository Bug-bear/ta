import javax.swing.JFileChooser;
import java.io.File;
import java.io.IOException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import javax.imageio.*;
import java.awt.image.*; //buffered image

import java.awt.Graphics;

import java.awt.GridLayout;

import java.util.Scanner;

public class SteganFrame extends JFrame
{
    // instance variables - replace the example below with your own
    private JButton loadButton;
    private JButton saveButton;
    
    private JButton encryptButton;
    private JButton decryptButton;
    
    private JTextArea resultArea;
   
    private JPanel panel;
    private ImagePanel panel2;
   
    private static final int AREA_ROWS = 10;
    private static final int AREA_COLUMNS = 20;
    private static final int FRAME_WIDTH = 550;
    private static final int FRAME_HEIGHT = 425;
    
    
    private static final int  UNICODE_BIT_LENGTH = 16;
    private static final char START_CHAR ='[';
    private static final char END_CHAR =']';
    
    private SteganImage si = null;
 
    /**
     * Constructor for objects of class SteganFrame
     */
    public SteganFrame(){
        setLayout(new GridLayout(1, 2));
        resultArea = new JTextArea(AREA_ROWS, AREA_COLUMNS);
        resultArea.setEditable(true);
        createButtons();
        createStegButtons();
       
        JPanel panel = new JPanel();
        panel.add(loadButton);
        panel.add(saveButton);
        panel.add(resultArea);
        panel.add(encryptButton);
        panel.add(decryptButton);
        panel2 = new ImagePanel();
       
        add(panel);
        add(panel2);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }
  
	class ImagePanel extends JPanel {
		public void paintComponent(Graphics g) {
			if(si != null){
				g.drawImage(si.getImage(), 0, 0,null);
			}
		}
	}

	class SaveAnImage implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if (si== null){
				System.out.println("No Image to save");
			} else {
				File f  = SaveDialog();
				try{
					ImageIO.write(si.getImage(), "png", f);	  
				} catch (Exception e){
					System.out.println("Image could not be saved");         
				}
			}
		}            
   }
   
	class LoadAnImage implements ActionListener{
		public void actionPerformed(ActionEvent event){
            File f =  LoadDialog();
            if ( f!=null){
				try{
                    BufferedImage s = ImageIO.read(f);
                    //System.out.println(s.getType());
                    switch (s.getType()) {
                            case BufferedImage.TYPE_4BYTE_ABGR: si = new StegRGBimage(s);
                                                                break;
                            case BufferedImage.TYPE_BYTE_GRAY:  si = new StegGreyScale(s);
                                                                break; 
                            default:                            System.out.println("Cannot Handle this image format");
                                                                break;
                    }
                    repaint();
                }
                catch (Exception e) 
                {
                    System.out.println("Image could not be read");         
                }
              
            }    
		}            
	}	
	
	private void createButtons(){
		loadButton = new JButton("Load Image");         
		ActionListener listener = new LoadAnImage();
		loadButton.addActionListener(listener);

		saveButton = new JButton("Save Image");         
		ActionListener listener2 = new SaveAnImage();
		saveButton.addActionListener(listener2);
	}
  
	class ReadMessage implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if( si == null){
                System.out.println("Load an image"); 
			}else{
                if (IsMessageInImage()){               
                     resultArea.setText(ReadTheHiddenMessage());  
                } else{
                     resultArea.setText("No Text Stored in this image");             
                }
			}
		}
	}
	
    private String ReadTheHiddenMessage(){
		String str="";
		String outputStr ="";
		boolean boolRead= true;
		for (int x = 0; x<si.getImage().getWidth(); x++){
			for (int y = 0; y<si.getImage().getHeight(); y++){  
				//at a particular (x,y) coordinate
				if (boolRead){
					//accumulate bits of the pixel
					str=str+si.ReadPixel(x,y); 
					if (str.length() >= UNICODE_BIT_LENGTH){
						//have enough bits for another char, convert!
						char c = ConvertUnicodeBinaryToChar(str.substring(0,UNICODE_BIT_LENGTH));
						if (c == END_CHAR){
							boolRead= false;
						} else {
							outputStr=outputStr+c ;
						}
						//get rid of the already-converted bits for the next iteration
						str=str.substring(UNICODE_BIT_LENGTH,str.length());
					}                      
				}
			}                        
		}
		//return the final string without the leading '['
        return outputStr.substring(1,outputStr.length());
    }
    
	private boolean IsMessageInImage(){
		String str="";
		int y=0;
		do{
			str = str+si.ReadPixel(0,y); 
			y++;
		} while(str.length() < UNICODE_BIT_LENGTH);
		char  c = ConvertUnicodeBinaryToChar(str.substring(0,UNICODE_BIT_LENGTH)); 
		return (c == START_CHAR);
     }
   
    public static char ConvertUnicodeBinaryToChar(String s){   
        return (char)Integer.parseInt(s,2);
    } 
       
    public String ConvertCharToUnicodeBinary(char c){   
        String unicodeBinary =Integer.toBinaryString(c);
        return String.format("%16s", unicodeBinary).replace(" ", "0");
    }
    
    public String ConvertWordstoBits(String s){
		String str="";
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			String bin = ConvertCharToUnicodeBinary(c);
			str=str+bin;
		}
		return str;
    }
    
    public void WriteToImage(String str){
        int loc =0;
        str = START_CHAR + str + END_CHAR;
        String s = ConvertWordstoBits(str);
      
        if (s.length() <= si.Capacity()){ //if there is enough space for our message
            for (int x = 0; x<si.getImage().getWidth(); x++){
                for (int y = 0; y<si.getImage().getHeight(); y++){        
					//at this specific pixel
                    if (loc < s.length()){
						//retrieve the next 3 bits
                        String bits = s.substring(loc, Math.min(s.length(),loc+si.BITS_PER_PIXEL));
						//write this 3 bits to the pixel
                        si.WritePixel(x, y, bits);
                        //move on to the position for the next batch
						loc = loc+si.BITS_PER_PIXEL ;
                    }   
                }      
            }
            resultArea.setText("Text Written");
            repaint();  
        }else{
            System.out.println("Text too long");  
        }
    }

	class WriteMessage implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(si == null){
				System.out.println("No image to write message into");  
			}else{
				WriteToImage(resultArea.getText());
			}
		}            
	}
  
	private void createStegButtons(){
		encryptButton = new JButton("Read Message");         
		ActionListener listener3 = new ReadMessage();
		encryptButton.addActionListener(listener3);

		decryptButton = new JButton("Write Message");         
		ActionListener listener4 = new WriteMessage();
		decryptButton.addActionListener(listener4);
	} 
  
	public static File  LoadDialog(){
		File f = null;            
		JFileChooser selectfile= new JFileChooser(new File("."));
		int  returnVal = selectfile.showOpenDialog(null);
		if (returnVal==JFileChooser.APPROVE_OPTION){
			f  = selectfile.getSelectedFile();
		}
		return f;
	}
	
	public static File  SaveDialog(){
		File f = null;            
		JFileChooser selectfile= new JFileChooser();
		int  returnVal = selectfile.showSaveDialog(null);
		if (returnVal==JFileChooser.APPROVE_OPTION){
			f  = selectfile.getSelectedFile();
		}
		return f;
	}
}
