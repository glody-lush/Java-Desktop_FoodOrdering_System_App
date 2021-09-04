package welcomepage;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

import customer.CustomerLogin;
import manager.ManagerLogin;
import manager.ManagerMenu;
import staff.LoginStaff;


public class WelcomePage {

	public JFrame frame;
	private JLabel picJLabel;
	private JButton customerJButton;
    private JButton StaffJButton;
    private JButton ManagerJButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomePage window = new WelcomePage();
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
	public WelcomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		frame.setBounds(100, 100, 735, 451);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		customerJButton = new JButton("Customers");
		customerJButton.setBackground(Color.CYAN);
		customerJButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		customerJButton.setBounds(52, 344, 115, 42);
		frame.getContentPane().add(customerJButton);
		
		StaffJButton = new JButton("Staff");
		StaffJButton.setBackground(Color.CYAN);
		StaffJButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		StaffJButton.setBounds(299, 344, 115, 42);
		frame.getContentPane().add(StaffJButton);
		
		ManagerJButton = new JButton("Manager");
		ManagerJButton.setBackground(Color.RED);
		ManagerJButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		ManagerJButton.setBounds(528, 344, 115, 42);
		frame.getContentPane().add(ManagerJButton);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 419, 729, 3);
		frame.getContentPane().add(panel);
	    
	    JLabel WelcomepageJLabel = new JLabel("    WELCOME TO FOOD ORDERING SYSTEM");
	    WelcomepageJLabel.setBounds(148, 76, 457, 55);
	    frame.getContentPane().add(WelcomepageJLabel);
	    WelcomepageJLabel.setForeground(Color.BLACK);
	    WelcomepageJLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
	    
	    picJLabel = new JLabel("");// JLabel for picture background
	    picJLabel.setBounds(0, 0, 729, 422);
	    frame.getContentPane().add(picJLabel);
	    Image img = new ImageIcon(this.getClass().getResource("/welcomepage.png")).getImage();
	    picJLabel.setIcon(new ImageIcon(img));
		
	    //add buttons
	    ButtonHandler handler = new ButtonHandler();
	    customerJButton.addActionListener(handler);
	    ManagerJButton.addActionListener(handler);
	    StaffJButton.addActionListener(handler);
	}// end of initialize methode
	
	private class ButtonHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			
			if(event.getSource()==customerJButton)
			{
				frame.setVisible(false);
				CustomerLogin window = new CustomerLogin();
				window.frmWelcomeToOur.setVisible(true);
			}// end of customerJButton
			  
			
			else if(event.getSource()==ManagerJButton)
			{
				frame.setVisible(false);
				ManagerLogin window = new ManagerLogin();
				window.frame.setVisible(true);
				
			}// end of customerJButton
			
			else if(event.getSource()==StaffJButton )
			{
				frame.setVisible(false);
				LoginStaff window = new LoginStaff();
				window.frame.setVisible(true);
				
			}// end of StaffJButton
		}
		
		
		
		
		
		
		
	}
	
}
