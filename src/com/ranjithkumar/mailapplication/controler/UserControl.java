package controller;

import model.MailDatabase;

public class UserControl {
   public boolean userIsFound(String userId) {
	   if(MailDatabase.getDb().getUserDetails().containsKey(userId)) {
			return true;
		}
		return false;
		
   }
}
