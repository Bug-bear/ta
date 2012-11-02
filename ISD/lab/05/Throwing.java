import java.util.Scanner;
import java.io.*;

public class Throwing{
	public static void main(String[] args){
		try{
			int x = getInt();
			System.out.println(x);
		} catch(IOException e){
			System.out.println(e);
		}
	}
   
	public static int getInt() throws IOException
	{
		System.out.println("give me an int");
		Scanner in = new Scanner(System.in);
		if(!in.hasNextInt()){
			throw new IOException("it's not integer!");
		}
		return in.nextInt();
	}
} 