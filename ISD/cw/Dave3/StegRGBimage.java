import java.awt.image.*; //buffered image
public class StegRGBimage extends SteganImage 
{
private static final int COLOUR_CHANNELS = 3;
   public  StegRGBimage(BufferedImage i){
        bi = i;
    }
    
    public void WritePixel(int x, int y, String bits){
        int[] colourIntensity=getColourValues( x, y); 
        String newStr;
        for (int i=0; i<bits.length(); i++)
        {
           String str = Integer.toBinaryString(colourIntensity[i]);
           if (str.length()==1){
             newStr =Character.toString(bits.charAt(i));              
            } else {
             newStr = str.substring(0,str.length()-1)+bits.charAt(i);              
            }
           colourIntensity[i] = Integer.parseInt(newStr,2);
        }
        setColourValues( x,  y, colourIntensity);
    }
     public String ReadPixel(int x, int y){
       String bits="";
       int[] colourIntensity=getColourValues( x, y); 
       for (int i=0; i<COLOUR_CHANNELS; i++)
        {
           String str = Integer.toBinaryString(colourIntensity[i]);
           bits=bits+str.charAt(str.length()-1);
        }
        return bits;
    }
     

  private int[] getColourValues(int x, int y){
         int[] colourIntensity = new int[COLOUR_CHANNELS];
         WritableRaster raster = bi.getRaster();
         for(int i=0;i<COLOUR_CHANNELS;i++){
             colourIntensity[i]=raster.getSample(x,y,i);
            }
          return colourIntensity;
  }
    
    private void setColourValues(int x, int y,int[] colourIntensity){
   
         WritableRaster raster = bi.getRaster();
         for(int i=0;i<COLOUR_CHANNELS;i++){
             raster.setSample(x,y,i,colourIntensity[i]);
         }
    }


}


  