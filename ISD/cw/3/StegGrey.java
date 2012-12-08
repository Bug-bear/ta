import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class StegGrey extends SteganImage{
	public StegGrey(String srcPath) throws IllegalArgumentException, IOException{
		super(srcPath);
	}
	
	@Override
	public void writeMessage(String text){
		//add text header and tail
		text = START + text + END;
		//inital value for start-up
		int posX = 0;
		int posY = 0;
		String str = getIntensityBitString(posX, posY); //string of 8-bit intensity
		int spaceLeft = 3;
		String newStr = "";
		
		//for every char
		for(int i=0; i<text.length(); i++){
			String binary = Parser.ConvertCharToUnicodeBinaryString(text.charAt(i)); // 8 bits of the char
			//System.out.println("char " + text.charAt(i) + " : " + binary); //debug
			int charBitLeft = 16; // number of inserted bits
			
			while(charBitLeft > 0){ 			
				//manipulate intensity string
				if(charBitLeft >= spaceLeft){ //more char bits than avaiable intensity bits
					if(spaceLeft == 3){ //an unused new string
						newStr = str.substring(0, str.length()-spaceLeft) + binary.substring(16-charBitLeft, 16-charBitLeft+spaceLeft);
					} else{ //will leave a partly used string
						newStr += binary.substring(16-charBitLeft, 16-charBitLeft+spaceLeft);
					}
					charBitLeft -= spaceLeft;
					spaceLeft = 0;
				} else{ //more avaiable intensity bits than char bits to insert
					newStr = str.substring(0, str.length()-spaceLeft) + binary.substring(16-charBitLeft);
					spaceLeft -= charBitLeft;
					charBitLeft = 0;
				}
				
				//we now have a complele intensity bit string to write
				if(spaceLeft == 0){
					setIntensityBitString(posX,posY,newStr);
					//update coordinates only if no space left in the current pixel
					posY++;
					if(posY == image.getHeight()){
						posY=0;
						posX++;
					}
					//retrived a new pixel
					str = getIntensityBitString(posX, posY);
					spaceLeft = 3;
					newStr = ""; //reset
				}
			}
		}
		//handel any left-over
		if(!newStr.equals("")){
			newStr = newStr + str.substring(str.length()-spaceLeft);
			setIntensityBitString(posX,posY,newStr);
		}
	}
	
	@Override
	public String readMessage(){
		String text = "";
		String charString = "";
		int bitCtr = 0;
		for(int i=0; i<image.getWidth(); i++){
			for(int j=0; j<image.getHeight(); j++){
				//retrieve intensity of this pixel
				int intensity = getGreyScaleValue(i, j, image);
				//convert to bit string
				String str = String.format("%16s", Integer.toBinaryString(intensity)).replace(" ", "0");
				//System.out.println(str); //debug
				//retrieve bits
				if(bitCtr <= (16-3)){
					charString += str.substring(str.length()-3);
					bitCtr += 3;
				} else{
					charString += str.substring(str.length()-3, str.length()-3+(16-bitCtr));
					char letter = Parser.ConvertUnicodeBinaryStringToChar(charString);
					if(letter == ']'){
						return text;
					}
					if(letter != '['){
						text += letter;
					}
					//System.out.println(text); //debug
					charString = str.substring(str.length()-(3-(16-bitCtr)));
					bitCtr = 3-(16-bitCtr);
				}
			}
		}
		return text;
	}
	
	//helpers
	private String getIntensityBitString(int x, int y){
		int intensity = getGreyScaleValue(x, y, image);
		return String.format("%16s", Integer.toBinaryString(intensity)).replace(" ", "0"); 
	}
	
	private void setIntensityBitString(int x, int y, String newStr){
		int grayIntensity = Integer.parseInt(newStr,2);
		setGreyScaleValue(x,y,grayIntensity,image);	
	}	
	
	private int getGreyScaleValue(int x, int y, BufferedImage bi){
		WritableRaster raster = bi.getRaster();
		int grayIntensity = raster.getSample(x, y, 0);
		return grayIntensity;
	}
	
	private void setGreyScaleValue(int x, int y,int grayIntensity, BufferedImage bi){
		WritableRaster raster = bi.getRaster();
		raster.setSample(x,y,0,grayIntensity);
	}
}