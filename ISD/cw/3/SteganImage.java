import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public abstract class SteganImage{
	protected BufferedImage image;
	
	public SteganImage(String srcPath) throws IllegalArgumentException, IOException{
		File f = new File(srcPath);
		this.image = ImageIO.read(f);
	}
	
	public void saveImage(String dstPath) throws IllegalArgumentException, IOException{
		File f = new File(dstPath);
		ImageIO.write(this.image, "png", f);
	}
}