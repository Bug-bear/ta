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
		BufferedImage temp = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
		WritableRaster raster = temp.getRaster();
		int posX = 0;
		int posY = 0;
		for(int i=0; i<text.length(); i++){
			String binary = ConvertCharToUnicodeBinaryString(text.charAt(i)); // 8 bits of the char
			int charBitCtr = 0; // number of inserted bits
			//for this char
			while(charBitCtr < binary.length()){ 
				int intensity = getGreyScaleValue(posX, posY, image);
				//string of 8-bit intensity
				String str = String.format(Integer.toBinaryString(i)); 
				//manipulate intensity string
				//String newStr = str.substring(0, str.length()-3) + str.substring(charBitCtr, charBitCtr+3);
				String newStr = str.substring(0, str.length()-3) + str.substring(str.length()-2, str.length());
				//convert back to string format
				int grayIntensity = Integer.parseInt(newStr,2);
				//put intensity to image
				raster.setSample(posX,posY,0,grayIntensity);
				//update coordinates
				posY++;
				if(posY==temp.getHeight()){
					posY=0;
					posX++;
				}
				//update counter
				charBitCtr += 3;
			}
		}
		image = temp;
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
}