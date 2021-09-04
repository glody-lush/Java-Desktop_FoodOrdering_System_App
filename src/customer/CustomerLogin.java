package customer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;

import database.Datebase;
import item.FoodMenu;
import welcomepage.WelcomePage;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class CustomerLogin {

	public JFrame frmWelcomeToOur;
	public static JTextField emailaddressJTextField;
	private JLabel PasswordJLabel;
	private JPasswordField passwordJTextField;
	private JButton RecoverPasswordJButton;
	private JButton CanceJButtonl;
	private JButton SinginLoginJButton;
	private JButton SignupRegisterJButton;
	private JLabel picJLabel;

	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerLogin window = new CustomerLogin();
					window.frmWelcomeToOur.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CustomerLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWelcomeToOur = new JFrame();
		frmWelcomeToOur.getContentPane().setForeground(new Color(0, 0, 0));
		frmWelcomeToOur.setResizable(false);
		/*frmWelcomeToOur.setUndecorated(true); // To removed the frame outline*/
		frmWelcomeToOur.setBounds(400, 600, 590, 390);
		frmWelcomeToOur.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWelcomeToOur.getContentPane().setLayout(null);
		frmWelcomeToOur.setLocationRelativeTo(null);
		
		JLabel EmailAddressJLabel = new JLabel(" Email Address");
		EmailAddressJLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		EmailAddressJLabel.setForeground(new Color(0, 0, 0));
		EmailAddressJLabel.setBounds(25, 86, 97, 26);
		frmWelcomeToOur.getContentPane().add(EmailAddressJLabel);
		
		emailaddressJTextField = new JTextField();
		emailaddressJTextField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		emailaddressJTextField.setBounds(147, 88, 304, 25);
		frmWelcomeToOur.getContentPane().add(emailaddressJTextField);
		emailaddressJTextField.setColumns(10);
		
		PasswordJLabel = new JLabel("Password");
		PasswordJLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		PasswordJLabel.setBounds(25, 122, 80, 26);
		frmWelcomeToOur.getContentPane().add(PasswordJLabel);
		
		passwordJTextField = new JPasswordField();
		passwordJTextField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		passwordJTextField.setBounds(147, 124, 304, 25);
		frmWelcomeToOur.getContentPane().add(passwordJTextField);
		
		SinginLoginJButton = new JButton("SIGNIN/LOGIN");
		SinginLoginJButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		SinginLoginJButton.setBounds(175, 171, 231, 23);
		frmWelcomeToOur.getContentPane().add(SinginLoginJButton);
		
		SignupRegisterJButton = new JButton("SIGNUP/REGISTER");
		SignupRegisterJButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		SignupRegisterJButton.setBounds(326, 228, 157, 23);
		frmWelcomeToOur.getContentPane().add(SignupRegisterJButton);
		
		RecoverPasswordJButton = new JButton("Recover Password");
		RecoverPasswordJButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		RecoverPasswordJButton.setBounds(147, 228, 147, 23);
		frmWelcomeToOur.getContentPane().add(RecoverPasswordJButton);
		
		CanceJButtonl = new JButton("CANCEL");
		CanceJButtonl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		CanceJButtonl.setBounds(377, 281, 89, 23);
		frmWelcomeToOur.getContentPane().add(CanceJButtonl);
		
		picJLabel = new JLabel("");
		picJLabel.setBounds(0, 0, 584, 361);
		frmWelcomeToOur.getContentPane().add(picJLabel);
		Image img = new ImageIcon(this.getClass().getResource("/logincustomer.jpg")).getImage();
		picJLabel.setIcon(new ImageIcon(img));
		
		
		
		
		
		// register buttons
		
		ButtonHanler handler = new ButtonHanler();
		SinginLoginJButton.addActionListener(handler);
		RecoverPasswordJButton.addActionListener(handler);
		SignupRegisterJButton.addActionListener(handler);
		CanceJButtonl.addActionListener(handler);
	}
	
	
	private class ButtonHanler implements ActionListener{

		@SuppressWarnings("null")
		@Override
		public void actionPerformed(ActionEvent event) {
			
			Datebase data = new Datebase();  // creating database object
			
			
			String email = emailaddressJTextField.getText();
			String password = passwordJTextField.getText();
					
			
			
			if(event.getSource()== SinginLoginJButton )
			{
				try
				{
					//______________________________________________Checking if the method returned failed or successful
				if(data.CustomerLogin(email, password)=="success")
				{
					
					//----------------------------------------------calling the foodmanu class
				    FoodMenu window = new FoodMenu();
				    FoodMenu.EmailUserTextField.setText(email);
				    window.frame.setVisible(true);
				    JOptionPane.showMessageDialog(null, "welcome to our restaurant Menu\t "+email);
				    frmWelcomeToOur.setVisible(false);
				}
				else if(data.CustomerLogin(email, password)=="failed") 
				{
					JOptionPane.showMessageDialog(null, "Incorrect password/email");
				}
				
				} 
				catch (SQLException e) {
					
					JOptionPane.showMessageDialog(null, "SINGNUP/REGISTER Before SIGNIN/LOGIN");
					e.printStackTrace();
				}
				
			}
			
			else if (event.getSource()==RecoverPasswordJButton)
			{
				/*FoodMenu window = new FoodMenu();
				window.frame.setVisible(true);*/
				JOptionPane.showMessageDialog(null, "Haven't implemented yet");

				
			}
			
			
			else if (event.getSource()==SignupRegisterJButton)
			{
				frmWelcomeToOur.setVisible(false);
				CustomerRegistration window = new CustomerRegistration();
				window.frame.setVisible(true);
				
			}
			else if (event.getSource()==CanceJButtonl)
			{
				frmWelcomeToOur.setVisible(false);
				WelcomePage window = new WelcomePage();
				window.frame.setVisible(true);
				
			}
		}
		
	}
	
	public String ekmail()
	{
		String email = emailaddressJTextField.getText();
		/*Email_Storage email_Session=new Email_Storage() ;
		//Email_Storage[] email_Session = new Email_Storage[1];
		List<Email_Storage> list = new ArrayList<>();
		email_Session.setEmail(email);
		JOptionPane.showMessageDialog(null, "checking\n"+email_Session.getEmail());
		 list.add(email_Session);*/
		 
		return  email;
		
	}
	
}
