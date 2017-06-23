import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Form {
	private JFrame mainFrame;

	public Form() {
		mainFrame = new JFrame("Java Swing Examples");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(400,400);


		mainFrame.setVisible(true); 
	}

}