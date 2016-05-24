package edu.txstate.cs.console;

import java.util.Scanner;

import edu.txstate.cs.search.DocumentSearch;
import edu.txstate.cs.simpleLib.LibSystem;

/**
 * Is ths context for the Stragety pattern
 *
 * @return .....
 */

public abstract class ConsoleWindow {
	protected static LibSystem libsys = LibSystem.getInstance();
	protected static Scanner in = new Scanner(System.in );
	
	// Instance Variable
	public DocumentSearch documentSearch;
	/**
	* Abstract method. To be implemented by subclasses.
	*/
	protected abstract void printMenu();
	public abstract void start();
	
	// Setter
	public void setDocumentSearch(DocumentSearch ds)
	{
		documentSearch = ds;
	}
	
	public void performDocumentSearch() {
		documentSearch.search();
	}

	public static Scanner getIn() {
		return in;
	}
	public static void setIn(Scanner in) {
		ConsoleWindow.in = in;
	}
	
	public static LibSystem getLib() {
		return ConsoleWindow.libsys;
	}
	public static void setIn(LibSystem libsys) {
		ConsoleWindow.libsys = libsys;
	}
}
