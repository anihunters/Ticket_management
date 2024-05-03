package tckt_theme;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class register {

	public static void main(String[] args) throws ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ticket_management", "root", "Shivam@123");
		Scanner us=new Scanner (System.in);	
			User user=new User(con,us);
			ticket_fare tk=new ticket_fare(con,us);
			String email;
			while(true) {
				System.out.println("Welcome to ticket management system");
				System.out.println("1 , register");
				System.out.println("2 , login");
				System.out.println("3 , Exit");
				System.out.println("Enter Choice ");
				int choice = us.nextInt();
				
				switch(choice) {
				case 1:
					user.registration();
					break;
				case 2:
				email =user.login();
				 
				while(true) {
					System.out.println();					
					System.out.println("1 ,Ticket ");
					System.out.println("2 , Select ride");
					System.out.println("3 , Exit");
					System.out.println("Enter Choice ");
					int choice2=us.nextInt();
					
					switch(choice2){
					case 1:
						ticket_fare.price();
					break;
					case 2:
						ticket_fare.ride();
						break;
						
					case 3 :
						System.out.println("THANK FOR GIVING YOUR PRECIOUS TIME");
						return;
					default :
						System.out.println("Enter valid choice");
						break;
				
					}
					break;
				}
			
				
				case 3:
					user.Exit();
					System.out.println("Thank you for visiting us.");
					return;
				default :
					System.out.println("Enter valid choice");
					break;
					
				}
		
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
