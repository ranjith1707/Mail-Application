package repository;

import java.util.HashMap;
import java.util.Map;

import model.Mail;

import model.User;

public class MailDatabase {
	 static MailDatabase mailDB;
	  private long messageId=1;
	  private  Map<String,User> userDetails;
	   private Map<String,Map<Long,Mail>> composeMails;
	   private Map<String,Map<Long,Mail>> recivedMail;
	   
	   private MailDatabase() {
		   setUserDetails(new HashMap<String, User>());
		   setComposeMails(new HashMap<String,Map<Long,Mail>>());
		   setRecivedMail(new HashMap<String,Map<Long,Mail>>());
	   }
	   
	   
	   
	  static public MailDatabase getDb() {
		  if(mailDB==null) {
			  mailDB=new  MailDatabase();
		  }
		return mailDB;
		  
	  }

	public Map<String,User> getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(Map<String,User> userDetails) {
		this.userDetails = userDetails;
	}

	public Map<String,Map<Long,Mail>> getComposeMails() {
		return composeMails;
	}

	public void setComposeMails(Map<String,Map<Long,Mail>> composeMails) {
		this.composeMails = composeMails;
	}

	public Map<String,Map<Long,Mail>> getRecivedMail() {
		return recivedMail;
	}

	public void setRecivedMail(Map<String,Map<Long,Mail>> recivedMail) {
		this.recivedMail = recivedMail;
	}

	public User getUser(String userId) {
		return userDetails.get(userId);
		
	}
	public long getMessageId() {
		this.messageId=this.messageId++;
		return this.messageId;
	}
	public Map<Long,Mail> getSendMessage(String userId) {
		return composeMails.get(userId);
	}
	public Map<Long,Mail> getRecividMail(String userId) {
		return recivedMail.get(userId);
	}

}
