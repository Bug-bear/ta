import java.io.*;
import java.awt.image.*;
import javax.imageio.*;
import java.util.*;

public class StegColour extends SteganImage{
	public StegColour(BufferedImage bi){
		super(bi);
	}

	public StegColour(String srcPath) throws IllegalArgumentException, IOException{
		super(srcPath);
	}
	
	@Override
	public void writeMessage(String text){
		//add text header and tail
		text = START + text + END;
		//inital value for start-up
		int posX = 0;
		int posY = 0;
		String[] str = getIntensityBitStringArray(posX, posY);
		int spaceLeft = 3;
		String[] newStr = new String[3];
		
		//for every char
		for(int i=0; i<text.length(); i++){
			String binary = Parser.ConvertCharToUnicodeBinaryString(text.charAt(i)); // 8 bits of the char
			int charBitLeft = 16; // number of inserted bits
			//System.out.println("char " + text.charAt(i) + " : " + binary); //debug
			
			while(charBitLeft > 0){ 				
				//manipulate intensity string
				if(charBitLeft >= spaceLeft){ //more char bits than avaiable intensity bits
					for(int p=3-spaceLeft; p<3; p++){
						newStr[p] = str[p].substring(0, str[p].length()-1) + binary.substring(16-charBitLeft,16-charBitLeft+1);
						charBitLeft--;			
					}
					spaceLeft = 0;
				} else{ //will leave a partly filled string array
					for(int p=0; p<charBitLeft; p++){
						newStr[p] = str[p].substring(0, str[p].length()-1) + binary.substring(16-charBitLeft+p,16-charBitLeft+p+1);
						spaceLeft--;
					}
					charBitLeft = 0;
				}
				
				//we now have a complele intensity bit string to write
				//System.out.println(Arrays.toString(newStr)); //debug
				if(spaceLeft == 0){
					setIntensityBitStringArray(posX,posY,newStr);
					//update coordinates only if no space left in the current pixel
					posY++;
					if(posY == image.getHeight()){
						posY=0;
						posX++;
					}
					//retrived a new pixel
					str = getIntensityBitStringArray(posX, posY);
					spaceLeft = 3;
					newStr = new String[3];; //reset
				}
			}
		}
		//handel any left-over
		if(spaceLeft != 3){
			for(int p=3-spaceLeft; p<3; p++){
				newStr[p] = str[p];
			}	
			setIntensityBitStringArray(posX,posY,newStr);			
		}
	}
	
	@Override
	public String readMessage(){
		String text = "";
		String charString = "";
		int bitCtr = 0;
		int usedBand = 0;
		for(int i=0; i<image.getWidth(); i++){
			for(int j=0; j<image.getHeight(); j++){
				//retrieve intensity of this pixel
				String[] str = getIntensityBitStringArray(i,j);
				usedBand = 0;
				//retrieve bits
				for(int p=usedBand; p<3 && bitCtr<16; p++){
					charString += str[p].substring(str[p].length()-1);
					bitCtr++;
					usedBand++;
				}
				if(bitCtr == 16){
					bitCtr = 0;
					//System.out.println(text); //debug
					char letter = Parser.ConvertUnicodeBinaryStringToChar(charString);
					charString = "";
					if(letter == ']'){
						return text;
					}
					if(letter != '['){
						if(text.length() == 0){
							return "no message found \n \u65E0\u4FE1\u606F";
						}					
						text += letter;
					}
					if(usedBand < 3){
						for(int p=usedBand; p<3; p++){
							charString += str[p].substring(str[p].length()-1);
							bitCtr++;
						}						
					}
				}
			}
		}
		return text;
	}
	
	//helpers
	private String[] getIntensityBitStringArray(int x, int y){
		String[] str = new String[3];
		int[] intensity = getColourValues(x, y, image);
		for(int p=0; p<intensity.length; p++){
			str[p] = String.format("%16s", Integer.toBinaryString(intensity[p])).replace(" ", "0"); 
		}
		return str;
	}	
	
	private void setIntensityBitStringArray(int x, int y, String[] newStr){
		int[] colourIntensity = new int[3];
		for(int p=0; p<3; p++){
			colourIntensity[p] = Integer.parseInt(newStr[p],2);
			//System.out.println(p + " : " + newStr[p]); //debug
		}
		//put intensity to image
		setColourValues(x,y,colourIntensity,image);		
	}	
	
	private int[] getColourValues(int x, int y, BufferedImage bi){
		int[] colourIntensity = new int[3];
		WritableRaster raster = bi.getRaster();
		for(int i=0;i<3;i++){
			colourIntensity[i]=raster.getSample(x,y,i);
		}
		return colourIntensity;
	}
	
	private void setColourValues(int x, int y,int[] colourIntensity, BufferedImage bi){
		WritableRaster raster = bi.getRaster();
		for(int i=0;i<3;i++){
			raster.setSample(x,y,i,colourIntensity[i]);
		}
	}
}