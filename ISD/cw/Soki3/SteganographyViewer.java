import javax.swing.JFrame;

public class SteganographyViewer
{
	public static void main(String[] args)
	{
		JFrame frame = new SteganographyFrame();
		final int FRAME_WIDTH = 500;
		final int FRAME_HEIGHT = 350;
		frame.setTitle("Steganography");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}