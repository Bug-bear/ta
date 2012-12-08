import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class Test{
	public static void main(String[] args){
		//testCharToBinary(args);
		
		try{
			testPixelWrite();
			System.out.println();
			testPixelRead();
		} catch(IllegalArgumentException e){
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	
	private static void testPixelWrite() throws IllegalArgumentException, IOException{
		/*SteganImage grey = new StegGrey("GreyImage.png");
		grey.writeMessage("once I was a wooden boy");
		grey.saveImage("wa.png");*/
		
		SteganImage colour = new StegColour("ColourImage.png");
		colour.writeMessage("little wooden boy");
		colour.saveImage("ya.png");
	}
	
	private static void testPixelRead() throws IllegalArgumentException, IOException{
		/*SteganImage grey = new StegGrey("wa.png");
		System.out.println(grey.readMessage());*/
		
		SteganImage colour = new StegColour("ya.png");
		System.out.println(colour.readMessage());
	}	
	
	private static void testCharToBinary(String[] args){
		if(args.length != 0){
			System.out.println(args[0] + "\n" + Parser.perpareWrite(args[0]));
		}
	}
}