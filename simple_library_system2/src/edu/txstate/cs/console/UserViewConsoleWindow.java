package edu.txstate.cs.console;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;


import edu.txstate.cs.data.ASCIIFormat;
import edu.txstate.cs.data.LibData;
import edu.txstate.cs.data.SerializedFormat;
import edu.txstate.cs.search.DocumentSearch;
import edu.txstate.cs.search.SearchByAuthor;
import edu.txstate.cs.search.SearchByPublisher;
import edu.txstate.cs.search.SearchByTitle;
import edu.txstate.cs.simpleLib.Book;
import edu.txstate.cs.simpleLib.Document;
import edu.txstate.cs.simpleLib.Faculty;
import edu.txstate.cs.simpleLib.Journal;
import edu.txstate.cs.simpleLib.LibSystem;
import edu.txstate.cs.simpleLib.Staff;
import edu.txstate.cs.simpleLib.Student;
import edu.txstate.cs.simpleLib.User;

public class UserViewConsoleWindow extends ConsoleWindow
{
	protected static LibData libdata = LibData.getInstance();
	protected static LibData libData1;
	protected static LibData libData2;
	
	UserViewConsoleWindow() {}
	public UserViewConsoleWindow(LibSystem libsys) 
	{
		UserViewConsoleWindow.libsys = libsys;
	}
	
	private static Document document = null;
	
	@Override
	protected void printMenu() 
	{
		System.out .println(
		"\n1. Search \n"
		+ "2. Borrow \n"
		+ "3. Return \n"
		+ "4. Display loan items in text file\n" 
		+ "5. Display loan items in serialized object\n"
		+ "6. Main Menu\n");
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
						Search(); 
						break;
					case 2: 
						Borrow(); 
						break;
					case 3: 
						Return(); 
						break;
					case 4: 
						displayLoanItemsFromTextFile();
						break;
					case 5: 
						displayLoanItemsFromSerializedObject();
						break;	
					case 6: 
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

	private void Search() {
		DocumentSearch documentSearch = null;
		int choiceSearch = 0;
		boolean exitProgram = false;
		do {
		
			// search
			System.out.println("1. Search by Title");
			System.out.println("2. Search by Author");
			System.out.println("3. Search by Publisher");
			System.out.println("4. Previous Menu");
				
			try{	
				choiceSearch = Integer.parseInt(getIn().nextLine());
				switch(choiceSearch)
				{
					case 1:
						// search by Title
						documentSearch = new SearchByTitle();
						documentSearch.search();
						break;
					case 2:
						// search by Author
						documentSearch = new SearchByAuthor();
						documentSearch.search();
						break;
					case 3:
						// search by Publisher
						documentSearch = new SearchByPublisher();
						documentSearch.search();
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
		} while(!exitProgram);
	}

	public void Borrow() {
		
		User user = null;
		int loanItemCount = 0;			// number of items borrowed
        int maxLoanItems = 0;			// maximum number of borrowed items
        int loanPeriod = 0;				// the loan period of borrowed item
        int menuItem = -1;
        String documentTitle = null;	// title of document

		System.out.println("Enter the name of the borrower: ");
		Scanner in = new Scanner(System.in);
		String name = in.nextLine();
		user = libsys.getUser(name);
		
		if (user == null || user.getName() == "") {
			System.out.println("There is no User with name " + user.getName() + ".\n");
			return;
		}
		
        if ( libsys.getSizeItemsOnLoan() > 0) {
            LinkedList<LibData> borrowedList = libdata.getBorrowedList();
            for (LibData object : borrowedList){
                if (object.getId() == user.getId())
                    loanItemCount++;
            }
        }
        if (user instanceof Student) {
        	Student student = (Student)user;
        	maxLoanItems = student.getMaximumItems();
        	loanPeriod = Student.LONG_TERM_LOAN_PERIOD;
        	
        } else if (user instanceof Faculty) {
        	Faculty faculty = (Faculty)user;
        	maxLoanItems = faculty.getMaximumItems();
        	loanPeriod = Faculty.LONG_TERM_LOAN_PERIOD;
        } else if (user instanceof Staff) {
        	Staff staff = (Staff)user;
        	maxLoanItems = staff.getMaximumItems();
        	loanPeriod = Staff.LONG_TERM_LOAN_PERIOD;
        }
        
        if (loanItemCount >= 0 && loanItemCount <= maxLoanItems) {
            // Set the loan period
            Calendar dueDate = Calendar.getInstance();
            dueDate.add(Calendar.MONTH, loanPeriod);
            
            // Get the title of the document
            System.out.println("Enter the title of the document: ");
            Scanner in2 = new Scanner(System.in);
            documentTitle = in2.nextLine();
            
            document = libsys.getDocument(documentTitle);
            if (document != null) {
            	if (document instanceof Book) {
            		Book book = (Book) document;
            		if (book.getTitle().equals(documentTitle)){
            			if (book.getCopies() > 0) 
            				book.setCopies(book.getCopies()-1);
                        else 
                            System.out.println("There are no more copies of " + book.getTitle() + "' for checkout.\n");
            		}
            	}
            	if (document instanceof Journal) {
            		Journal journal = (Journal) document;
            		if (journal.getTitle().equals(documentTitle)){
            			if (journal.getCopies() > 0) 
            				journal.setCopies(journal.getCopies()-1);
                        else 
                            System.out.println("There are no more copies of " + journal.getTitle() + "' for checkout.\n");
            		}
            	}
            } else {
	        	System.out.println("There is no document with title " + document.getTitle() + "\n" );
            }
            
            boolean exitProgram = false;
            try {
	            do{
	            	menuItem = saveMenu();
	            	switch (menuItem) {
	            	
	            	case 1: // save the loan information to text file
	    		        	libData1 = new LibData(user.getId(), user.getName(),documentTitle, 
	    		        			dueDate.getTime().toString(), new ASCIIFormat());
	    		        	libdata.getBorrowedList().add(libData1);
	    		        	libData1.saveLibData(LibData.docsOnLoanFile, libData1);
	    		        	break;
	            	case 2: // save the loan information to serialized object
	    		        	libData2 = new LibData(user.getId(), user.getName(), documentTitle, 
	    						dueDate.getTime().toString(), new SerializedFormat());
	    		        	libdata.getBorrowedList().add(libData2);
	    		        	libData2.saveLibData(LibData.docsOnLoanSerFile, libData2);
	    		        	break;
	            	case 3: // exit the program
							exitProgram = true; 
							break;
					default: 
							System.err.println("Please select a number between 1 and 3.");
	            	}
	            } while (!exitProgram);
			} catch (InputMismatchException ex) {
				System.err.println("Input mismatch. Please Try again. " + ex);
				in.nextLine(); //clear the new line character from the input
			} catch (UnsupportedOperationException ex) {
				ex.printStackTrace(); //For debugging purposes only.
			} catch (Exception ex) {
				System.err.println( "An unknown error has occured. " + ex);
			}
        } else {
        	System.out.println(user.getName() + " has reached the borrowing limit.\n");
        }
	}
	
	protected int saveMenu() 
	{
		    int choice;
		    Scanner input = new Scanner(System.in);
			System.out.println(
			"\n1. Save to text file. \n"
			+ "2. Save to serialized object. \n"
			+ "3. Exit program.\n"
			+ "\n"
			+ "Enter a choice: ");
		    choice = input.nextInt();
		    return choice;
	}
	
	public void Return() {
		User user = null;
        String documentTitle = null;	// title of document
		
		System.out.println("Enter the name of the borrower: ");
		Scanner in3 = new Scanner(System.in);
		String name3 = in3.nextLine();
		user = libsys.getUser(name3);
		
		if (user != null) {
            // Get the title of the document
            System.out.println("Enter the title of the document: ");
            Scanner in2 = new Scanner(System.in);
            documentTitle = in2.nextLine();
            
            // remove the document from the file containing the list of borrowed documents.
            //removeDocumentFromTextFile(LibData.docsOnLoanFile, user.getId(), documentTitle);
            removeDocumentFromSerializedObject(LibData.docsOnLoanSerFile, user.getId(), documentTitle);
            
            document = libsys.getDocument(documentTitle);
            if (document != null) {
            	if (document instanceof Book) {
            		Book book = (Book) document;
            		if (book.getTitle().equals(documentTitle)){
            			if (book.getCopies() > 0) 
            				book.setCopies(book.getCopies()+1);
                        else 
                            System.out.println("There are no more copies of " + book.getTitle() + "' for checkout.\n");
            		}
            	}
            	if (document instanceof Journal) {
            		Journal journal = (Journal) document;
            		if (journal.getTitle().equals(documentTitle)){
            			if (journal.getCopies() > 0) 
            				journal.setCopies(journal.getCopies()+1);
                        else 
                            System.out.println("There are no more copies of " + journal.getTitle() + "' for checkout.\n");
            		}
            	}
            } else {
            	System.out.println("There is no document with title " + document.getTitle() + "\n" );
            }
		} 
	}
	
	 public void removeDocumentFromTextFile(String fileName, int id, String title) {
		 try {
			 File inFile = new File(fileName);

			 if (!inFile.isFile()) {
				 System.out.println("Parameter is not an existing file");
				 return;
			 }	

			 //Construct the new file that will later be renamed to the original filename.
			 File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

			 FileWriter fos = new FileWriter(tempFile);
			 BufferedWriter bw = new BufferedWriter(fos);
			
			 String line = null;

			 BufferedReader br = new BufferedReader(new FileReader(fileName));
			 
			 //Read from the original file and write to the new
			 //unless content matches data to be removed.
			 while ((line = br.readLine()) != null) {
				 String[] content = line.split("\\$");
				 if (!(content[0].equalsIgnoreCase(Integer.toString(id)) && content[1].equalsIgnoreCase(title))) {

					 bw.write(line);
					 bw.flush();
				 }
			 }
			 fos.close();
			 bw.close();
			 br.close();

		      //Delete the original file
		      if (!inFile.delete()) {
		        System.out.println("Could not delete text file");
		        return;
		      } 
		      	
			 //Rename the new file to the filename the original file had.
			 if (!tempFile.renameTo(inFile))
				 System.out.println("Could not rename text file");
		 }
		 catch (FileNotFoundException ex) {
			 ex.printStackTrace();
		 }
		 catch (IOException ex) {
			 ex.printStackTrace();
		 }
	 }
	 
	 public void removeDocumentFromSerializedObject(String fileName, int id, String title) {
		 
		 LinkedList<LibData> documentList = libdata.getBorrowedList();
		 for (LibData ld: documentList) {
			 if (ld.getId() == id && ld.getTitle().equals(title)) {
				 documentList.remove(ld);
			 }
		 }
		 
		 libData2.saveLibData(fileName, libdata);
	 }
	 
		public void displayLoanItemsFromTextFile() {
			try {
		        FileReader fr = new FileReader(LibData.docsOnLoanFile);
		        BufferedReader br  = new BufferedReader(fr);
		        String currentLine = br.readLine();
				System.out.println("ID\t\t" + "Name\t\t\t\t" + "Document on Loan\t\t\t" + "Due Date");
		        while (currentLine != null) {
		        	String[] content = currentLine.split("\\$");
		            System.out.println(content[0] + "\t\t" + content[1] + "\t\t\t" + content[2] + "\t\t\t" + content[3]);
		            currentLine = br.readLine();
		        }
		        System.out.println("\n");
		    } catch (FileNotFoundException e) {
		        System.err.println("input file not found.");
		        e.printStackTrace();
		    } catch (IOException e){
				System.out.println("Can't access file");
		        e.printStackTrace();
			} 
		}
		
		public void displayLoanItemsFromSerializedObject() {
		
			 
			LinkedList<LibData> documentList = libdata.getBorrowedList();
			System.out.println("ID\t\t" + "Name\t\t\t" + "Document on Loan\t\t\t" + "Due Date");
			for (LibData ld: documentList) {
	            System.out.println(ld.getId() + "\t\t" + ld.getName() + "\t\t" + ld.getTitle() + "\t\t\t" + ld.getDate());
			}
		}
}
