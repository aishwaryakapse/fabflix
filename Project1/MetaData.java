package project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class MetaData {
	void metaData() throws Exception {

		// Incorporate mySQL driver
		Class.forName("com.mysql.jdbc.Driver").newInstance();

		// Connect to the test database; url to be found out
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/moviedb", "root",
				"WebApps_2016");

		// Create an execute an SQL statement to select all of table "movies"
		// records
		Statement select = connection.createStatement();
		ResultSet result = select.executeQuery("Select * from movies");

		// Get metatdata from stars; print # of attributes in table
		System.out.println("Displaying the metadata of database moviedb:");
		System.out.println("Table Movies:");
		ResultSetMetaData metadata = result.getMetaData();
		System.out.println("There are " + metadata.getColumnCount() + " columns");

		// Print type of each attribute
		for (int i = 1; i <= metadata.getColumnCount(); i++)
			System.out.println("Type of column " + i + " is " + metadata.getColumnTypeName(i));
		// -------------------------------------------------------------------------------------------------------------------------------------------------------
		// Create an execute an SQL statement to select all of table "stars"
		// records
		// Statement select = connection.createStatement();
		ResultSet result1 = select.executeQuery("Select * from stars");
		System.out.println("Table Stars:");

		// Get metatdata from stars; print # of attributes in table
		// System.out.println("The results of the query");
		ResultSetMetaData metadata1 = result1.getMetaData();
		System.out.println("There are " + metadata1.getColumnCount() + " columns");

		// Print type of each attribute
		for (int i = 1; i <= metadata1.getColumnCount(); i++)
			System.out.println("Type of column " + i + " is " + metadata1.getColumnTypeName(i));
		// -----------------------------------------------------------------------------------------------------------------------------------------------------------
		// Create an execute an SQL statement to select all of table
		// "stars_in_movies" records
		// Statement select = connection.createStatement();
		ResultSet result2 = select.executeQuery("Select * from stars_in_movies");
		System.out.println("Table Stars_in_movies:");

		// Get metatdata from stars; print # of attributes in table
		// System.out.println("The results of the query");
		ResultSetMetaData metadata2 = result2.getMetaData();
		System.out.println("There are " + metadata2.getColumnCount() + " columns");

		// Print type of each attribute
		for (int i = 1; i <= metadata2.getColumnCount(); i++)
			System.out.println("Type of column " + i + " is " + metadata2.getColumnTypeName(i));
		// -----------------------------------------------------------------------------------------------------------------------------------------------------------
		// Create an execute an SQL statement to select all of table "genres"
		// records
		// Statement select = connection.createStatement();
		ResultSet result3 = select.executeQuery("Select * from genres");
		System.out.println("Table genres:");

		// Get metatdata from stars; print # of attributes in table
		// System.out.println("The results of the query");
		ResultSetMetaData metadata3 = result3.getMetaData();
		System.out.println("There are " + metadata3.getColumnCount() + " columns");

		// Print type of each attribute
		for (int i = 1; i <= metadata3.getColumnCount(); i++)
			System.out.println("Type of column " + i + " is " + metadata3.getColumnTypeName(i));
		// -----------------------------------------------------------------------------------------------------------------------------------------------------------
		// Create an execute an SQL statement to select all of table
		// "genres_in_movies" records
		// Statement select = connection.createStatement();
		ResultSet result4 = select.executeQuery("Select * from genres_in_movies");
		System.out.println("Table genres_in_movies:");

		// Get metatdata from stars; print # of attributes in table
		// System.out.println("The results of the query");
		ResultSetMetaData metadata4 = result4.getMetaData();
		System.out.println("There are " + metadata4.getColumnCount() + " columns");

		// Print type of each attribute
		for (int i = 1; i <= metadata4.getColumnCount(); i++)
			System.out.println("Type of column " + i + " is " + metadata4.getColumnTypeName(i));
		// -----------------------------------------------------------------------------------------------------------------------------------------------------------
		// Create an execute an SQL statement to select all of table "customers"
		// records
		// Statement select = connection.createStatement();
		ResultSet result5 = select.executeQuery("Select * from customers");
		System.out.println("Table customers:");

		// Get metatdata from stars; print # of attributes in table
		// System.out.println("The results of the query");
		ResultSetMetaData metadata5 = result5.getMetaData();
		System.out.println("There are " + metadata5.getColumnCount() + " columns");

		// Print type of each attribute
		for (int i = 1; i <= metadata5.getColumnCount(); i++)
			System.out.println("Type of column " + i + " is " + metadata5.getColumnTypeName(i));
		// -----------------------------------------------------------------------------------------------------------------------------------------------------------
		// Create an execute an SQL statement to select all of table "sales"
		// records
		// Statement select = connection.createStatement();
		ResultSet result6 = select.executeQuery("Select * from sales");
		System.out.println("Table Sales:");

		// Get metatdata from stars; print # of attributes in table
		// System.out.println("The results of the query");
		ResultSetMetaData metadata6 = result6.getMetaData();
		System.out.println("There are " + metadata6.getColumnCount() + " columns");

		// Print type of each attribute
		for (int i = 1; i <= metadata6.getColumnCount(); i++)
			System.out.println("Type of column " + i + " is " + metadata6.getColumnTypeName(i));
		// -----------------------------------------------------------------------------------------------------------------------------------------------------------
		// Create an execute an SQL statement to select all of table
		// "creditcards" records
		// Statement select = connection.createStatement();
		ResultSet result7 = select.executeQuery("Select * from creditcards");
		System.out.println("Table creditcards:");

		// Get metatdata from stars; print # of attributes in table
		// System.out.println("The results of the query");
		ResultSetMetaData metadata7 = result7.getMetaData();
		System.out.println("There are " + metadata7.getColumnCount() + " columns");

		// Print type of each attribute
		for (int i = 1; i <= metadata7.getColumnCount(); i++)
			System.out.println("Type of column " + i + " is " + metadata7.getColumnTypeName(i));
	}
}
