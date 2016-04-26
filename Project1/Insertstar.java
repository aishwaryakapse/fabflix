package project1;
import java.sql.*;
import java.sql.Connection.*;
import java.sql.DriverManager.*;
import java.sql.Statement.*;
import java.util.Scanner;

public class Insertstar {
	
	void insertStar() throws Exception{
		
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/moviedb","root", "WebApps_2016");
		
		Statement select = connection.createStatement();
		
		String first_name,last_name,photo_url,dob;
	
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter the actor's following details");
		System.out.println("Enter first_name:");
	    first_name = in.nextLine();
	    System.out.println("Enter last_name:");
	    last_name = in.nextLine();
	    System.out.println("Enter a photo_url:");
	    photo_url= in.nextLine();
	    System.out.println("Enter date of birth in the format yyyy-mm-dd:");
	    dob = in.nextLine(); 
	    
	    System.out.println("Inserting record into the table...");
	    
	    //if first_name is empty, leave it as empty
	    if(first_name.equals(""))
	    {
	    	String sql1 = "insert into stars (first_name,last_name,dob,photo_url) values ('',"+"'"+last_name+"'"+","+"'"+dob+"'"+","+"'"+photo_url+"'"+")";
	    	select.executeUpdate(sql1);
	    }
	  //if last_name is empty, insert first_name as last_name
	    else if(last_name.equals("") && !first_name.equals(""))
	    {
	    	String sql2 = "insert into stars (first_name,last_name,dob,photo_url) values ('',"+"'"+first_name+"'"+","+"'"+dob+"'"+","+"'"+photo_url+"'"+")";
	    	select.executeUpdate(sql2);
	    }
	    //both not empty
	    else 
	    {
	    	String sql3 = "insert into stars (first_name,last_name,dob,photo_url) values ('"+first_name+"',"+"'"+last_name+"'"+","+"'"+dob+"'"+","+"'"+photo_url+"'"+")";
	    	select.executeUpdate(sql3);
	    }
	    
	    System.out.println("Inserted record into the table...");
	
	}
}

