import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class Test{
	public static void main(String[] args){
		//testCharToBinary(args);
		try{
			testPixelRead();
		} catch(IllegalArgumentException e){
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	
	private static void testPixelRead() throws IllegalArgumentException, IOException{
		SteganImage grey = new StegGrey("GreyImage.png");
		//SteganImage colour = new StegColour("ColourImage.png");
		((StegGrey)grey).read(0,0);
		((StegGrey)grey).writeMessage("wa");
		grey.saveImage("wa.png");
	}
	
	private static void testCharToBinary(String[] args){
		if(args.length != 0){
			System.out.println(args[0] + "\n" + SecretParser.perpareWrite(args[0]));
		}
	}
}