package customer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

import database.Datebase;
import item.FoodMenu;

import javax.swing.JTextArea;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;

public class CustomerProfile {

	public JFrame frame;
    private JScrollPane UserScrollpane;
    private JTextField textField;
    public static JTextArea OrderStatustextArea;
    private JButton StatusButton;
    private JButton btnRemoveorder;
    private JButton historyButton;
    private JPanel CancelOrderpanel;
    private JButton managedButton;
    private JButton RateButton;
    private JButton HideProfilecustonJButton;
    private JRadioButton rdbtnNewRadioButton;
    private JRadioButton rdbtnUnsatisfied;
    private JRadioButton rdbtnUnhappy;
    private JRadioButton rdbtnExcellent;
    public static JTextField emailCustomerprofiletextField_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerProfile window = new CustomerProfile();
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
	public CustomerProfile() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 11));
		frame.setBounds(100, 100, 495, 334);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	    rdbtnNewRadioButton = new JRadioButton("happy");
		rdbtnNewRadioButton.setBounds(318, 44, 109, 14);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		
		
		rdbtnUnsatisfied = new JRadioButton("unsatisfied");
		rdbtnUnsatisfied.setBounds(318, 77, 109, 14);
		frame.getContentPane().add(rdbtnUnsatisfied);
		
		rdbtnUnhappy = new JRadioButton("unhappy");
		rdbtnUnhappy.setBounds(318, 109, 109, 14);
		frame.getContentPane().add(rdbtnUnhappy);
		
		rdbtnExcellent = new JRadioButton("Excellent");
		rdbtnExcellent.setBounds(318, 135, 109, 14);
		frame.getContentPane().add(rdbtnExcellent);
		
		RateButton = new JButton("Rate");
		RateButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		RateButton.setBounds(318, 156, 89, 23);
		frame.getContentPane().add(RateButton);
		
		//****grouping radio buttons to enable one option at a time
		ButtonGroup a =new ButtonGroup();
		a.add(rdbtnExcellent);
		a.add(rdbtnUnhappy);
		a.add(rdbtnUnsatisfied);
		a.add(rdbtnNewRadioButton);
		//***********************************************************
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(300, 35, 169, 157);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Rate The Service");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel.setBounds(328, 14, 130, 14);
		frame.getContentPane().add(lblNewLabel);
		
	    StatusButton = new JButton("Status");
		StatusButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		StatusButton.setBounds(10, 100, 89, 23);
		frame.getContentPane().add(StatusButton);
		
	    OrderStatustextArea = new JTextArea();
		OrderStatustextArea.setFont(new Font("Tahoma", Font.BOLD, 13));
		OrderStatustextArea.setEditable(false);
		//OrderStatustextArea.setBounds(10, 34, 280, 57);
		//frame.getContentPane().add(OrderStatustextArea);
		
	    UserScrollpane = new JScrollPane(OrderStatustextArea,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		UserScrollpane.setBounds(10, 34, 280, 57);
		UserScrollpane.setVisible(false);
		frame.getContentPane().add(UserScrollpane);
		
		
		JLabel lblNewLabel_1 = new JLabel("items");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(10, 15, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblQty = new JLabel("Qty");
		lblQty.setFont(new Font("Dialog", Font.BOLD, 12));
		lblQty.setBounds(83, 14, 46, 14);
		frame.getContentPane().add(lblQty);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStatus.setBounds(216, 15, 46, 14);
		frame.getContentPane().add(lblStatus);
		
		managedButton = new JButton("Manage");
		managedButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		managedButton.setBounds(10, 131, 89, 23);
		frame.getContentPane().add(managedButton);
		
		JLabel lblNewLabel_2 = new JLabel("OrderNo.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(136, 15, 56, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel label = new JLabel("");
		label.setBounds(216, 160, 46, 14);
		frame.getContentPane().add(label);
		
	    CancelOrderpanel = new JPanel();
		CancelOrderpanel.setBackground(Color.WHITE);
		CancelOrderpanel.setBounds(10, 204, 314, 41);
		frame.getContentPane().add(CancelOrderpanel);
		
		JLabel lblOrderno = new JLabel("OrderNo");
		CancelOrderpanel.add(lblOrderno);
		lblOrderno.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel label_1 = new JLabel("");
		CancelOrderpanel.add(label_1);
		
		textField = new JTextField();
		CancelOrderpanel.add(textField);
		textField.setColumns(10);
		
		btnRemoveorder = new JButton("RemoveOrder");
		btnRemoveorder.setBackground(Color.BLACK);
		CancelOrderpanel.add(btnRemoveorder);
		
	    historyButton = new JButton("History");
		historyButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		historyButton.setBounds(10, 169, 89, 23);
		frame.getContentPane().add(historyButton);
		
		JLabel UserLabel_3 = new JLabel("User");
		UserLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		UserLabel_3.setBounds(10, 270, 46, 14);
		frame.getContentPane().add(UserLabel_3);
		
		emailCustomerprofiletextField_1 = new JTextField();
		emailCustomerprofiletextField_1.setEditable(false);
		emailCustomerprofiletextField_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		emailCustomerprofiletextField_1.setBounds(53, 268, 195, 20);
		frame.getContentPane().add(emailCustomerprofiletextField_1);
		emailCustomerprofiletextField_1.setColumns(10);
		
		HideProfilecustonJButton = new JButton("Hide");
		HideProfilecustonJButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		HideProfilecustonJButton.setBounds(357, 267, 89, 23);
		frame.getContentPane().add(HideProfilecustonJButton);
		CancelOrderpanel.setVisible(false);
	
		
		       // add Button
		
		ButtonHandler handler =  new ButtonHandler();
		StatusButton.addActionListener(handler);
		managedButton.addActionListener(handler);
		historyButton.addActionListener(handler);
		RateButton.addActionListener(handler);
		btnRemoveorder.addActionListener(handler);
		HideProfilecustonJButton.addActionListener(handler);
		
	}
	
	
	private class ButtonHandler implements ActionListener
	{
		Datebase data = new Datebase();
		
		
		@Override
		public void actionPerformed(ActionEvent event) {
		
			String email = emailCustomerprofiletextField_1.getText();
			String OrderNum = textField.getText();
			System.out.print(email);
			if(event.getSource() ==StatusButton )
			{
				
				
				try {
					UserScrollpane.setVisible(true);
					CancelOrderpanel.setVisible(false);
					 OrderStatustextArea.setText("");
					data.profilestatus(email);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
			
			else if(event.getSource() ==historyButton)
				
			{
				UserScrollpane.setVisible(false);
				CancelOrderpanel.setVisible(false);
			}
			
          
			
           else if(event.getSource()==managedButton)
           {
        	   UserScrollpane.setVisible(false);
        	   CancelOrderpanel.setVisible(true);
        	   
        	   
           }
			
           else if(event.getSource() ==btnRemoveorder)
				
			{
				try {
					if(data.ExictingOrderNo(OrderNum, email)== "Existe")
					{
						JOptionPane.showMessageDialog(null, "Order Has been Removed");
						
					}
					
					else if(data.ExictingOrderNo(OrderNum, email)== "Doesn't exit")
					{
						JOptionPane.showMessageDialog(null, "Order never existed");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
   
			
           else if(event.getSource()==HideProfilecustonJButton)
           {
        	 
				frame.setVisible(false);
        	   
           }
			
           else if(event.getSource()==RateButton)
           {
        	   
        	   UserScrollpane.setVisible(false);
        	   CancelOrderpanel.setVisible(false);
        	 if(rdbtnNewRadioButton.isSelected())
        	 {
        		 try {
					data.Rate(email, "happy");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	 }
        	 else if(rdbtnUnsatisfied.isSelected())
        	 {
        		 try {
					data.Rate(email, "unsatisfied");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	 }
        	 else if(rdbtnUnhappy.isSelected())
        	 {
        		 try {
					data.Rate(email, "unhappy");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	 }
        	 else if(rdbtnExcellent.isSelected())
        	 {
        		 try {
					data.Rate(email, "Excellent");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	 }
        	 else
        	 {
        		 JOptionPane.showMessageDialog(null, "Please rate our service by clicking one of the options above");
        		 
        	 }
        	   
           }// end of the if else statement of rate button
			
		}// end of actionPerformed method
		
		
		//(SQLIntegrityConstraintViolationException) catch for each radioButton this error
		
		
		
		
	}//end of inner ButtonHandler class
}
