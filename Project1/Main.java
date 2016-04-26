package project1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {

		// TODO Auto-generated method stub

		System.out.println("1\t Print movies featuring a given star");
		System.out.println("2\t Insert new Star");
		System.out.println("3\t Insert New Customer");
		System.out.println("4\t Delete Customer");
		System.out.println("5\t Show Metadata of Database");
		System.out.println("6\t Enter SQL Query");
		System.out.println("7\t Exit the menu");
		System.out.println("8\t Exit the Program");
		System.out.println("Please enter your choice:");

		// Get user's choice

		Scanner in = new Scanner(System.in);
		int choice = in.nextInt();

		// Display the title of the chosen module
		switch (choice) {
		case 1:
			System.out.println("1.Printing Movies");
			ShowMovies showmovies = new ShowMovies();
			showmovies.printMovies();
			break;

		case 2:
			System.out.println("2.Insert new Star");
			Insertstar insertstar = new Insertstar();
			insertstar.insertStar();
			break;

		case 3:
			System.out.println("3.Insert New Customer");
			InsertCustomer insertcustomer = new InsertCustomer();
			insertcustomer.insertCust();

			break;
		case 4:
			System.out.println("4.Delete Customer");
			DeleteCustomer deletecustomer = new DeleteCustomer();
			deletecustomer.deleteCustomer();
			break;

		case 5:
			System.out.println("5.Show Metadata of Database");
			MetaData metadata = new MetaData();
			metadata.metaData();
			break;

		case 6:
			System.out.println("6.Command Line for SQL Queries");
			CommandLine commandline = new CommandLine();
			commandline.commandLine();
			break;

		case 7:
			System.out.println("7.Exit the menu");
			Connect connect = new Connect();
			connect.displayConnection();
			break;

		case 8:
			System.out.println("Goodbye!");
			System.exit(0);
			break;

		default:
			System.out.println("Do you want to continue?");
			break;

		}// end of switch
	}// end of the main method
}// end of class
