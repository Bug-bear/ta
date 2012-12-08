import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public abstract class SteganImage{
	protected BufferedImage image;
	static final String START = "[";
	static final String END = "]";
	
	public SteganImage(String srcPath) throws IllegalArgumentException, IOException{
		File f = new File(srcPath);
		this.image = ImageIO.read(f);
	}
	
	abstract public void writeMessage(String text);
	
	abstract public String readMessage();
	
	public void saveImage(String dstPath) throws IllegalArgumentException, IOException{
		File f = new File(dstPath);
		ImageIO.write(this.image, "png", f);
	}
}