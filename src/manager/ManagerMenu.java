package manager;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import database.Datebase;
import welcomepage.WelcomePage;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JInternalFrame;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.SystemColor;

public class ManagerMenu {

	public JFrame frame;
	private JTextField HIREnameJtextField;
	private JTextField HIREsurnameJtextField;
	private JTextField HIREcellPhoneJtextField;
	private JTextField HIREpasswordJtextField;
	private JTextField HIREstaffNoJtextField;
	private JButton HireJButton; 
	private JButton FireJButton;
	private JButton MoreJButton;
	private JButton SEARCHexitJButton;
	private JButton HIREhireJButton;
	private JButton HIREbackJButton;
	private JButton HIREclearJButton;
	private JButton PromotionJButton;
	private  JButton CommentJButton;
	private JButton FIREfireJButton;
	private JButton SEARCHsearchJButton; 
	private JInternalFrame hireFrame;
	private JTextField FIREstaffnoJTextField;
	private JInternalFrame fireFrame;
	private JTextField SEARCHstaffNumberJTextField;
	private JTextField SEARCHnameJTextField;
	private JTextField SEARCHsurnameJTextField;
	private JTextField SEARCHcellnoJTextField;
	private JButton searchJButton;
	private JInternalFrame SEARCHFrame;
	private JButton BacktoMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerMenu window = new ManagerMenu();
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
	public ManagerMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(65, 105, 225));
		frame.setBounds(100, 100, 758, 471);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationByPlatform(false);
		frame.setResizable(false);
		
		HireJButton = new JButton("Hire");
		HireJButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		HireJButton.setBounds(81, 327, 89, 23);
		frame.getContentPane().add(HireJButton);
		
		PromotionJButton = new JButton("PROMOTION");
		PromotionJButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		PromotionJButton.setBounds(251, 327, 121, 23);
		frame.getContentPane().add(PromotionJButton);
		
	    CommentJButton = new JButton("COMMENT");
		CommentJButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		CommentJButton.setBounds(436, 327, 113, 23);
		frame.getContentPane().add(CommentJButton);
		
		FireJButton = new JButton("Fire");
		FireJButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		FireJButton.setBounds(81, 386, 89, 23);
		frame.getContentPane().add(FireJButton);
		
	    searchJButton = new JButton("SEARCH");
		searchJButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		searchJButton.setBounds(251, 386, 121, 23);
		frame.getContentPane().add(searchJButton);
		
		MoreJButton = new JButton("MORE");
		MoreJButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		MoreJButton.setBounds(436, 386, 113, 23);
		frame.getContentPane().add(MoreJButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(128, 0, 128));
		panel_2.setBounds(0, 312, 752, 130);
		frame.getContentPane().add(panel_2);
		
		SEARCHFrame = new JInternalFrame("");
		SEARCHFrame.setBounds(51, 11, 415, 260);
		frame.getContentPane().add(SEARCHFrame);
		SEARCHFrame.getContentPane().setLayout(null);
		
		JLabel SEARCHnameJlabel = new JLabel("Name");
		SEARCHnameJlabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		SEARCHnameJlabel.setBounds(23, 76, 56, 23);
		SEARCHFrame.getContentPane().add(SEARCHnameJlabel);
		
		JLabel SEARCHstaffNumberJLabel = new JLabel("Staff Number");
		SEARCHstaffNumberJLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		SEARCHstaffNumberJLabel.setBounds(23, 30, 99, 23);
		SEARCHFrame.getContentPane().add(SEARCHstaffNumberJLabel);
		
		SEARCHstaffNumberJTextField = new JTextField();
		SEARCHstaffNumberJTextField.setFont(new Font("Tahoma", Font.BOLD, 12));
		SEARCHstaffNumberJTextField.setColumns(10);
		SEARCHstaffNumberJTextField.setBounds(152, 31, 116, 20);
		SEARCHFrame.getContentPane().add(SEARCHstaffNumberJTextField);
		
		SEARCHsearchJButton = new JButton("SEARCH");
		SEARCHsearchJButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		SEARCHsearchJButton.setBounds(282, 30, 107, 23);
		SEARCHFrame.getContentPane().add(SEARCHsearchJButton);
		
		SEARCHnameJTextField = new JTextField();
		SEARCHnameJTextField.setEditable(false);
		SEARCHnameJTextField.setFont(new Font("Tahoma", Font.BOLD, 12));
		SEARCHnameJTextField.setColumns(10);
		SEARCHnameJTextField.setBounds(152, 78, 158, 20);
		SEARCHFrame.getContentPane().add(SEARCHnameJTextField);
		
		JLabel SEARCHsurnameJLabel = new JLabel("Surname");
		SEARCHsurnameJLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		SEARCHsurnameJLabel.setBounds(23, 112, 56, 23);
		SEARCHFrame.getContentPane().add(SEARCHsurnameJLabel);
		
		SEARCHsurnameJTextField = new JTextField();
		SEARCHsurnameJTextField.setEditable(false);
		SEARCHsurnameJTextField.setFont(new Font("Tahoma", Font.BOLD, 12));
		SEARCHsurnameJTextField.setColumns(10);
		SEARCHsurnameJTextField.setBounds(152, 109, 158, 20);
		SEARCHFrame.getContentPane().add(SEARCHsurnameJTextField);
		
		JLabel SEARCHcellnoJLabel = new JLabel("Cell No");
		SEARCHcellnoJLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		SEARCHcellnoJLabel.setBounds(23, 146, 56, 23);
		SEARCHFrame.getContentPane().add(SEARCHcellnoJLabel);
		
		SEARCHcellnoJTextField = new JTextField();
		SEARCHcellnoJTextField.setEditable(false);
		SEARCHcellnoJTextField.setFont(new Font("Tahoma", Font.BOLD, 12));
		SEARCHcellnoJTextField.setColumns(10);
		SEARCHcellnoJTextField.setBounds(152, 148, 158, 20);
		SEARCHFrame.getContentPane().add(SEARCHcellnoJTextField);
		
		SEARCHexitJButton = new JButton("EXIT");
		SEARCHexitJButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		SEARCHexitJButton.setBounds(179, 196, 89, 23);
		SEARCHFrame.getContentPane().add(SEARCHexitJButton);
		
		fireFrame = new JInternalFrame("");
		fireFrame.setBounds(310, 26, 396, 170);
		frame.getContentPane().add(fireFrame);
		fireFrame.getContentPane().setLayout(null);
		
		JLabel FIREstaffnoJlabel = new JLabel("Staff No");
		FIREstaffnoJlabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		FIREstaffnoJlabel.setBounds(33, 21, 100, 26);
		fireFrame.getContentPane().add(FIREstaffnoJlabel);
		
		FIREstaffnoJTextField = new JTextField();
		FIREstaffnoJTextField.setFont(new Font("Tahoma", Font.BOLD, 12));
		FIREstaffnoJTextField.setColumns(10);
		FIREstaffnoJTextField.setBounds(149, 27, 158, 20);
		fireFrame.getContentPane().add(FIREstaffnoJTextField);
		
		FIREfireJButton = new JButton("Fire");
		FIREfireJButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		FIREfireJButton.setBounds(179, 98, 89, 23);
		fireFrame.getContentPane().add(FIREfireJButton);
		
		hireFrame = new JInternalFrame("");
		hireFrame.setBounds(138, 36, 554, 242);
		frame.getContentPane().add(hireFrame);
		hireFrame.getContentPane().setLayout(null);
		
		
		HIREhireJButton = new JButton("HIRE");
		HIREhireJButton.setBackground(SystemColor.textHighlight);
		HIREhireJButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		HIREhireJButton.setBounds(30, 169, 89, 23);
		hireFrame.getContentPane().add(HIREhireJButton);
		
		JLabel HIREnameJLabel = new JLabel("Name");
		HIREnameJLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		HIREnameJLabel.setBounds(30, 21, 56, 23);
		hireFrame.getContentPane().add(HIREnameJLabel);
		
		JLabel HIREsurnameJLabel = new JLabel("Surname");
		HIREsurnameJLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		HIREsurnameJLabel.setBounds(30, 55, 56, 23);
		hireFrame.getContentPane().add(HIREsurnameJLabel);
		
		JLabel HIREcellNoJLabel = new JLabel("Cell No");
		HIREcellNoJLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		HIREcellNoJLabel.setBounds(30, 89, 56, 23);
		hireFrame.getContentPane().add(HIREcellNoJLabel);
		
		HIREnameJtextField = new JTextField();
		HIREnameJtextField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		HIREnameJtextField.setBounds(152, 23, 133, 20);
		hireFrame.getContentPane().add(HIREnameJtextField);
		HIREnameJtextField.setColumns(10);
		
		HIREsurnameJtextField = new JTextField();
		HIREsurnameJtextField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		HIREsurnameJtextField.setColumns(10);
		HIREsurnameJtextField.setBounds(152, 57, 133, 20);
		hireFrame.getContentPane().add(HIREsurnameJtextField);
		
		HIREcellPhoneJtextField = new JTextField();
		HIREcellPhoneJtextField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		HIREcellPhoneJtextField.setColumns(10);
		HIREcellPhoneJtextField.setBounds(152, 91, 133, 20);
		hireFrame.getContentPane().add(HIREcellPhoneJtextField);
		
		JPanel panel = new JPanel();
		panel.setBounds(25, 11, 274, 133);
		hireFrame.getContentPane().add(panel);
		
		JLabel HIREstaffNoJLabel = new JLabel("Staff No");
		HIREstaffNoJLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		HIREstaffNoJLabel.setBounds(335, 41, 79, 14);
		hireFrame.getContentPane().add(HIREstaffNoJLabel);
		
		JLabel HIREpasswordJLabel = new JLabel("Password");
		HIREpasswordJLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		HIREpasswordJLabel.setBounds(335, 93, 79, 14);
		hireFrame.getContentPane().add(HIREpasswordJLabel);
		
		HIREpasswordJtextField = new JTextField();
		HIREpasswordJtextField.setEditable(false);
		HIREpasswordJtextField.setFont(new Font("Tahoma", Font.BOLD, 12));        
		HIREpasswordJtextField.setColumns(10);
		HIREpasswordJtextField.setBounds(327, 120, 133, 20);
		hireFrame.getContentPane().add(HIREpasswordJtextField);
		
		HIREstaffNoJtextField = new JTextField();
		HIREstaffNoJtextField.setEditable(false);
		HIREstaffNoJtextField.setFont(new Font("Tahoma", Font.BOLD, 12));
		HIREstaffNoJtextField.setColumns(10);
		HIREstaffNoJtextField.setBounds(327, 62, 133, 20);
		hireFrame.getContentPane().add(HIREstaffNoJtextField);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(315, 34, 197, 123);
		hireFrame.getContentPane().add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Login Details Here");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(335, 11, 177, 14);
		hireFrame.getContentPane().add(lblNewLabel);
		
		
	    HIREclearJButton = new JButton("Clear");
		HIREclearJButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		HIREclearJButton.setBackground(SystemColor.textHighlight);
		HIREclearJButton.setBounds(152, 170, 89, 23);
		hireFrame.getContentPane().add(HIREclearJButton);
		
		HIREbackJButton = new JButton("BACK");
		HIREbackJButton.setBackground(new Color(65, 105, 225));
		HIREbackJButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		HIREbackJButton.setBounds(358, 171, 89, 23);
		hireFrame.getContentPane().add(HIREbackJButton);
		
		BacktoMenu = new JButton("BACK");
		BacktoMenu.setBackground(Color.GREEN);
		BacktoMenu.setFont(new Font("Tahoma", Font.BOLD, 12));
		BacktoMenu.setBounds(592, 342, 89, 50);
		frame.getContentPane().add(BacktoMenu);
		hireFrame.setVisible(false);
		fireFrame.setVisible(false);
		SEARCHFrame.setVisible(false);
		
		//addButton
		
		
		ButtonHandler handler = new ButtonHandler();
		HireJButton.addActionListener(handler); 
		FireJButton.addActionListener(handler);
	    searchJButton.addActionListener(handler);
	    HIREhireJButton.addActionListener(handler);
	    SEARCHsearchJButton.addActionListener(handler);
	    HIREbackJButton.addActionListener(handler);
	    SEARCHexitJButton.addActionListener(handler);
	    FIREfireJButton.addActionListener(handler);
	    CommentJButton.addActionListener(handler);
	    BacktoMenu.addActionListener(handler);
	    HIREclearJButton.addActionListener(handler);
	    PromotionJButton.addActionListener(handler);
	    MoreJButton.addActionListener(handler);
	}
	
	
	private class ButtonHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			
			 String name = HIREnameJtextField.getText();
		     String surname = HIREsurnameJtextField.getText();     
		     String cell=HIREcellPhoneJtextField.getText();
		     String StaffNumber = FIREstaffnoJTextField.getText();
		     Datebase data = new Datebase();
		     
		     if(event.getSource()== MoreJButton )
					
				{
				JOptionPane.showMessageDialog(null, "Haven't been implemented yet");
					 
				}
		     
		     if(event.getSource()== PromotionJButton )
					
				{
				JOptionPane.showMessageDialog(null, "Haven't been implemented yet");
					 
				}
			
			if(event.getSource()== HireJButton )
				
			{
				hireFrame.setVisible(true);
				 fireFrame.setVisible(false);
				 SEARCHFrame.setVisible(false);
				 
			}
			
			else if(event.getSource()== CommentJButton)
			{
				hireFrame.setVisible(false);
				 fireFrame.setVisible(false);
				 SEARCHFrame.setVisible(false);
				 Commenting window = new Commenting();
					window.frame.setVisible(true);
			}
			
			// if for internalframe

			else if(event.getSource() == HIREhireJButton)
			{
				 if(HIREnameJtextField.getText().length()<=0 ||  HIREsurnameJtextField.getText().length()<=0 || HIREcellPhoneJtextField.getText().length()<=0)
				{
					JOptionPane.showMessageDialog(null, " Field cannot remain empty");
				}
				
				 else if(HIREnameJtextField.getText().length()<=3 || HIREsurnameJtextField.getText().length()<=3)
				{
					JOptionPane.showMessageDialog(null, "Name/Surname too short");
					
				}
				 
				 else if(HIREnameJtextField.getText().length()>=10 || HIREsurnameJtextField.getText().length()>=10)
					{
						JOptionPane.showMessageDialog(null, "Name/Surname too long");
						
					}
				
				 
				 else if( !(HIREcellPhoneJtextField.getText().matches("[0-9]{10}") ))
				 {
					 JOptionPane.showMessageDialog(null, "Takes only phoneNumber");
				 }
				 
				 else if( HIREnameJtextField.getText().matches("[A-Za-z]")|| HIREsurnameJtextField.getText().matches("[A-Za-z]"))
				 {
					 JOptionPane.showMessageDialog(null, "Support only letters");
				 }
				 
				 

				else {
				
				try {
					String staffNumber = StaffNUmber(name,surname);
					String password=passwordValidation(name,surname);
						data.employing(name, surname, cell, staffNumber, password);
						JOptionPane.showMessageDialog(null, "You have been hired");
					 HIREpasswordJtextField.setText(password);
					HIREstaffNoJtextField.setText(staffNumber);
					
					
				} catch (SQLException e) {
					
					JOptionPane.showMessageDialog(null, "Couldn't hire!!/nUnexcpted Error");
					e.printStackTrace();
				}
				
				}// end of else condition	
				
			}//end of hireButton
			
			else if(event.getSource() == FireJButton)
			{
				hireFrame.setVisible(false);
				 fireFrame.setVisible(true);
				 SEARCHFrame.setVisible(false);
				 FIREstaffnoJTextField.setText("");
				 
			}
			
			else if(event.getSource() == searchJButton)
			{
				
				hireFrame.setVisible(false);
				 fireFrame.setVisible(false);
				 SEARCHFrame.setVisible(true);
				 
                
				
			}
			
			else if(event.getSource() == SEARCHsearchJButton)
			{
				
				EmployeeStored stored =  new EmployeeStored();
				 
				 try {
					 
					 List<EmployeeStored>list=data.search(SEARCHstaffNumberJTextField.getText());    //casting the search method into the List object of type list
					 if(list.isEmpty()) 
					 {
						 JOptionPane.showMessageDialog(null, "Staff Number doesn't exist"); 
					 }
					 else {
					 stored= list.get(0);    //getting index zero in the list
					 
					 //displaying the data in the list to the testfield
					 SEARCHnameJTextField.setText(""+stored.getName());
					 SEARCHsurnameJTextField.setText(""+stored .getSurname());
					 SEARCHcellnoJTextField.setText(""+stored .getCell());
					 }
					
				}
				 catch (SQLException e) 
				    {
					JOptionPane.showMessageDialog(null,"unexpected error please try again");
					e.printStackTrace();
			    	}
				
			}
			
			else if(event.getSource()== HIREbackJButton)
				
			{
				
				hireFrame.setVisible(false);
				
				
			}
			
           else if(event.getSource()== HIREclearJButton)
				
			{
        	     HIREnameJtextField.setText("");
        		 HIREsurnameJtextField.setText("");
        		 HIREcellPhoneJtextField.setText("");
        		 HIREpasswordJtextField.setText("");
        		 HIREstaffNoJtextField.setText("");
				
				
			}
			
           else if(event.getSource()==SEARCHexitJButton )
				
			{
        	   SEARCHstaffNumberJTextField.setText("");
        	   SEARCHnameJTextField.setText("");
				 SEARCHsurnameJTextField.setText("");
				 SEARCHcellnoJTextField.setText("");
				SEARCHFrame.setVisible(false);
			}
				
				
           else if(event.getSource()==FIREfireJButton)
           {
        	   try {
        		   
        		   if(  data.ExictingStaffNum(StaffNumber)== "fired")
        		   {
        			   JOptionPane.showMessageDialog(null, "Staff has been fired");
        			   FIREstaffnoJTextField.setText("");
        			   fireFrame.setVisible(false); 
        		   }
        		   
        		   else if(data.ExictingStaffNum(StaffNumber)== "Staff Number doesn't exist")
        		   {
        			   JOptionPane.showMessageDialog(null, "Staff doesn't exist");
        			   fireFrame.setVisible(false);
        		   }
        			 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           }
			
           else if(event.getSource()==BacktoMenu)
           {
        	   frame.setVisible(false);
        	   WelcomePage window = new WelcomePage();
				window.frame.setVisible(true);
           }
				
				
		}//end of action performed
		
		
		/**
		 * method which returns a valid password
		 * @return
		 */
		public String passwordValidation(String name,String surname )
		{
		
			 Random rand = new Random(); 
		     int rand_int1 = rand.nextInt(90); 
		     
		     String result = name.substring(0, 2)+surname.substring(0, 2)+"#"+rand_int1+4;
			 return result;
		}
		/**
		 * method which returns the staff number
		 * @return
		 */
        public String StaffNUmber(String name,String surname)
        {
        	
			int year = Calendar.getInstance().get(Calendar.YEAR);
     
        	Random rand = new Random(); 
        	 int rand_int1 = 50+rand.nextInt(40);; 
        	
        	return name.length()+""+surname.length()+year+rand_int1;

        }
		
	}
}
