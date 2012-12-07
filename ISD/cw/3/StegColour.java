import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class StegColour extends SteganImage{
	public StegColour(String srcPath) throws IllegalArgumentException, IOException{
		super(srcPath);
	}
	
	public int read(int x, int y){
		WritableRaster raster = image.getRaster();
		int grayIntensity = raster.getSample(x, y, 0);
		return grayIntensity;
	}	
}