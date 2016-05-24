package edu.txstate.cs.console;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.txstate.cs.simpleLib.Faculty;
import edu.txstate.cs.simpleLib.LibSystem;
import edu.txstate.cs.simpleLib.Staff;
import edu.txstate.cs.simpleLib.Student;
import edu.txstate.cs.simpleLib.User;

public class AdminViewConsoleWindow extends ConsoleWindow
{
	AdminViewConsoleWindow() {}
	public AdminViewConsoleWindow(LibSystem lib) 
	{
		AdminViewConsoleWindow.libsys = lib;
	}

	@Override
	protected void printMenu() 
	{
		System.out .println(
		"\n1. Add User \n"
		+ "2. Remove User \n"
		+ "3. List users \n"
		+ "4. Main Menu\n");
	}

	@Override
	public void start() 
	{
		int choice = 0;
		boolean exitProgram = false;
		do {
			printMenu();
			
			try {
				choice = getIn().nextInt();
				getIn().nextLine(); //clear the new line character from the input
				
				switch (choice) 
				{
					case 1: 
						addUser(); 
						break;
					case 2: 
						removeUser(); 
						break;
					case 3: 
						listUsers(); 
						break;
					case 4: 
						exitProgram = true; 
						break;
					default: 
						System.err.println("Please select a number between 1 and 4.");
				}
				
			} catch (InputMismatchException ex) {
				System.err.println("Input missmatch. Please Try again. " + ex);
				getIn().nextLine(); //clear the new line character from the input
			} catch (UnsupportedOperationException ex) {
				ex.printStackTrace(); //For debugging purposes only.
			} catch (Exception ex) {
				System.err.println( "An unknown error has occured. " + ex);
			}
		} while (!exitProgram);
	}

	private void addUser() {
//		User u = null;
		
		int choiceAddUser = 0;
		boolean exitProgram = false;
		do {
		
		
			// add a user
			System.out.println("\n1. Add a student");
			System.out.println("2. Add a faculty");
			System.out.println("3. Add a staff");
			System.out.println("4. Previous Menu");
			
			try {
			
				choiceAddUser = Integer.parseInt(getIn().nextLine());
				switch(choiceAddUser)
				{
					case 1:
						// add a student
		//				if(users == null)
		//				{
		//					users = new ArrayList<User>();
		//				}
						
						String name;
						int id;
						int itemsBorrowed = 0;
						int maximumItems = 6;
						User astudent = null;
						
						System.out.println("\nEnter name: ");
		        		Scanner in = new Scanner(System.in);		        		
						name = in.nextLine();
						System.out.println("\nEnter ID: ");
						id = Integer.parseInt(in.nextLine());
						
						astudent = new Student(name, id, itemsBorrowed, maximumItems);
						libsys.addUser(astudent);
						
						if(astudent != null)
						{
		//					users.add(astudent);
							libsys.printUser(astudent);
						}
						break;
					case 2:
						// add faculty
		//				if(users == null)
		//				{
		//					users = new ArrayList<User>();
		//				}
						
						String namef;
						int idf;
						int itemsBorrowedf = 0;
						int maximumItemsf = 12;
						User afaculty = null;
						
						System.out.println("\nEnter name: ");
						namef = getIn().nextLine();
						System.out.println("\nEnter ID:");
						idf = Integer.parseInt(getIn().nextLine());
						
						afaculty = new Faculty(namef, idf, itemsBorrowedf, maximumItemsf);
						libsys.addUser(afaculty);
						
						if(afaculty != null)
						{
		//					users.add(afaculty);
							libsys.printUser(afaculty);
						}
						break;
					case 3:
						// add faculty
		//				if(users == null)
		//				{
		//					users = new ArrayList<User>();
		//				}
						
						String names;
						int ids;
						int itemsBorroweds = 0;
						int maximumItemss = 12;
						User astaff = null;
						
						System.out.println("\nEnter name: ");
						names = getIn().nextLine();
						System.out.println("\nEnter ID:");
						ids = Integer.parseInt(getIn().nextLine());
						
						astaff = new Staff(names, ids, itemsBorroweds, maximumItemss);
						libsys.addUser(astaff);
						
						if(astaff != null)
						{
		//					users.add(astaff);
							libsys.printUser(astaff);
						}
						break;
					case 4:
						exitProgram = true;
						break;
					default: 
						System.err.println("Please select a number between 1 and 3.");
				}
			} catch (InputMismatchException ex) {
				System.err.println("Input missmatch. Please Try again. " + ex);
				getIn().nextLine(); //clear the new line character from the input
			} catch (UnsupportedOperationException ex) {
				ex.printStackTrace(); //For debugging purposes only.
			} catch (Exception ex) {
				System.err.println( "An unknown error has occured. " + ex);
			}
		} while(!exitProgram);	
	}
	
	private void removeUser() {
		
		String nameUser;
		User u = null;
		
		try 
		{
			System.out.println("\nEnter the user name: ");
			nameUser = getIn().nextLine();
			u = libsys.getUser(nameUser);
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println("There is no User with that name.\n");
		}
		if(u != null)
		{
			libsys.removeUserFromCollection(u);
			System.out.println("User has been removed.");
		}
	}
	
	private void listUsers() {
		if(libsys.getSizeUsers() == 0)
		{
			System.out.println("The list is empty.");
		}
		else
		{
			libsys.printListUsers();
		}
	}
}
