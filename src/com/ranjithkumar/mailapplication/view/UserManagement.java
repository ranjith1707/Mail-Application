package view;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

import model.Mail;

import model.User;
import repository.MailDatabase;

import java.util.regex.Matcher;
public class UserManagement {
	Scanner scanner=new Scanner(System.in);
public void createNewAccount() {
	   
	   System.out.print("Enter Your Name : ");
	   String name=scanner.nextLine();
	   System.out.print("Enetr Date Of Birth : ");
	   String dateOfBirth=scanner.nextLine();
	   System.out.print("Create UserId use Special character  : ");
	   String userId=scanner.nextLine();
	  
	   System.out.println("Create New Password  : ");
	   String password=scanner.nextLine();
	   System.out.println("Enter Mobile Number : ");
	   long mobileNumber=scanner.nextLong();
	   User user=new User(name,userId,password,mobileNumber,dateOfBirth);
	   MailDatabase.getDb().getUserDetails().put(userId, user);
	   MailDatabase.getDb().getComposeMails().put(userId, new HashMap<Long,Mail>());
	   MailDatabase.getDb().getRecivedMail().put(userId,new HashMap<Long,Mail>());
	   
	   }
}
