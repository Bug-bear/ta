import java.awt.image.*; //buffered image
/**
 * Abstract class SteganImage - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class SteganImage
{
    // instance variables - replace the example below with your own
    protected BufferedImage bi = null;
    protected static final int BITS_PER_PIXEL = 3;
    
    public BufferedImage getImage()
    {
        return bi;
    }
    public int Capacity()
    {
        if (bi== null)
        {
            return 0;
        } else 
        {           
            return BITS_PER_PIXEL*bi.getWidth()*bi.getHeight();
        }
    }
    
    public abstract void WritePixel(int x, int y, String bits);
        
    public abstract String ReadPixel(int x, int y);
    
     
}
