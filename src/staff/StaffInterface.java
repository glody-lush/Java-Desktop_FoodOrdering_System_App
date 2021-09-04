package staff;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JInternalFrame;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import customer.CustomerProfile;
import database.Datebase;
import welcomepage.WelcomePage;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.JTextField;

public class StaffInterface {

	public JFrame frame;
	private JScrollPane UserScrollpane;
	public static JTextArea staffInterfaceJtextArea;
   private final JPanel panel= new JPanel();
   private JButton viewOrdersJButton; 
   private JButton ManageOrderButton;
   private JTextField textFieldOrderNum;
   private JTextField StatusOrderNumtextField_1;
   private JInternalFrame Client;
   private JButton hidebutton;
   private JButton UpdateButton;
   private JButton BackMenu;
   
            
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffInterface window = new StaffInterface();
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
	public StaffInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 902, 432);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		panel.setBackground(new Color(0, 0, 255));
		panel.setBounds(0, 317, 886, 76);
		frame.getContentPane().add(panel);
		
		viewOrdersJButton = new JButton("Orders");
		panel.add(viewOrdersJButton);
		viewOrdersJButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		ManageOrderButton = new JButton("Manage");
		ManageOrderButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel.add(ManageOrderButton);
		
		JInternalFrame internalFrame = new JInternalFrame("");
		internalFrame.setBounds(10, 11, 866, 295);
		frame.getContentPane().add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		
	    staffInterfaceJtextArea = new JTextArea();
	    staffInterfaceJtextArea.setEditable(false);
	    staffInterfaceJtextArea.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JSlider slider = new JSlider();
		slider.setFont(new Font("Tahoma", Font.PLAIN, 13));
		slider.setBackground(new Color(30, 144, 255));
		slider.setBounds(22, 226, 515, 26);
		internalFrame.getContentPane().add(slider);
		
		
		JLabel orderNoJLabel = new JLabel("order number");
		orderNoJLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		orderNoJLabel.setBounds(152, 11, 83, 14);
		internalFrame.getContentPane().add(orderNoJLabel);
		
		JLabel customerIDJLabel = new JLabel("customer id");
		customerIDJLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		customerIDJLabel.setBounds(39, 11, 76, 14);
		internalFrame.getContentPane().add(customerIDJLabel);
		
		JLabel ItemsJLabel = new JLabel("items");
		ItemsJLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		ItemsJLabel.setBounds(271, 11, 51, 14);
		internalFrame.getContentPane().add(ItemsJLabel);
		
		JLabel QtyJLabel = new JLabel("Qty");
		QtyJLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		QtyJLabel.setBounds(375, 11, 40, 14);
		internalFrame.getContentPane().add(QtyJLabel);
		
		JLabel OrderStatusJLabel = new JLabel("order status");
		OrderStatusJLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		OrderStatusJLabel.setBounds(454, 6, 83, 25);
		internalFrame.getContentPane().add(OrderStatusJLabel);
		
		
		UserScrollpane = new JScrollPane(staffInterfaceJtextArea,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		UserScrollpane.setBounds(22, 36, 531, 179);
		UserScrollpane.setVisible(true);
		internalFrame.getContentPane().add(UserScrollpane);
		
		Client = new JInternalFrame("");
		Client.setBackground(new Color(230, 230, 250));
		Client.setBounds(578, 33, 262, 219);
		internalFrame.getContentPane().add(Client);
		Client.getContentPane().setLayout(null);
		
		textFieldOrderNum = new JTextField();
		textFieldOrderNum.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		textFieldOrderNum.setBounds(102, 52, 126, 20);
		Client.getContentPane().add(textFieldOrderNum);
		textFieldOrderNum.setColumns(10);
		
		JLabel lblOrderno = new JLabel("OrderNo");
		lblOrderno.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOrderno.setBounds(28, 55, 46, 14);
		Client.getContentPane().add(lblOrderno);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStatus.setBounds(28, 80, 46, 14);
		Client.getContentPane().add(lblStatus);
		
		StatusOrderNumtextField_1 = new JTextField();
		StatusOrderNumtextField_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		StatusOrderNumtextField_1.setColumns(10);
		StatusOrderNumtextField_1.setBounds(102, 77, 126, 20);
		Client.getContentPane().add(StatusOrderNumtextField_1);
		
		UpdateButton = new JButton("Update");
		UpdateButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		UpdateButton.setBounds(148, 143, 76, 23);
		Client.getContentPane().add(UpdateButton);
		
		JLabel lblUpdateOrderStatus = new JLabel("    Update Order Status");
		lblUpdateOrderStatus.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblUpdateOrderStatus.setBounds(39, 11, 189, 14);
		Client.getContentPane().add(lblUpdateOrderStatus);
		
		hidebutton = new JButton("Hide");
		hidebutton.setFont(new Font("Tahoma", Font.BOLD, 11));
		hidebutton.setBounds(43, 143, 76, 23);
		Client.getContentPane().add(hidebutton);
		
		BackMenu = new JButton("BACK");
		BackMenu.setBounds(760, 361, 126, 32);
		frame.getContentPane().add(BackMenu);
		BackMenu.setBackground(Color.RED);
		BackMenu.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		 Client.setVisible(false);
		internalFrame.setVisible(true);
		
		// add Buttons
		ButtonHandler handler = new ButtonHandler();
		viewOrdersJButton.addActionListener(handler);
		ManageOrderButton.addActionListener(handler);
		hidebutton.addActionListener(handler);
		UpdateButton.addActionListener(handler);
		BackMenu.addActionListener(handler);
	}
	
	private class ButtonHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			Datebase data = new Datebase();
		  
			if (event.getSource()==viewOrdersJButton)
			{
			  try {
				  
				  Client.setVisible(false);
				staffInterfaceJtextArea.setText("");
				data.ViewOrders();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			
			else if(event.getSource()==ManageOrderButton)
			{
				 Client.setVisible(true);
				 
			}
			
			else if(event.getSource()==hidebutton)
			{
				 Client.setVisible(false);
				 
			}
			
			else if(event.getSource()==UpdateButton)
			{
				 try {
					data.UpdateStatus(textFieldOrderNum.getText(), StatusOrderNumtextField_1.getText());
					textFieldOrderNum.setText("");
					StatusOrderNumtextField_1.setText("");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
			}
			
			else if(event.getSource()==BackMenu)
			{
				frame.setVisible(false);
				WelcomePage window = new WelcomePage();
				window.frame.setVisible(true);
				
			}
			
		}
		
		
		
	}
}
