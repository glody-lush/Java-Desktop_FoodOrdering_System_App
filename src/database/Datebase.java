package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import customer.CustomerProfile;
import customer.Email_Storage;
import manager.Commenting;
import manager.EmployeeStored;
import manager.ManagerMenu;
import staff.StaffInterface;

public class Datebase 
{
//instance variables
	private String password = "Glody";
	private String username = "root";
	private String url ="jdbc:mysql://Localhost:3306/OnlineFoodOrderingSystem";
	
//	
	Connection connect;
	PreparedStatement prepared;
	ResultSet result;
	
	/**
	 * connecting to database
	 * @throws SQLException
	 */
	public void ConnectionDatabase() throws SQLException
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) 
		{
			JOptionPane.showMessageDialog(null, "invalid");
		}
	}
	//*****************************
	public void Registration(String name,String surname,String email,String phoneNo,String areaAddress, String street, String flat, String pasword, String cnfirmpassword ) throws SQLException
	{
		 ConnectionDatabase();
		 prepared = connect.prepareStatement("insert into Customers(name,surname,email,phoneNo, areaAddress,street,flat,pasword,cnfirmpassword) values(?,?,?,?,?,?,?,?,?)");
		    prepared.setString(1, name);
			prepared.setString(2, surname);
			prepared.setString(3, email);
			prepared.setString(4, phoneNo);
			prepared.setString(5, areaAddress);
			prepared.setString(6, street);
			prepared.setString(7, flat);
			prepared.setString(8, pasword);
			prepared.setString(9, cnfirmpassword);
			prepared.executeUpdate();
					 
	}

	/**
	 * 
	 * @param Email
	 * @param password
	 * @throws SQLException
	 */
	public String CustomerLogin(String Email, String password) throws SQLException
	{
		String Message="";
		ConnectionDatabase();
		prepared = connect.prepareStatement("select email from Customers where Email = ? and Pasword = ?");
		prepared.setString(1, Email);
		prepared.setString(2, password);
		result= prepared.executeQuery();
		if(result.next())
		{
			Message="success";
		}
		
		else
		{
			Message="failed";
		}
		return Message;
	}
	
	
	
	
	
	
	public void employing(String name,String surname,String cellphone,String staffNo, String passsword ) throws SQLException
	{
		 ConnectionDatabase();
		 prepared = connect.prepareStatement("insert into employees(name,surname,cellphone,staffNo,password) values(?,?,?,?,?)");
		    prepared.setString(1, name);
			prepared.setString(2, surname);
			prepared.setString(3, cellphone);
			prepared.setString(4, staffNo);
			prepared.setString(5, passsword);
			prepared.executeUpdate();				 
	}
	
public String employeeLogin(String name, String staffNo, String password) throws SQLException
	
	{     String StaffID = null;
		ConnectionDatabase();
		prepared = connect.prepareStatement("select staffNo from employees where name  = ? and staffNo = ? and password = ?");
		prepared.setString(1, name);
		prepared.setString(2, staffNo);
		prepared.setString(3, password);
		result= prepared.executeQuery();
		if(result.next())
		{
	    	StaffID =result.getString(1);
			JOptionPane.showMessageDialog(null, "welcome "+StaffID);
			StaffInterface window = new StaffInterface();
			window.frame.setVisible(true);
		}
		
		else
		{
			JOptionPane.showMessageDialog(null, "Incorrect password/email try again or contact the manager");
			JOptionPane.showMessageDialog(null, "Repeat the process ");
			
		}
		 return StaffID;
	}


/**
 * method which store EmployeeStored data into an array list  of ListStorage
 * @param StaffId
 * @return
 * @throws SQLException
 */
    public List<EmployeeStored> search(String StaffId) throws SQLException
    {
    	EmployeeStored stored = null;     //creating an object of EmployeeStored class
    	
    	List<EmployeeStored> ListStorage =new ArrayList<EmployeeStored>();  //casting EmployeeStored the class to list of array list
    	
    	    ConnectionDatabase();
    	    prepared = connect.prepareStatement("select name,surname,cellphone from employees where  staffNo = ?");
		    prepared.setString(1, StaffId);
			result= prepared.executeQuery();
			if(result.next())
			{
				stored = new EmployeeStored();
				stored.setName(result.getString(1));
			    stored.setSurname(result.getString(2));
			     stored.setCell(result.getString(3));
			     
			     ListStorage.add(stored);   //populating the list with data
			     JOptionPane.showMessageDialog(null,""+stored.getName()+"");
			}
			
			else
			{
				JOptionPane.showMessageDialog(null, "Incorrect staff number");
				
			}
			return ListStorage;
			
    }// end of search method of list type
    
    
    public  void orders(String Email,String item,int quantity, double Price, String Statuts,double  total_Price) throws SQLException
    {
    	ConnectionDatabase();
    	prepared = connect.prepareStatement("insert into Orders(email,Items,Quantity,Price,Status, total_Price) values(?,?,?,?,?,?)");
    	prepared.setString(1, Email);
    	prepared.setString(2,item );
    	prepared.setInt(3,quantity );
    	prepared.setDouble(4,Price );
    	prepared.setString(5,Statuts );
    	prepared.setDouble(6, total_Price );
    	prepared.executeUpdate();
    	
    	
    }
    
    public void profilestatus(String email) throws SQLException
    {
    	String resultString = "";
    	ConnectionDatabase();
    	prepared= connect.prepareStatement("select Items,Quantity,Order_No,Status from Orders where email=?");
    	prepared.setString(1, email);
    	result= prepared.executeQuery();
    	
    	while(result.next())
    		
    	{
    		
    		String items = result.getString(1);
    		String quantity = result.getString(2);
    		String OrderNum = result.getString(3);
    		String statuts = result.getString(4);
    	    resultString = items+"          "+quantity+"              "+OrderNum+"           "+statuts+"\n";
    	    System.out.println(resultString);
    	    CustomerProfile.OrderStatustextArea.append(resultString);  
    	}
	
    
    	
    	
    }// end of profileStatus method
    
    /*
     * method that delete the employee detail from the database table
     */
    public void  ManagerFired(String staffNo ) throws SQLException
    {
    	ConnectionDatabase();
    	prepared = connect.prepareStatement("delete from employees where  staffNo = ?");
    	prepared.setString(1, staffNo);
        prepared.executeUpdate();
    }
/*
 * Method who check if the staffNumber
 * exist or not
 */
  public String ExictingStaffNum(String staffNo) throws SQLException
  {
	  String StaffID = "";
		ConnectionDatabase();
		prepared = connect.prepareStatement("select staffNo from employees where  staffNo = ?");
		prepared.setString(1, staffNo);
		result= prepared.executeQuery();
		if(result.next())
		{
			ManagerFired( staffNo );
			StaffID= "fired";
		}
		
		else
		{
			StaffID= "Staff Number doesn't exist";
			
		}
		 return StaffID;
	  
  }// end of ExictingStaffNu
  
  
  
  /*
   * Method that removed Order
   */
    
  public void  RemovedOrder(String OrderNo, String email ) throws SQLException
  {
  	ConnectionDatabase();
  	prepared = connect.prepareStatement("delete from orders where  Order_No = ? and email = ?");
  	prepared.setString(1, OrderNo);
  	prepared.setString(2, email);
      prepared.executeUpdate();
  }// end of RemovedOrder
  
  /**
   * Removing order after logout
   * @param mail
   * @throws SQLException
   */
  public void removeOrder(String mail) throws SQLException

  {
	  ConnectionDatabase();
	  prepared= connect.prepareStatement("delete from orders where email= ?");
	  prepared.setString(1, mail);
	  prepared.executeUpdate();
  }// end of removing order after log out
  
  
  /*
   * Method that check if the OrderNo exist or not
   */
  public String ExictingOrderNo(String OrderNo,String email) throws SQLException
  {
	  String OrderNUMBER = "";
		ConnectionDatabase();
		prepared = connect.prepareStatement("select Order_No from orders where  Order_No = ? and email = ?");
		prepared.setString(1, OrderNo);
		prepared.setString(2, email);
		result= prepared.executeQuery();
		if(result.next())
		{
			RemovedOrder(OrderNo, email );
			OrderNUMBER = "Existe";
		}
		
		else
		{
			OrderNUMBER = "Doesn't exit";
			
		}
		 return OrderNUMBER;
}// end of ExictingOrderNo method
  
  
  public void Rate(String email, String feedback) throws SQLException
  {
	  ConnectionDatabase();
	  prepared= connect.prepareStatement("insert into Rate(email,feedback) values(?,?)");
	  prepared.setString(1, email);
	  prepared.setString(2, feedback);
	  prepared.executeUpdate();
	  JOptionPane.showMessageDialog(null, "Thank you for rating our service");
	  
  }// end of Rate method
  
  
  /*
   * Method that view the orders of the customers in the
   * staff interface
   */
  public void ViewOrders() throws SQLException
 {
	  ConnectionDatabase();
	  prepared= connect.prepareStatement("select Order_No,email,Items,Quantity,Status from Orders");
   	  result= prepared.executeQuery();
  	
  	while(result.next())
  		
  	{
  		String resultString= "";
  		
  		String items = result.getString(3);
  		String quantity = result.getString(4);
  		String OrderNum = result.getString(1);
  		String statuts = result.getString(5);
  		String cust_Id = result.getString(2);
  		resultString = cust_Id +"                   "+OrderNum+"              "+items+"                  "+quantity+"               "+statuts+"\n";
  	    
  	    
  	    // resultString = cust_Id +"                   "+OrderNum+"              "+items+"                  "+quantity+"               "+statuts+"\n";
  	    System.out.println(resultString);
  	  StaffInterface.staffInterfaceJtextArea.append(resultString);  
  	}
  }// end of ViewOrders method
  
  /**
   * method which updating order of the customers
   * @param OrderNum
   * @param statuts
   * @throws SQLException
   */
  public void UpdateStatus(String OrderNum, String statuts) throws SQLException
  {
	  ConnectionDatabase();
	  prepared= connect.prepareStatement("select status from Orders  where Order_No = '"+OrderNum +"'");
	  result = prepared.executeQuery();
	  if(result.next())
	  {
		  prepared= connect.prepareStatement("update Orders set status ='"+statuts+"' where Order_No = '"+OrderNum +"'");
		  prepared.executeUpdate();
		  JOptionPane.showMessageDialog(null, "Client Notified");
		  
	  }
	  else
	  {
		  JOptionPane.showMessageDialog(null, "Order Number never Existed");
	  }

  }// end of UpdateStatus method
  /**
   * The method give a feedback on the comment interface of the manager
   * @throws SQLException
   */
  public void ReadComment() throws SQLException
  {
	  ConnectionDatabase();
	  prepared= connect.prepareStatement("select email, feedback from rate  ");
	  result = prepared.executeQuery();
	  // ckecking if there is data in the database
	  if(result.next())
	  {
		  
		  
		  prepared= connect.prepareStatement("select email, feedback from rate  ");
		  result = prepared.executeQuery();
		 // if there is data in the database, displaying it in the textArea  
	  while(result.next())
	  		
	  	{
	  		String resultString= "";
	  		
	  		String email = result.getString(1);
	  		String feedback = result.getString(2);
	  		
	  	    resultString = email +"                                        "+feedback+"\n";
	  	    System.out.println(resultString);
	  	  Commenting.textArea.append(resultString);  
	  	}
     }
	  
	  else
	  {
		  Commenting.textArea.append("No Comment at The moment");
		  
	  }
	  
	  
  }// end of ReadComment method
  
 /**
  * The Manager Login 
  * @param name
  * @param StaffNumber
  * @param password
  * @throws SQLException
  */
  public void ManagerLogin(String name, String StaffNumber, String password) throws SQLException
  {
	  ConnectionDatabase();
	  prepared= connect.prepareStatement("select * from ManagerLogin  where name = ? and staffNumber =? and password=? " );
	  prepared.setString(1,name);
	  prepared.setString(2,StaffNumber);
	  prepared.setString(3,password);
	  result = prepared.executeQuery();
	  if(result.next())
	  {
		  
		  JOptionPane.showMessageDialog(null, "Successfully Login");
			ManagerMenu window = new ManagerMenu();
			window.frame.setVisible(true);
	  }
	  else
	  {
		  JOptionPane.showMessageDialog(null, "You need The manager Logging detail!!");
	  }
	  
  }// end of the managerLogin
  
  
  
  
  
}// end of the Datebase class 
//********************************************************************************