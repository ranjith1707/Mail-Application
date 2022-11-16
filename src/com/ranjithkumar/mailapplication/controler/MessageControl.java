package controller;

import database.DatabaseManagement;
import model.Mail;
import model.MailDatabase;

public class MessageControl {
	

	public void messageSending(String fromId, String toId, String subject, String message) {
		UserControl userControl = new UserControl();
		long messageId=MailDatabase.getDb().getMessageId();
		Mail mail=new Mail(fromId,toId, subject,message);
		
		String[] users = toId.split(",");
		String to;
		boolean flag=false;
		DatabaseManagement dbManage = new DatabaseManagement();
		
		for (int i = 0; i < users.length; i++) {
			to = users[i];
			if (userControl.userIsFound(to)) {
				flag=true;
				MailDatabase.getDb().getRecividMail(to).put(messageId,mail);
			}
			else {
				System.out.println("Message Not Send");
			}
		}
		if(flag) {
			MailDatabase.getDb().getSendMessage(fromId).put(messageId, mail);
		}
	}
	
	
	public void deleteMessage(String userId, long messageId,String type) {
		if(type.equals("Recived")) {
		MailDatabase.getDb().getRecividMail(userId).remove(messageId);
		}
		else if(type.equals("Send")){
			MailDatabase.getDb().getSendMessage(userId).remove(messageId);
		}
		
	}

}
