import java.awt.image.WritableRaster;
import java.awt.image.BufferedImage;

public class StegGrey extends SteganImage
{
	public StegGrey(BufferedImage bi)
	{
		super(bi);
	}

	public void encode(String message)
	{
		//get binary representation of message
		String binary=ConvertStringToUnicodeBinaryString(message);
		System.out.println("Message to be encoded in binary:"+binary);
		System.out.println("Message to be encoded: "+ConvertUnicodeBinaryStringToString(binary));

		BinaryStringReader reader=new BinaryStringReader(binary);

		//get dimensions of image
		int width=bi.getWidth();
		int height=bi.getHeight();
		System.out.println("x="+bi.getMinX()+":"+width);
		System.out.println("y="+bi.getMinY()+":"+height);	
		
		//update image
		boolean stop=false;
		
		for(int i=bi.getMinX();i<width&&stop==false;i++)
		{
			for(int j=bi.getMinY();j<height;j++)
			{
				//get the value of this pixel
				int[] intensity=getIntensityValues(i,j);
				
				//update the three least significant bits of this value
				String sIntensity=ConvertIntegerToBinaryString(intensity[0]);
				char[] aIntensity=sIntensity.toCharArray();
				int leastSignificantBit=aIntensity.length-1;
				//System.out.println("1.encode - intensity: "+sIntensity);	

				for(int z=0;z<3;z++)
				{
					char nextBit;
				
					if(reader.hasMoreCharacters())
					{
						nextBit=reader.nextCharacter();
					}
					else
					{
						stop=true;
						nextBit='0';
					}
						
					aIntensity[leastSignificantBit--]=nextBit;
				}
					
				sIntensity=new String(aIntensity);
				//System.out.println("2.encode - intensity: "+sIntensity);	

				intensity[0]=ConvertBinaryStringToInteger(sIntensity);

				//set the values of this pixel
				setIntensityValues(i,j,intensity);
				
				//if there are no more bits stop the process
				if(stop==true)
				{
					break;
				}
			}
		}
	}

	public String decode()
	{
		//variable to hold binary representation of message
		String binary="";
		
		//variable to hold the message
		String message="";
		
		//variable to indicate whether a message exists
		boolean exists=false;

		//get dimensions of image
		int width=bi.getWidth();
		int height=bi.getHeight();
		
		//traverse image
		boolean stop=false;
		boolean firstCharacterChecked=false;
		
		for(int i=bi.getMinX();i<width&&stop==false;i++)
		{
			for(int j=bi.getMinY();j<height;j++)
			{
				//get the value of this pixel
				int[] intensity=getIntensityValues(i,j);
				
				//get the three least significant bits of this value
				String sIntensity=ConvertIntegerToBinaryString(intensity[0]);
				char[] aIntensity=sIntensity.toCharArray();
				int leastSignificantBit=aIntensity.length-1;
				System.out.println("decode - intensity: "+sIntensity);	
				
				for(int z=0;z<3;z++)
				{	
					binary+=aIntensity[leastSignificantBit--];
				}
				
				System.out.println("decode - binary string so far: "+binary);	
				
				//if we don't have enough data to form a character we carry on
				if(binary.length()<16)
				{
					System.out.println("decode - not enough data in binary");	
					continue;
				}

				//if the first character is not [ stop the process
				if(firstCharacterChecked==false)
				{			
					char first=ConvertUnicodeBinaryStringToChar(binary.substring(0,16));
					System.out.println("decode - first character read: "+first);	
					
					//if there is no message stop the process
					if(first!='[')
					{
						System.out.println("decode - no message");	
						stop=true;
						break;
					}
					else
					{
						System.out.println("decode - first character found");	
					}
					
					firstCharacterChecked=true;
					continue;
				}
				
				//if the last character is found stop the process
				message=ConvertUnicodeBinaryStringToString(binary);
				System.out.println("decode - message so far: "+message);	
				
/*				try
				{
					Thread.sleep(3000);
				}
				catch(InterruptedException e){}
*/				
				if(message.indexOf(']')!=-1)
				{
					System.out.println("decode - last character found");	
					stop=true;
					exists=true;
					break;
				}
			}
		}
		
		if(exists)
		{
			return message.replace("[","").replace("]","");
		}
		else
		{
			return "";
		}
	}

	protected int[] getIntensityValues(int x, int y)
	{
		WritableRaster raster = bi.getRaster();
		int[] grayIntensity = new int[1];
		grayIntensity[0]=raster.getSample(x, y, 0);
		
		return grayIntensity;
	}

	protected void setIntensityValues(int x, int y, int[] intensity)
	{
		WritableRaster raster = bi.getRaster();
		raster.setSample(x,y,0,intensity[0]);
	}
}