import java.awt.image.BufferedImage;

public abstract class SteganImage
{
	protected BufferedImage bi;
	
	public SteganImage(BufferedImage bi)
	{
		this.bi=bi;
	}
	
	public BufferedImage getImage()
	{
		return bi;
	}
	
	abstract protected int[] getIntensityValues(int x, int y);
	abstract protected void setIntensityValues(int x, int y, int[] intensity);
	abstract public void encode(String message);
	abstract public String decode();
	
	public static char ConvertUnicodeBinaryStringToChar(String s)
	{
		return (char) Integer.parseInt(s,2);
	}
	
	public static String ConvertCharToUnicodeBinaryString(char c)
	{
		String unicodeBinary=Integer.toBinaryString(c);
		return String.format("%16s", unicodeBinary).replace(" ", "0");
	}
	
	public static String ConvertStringToUnicodeBinaryString(String message)
	{
		message="["+message+"]";
		
		String binary="";
		
		for(int i=0;i<message.length();i++)
		{
			char c=message.charAt(i);
			binary+=ConvertCharToUnicodeBinaryString(c);
		}
		
		return binary;
	}

	public static String ConvertUnicodeBinaryStringToString(String binary)
	{
		if(binary.length()<16)
		{
			return "";
		}
		
		String message="";
			
		for(int i=0;(i+16)<=binary.length();i+=16)
		{
			char c=ConvertUnicodeBinaryStringToChar(binary.substring(i,i+16));
			message+=c+"";
		}
		
		return message;
	}
	
	public static String ConvertIntegerToBinaryString(int decimal)
	{
		String binary=Integer.toBinaryString(decimal);
		return String.format("%32s", binary).replace(" ", "0");
	}
	
	public static int ConvertBinaryStringToInteger(String bin)
	{
		return Integer.parseInt(bin,2);
	}
	
	public class BinaryStringReader
	{
		private String s;
		private int position;
		
		public BinaryStringReader(String s)
		{
			this.s=s;
			position=0;
		}
		
		public char nextCharacter()
		{
			return s.charAt(position++);
		}
		
		public boolean hasMoreCharacters()
		{
			return position<s.length();
		}
	}
}