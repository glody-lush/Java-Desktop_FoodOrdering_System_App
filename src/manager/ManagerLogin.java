package manager;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
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

public class ManagerLogin {

	public JFrame frame;
	private JTextField NameJTextField;
	private JTextField StaffNumberJTextField;
	private JButton LoginJButton ;
	private JButton CancelJButton ;
	private JButton ResetJButton ;
	private JPasswordField passwordField;
	private JLabel picJLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				
					ManagerLogin window = new ManagerLogin();
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
	public ManagerLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 597, 411);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel NameJLabel = new JLabel("Name");
		NameJLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		NameJLabel.setBounds(89, 108, 54, 14);
		frame.getContentPane().add(NameJLabel);
		
		NameJTextField = new JTextField();
		NameJTextField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		NameJTextField.setBounds(262, 106, 195, 20);
		frame.getContentPane().add(NameJTextField);
		NameJTextField.setColumns(10);
		
		JLabel StaffNumberJLabel = new JLabel("Staff Number");
		StaffNumberJLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		StaffNumberJLabel.setBounds(89, 158, 94, 14);
		frame.getContentPane().add(StaffNumberJLabel);
		
		StaffNumberJTextField = new JTextField();
		StaffNumberJTextField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		StaffNumberJTextField.setColumns(10);
		StaffNumberJTextField.setBounds(262, 152, 195, 20);
		frame.getContentPane().add(StaffNumberJTextField);
		
	    LoginJButton = new JButton("LOGIN");
		LoginJButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LoginJButton.setBounds(146, 298, 89, 23);
		frame.getContentPane().add(LoginJButton);
		
	    CancelJButton = new JButton("CANCEL");
		CancelJButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		CancelJButton.setBounds(422, 298, 89, 23);
		frame.getContentPane().add(CancelJButton);
		
	    ResetJButton = new JButton("RESET");
		ResetJButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ResetJButton.setBounds(298, 298, 89, 23);
		frame.getContentPane().add(ResetJButton);
		
		JLabel PasswordJLabel = new JLabel("Password");
		PasswordJLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		PasswordJLabel.setBounds(89, 211, 94, 14);
		frame.getContentPane().add(PasswordJLabel);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		passwordField.setBounds(262, 210, 195, 20);
		frame.getContentPane().add(passwordField);
		
		picJLabel = new JLabel("");
		picJLabel.setBounds(0, 0, 585, 372);
		frame.getContentPane().add(picJLabel);
		Image img = new ImageIcon(this.getClass().getResource("/logincustomer.jpg")).getImage();
		picJLabel.setIcon(new ImageIcon(img));
		
		//add buttons
		ButtonHandler handler = new ButtonHandler();
		LoginJButton.addActionListener(handler);
		CancelJButton.addActionListener(handler);
		
	}// end of initialize method
	
	private class ButtonHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			Datebase data = new Datebase();
			if(event.getSource()==LoginJButton)
			{
				//frame.setVisible(false);
				try {
					data.ManagerLogin(NameJTextField.getText(), StaffNumberJTextField.getText(), passwordField.getText());
					frame.setVisible(false);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			else if(event.getSource()== CancelJButton)
			{
				frame.setVisible(false);
				WelcomePage window = new WelcomePage();
				window.frame.setVisible(true);
			}
			
		}
		
		
		
		
	}
}
