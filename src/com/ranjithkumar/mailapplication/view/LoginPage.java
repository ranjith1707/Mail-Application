package view;

import controller.LoginControl;
import controller.MessageControl;
import model.Mail;
import repository.MailDatabase;

import java.util.Map;
import java.util.Scanner;
import controller.LoginControl;

public class LoginPage {
	

	public static void main(String[] args) {
		LoginPage login=new LoginPage();
		login.dashBoard();
	}

	private void dashBoard() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("  *  Welcome To Mail Application  * ");
		System.out.println(" 1 > Login \n 2 > Create New Account \n 3 > Exit ");
		int selection = scanner.nextInt();
		switch (selection) {
		case 1:loginview();
			break;
		case 2:new UserManagement().createNewAccount();
			break;

		}
		if (selection != 3) {
			dashBoard();
		}

	}

	private void loginview() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("__________________________________________________________ \n ");
		UserManagement user = new UserManagement();
		LoginControl loginControl = new LoginControl();
		System.out.print("Enter Mail Id : ");
		String mailId = scanner.nextLine();
		System.out.print("Enter Password : ");
		String password = scanner.nextLine();

		LoginControl logincontrol = new LoginControl();
		if (logincontrol.userLogInCheck(mailId, password)) {
			menu(mailId);
		}

	}

	private void menu(String mailId) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(
				"1 > Compose Mail\n 2 > View SendMail \n 3 > View Reciver MAil \n 4 > delete SendMail\n 5 > Delect recived Mail \n 6 > Logout");
		String option = scanner.nextLine();
		switch (option) {
		case "1":
			new MailManagement().composeNewMail(mailId);
			break;
		case "2":viewSendMessage(mailId);
			break;
		case "3":viewReviveMessage(mailId);
			break;
		case "4":deleteSendMessage(mailId);
			break;
		case "5":deleteReviveMessage(mailId);
			break;
		}
		if (!option.equals("6")) {
			menu(mailId);
		}
	}

	private void viewSendMessage(String userId) {
		for (Map.Entry<Long, Mail> mail : MailDatabase.getDb().getSendMessage(userId).entrySet()) {
			System.out.println("Message Id "+mail.getKey()+"\n from : " + mail.getValue().getFromId() + "\n To : " + mail.getValue().getToId()
					+ "\n Subject : " + mail.getValue().getSubject() + "\n Message : " + mail.getValue().getMessage()+"\n ");
		}
		
	}
	private void viewReviveMessage(String userId) {
		for (Map.Entry<Long, Mail> mail : MailDatabase.getDb().getRecividMail(userId).entrySet()) {
			System.out.println("Message Id "+mail.getKey()+"\n from : " + mail.getValue().getFromId() + "\n To : " + mail.getValue().getToId()
					+ "\n Subject : " + mail.getValue().getSubject() + "\n Message : " + mail.getValue().getMessage()+"\n ");
		}

 
	}
	private void deleteSendMessage(String userId) {
		Scanner scanner = new Scanner(System.in);
		viewSendMessage(userId);
		System.out.println("\n Enetr Message Id ");
		long messageId=scanner.nextLong();
		new MessageControl().deleteMessage(userId,messageId,"Send");
		
	}
	
	private void deleteReviveMessage(String userId) {
		Scanner scanner = new Scanner(System.in);
		viewReviveMessage(userId);
		System.out.println("\n Enetr Message Id ");
		long messageId=scanner.nextLong();
		new MessageControl().deleteMessage(userId,messageId,"Recived");
	}
	
}