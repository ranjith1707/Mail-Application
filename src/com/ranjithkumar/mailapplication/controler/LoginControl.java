package controller;
import repositort.MailDatabase;
public class LoginControl {
	
	
	
	
	public boolean userLogInCheck(String userId, String password){
		if(userNameCheck(userId)) {
			if(passwordCheck(userId,password)) {
				return true;
			}
			else {
				System.out.println("Password Incorrect ! ");
			}
		}
		System.out.println("UserId Incorrect ! ");
		
		return false;
		
	}
   
	private boolean userNameCheck(String userId) {
		if(MailDatabase.getDb().getUserDetails().containsKey(userId)) {
			return true;
		}
		return false;
		
	}
	
	private boolean passwordCheck(String userId ,String password) {
		if(MailDatabase.getDb().getUser(userId).getPassword().equals(password)) {
			return true;	
		}
		return false;
		
		
	}
	
	
}
