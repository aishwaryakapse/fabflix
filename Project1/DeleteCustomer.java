package project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteCustomer {
	void deleteCustomer() throws Exception {

		// SQL Driver
		Class.forName("com.mysql.jdbc.Driver").newInstance();

		// Connect to the test database
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/moviedb", "root",
				"WebApps_2016");

		// Create an execute an SQL statement to select all of table stars
		// records
		// Statement select = connection.createStatement();

		// input from user
		String input_delete;
		@SuppressWarnings("resource")
		Scanner in_del = new Scanner(System.in);
		System.out.println("Enter the customers id: ");
		input_delete = in_del.nextLine();

		// Create an update an SQL statement to delete all of table stars
		// records
		Statement update = connection.createStatement();
		int retID = update.executeUpdate("delete from customers where id = " + input_delete);
		System.out.println("retID = " + retID);
	}
}
