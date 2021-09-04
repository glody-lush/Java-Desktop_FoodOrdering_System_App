package manager;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import database.Datebase;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class Commenting {

	public static JFrame frame;
	private JButton ReadtButton;
	public static JTextArea textArea;
	private JScrollPane UserScrollpane;
	private JButton BackJButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Commenting window = new Commenting();
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
	public Commenting() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBackground(new Color(175, 238, 238));
		textArea.setFont(new Font("Tahoma", Font.BOLD, 13));
		textArea.setEditable(false);
		
		JLabel lblCustid = new JLabel("Customer email");
		lblCustid.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCustid.setBounds(47, 27, 94, 14);
		frame.getContentPane().add(lblCustid);
		
		JLabel lblCustcomment = new JLabel("Customer Comment");
		lblCustcomment.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCustcomment.setBounds(276, 27, 121, 14);
		frame.getContentPane().add(lblCustcomment);
		
		  UserScrollpane = new JScrollPane(textArea,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			UserScrollpane.setBounds(27, 52, 380, 143);
			UserScrollpane.setVisible(true);
			frame.getContentPane().add(UserScrollpane);
		
		ReadtButton = new JButton("Read");
		ReadtButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		ReadtButton.setBounds(65, 206, 89, 23);
		frame.getContentPane().add(ReadtButton);
		
		BackJButton = new JButton("Back");
		BackJButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		BackJButton.setBounds(261, 206, 89, 23);
		frame.getContentPane().add(BackJButton);
		
		//add button
		ButtonHandler handler = new ButtonHandler();
		ReadtButton.addActionListener(handler);
		BackJButton.addActionListener(handler);
	}
	
	
	private class ButtonHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			Datebase data = new Datebase();
			
			if(e.getSource()== ReadtButton)
			{
				
				try {
					textArea.setText("");
					data.ReadComment();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			else if(e.getSource()==BackJButton)
			{
				frame.setVisible(false);
				
			}
		}
		
		
		
		
	}
}
