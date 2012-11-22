import javax.swing.JFrame;

public class MyFirstFrame{
	public static void main(String[] args){
		JFrame frame = new JFrame();
		final int FRAME_WIDTH = 800;
		final int FRAME_HEIGHT = 800;
		frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
		frame.setTitle("My first frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}