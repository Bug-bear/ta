import java.awt.image.*; //buffered image
public class StegGreyScale extends SteganImage{
	private static final boolean TO_THE_LEFT = true;
	private static final boolean TO_THE_RIGHT = false;
   
    public  StegGreyScale(BufferedImage i){
		bi = i;
    }
    
    public void WritePixel(int x, int y, String bits){
        int grayIntensity = getGreyScaleValue(x, y);
        String str = Integer.toBinaryString(grayIntensity);
        str = padString(str,BITS_PER_PIXEL,TO_THE_LEFT);
   
        bits = padString(bits,BITS_PER_PIXEL,TO_THE_RIGHT);
   
        String newStr = str.substring(0,str.length()-BITS_PER_PIXEL)+bits;
       
        setGreyScaleValue(x, y, Integer.parseInt(newStr,2));
    }
	
    public  String ReadPixel(int x, int y){
        int grayIntensity = getGreyScaleValue(x,y);         
        
        String str = Integer.toBinaryString(grayIntensity);
        
        str= padString(str,BITS_PER_PIXEL,TO_THE_LEFT);
        
        return str.substring(str.length()-BITS_PER_PIXEL,str.length());
    }

    private int getGreyScaleValue(int x, int y){
		WritableRaster raster   = bi.getRaster();
		int grayIntensity = raster.getSample(x, y, 0);
		return grayIntensity;
    }
	
    private void setGreyScaleValue(int x, int y,int grayIntensity){   
		WritableRaster raster = bi.getRaster();
		raster.setSample(x,y,0,grayIntensity);   
    }

    private String padString(String str, int length,boolean Onleft){
		if (str.length()>=length){
			return str;
        } else {
			String padStr=str;

			for (int i=0;i<length-str.length();i++){
				if (Onleft==TO_THE_LEFT){
					padStr="0" + padStr;
				} else{
					padStr=padStr +"0";                           
				}
			}
			return padStr;  
        }
    }
}
