import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class StegGrey extends SteganImage{
	public StegGrey(String srcPath) throws IllegalArgumentException, IOException{
		super(srcPath);
	}
	
	public int read(int x, int y){
		WritableRaster raster = image.getRaster();
		int grayIntensity = raster.getSample(x, y, 0);
		return grayIntensity;
	}
	
	public void writeMessage(String text){
		//add text header and tail
		text = START + text + END;
		int posX = 0;
		int posY = 0;
		String str = ""; // intensity bit string of current pixel
		String newStr = "";
		int spaceLeft = 0;
		
		for(int i=0; i<text.length(); i++){
			String binary = ConvertCharToUnicodeBinaryString(text.charAt(i)); // 8 bits of the char
			System.out.println("char " + text.charAt(i) + " : " + binary); //debug
			int charBitLeft = 16; // number of inserted bits
			
			//for this char
			while(charBitLeft > 0){ 
				//retrive a new pixel when no space left
				if(spaceLeft == 0){
					int intensity = getGreyScaleValue(posX, posY, image);
					//string of 8-bit intensity
					str = String.format("%16s", Integer.toBinaryString(intensity)).replace(" ", "0"); 
					spaceLeft = 3;
				}
				
				//manipulate intensity string
				if(charBitLeft >= spaceLeft){ //more char bits than avaiable intensity bits
					if(spaceLeft == 3){ //an unused new string
						newStr = str.substring(0, str.length()-spaceLeft) + binary.substring(16-charBitLeft, 16-charBitLeft+spaceLeft);
					} else{ //partly used string
						//System.out.println(newStr); //debug
						newStr += binary.substring(16-charBitLeft, 16-charBitLeft+spaceLeft);
					}
					charBitLeft -= spaceLeft;
					spaceLeft = 0;
				} else{ //more avaiable intensity bits than char bits to insert
					//newStr = str.substring(0, str.length()-spaceLeft) + binary.substring(16-charBitLeft);
					newStr = str.substring(0, str.length()-spaceLeft) + binary.substring(16-charBitLeft);
					//System.out.println(binary.substring(16-charBitLeft)); //debug
					//System.out.println(newStr); //debug
					spaceLeft -= charBitLeft;
					//System.out.println(spaceLeft); //debug
					charBitLeft = 0;
				}
				
				//we now have a complele intensity bit string to write
				if(spaceLeft == 0){
					System.out.println(newStr); //debug
					//convert back to string format
					int grayIntensity = Integer.parseInt(newStr,2);
					//put intensity to image
					setGreyScaleValue(posX,posY,grayIntensity,image);
					newStr = ""; //reset
				
					//update coordinates only if no space left in the current pixel
					posY++;
					if(posY == image.getHeight()){
						posY=0;
						posX++;
					}
				}
			}
		}
		//handel any left-over
		if(!newStr.equals("")){
			newStr = newStr + str.substring(str.length()-spaceLeft);
			System.out.println(newStr); //debug
			//convert back to string format
			int grayIntensity = Integer.parseInt(newStr,2);
			//put intensity to image
			setGreyScaleValue(posX,posY,grayIntensity,image);			
		}
	}
	
	public void readMessage(){
		String text = "";
		char letter = '\u0000'; 
		for(int i=0; i<image.getWidth(); i++){
			for(int j=0; j<image.getHeight(); j++){
				//retrieve intensity of this pixel
				int intensity = getGreyScaleValue(i, j, image);
				//convert to bit string
				String str = String.format("%16s", Integer.toBinaryString(intensity)).replace(" ", "0");
				//retrieve the last 3 bits
			}
		}
	}
	
	
	// helpers
	private static String ConvertCharToUnicodeBinaryString(char c){
		String unicodeBinary =Integer.toBinaryString(c);
		return String.format("%16s", unicodeBinary).replace(" ", "0");
	}	
	
	private int getGreyScaleValue(int x, int y, BufferedImage bi)
	{
		WritableRaster raster = bi.getRaster();
		int grayIntensity = raster.getSample(x, y, 0);
		return grayIntensity;
	}
	
	private void setGreyScaleValue(int x, int y,int grayIntensity, BufferedImage bi)
	{
		WritableRaster raster = bi.getRaster();
		raster.setSample(x,y,0,grayIntensity);
	}
}