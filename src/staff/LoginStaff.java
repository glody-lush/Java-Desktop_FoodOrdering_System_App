package staff;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JTextField;

import database.Datebase;
import welcomepage.WelcomePage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class LoginStaff {

	public JFrame frame;
	private JTextField nameJtextField;
	private JTextField staffNumberJtextField;
	private JButton loginJButton ;
    private JButton cancelJButton ;
    private JPasswordField passwordJtextField;
    private JLabel picJLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginStaff window = new LoginStaff();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginStaff() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 564, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JLabel nameJLabel = new JLabel("Name ");
		nameJLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameJLabel.setBounds(94, 61, 80, 36);
		frame.getContentPane().add(nameJLabel);
		
		JLabel staffnumberJLabel = new JLabel("Staff Number");
		staffnumberJLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		staffnumberJLabel.setBounds(94, 125, 96, 19);
		frame.getContentPane().add(staffnumberJLabel);
		
		nameJtextField = new JTextField();
		nameJtextField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nameJtextField.setBounds(237, 70, 226, 20);
		frame.getContentPane().add(nameJtextField);
		nameJtextField.setColumns(10);
		
		staffNumberJtextField = new JTextField();
		staffNumberJtextField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		staffNumberJtextField.setBounds(237, 125, 226, 20);
		frame.getContentPane().add(staffNumberJtextField);
		staffNumberJtextField.setColumns(10);
		
		JLabel passwordJLabel = new JLabel("Password");
		passwordJLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordJLabel.setBounds(94, 172, 80, 20);
		frame.getContentPane().add(passwordJLabel);
		
		loginJButton = new JButton("LOGIN");
		loginJButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		loginJButton.setBounds(274, 242, 89, 23);
		frame.getContentPane().add(loginJButton);
		
	    cancelJButton = new JButton("CANCEL");
		cancelJButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cancelJButton.setBounds(374, 242, 89, 23);
		frame.getContentPane().add(cancelJButton);
		
		passwordJtextField = new JPasswordField();
		passwordJtextField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		passwordJtextField.setBounds(237, 173, 226, 20);
		frame.getContentPane().add(passwordJtextField);
		
		picJLabel = new JLabel("");
		picJLabel.setBounds(0, 0, 558, 331);
		frame.getContentPane().add(picJLabel);
        Image img = new ImageIcon(this.getClass().getResource("/logincustomer.jpg")).getImage();
		picJLabel.setIcon(new ImageIcon(img));
		
		// add Buttons
		
		ButtonHandler handler= new ButtonHandler();
		loginJButton.addActionListener(handler);
		cancelJButton.addActionListener(handler);
	}
	
	private class ButtonHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			
			 Datebase data = new Datebase();
			 String name = nameJtextField.getText();
			 String staffNumber = staffNumberJtextField.getText();
			 String Password = passwordJtextField.getText();
			 
		 if(event.getSource() == loginJButton)
		 {
			 
			try {
				data.employeeLogin(name, staffNumber, Password);
				frame.setVisible(false);
				
			} catch (SQLException e) {
				
				JOptionPane.showMessageDialog(null, "Error");
				e.printStackTrace();
			}
			 
		 }
		 
		 else if(event.getSource()== cancelJButton)
		 {
			 frame.setVisible(false);
			 WelcomePage window = new WelcomePage();
			window.frame.setVisible(true);
		 }
			
		}
		
		
		
		
		
		
		
	}
}
