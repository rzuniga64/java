package edu.txstate.cs.simpleLib;

/*
 * Group Members: Raul Zuniga, Antonio Villegas
 */

import edu.txstate.cs.console.MainMenuConsoleWindow;

public class Main 
{
//	public static String fileName = "library.txt";
	private static LibSystem lib = new LibSystem();
	private static MainMenuConsoleWindow mainMenu = new MainMenuConsoleWindow(lib);
	
	public static void main(String[] args) 
	{
		mainMenu.start();
	}
}
