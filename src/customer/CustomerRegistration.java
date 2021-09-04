package customer;

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
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JPasswordField;

public class CustomerRegistration {

	public static JFrame frame;
	private JTextField nameJtextField;
	private JTextField surnameJtextField;
	private JTextField emailJtextField;
	private JTextField phonenumberJtextField;
	private JTextField areaAddressJtextField;
	private JTextField streetaddressJtextField;
	private JTextField flatnameaddressJTextField;
	private JButton cancelJButton;
	private JButton submitJButton;
	private JPasswordField passwordJTextField;
	private JPasswordField ConfirmpasswordJTextField;
	private JLabel picJLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerRegistration window = new CustomerRegistration();
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
	public CustomerRegistration() {
		initialize();
	}// end of CustomerRegistration constructor

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 654, 478);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JLabel nameJLabel = new JLabel("Name");
		nameJLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		nameJLabel.setBounds(77, 73, 53, 22);
		frame.getContentPane().add(nameJLabel);
		
		JLabel surnameJLabel = new JLabel("Surname");
		surnameJLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		surnameJLabel.setBounds(77, 105, 71, 22);
		frame.getContentPane().add(surnameJLabel);
		
		JLabel emailJLabel = new JLabel("Email ");
		emailJLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		emailJLabel.setBounds(77, 138, 59, 22);
		frame.getContentPane().add(emailJLabel);
		
		JLabel addrerssJlabel = new JLabel("Address");
		addrerssJlabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		addrerssJlabel.setBounds(84, 221, 90, 28);
		frame.getContentPane().add(addrerssJlabel);
		
		JLabel phonenumberJLabel = new JLabel("Phone Number");
		phonenumberJLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		phonenumberJLabel.setBounds(77, 171, 122, 22);
		frame.getContentPane().add(phonenumberJLabel);
		
		JLabel passwordJLabel = new JLabel("Password");
		passwordJLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordJLabel.setBounds(77, 303, 71, 22);
		frame.getContentPane().add(passwordJLabel);
		
		JLabel confirmpasswordJLabel = new JLabel("Confirm Password");
		confirmpasswordJLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		confirmpasswordJLabel.setBounds(77, 336, 135, 25);
		frame.getContentPane().add(confirmpasswordJLabel);
		
		nameJtextField = new JTextField();          
		nameJtextField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nameJtextField.setBounds(226, 75, 286, 20);  
		frame.getContentPane().add(nameJtextField);
		nameJtextField.setColumns(10);
		
		surnameJtextField = new JTextField();   
		surnameJtextField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		surnameJtextField.setText("");
		surnameJtextField.setBounds(226, 107, 286, 20);
		frame.getContentPane().add(surnameJtextField);
		surnameJtextField.setColumns(10);
		
		emailJtextField = new JTextField();
		emailJtextField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		emailJtextField.setText("");
		emailJtextField.setBounds(226, 140, 286, 20);
		frame.getContentPane().add(emailJtextField);
		emailJtextField.setColumns(10);
		
		phonenumberJtextField = new JTextField();
		phonenumberJtextField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		phonenumberJtextField.setBounds(226, 173, 286, 20);
		frame.getContentPane().add(phonenumberJtextField);
		phonenumberJtextField.setColumns(10);
		
		areaAddressJtextField = new JTextField();
		areaAddressJtextField.setToolTipText("Area& flatName");
		areaAddressJtextField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		areaAddressJtextField.setBounds(226, 226, 286, 20);
		frame.getContentPane().add(areaAddressJtextField);
		areaAddressJtextField.setColumns(10);
		
	    cancelJButton = new JButton("CANCEL");
	    cancelJButton.setBackground(new Color(255, 0, 0));
		cancelJButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cancelJButton.setBounds(243, 393, 89, 23);
		frame.getContentPane().add(cancelJButton);
		
	    submitJButton = new JButton("SUBMIT");
	    submitJButton.setBackground(new Color(0, 255, 255));
		submitJButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		submitJButton.setBounds(423, 393, 89, 23);
		frame.getContentPane().add(submitJButton);
		
		streetaddressJtextField = new JTextField();
		streetaddressJtextField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		streetaddressJtextField.setToolTipText("StreetNo & StreetName");
		streetaddressJtextField.setColumns(10);
		streetaddressJtextField.setBounds(226, 248, 286, 20);
		frame.getContentPane().add(streetaddressJtextField);
		
		flatnameaddressJTextField = new JTextField();
		flatnameaddressJTextField.setToolTipText("Enter FlatNumber ");
		flatnameaddressJTextField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		flatnameaddressJTextField.setColumns(10);
		flatnameaddressJTextField.setBounds(226, 275, 286, 20);
		frame.getContentPane().add(flatnameaddressJTextField);
		
		passwordJTextField = new JPasswordField();
		passwordJTextField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		passwordJTextField.setBounds(226, 305, 286, 20);
		frame.getContentPane().add(passwordJTextField);
		
		ConfirmpasswordJTextField = new JPasswordField();
		ConfirmpasswordJTextField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ConfirmpasswordJTextField.setBounds(226, 339, 286, 20);
		frame.getContentPane().add(ConfirmpasswordJTextField);
		
		picJLabel = new JLabel("");
		picJLabel.setBounds(0, 0, 648, 449);
		frame.getContentPane().add(picJLabel);
		Image img = new ImageIcon(this.getClass().getResource("/customerSignUp.jpg")).getImage();
		picJLabel.setIcon(new ImageIcon(img));
		
		
		// register button
		ButtonHandler handler =  new ButtonHandler();
		cancelJButton.addActionListener(handler);
		submitJButton.addActionListener(handler);
		
		
	}// end of initialize method
	
  	private class ButtonHandler implements ActionListener{

		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent event) {
			
			Datebase data = new Datebase();       // creating a database object
			
			 String name = nameJtextField.getText(); 
			 String surname =surnameJtextField.getText(); 
			 String email = emailJtextField.getText(); 
			 String Phone = phonenumberJtextField.getText();
			 String password = passwordJTextField.getText();
			 String passwordConf = ConfirmpasswordJTextField.getText();
			 String areaName = areaAddressJtextField.getText();
		     String streetName = streetaddressJtextField.getText();
	   	     String flatName = flatnameaddressJTextField.getText();
			   
			if(event.getSource() == submitJButton )
			{
				
				
				if(name.length()==0||surname.length()==0||email.length()==0||Phone.length()==0)
				{
					JOptionPane.showMessageDialog(null,"personal details fields cannot be empty");
				}
				else if((password.length()<=3 || passwordConf.length()<=3)) 
				{
					JOptionPane.showMessageDialog(null,"passwords too short");
				}
				
				else if( !(password.equals(passwordConf)) )
				{
					JOptionPane.showMessageDialog(null,"passwords don't match");
				}
				
				else
				{
					JOptionPane.showMessageDialog(null,"welcome now you can login");
					try {
						data.Registration(name, surname, email, Phone, areaName, streetName, flatName, password, passwordConf);
						frame.setVisible(false);
						CustomerLogin window = new CustomerLogin();
						window.frmWelcomeToOur.setVisible(true);
						
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null,"could not register you");
						e.printStackTrace();
					}
				
				}
				
			}
			
			else if(event.getSource()==cancelJButton )
			{
				
				frame.setVisible(false);
				WelcomePage window = new WelcomePage();
				window.frame.setVisible(true);
			}
		
			
			
		}
  		
  		
  		
  		
  		
  		
  		
  		
  		
  		
  		
  	}
}
