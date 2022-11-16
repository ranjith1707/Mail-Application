package model;

public class Mail {
	
	private String fromId;
	private String toId;
   private String message;
   private String Subject;
   public Mail(String fromId, String toId, String message, String subject) {
		super();
		this.fromId = fromId;
		this.toId = toId;	
		this.message = message;
		Subject = subject;
	}
public String getFromId() {
	return fromId;
}
public void setFromId(String fromId) {
	this.fromId = fromId;
}
public String getToId() {
	return toId;
}
public void setToId(String toId) {
	this.toId = toId;
}
public String getMessage() {
	
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getSubject() {
	return Subject;
}
public void setSubject(String subject) {
	Subject = subject;
	
}
}
