package view;

import java.util.Scanner;

import controller.MessageControl;

public class MailManagement {

	public void composeNewMail(String fromId) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter To Id  : ");
		String toId=scanner.nextLine();
		System.out.print("Enetr Subject : ");
		String subject=scanner.nextLine();
		System.out.println("Enter Body Of The Message ");
		String message=scanner.nextLine();
		
		MessageControl messageControl=new MessageControl();
		messageControl.messageSending(fromId, toId, subject, message);
	}
	
	
}
