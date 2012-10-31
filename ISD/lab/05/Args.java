import java.util.Scanner;

public class Args{
	public static void main(String[] args){
		String temp = "";
		for(String arg : args){
			temp = temp + " " + arg;
		}
		Scanner in = new Scanner(temp);
		while(in.hasNext()){
			if(in.hasNextInt()){
				System.out.println(in.nextInt() + " is Integer");
			}
			else if(in.hasNextDouble()){
				System.out.println(in.nextDouble() + " is Double");
			}
		}
	}
}