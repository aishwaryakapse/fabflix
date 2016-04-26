package project1;
import java.sql.*;
import java.sql.Connection.*;
import java.sql.DriverManager.*;
import java.sql.Statement.*;
import java.util.Scanner;

public class ShowMovies {
	
	void printMovies() throws Exception {
			//SQL Driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();
						
			//Connect to the test database
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/moviedb","root","WebApps_2016");

			// -----------------  1. ------------------
			//Create an execute an SQL statement to select all of table stars records
			Statement select = connection.createStatement();
			ResultSet result = select.executeQuery("select * from stars");
			
			//Get meta data from stars
			//Print the result
			System.out.println("The result of the query");
			ResultSetMetaData metadata = result.getMetaData();
			System.out.println("There are "+ metadata.getColumnCount()+ " columns");
			
			
			 for (int i = 1; i <= metadata.getColumnCount(); i++)
	            System.out.println("Type of column "+ i + " is " + metadata.getColumnTypeName(i));
			
			// print table's contents, field by field
	        while (result.next())
	        {
	                System.out.println("Id = " + result.getInt(1));
	                System.out.println("Name = " + result.getString(2) +" "+ result.getString(3));
	                System.out.println("DOB = " + result.getString(4));
	                System.out.println("photoURL = " + result.getString(5));
	                System.out.println();
	        }
	        
	        //input from user
			String input;
			Scanner in = new Scanner(System.in);
			System.out.println("Enter the stars name or id: ");
			input = in.nextLine();
			
			//Check whether the input is string or integer
			boolean isDigits = input.matches("[0-9]*");
			String[] inputArray = input.split(" ");
			for (int i =0; i<inputArray.length; i++) {
				System.out.println(inputArray[i]);
			}
			
			//Executing the Query
			if (isDigits) {
				ResultSet setInner1 = select.executeQuery("SELECT * from movies WHERE id IN (SELECT movie_id FROM stars_in_movies WHERE star_id IN (SELECT id FROM stars WHERE id = " + input +"))");
				while(setInner1.next()) {
					System.out.println("Movie Id: " + setInner1.getInt(1));
					System.out.println("Movie Title: " + setInner1.getString(2));
					System.out.println("Year: " + setInner1.getString(3));
					System.out.println("Director: " + setInner1.getString(4));
					System.out.println("Banner URL: " + setInner1.getString(5));
					System.out.println("Trailer URL: " + setInner1.getString(6));
				}
			} else {
				if (inputArray.length == 1){
					ResultSet setInner2 = select.executeQuery("SELECT * from movies WHERE id IN (SELECT movie_id FROM stars_in_movies WHERE star_id IN (SELECT id FROM stars WHERE first_name = '" +inputArray[0] +"' OR last_name = '"+inputArray[0]+"'))");
					while(setInner2.next()){
						System.out.println("Movie Id: " + setInner2.getInt(1));
						System.out.println("Movie Title: " + setInner2.getString(2));
						System.out.println("Year: " + setInner2.getString(3));
						System.out.println("Director: " + setInner2.getString(4));
						System.out.println("Banner URL: " + setInner2.getString(5));
						System.out.println("Trailer URL: " + setInner2.getString(6));
					}
					
				} else {
					ResultSet setInner3 = select.executeQuery("SELECT * FROM movies WHERE id IN (SELECT movie_id FROM stars_in_movies WHERE star_id IN(SELECT id FROM stars WHERE first_name = '" +inputArray[0]+ "' AND last_name = '" +inputArray[1]+ "'))");	
					while(setInner3.next()){
						System.out.println("Movie Id: " + setInner3.getInt(1));
						System.out.println("Movie Title: " + setInner3.getString(2));
						System.out.println("Year: " + setInner3.getString(3));
						System.out.println("Director: " + setInner3.getString(4));
						System.out.println("Banner URL: " + setInner3.getString(5));
						System.out.println("Trailer URL: " + setInner3.getString(6));
					}
	      		
				}
			}
	}
}
				
