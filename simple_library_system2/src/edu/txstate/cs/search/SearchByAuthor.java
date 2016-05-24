package edu.txstate.cs.search;

import java.io.Serializable;

import edu.txstate.cs.console.ConsoleWindow;
import edu.txstate.cs.simpleLib.Document;

/**
 * Is a ConcreteStrategy for the Stragety pattern
 *
 * @return .....
 */

public class SearchByAuthor implements DocumentSearch, Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void search() {
		// search by Author
		
		Document d = null;
		
		if (ConsoleWindow.getLib() == null || ConsoleWindow.getLib().getSizeDocuments() == 0)
		{
			System.out.println("There are no documents in the Library system.");
		}
		else
		{
			System.out.println("Please enter the author of the document: ");
			String temp;
			temp = ConsoleWindow.getIn().nextLine();
				
			try {
				
				d = ConsoleWindow.getLib().getDocument(temp);
			} catch (Exception e) {
//				e.printStackTrace();
				System.out.println("There is no author with that name.\n");
			}
			
			if(d != null)
			{
				System.out.println(d.toString() + "\n");
			}
//			else
//			{
//				System.out.println("There is no document with that title.\n");
//			}
		}
	}
	
}
