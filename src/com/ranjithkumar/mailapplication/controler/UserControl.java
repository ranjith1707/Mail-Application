package controller;

import repository.MailDatabase;

public class UserControl {
   public boolean userIsFound(String userId) {
	   if(MailDatabase.getDb().getUserDetails().containsKey(userId)) {
			return true;
		}
		return false;
		
   }
}
