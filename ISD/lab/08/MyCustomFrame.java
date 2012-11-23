import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

public class MyCustomFrame extends JFrame{
	JButton button;
	JLabel label;
	JTextField field;
	JTextArea area;
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 800;
	
	public MyCustomFrame(){
		createComponents();
		this.setSize(FRAME_WIDTH,FRAME_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void createComponents(){
		JPanel panel = new JPanel();
		this.add(panel);	
		this.button = new JButton("call me button");
		this.button.addActionListener(new ClickListener());
		this.label = new JLabel("I'm a label");
		panel.add(button);
		panel.add(label);
		this.field =  new JTextField("");
		this.field.setColumns(10);
		this.area = new JTextArea(10,30);
		this.area.setText("||");
		area.setEditable(false);
		panel.add(field);
		panel.add(area);
	}
	
	class ClickListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			//System.out.println("Button was clicked");
			label.setText("Button was clicked");
			area.append(field.getText() + "||");
		}
	}
	
	public static void main(String[] args){
		MyCustomFrame frame = new MyCustomFrame();
		frame.setTitle("My Custom Frame");
	}
}