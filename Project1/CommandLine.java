package project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;

public class CommandLine {

	void commandLine() throws Exception {
		// Incorporate mySQL driver
		Class.forName("com.mysql.jdbc.Driver").newInstance();

		// Connect to the test database; url to be found out
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/moviedb", "root",
				"WebApps_2016");
		Statement select = connection.createStatement();

		System.out.println("Enter the SQL command:");
		StringBuffer cmmd = new StringBuffer();
		Scanner in = new Scanner(System.in);
		cmmd.append(in.nextLine());
		String str = cmmd.toString();

		// Extracting first word of the command entered by user
		int spaceIndex = str.indexOf(" ");
		String firstWord = str.substring(0, spaceIndex);
		// System.out.println(firstWord);

		// if user enters SELECT command
		if (firstWord.equals("SELECT") || firstWord.equals("select")) {
			ResultSet result = select.executeQuery(str);
			ResultSetMetaData metadata = result.getMetaData();

			while (result.next()) {
				for (int i = 1; i <= metadata.getColumnCount(); i++) {
					if (metadata.getColumnTypeName(i).equals("INT")) {
						System.out.println(result.getInt(i));
					}
					if (metadata.getColumnTypeName(i).equals("VARCHAR")) {
						System.out.println(result.getString(i));
					}
					if (metadata.getColumnTypeName(i).equals("DATE")) {
						System.out.println(result.getString(i));
					}

				}
			}
		}

		else {
			int retID = select.executeUpdate(str);
			System.out.println(retID + " no of rows affected");
		}
	}

}
