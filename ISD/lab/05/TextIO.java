import java.util.Scanner;

public class TextIO{
	public static void main(String[] args){
		String input1 = "Now is the time for all good men to come to the aid of their country.";
		String input2 = "abcdefghijklmnopqrstuvwxyz0123456789";
		String input3 = "a1b2c3 d4";
		
		Scanner in1 = new Scanner(input1);
		while(in1.hasNext()){
			System.out.print(in1.next() + " ");
		}
		System.out.println();
		
		Scanner in2 = new Scanner(input2);
		in2.useDelimiter("");
		while(in2.hasNext()){
			System.out.print(in2.next());
		}
		
		Scanner in3 = new Scanner(input3);
		in3.useDelimiter("");
		while(in3.hasNext()){
			char ch = in3.next().charAt(0);
			if(Character.isLetter(ch)){
				System.out.println(ch + " is a letter.");
			}
			if(Character.isDigit(ch)){
				System.out.println(ch + " is a digit.");
			}
			if(Character.isWhitespace(ch)){
				System.out.println(ch + " is whitespace.");
			}
		}
	}
}