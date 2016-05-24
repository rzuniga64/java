package edu.txstate.cs.console;

import java.util.InputMismatchException;

import edu.txstate.cs.simpleLib.LibSystem;

public class MainMenuConsoleWindow extends ConsoleWindow
{
	MainMenuConsoleWindow() {}
	public MainMenuConsoleWindow(LibSystem libsys) 
	{
		MainMenuConsoleWindow.libsys = libsys;
	}
	
	protected void printMenu() 
	{
		System.out.println(
		"\n1. Switch to user view. \n"
		+ "2. Switch to librarian view. \n"
		+ "3. Switch to Admin view. \n"
		+ "4. Exit program.\n");
	}
	
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
						UserView(); 
						break;
					case 2: 
						LibrarianView(); 
						break;
					case 3: 
						AdminView(); 
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
	
	public void AdminView() 
	{
		AdminViewConsoleWindow AdminMenu = new AdminViewConsoleWindow();
		AdminMenu.start();
	}
	public void LibrarianView() 
	{
		LibrarianViewConsoleWindow LibrarianMenu = new LibrarianViewConsoleWindow();
		LibrarianMenu.start();
	}
	public void UserView() 
	{
		UserViewConsoleWindow userMenu = new UserViewConsoleWindow();
		userMenu.start();
	}
}