import java.io.*;
import java.util.Scanner;

public class SumRow{
	public static void main(String[] args) throws FileNotFoundException{
		File myfile = new File("numbers.txt");
		Scanner in = new Scanner(myfile);
		while(in.hasNextLine()){
			double sum = 0;
			String line = in.nextLine();
			Scanner ln = new Scanner(line);
			while(ln.hasNext()){
				double num = ln.nextDouble();
				sum += num;
				System.out.print(num + " ");
			}
			System.out.println("Sum: " + sum);
		}
		in.close();
	}
}