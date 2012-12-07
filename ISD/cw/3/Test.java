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
		//SteganImage grey = StegGrey("GreyImage.png");
		String path = "ColourImage.png";
		SteganImage colour = StegColour(path);
	}
	
	private static void testCharToBinary(String[] args){
		if(args.length != 0){
			System.out.println(args[0] + "\n" + SecretParser.perpareWrite(args[0]));
		}
	}
}