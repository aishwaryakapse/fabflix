package project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class InsertCustomer {
	void insertCust() throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/moviedb", "root",
				"WebApps_2016");
		System.out.println("Connected database successfully...");

		Statement select = connection.createStatement();

		String first_name, last_name, cc, addr, email, pass;

		Scanner in = new Scanner(System.in);

		System.out.println("Enter new customer's details");
		System.out.println("Enter first_name:");
		first_name = in.nextLine();
		System.out.println("Enter last_name:");
		last_name = in.nextLine();
		System.out.println("Enter your credit card:");
		cc = in.nextLine();

		// if credit card is not entered, do not accept the customer
		if (cc.equals("")) {
			System.out.println("Invalid card details. Retry.");
			return;
		}

		System.out.println("Enter your address:");
		addr = in.nextLine();
		System.out.println("Enter your email:");
		email = in.nextLine();
		System.out.println("Enter your password:");
		pass = in.nextLine();

		System.out.println("Inserting record into the table...");

		// if first_name is empty, leave it as empty
		if (first_name.equals("")) {
			System.out.println("Hie");

			String sql1 = "insert into customers (first_name,last_name,cc_id, address, email, password) values (''"
					+ "," + "'" + last_name + "'" + "," + "'" + cc + "'" + "," + "'" + addr + "'" + "," + "'" + email
					+ "'" + "," + "'" + pass + "'" + ")";
			select.executeUpdate(sql1);

		}
		// if last_name is empty, insert first_name as last_name
		else if (last_name.equals("") && !first_name.equals("")) {
			String sql2 = "insert into customers (first_name,last_name,cc_id, address, email, password) values ('"
					+ first_name + "'" + "," + "''" + "," + "'" + cc + "'" + "," + "'" + addr + "'" + "," + "'" + email
					+ "'" + "," + "'" + pass + "'" + ")";
			select.executeUpdate(sql2);

		}
		// both not empty
		else {

			String sql3 = "insert into customers (first_name,last_name,cc_id, address, email, password) values ('"
					+ first_name + "'" + "," + "'" + last_name + "'" + "," + "'" + cc + "'" + "," + "'" + addr + "'"
					+ "," + "'" + email + "'" + "," + "'" + pass + "'" + ")";
			select.executeUpdate(sql3);

		}

		System.out.println("Inserted record into the credit card table...");
	}
}
