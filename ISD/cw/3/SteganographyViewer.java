import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class SteganographyViewer{
	public static void main(String[] args){
		try {
			UIManager.setLookAndFeel(
				// Set cross-platform Java L&F (also called "Metal")
				//UIManager.getCrossPlatformLookAndFeelClassName()); 
				// Set System L&F
				UIManager.getSystemLookAndFeelClassName());
				
			// Set Motif L&F on any platform
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");				
		} 
		catch (UnsupportedLookAndFeelException e) {
		   // handle exception
		}
		catch (ClassNotFoundException e) {
		   // handle exception
		}
		catch (InstantiationException e) {
		   // handle exception
		}
		catch (IllegalAccessException e) {
		   // handle exception
		}
	
		JFrame frame = new SteganographyFrame();
		frame.setTitle("Eddy's little naive messenger - Ver. 09/12/2012");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}