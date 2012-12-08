/**
* A utility class for char and binary manipulation
*/

public class Parser{
	public static String ConvertCharToUnicodeBinaryString(char c){
		String unicodeBinary =Integer.toBinaryString(c);
		return String.format("%16s", unicodeBinary).replace(" ", "0");
	}	
	
	public static char ConvertUnicodeBinaryStringToChar(String s)
	{
		return (char) Integer.parseInt(s,2);
	}
	
	public static String[] perpareWrite(String text){
		String[] binary = new String[text.length()];
		for(int i=0; i<text.length(); i++){
			binary[i] = ConvertCharToUnicodeBinaryString(text.charAt(i));
		}
		return binary;
	}
}