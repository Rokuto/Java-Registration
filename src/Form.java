/* Swing Imports */
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

/* IO Imports */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

/* AWT Import */
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Form {
	private JFrame mainFrame;

	private JTextField age;
	private JTextField name;
	private JTextField contact;

	private JLabel labelAge;
	private JLabel labelName;
	private JLabel labelContact;

	private JButton submit;

	private int xAlignLabel;
	private int heightLabel;
	private int xAligntxtField;
	private int widthtxtField;
	private int heighttxtField;

	public Form() {
		xAlignLabel = 5;
		heightLabel = 15;
		xAligntxtField = 128;
		widthtxtField = 250;
		heighttxtField = 20;

		mainFrame = new JFrame("Registration"); // provide the name of the program
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // enable close button
		mainFrame.setSize(400,400); // size to be 400 by 400
		mainFrame.getContentPane().setLayout(null);

		age = new JTextField();
		age.setBounds(xAligntxtField, 58, widthtxtField, heighttxtField);
		mainFrame.getContentPane().add(age);
		age.setColumns(10);

		labelAge = new JLabel("Age:");
		labelAge.setBounds(xAlignLabel, 61, 46, heightLabel);
		mainFrame.getContentPane().add(labelAge);

		name = new JTextField();
		name.setBounds(xAligntxtField, 28, widthtxtField, heighttxtField);
		mainFrame.getContentPane().add(name);
		name.setColumns(10);

		labelName = new JLabel("Name:");
		labelName.setBounds(xAlignLabel, 31, 46, heightLabel);
		mainFrame.getContentPane().add(labelName);

		contact = new JTextField();
		contact.setBounds(xAligntxtField, 88, widthtxtField, heighttxtField);
		mainFrame.getContentPane().add(contact);
		contact.setColumns(10);

		labelContact = new JLabel("Contact Number:");
		labelContact.setBounds(xAlignLabel, 91, 126, heightLabel);
		mainFrame.getContentPane().add(labelContact);

		submit = new JButton("Submit");
		submit.addMouseListener(new MouseListener() {
			private File output;
			private BufferedWriter bw;
			private FileWriter fileWritter;

		    public void mouseClicked(MouseEvent e) {
		    	if( contact.getText().trim().length() == 0 || name.getText().trim().length() == 0 || age.getText().trim().length() == 0 ){
		    		System.out.println("Cannot Add");
		    		return;
		    	}

		    	try{
			    	output = new File("Registration.csv");
			    	if( !output.exists() ){
			    		output.createNewFile();
			    		
			    		/* Create header */
			    		fileWritter = new FileWriter(output.getName(),true);
		    			bw = new BufferedWriter(fileWritter);
		    			bw.write("name,age,contact\n" );
		    			bw.close();
			    	}
			    	
			    	fileWritter = new FileWriter(output.getName(),true);
		    		bw = new BufferedWriter(fileWritter);

		    		bw.write("" + name.getText().trim() + "," + age.getText().trim() + "," + contact.getText().trim() + ",\n" );
		    		bw.close();

		    		/* Clear texrfields */
		    		age.setText("");
		    		name.setText("");
		    		contact.setText("");

		    		JOptionPane.showMessageDialog(mainFrame,"Thank You"); 
		    	}catch(IOException err){
		    		err.printStackTrace();
		    	}

		    }

		    public void mousePressed(MouseEvent e) {}

		    public void mouseReleased(MouseEvent e) {}

		    public void mouseEntered(MouseEvent e) {}

		    public void mouseExited(MouseEvent e) {}

		});
		submit.setBounds(50, 120, 100, 20);
		mainFrame.getContentPane().add(submit);

		mainFrame.setLocationRelativeTo(null); // align the program at the center
		mainFrame.setVisible(true); // show changes
	}

}