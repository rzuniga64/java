package edu.txstate.cs.search;

import java.io.Serializable;

import edu.txstate.cs.console.ConsoleWindow;
import edu.txstate.cs.simpleLib.Document;

/**
 * Is a ConcreteStrategy for the Stragety pattern
 *
 * @return .....
 */

public class SearchByPublisher implements DocumentSearch, Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void search() {
		// search by Title
		
		Document d = null;
		

		//		if (documents == null || documents.size() == 0)
		if (ConsoleWindow.getLib() == null || ConsoleWindow.getLib().getSizeDocuments() == 0)
//		if (ConsoleWindow.getLibs().getSizeDocuments() == 0)
		{
			System.out.println("There are no documents in the Library system.");
		}
		else
		{
			System.out.println("Please enter the publisher of the document: ");
			String publisherDocument;
			publisherDocument = ConsoleWindow.getIn().nextLine();
			
			try {
				d = ConsoleWindow.getLib().getDocument(publisherDocument);
			} catch (Exception e) {
//				e.printStackTrace();
				System.out.println("There is no document with that name.\n");
			}
			
			if(d != null)
			{
				System.out.println(d.toString() + "\n");
			}
//			else
//			{
//				System.out.println("There is no document with that name.\n");
//			}
		}
	}


}
