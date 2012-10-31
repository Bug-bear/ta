import java.io.*;
import java.util.Scanner;

public class UpdateTable{
	public static void main(String[] args) throws FileNotFoundException{
		File myfile = new File("data.txt");
		Scanner in = new Scanner(myfile);
		while(in.hasNextLine()){
			int numPts = 0;
			String line = in.nextLine();
			Scanner ln = new Scanner(line);
			while(ln.hasNext()){
				String str = ln.next();
				for(int i=0; i<str.length(); i++){
					if(str.charAt(i) == '.'){
						numPts++;
					}
				}
				if(numPts != 2){
					System.out.printf("%6s", str + " ");
				} else{
					numPts = 0;
					String updated = "0" + str;
					System.out.printf("%6s", updated + " ");
				}
			}
			System.out.println(numPts);
		}
		in.close();
	}
}