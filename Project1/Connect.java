package project1;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import java.lang.String;

public class Connect {

	void displayConnection() throws Exception {

		String username, password;
		Scanner in = new Scanner(System.in);

		System.out.println("Enter Username:");
		username = in.nextLine();

		System.out.println("Enter Password:");
		password = in.nextLine();

		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/moviedb", username, password);

		Statement select = connection.createStatement();

		System.out.println("Successfully logged in");
		System.out.println("Connected database successfully...");
	}

}
