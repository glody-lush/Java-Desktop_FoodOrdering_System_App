package customer;

public class Email_Storage {

	String Email;
	public Email_Storage(String mail)
    {
    	Email = mail;
    	
    }//end of student null argument constructor

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}
}
