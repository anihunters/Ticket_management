package tckt_theme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ticket_fare {
	
	private static Connection con;
	private static Scanner us;

	public ticket_fare(Connection con, Scanner us) {

		this.con = con;
		this.us = us;
	}

	public static void price() {
		
		us.nextLine();
		System.out.println("Enter your age");
		String age = us.nextLine();

		System.out.println("Enter your visiting day");
		String day = us.nextLine();

		String mrp = "INSERT INTO price(age ,day)VALUES (?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(mrp);
			ps.setString(1, age);
			ps.setString(2, day);
			int i = ps.executeUpdate();

			if (i > 0) {
				System.out.println("Please select your ride");
				ride();
			} else {
				System.out.println("Data not store");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return;
	}

	public static void ride() {
		System.out.println("Select any on option yes or no");
		//us.nextLine();
		System.out.println();
		
		System.out.println("water_rides");
		String water_rides = us.nextLine();

		System.out.println("Monkey_ride");
		String Monkey_ride = us.nextLine();
		
		System.out.println("Ghost_house");
		String Ghost_house = us.nextLine();
		
		System.out.println("Last_ride");
		String Last_ride = us.nextLine();

		String rd = "INSERT INTO ride(water_rides ,Monkey_ride,Ghost_house,Last_ride)VALUES (?,?,?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(rd);
			ps.setString(1,water_rides );
			ps.setString(2, Monkey_ride);
			ps.setString(3,Ghost_house );
			ps.setString(4, Last_ride);
			
			int j = ps.executeUpdate();

			if (j> 0) {
				System.out.println("Thank you for choosing the rides");
			} else {
				System.out.println("Data not stored");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

		
	}

