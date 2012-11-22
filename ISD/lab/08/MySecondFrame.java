import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;

public class MySecondFrame{
	public static void main(String[] args){
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		JButton button = new JButton("click me");
		JLabel label = new JLabel("i'm a label");
		panel.add(button);
		panel.add(label);
		JFrame frame = new JFrame();
		final int FRAME_WIDTH = 800;
		final int FRAME_HEIGHT = 800;
		frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
		frame.setTitle("my second frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(panel);
	}
}