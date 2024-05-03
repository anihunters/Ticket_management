package tckt_theme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class User {
	
	private static final String email = null;
	private Connection con;
	private Scanner us;
	

	public User(Connection con, Scanner us) {
		
		this.con=con;
		this.us=us;
		// TODO Auto-generated constructor stub
	}

//	public static void main(String[] args) {
		// TODO Auto-generated method stub

	//}

	public void registration() {
		// TODO Auto-generated method stub
		us.nextLine();
		
		System.out.println("Enter your name");
		String name = us.nextLine();
		
		System.out.println("Enter your age");
		String age=us.nextLine();
	
		System.out.println("Enter your email");
		String email=us.nextLine();
		
		System.out.println("Enter your password");
		String pass=us.nextLine();
		
		String regis_query="INSERT INTO registration(name , age , email ,pass)VALUES (?,?,? ,?)";
		try {
		PreparedStatement ps=con.prepareStatement(regis_query);
		ps.setString(1,name);
		ps.setString(2, age);
		ps.setString(3,email);
		ps.setString(4,pass);
		int affectedrows = ps.executeUpdate();
		
		if(affectedrows>0) {
			System.out.println("Sucessfully Registered");
		}else {
			System.out.println("failed");
		}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	public String login() {
		us.nextLine();
		
		System.out.println("Enter your email");
		String name = us.nextLine();
		System.out.println("Enter your password:");
		String pass = us.nextLine();
		
		String login_query=  "Select * from registration where email=? and pass= ?";
		try {
			PreparedStatement ps=con.prepareStatement(login_query);

			ps.setString(1,email);
			ps.setString(2, pass);
			ResultSet abc= ps.executeQuery();
			System.out.println("Welcome to login page");
			if(abc.next()) {
				return email;
			}else {
				return null;
			}
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			


		return null;
		
	}


	public void Exit() {
		
		
	}

}
