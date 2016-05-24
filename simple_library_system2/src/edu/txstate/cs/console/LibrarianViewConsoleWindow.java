package edu.txstate.cs.console;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;

import edu.txstate.cs.data.LibData;
import edu.txstate.cs.simpleLib.Author;
import edu.txstate.cs.simpleLib.Book;
import edu.txstate.cs.simpleLib.Document;
import edu.txstate.cs.simpleLib.Journal;
import edu.txstate.cs.simpleLib.LibSystem;

public class LibrarianViewConsoleWindow extends ConsoleWindow
{
	protected static LibData libdata = LibData.getInstance();
	LibrarianViewConsoleWindow() {}
	public LibrarianViewConsoleWindow(LibSystem libsys) 
	{
		LibrarianViewConsoleWindow.libsys = libsys;
	}

	@Override
	protected void printMenu() {
		System.out .println(
		"\n1. Add new document \n"
		+ "2. Checked out documents \n"
		+ "3. Main Menu\n");
		
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
						addDocument(); 
						break;
					case 2: 
						checkedOutDocuments(); 
						break;
					case 3: 
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
		} while (!exitProgram);
		
	}

	private void addDocument() {
		// add a document
		ArrayList<Author> authors = null;
		
		int choiceAddDocument = 0;
		boolean exitProgram = false;
		do {
		
			System.out.println("\n1. Add a book");
			System.out.println("2. Add a journal");
			System.out.println("3. Previous Menu");
			
			try {
				
			
				choiceAddDocument = Integer.parseInt(getIn().nextLine());
				switch(choiceAddDocument)
				{
					case 1:
						// add a book
		//				if(documents == null)
		//				{
		//					documents = new ArrayList<Document>();
		//				}
						
						String title;
						String publisher;
						String date;
						String author;
						Author anAuthor = null;
						String answerY = "y";
						String answerN = "n";
						String answer;
						boolean running = true;
						long isbn;
					    int copies;
					    Document abook = null;
		//			    ArrayList<Author> authors = new ArrayList<Author>();
					    authors = new ArrayList<Author>();
					    
						try
						{
							System.out.println("\nEnter Title: ");
							title = getIn().nextLine();
							
							System.out.println("\nEnter publisher: ");
							publisher = getIn().nextLine();
							
							System.out.println("\nEnter date of publishing: ");
							date = getIn().nextLine();
							
							System.out.println("\nEnter author: ");
							author = getIn().nextLine();
							
							anAuthor = new Author(author);
		//					lib.addDocument(ajournal);
		//					Author a = (Author)author;
							authors.add(anAuthor);
							
							while(running)
							{
								System.out.println("\nAdd another author: (Y or N) ");
								answer = getIn().nextLine();
								
								if (answer.equalsIgnoreCase(answerY))
								{
									System.out.println("\nEnter author: ");
									author = getIn().nextLine();
									anAuthor = new Author(author);
									authors.add(anAuthor);
								}
								else if(answer.equalsIgnoreCase(answerN))
								{
									running = false;
								}
								else
								{
									System.out.println("\nY for yes, N for No. Please try again.");
								}
							}
							
							
							
							System.out.println("\nEnter ISBN: ");
							isbn = Long.parseLong(getIn().nextLine());
		//					isbn = in.nextLine();
							
							System.out.println("\nEnter number of copies: ");
							copies = Integer.parseInt(getIn().nextLine());
							
							if(copies > 1)
							{
								
								for(int i = 0; i < copies; i++)
								{
									abook = new Book(title, publisher, date, authors, isbn, copies);
									libsys.addDocument(abook);
								}
							}
							else
							{
								abook = new Book(title, publisher, date,  authors, isbn, copies);
								libsys.addDocument(abook);
							}
							
		//					abook = new Book(title, publisher, authors, isbn, copies);
		//					lib.addDocument(abook);
						}
						catch (NumberFormatException e)
						{
							System.out.println(e.toString());
						}
						
						if(abook != null)
						{
		//					documents.add(abook);
							libsys.printDocument(abook);
						}
						break;
					case 2:
						// add a journal
		//				if(documents == null)
		//				{
		//					documents = new ArrayList<Document>();
		//				}
						
						String titlej;
						String publisherj;
						String datej;
						String authorj;
						Author anAuthorj = null;
						String answerYj = "y";
						String answerNj = "n";
						String answerj;
						boolean runningj = true;
						int volume;
						int issue;
						Document ajournal = null;
						authors = new ArrayList<Author>();
		
						try
						{
							System.out.println("\nEnter Title: ");
							titlej = getIn().nextLine();
							
							System.out.println("\nEnter publisher: ");
							publisherj = getIn().nextLine();
							
							System.out.println("\nEnter date of publishing: ");
							datej = getIn().nextLine();
							
							System.out.println("\nEnter author: ");
							authorj = getIn().nextLine();
							
							
							
							while(runningj)
							{
								System.out.println("\nAdd another author: (Y or N) ");
								answerj = getIn().nextLine();
								
								if (answerj.equalsIgnoreCase(answerYj))
								{
									System.out.println("\nEnter author: ");
									authorj = getIn().nextLine();
									anAuthorj = new Author(authorj);
									authors.add(anAuthorj);
								}
								else if(answerj.equalsIgnoreCase(answerNj))
								{
									runningj = false;
								}
								else
								{
									System.out.println("\nY for yes, N for No. Please try again.");
								}
							}
							
							
							
							
							
							
							System.out.println("\nEnter volume: ");
							volume = Integer.parseInt(getIn().nextLine());
							
							System.out.println("\nEnter issue: ");
							issue = Integer.parseInt(getIn().nextLine());
							
							ajournal = new Journal(titlej, publisherj, datej, authors, volume, issue);
							libsys.addDocument(ajournal);
						}
						catch (NumberFormatException e)
						{
							System.out.println(e.toString());
						}
		
						if(ajournal != null)
						{
		//					documents.add(ajournal);
							libsys.printDocument(ajournal);
						}
						break;
					case 3:
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
	
	private void checkedOutDocuments() {
		
		LinkedList<LibData> documentList = libdata.getBorrowedList();
		System.out.println("ID\t\t" + "Name\t\t\t" + "Document on Loan\t\t\t" + "Due Date");
		for (LibData ld: documentList) {
            System.out.println(ld.getId() + "\t\t" + ld.getName() + "\t\t" + ld.getTitle() + "\t\t\t" + ld.getDate());
		}
	}

}
