package edu.txstate.librarysystem;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Scanner;

public class LibraryServices {
	private final static String docsOnLoanFile = "src\\edu\\txstate\\cs\\librarysystem\\edu.txstate.librarysystem.files\\documentsOnLoan.txt";
	
	FileReading fileReading = new FileReading().getInstance();
	
	private int loanPeriod;
	private int maximumItems;
	private Document document;
	private User user;
	
	public LibraryServices() {
		super();
		this.loanPeriod = 0;
		this.maximumItems = 0;
		this.document = null;
		this.user = null;
	}
	
	public int getLoanPeriod() { 
		return loanPeriod; 
	}
	
	public void setLoanPeriod(int newLoanPeriod) {
		this.loanPeriod = newLoanPeriod;
	}
	
	public int getMaximumItems() { 
		return maximumItems; 
	}
	
	public void setMaximumItems(int maximumItems) { 
		this.maximumItems = maximumItems; 
	}
	
	public void search() {
		
		int documentTypeMenuItem;
		int documentMenuItem;
		
		documentTypeMenuItem = documentSelectiontMenu();
		while(documentTypeMenuItem != 0) {
			switch(documentTypeMenuItem) {
	        	case 1:
	    			documentMenuItem = searchMenu();
	        		if (documentMenuItem == 1) {
		        		System.out.println("Enter the title of the book: ");
		        		Scanner in1 = new Scanner(System.in);
		        		String title = in1.nextLine();
		        		Book.searchByTitle(title);
	        		} else if (documentMenuItem == 2) {
		        		System.out.println("Enter the author of the book: ");
		        		Scanner in1 = new Scanner(System.in);
		        		String author = in1.nextLine();
		        		Book.searchByAuthor(author);
	        		}
	        		break;
	            case 2:
	    			documentMenuItem = searchMenu();
	        		if (documentMenuItem == 1) {
		        		System.out.println("Enter the title of the journal: ");
		        		Scanner in1 = new Scanner(System.in);
		        		String title = in1.nextLine();
		        		Journal.searchByTitle(title);
	        		} else if (documentMenuItem == 2) {
		        		System.out.println("Enter the author of the journal: ");
		        		Scanner in1 = new Scanner(System.in);
		        		String author = in1.nextLine();
		        		Journal.searchByAuthor(author);
	        		}
	        		break;
	            default:
	               System.out.println("Don't recognize input.");
			}
		}
	}
	
	private static int documentSelectiontMenu(){
	      int choice;
	      Scanner input = new Scanner(System.in);
	      System.out.println("\nDocument Selection Menu\n");
	      System.out.println("0. Exit the menu");
	      System.out.println("1. Book");
	      System.out.println("2. Journal");   
	      System.out.println();
	      System.out.print("Enter a choice: ");
	      choice = input.nextInt();
	      return choice;
	}
	
	private static int searchMenu(){
	      int choice;
	      Scanner input = new Scanner(System.in);
	      System.out.println("\nSearch Menu\n");
	      System.out.println("0. Exit the menu");
	      System.out.println("1. Search by title");
	      System.out.println("2. Search by author");   
	      System.out.println();
	      System.out.print("Enter a choice: ");
	      choice = input.nextInt();
	      return choice;
	}
	
	public void loanDocument(){
        int id;
		int menuItem = -1;
		while(menuItem != 0) {
	        menuItem = userMenu();
	        switch(menuItem) {
	        	case 1:
	        		System.out.println("Enter the name of the Faculty member: ");
	        		Scanner in1 = new Scanner(System.in);
	        		String facultyName = in1.nextLine();
	        		if (Faculty.isFaculty(facultyName)){
                        String[] fullname = facultyName.split("\\s");
                        id = User.getUserID(fullname[0], fullname[1], FileReading.getFacultySer());
	        			loan(facultyName, id, Faculty.MAXIMUM_LOAN_ITEMS, Faculty.LONG_TERM_LOAN_PERIOD );
	        		} else
	            		System.out.println(facultyName + " is not a registered user.");
	        		break;
	            case 2:
	        		System.out.println("Enter the name of the Staff member: ");
	        		Scanner in2 = new Scanner(System.in);
	        		String staffName = in2.nextLine();
	        		if (Staff.isStaff(staffName)){
                        String[] fullname = staffName.split("\\s");
                        id = User.getUserID(fullname[0], fullname[1], FileReading.getFacultySer());
	        			loan(staffName, id, Staff.MAXIMUM_LOAN_ITEMS, Staff.LONG_TERM_LOAN_PERIOD );
	        		} else
	            		System.out.println(staffName + " is not a registered user.");
	        		break;
	            case 3:
	        		System.out.println("Enter the name of the Student: ");
	        		Scanner in3 = new Scanner(System.in);
	        		String studentName = in3.nextLine();
	        		if (Student.isStudent(studentName)){
                        String[] fullname = studentName.split("\\s");
                        id = User.getUserID(fullname[0], fullname[1], FileReading.getFacultySer());
	        			loan(studentName, id, Student.MAXIMUM_LOAN_ITEMS, Student.LONG_TERM_LOAN_PERIOD );
	        		} else
	            		System.out.println(studentName + " is not a registered user.");
	        		break;
	            case 0:
	            	break;
	            default:
	            	System.out.println("Don't recognize input.");
	        }
		}
	}
	
	private void loan(String name, int id, int maxLoanItems, int longTermLoanPeriod ) {
		int loanItemCount = 0;	// number of items borrowed
		int documentType;	    // book or journal
        long isbn = 0;          // isbn of book

        if ( new File(Borrowed.borrowedSer).exists()) {
            LinkedList<Borrowed> borrowedList = Borrowed.getSerializedList();
            for (Borrowed object : borrowedList){
                if (object.getId() == id)
                    loanItemCount++;
            }
        }
        if (loanItemCount >= 0 && loanItemCount <= maxLoanItems) {
            // Get the document type: book or journal
            documentType = documentSelectiontMenu();
            // Get the title of the document
            System.out.println("Enter the title of the document: ");
            Scanner in2 = new Scanner(System.in);
            String documentTitle = in2.nextLine();
            // Set the loan period
            Calendar dueDate = Calendar.getInstance();
            dueDate.add(Calendar.MONTH, longTermLoanPeriod);
            // decrement the number of books on file
            if (documentType == 1) {
                ArrayList<Document> books = Document.getSerializedObject(FileReading.getBooksSer());
                for (Document book: books){
                    if (book.getTitle().equalsIgnoreCase(documentTitle)) {
                        if (book.getCopies() > 0) {
                            book.setCopies(book.getCopies() - 1);
                            isbn = book.getIsbn();
                            break;
                        }
                        else {
                            System.out.println("There are no more copies of '" + book.getTitle() + "' for checkout.");
                            return;
                        }
                    }
                }
                // store the updated number of copies
                Document.setSerializedObject(books, FileReading.getBooksSer());
            }
            // decrement the number of journals on file
            if (documentType == 2) {
                ArrayList<Document> journals = Document.getSerializedObject(FileReading.getJournalsSer());
                for (Document journal: journals){
                    if (journal.getTitle().equalsIgnoreCase(documentTitle)) {
                        if (journal.getCopies() > 0) {
                            journal.setCopies(journal.getCopies() - 1);
                            break;
                        }
                        else {
                            System.out.println("There are no more copies of '" + journal.getTitle() + "' for checkout.");
                            return;
                        }
                    }
                }
                // store the updated number of copies
                Document.setSerializedObject(journals, FileReading.getBooksSer());
            }
            // write the loan information to a serialized object
            Borrowed borrowedDocument = new Borrowed(id, documentTitle, isbn, dueDate.getTime().toString());
            Borrowed.setSerializedObject(borrowedDocument);
        } else {
            System.out.println(name + " has reached the borrowing limit.");
        }
	}
	
	public void returnDocument(){
        int id;
		int menuItem = -1;
		while(menuItem != 0) {
	        menuItem = userMenu();
	        switch(menuItem) {
	        	case 1:
	        		System.out.println("Enter the name of the Faculty member: ");
	        		Scanner in1 = new Scanner(System.in);
	        		String facultyName = in1.nextLine();
	        		if (Faculty.isFaculty(facultyName)){
                        String[] fullname = facultyName.split("\\s");
                        id = User.getUserID(fullname[0], fullname[1], FileReading.getFacultySer());
	        			returnDoc(id);
	        		} else
	            		System.out.println(facultyName + " is not a registered user.");
	        		break;
	            case 2:
	        		System.out.println("Enter the name of the Staff member: ");
	        		Scanner in2 = new Scanner(System.in);
	        		String staffName = in2.nextLine();
	        		if (Staff.isStaff(staffName)){
                        String[] fullname = staffName.split("\\s");
                        id = User.getUserID(fullname[0], fullname[1], FileReading.getFacultySer());
	        			returnDoc(id);
	        		} else
	            		System.out.println(staffName + " is not a registered user.");
	        		break;
	            case 3:
	        		System.out.println("Enter the name of the Student: ");
	        		Scanner in3 = new Scanner(System.in);
	        		String studentName = in3.nextLine();
	        		if (Student.isStudent(studentName)){
                        String[] fullname = studentName.split("\\s");
                        id = User.getUserID(fullname[0], fullname[1], FileReading.getFacultySer());
	        			returnDoc(id);
	        		} else
	            		System.out.println(studentName + " is not a registered user.");
	        		break;
	            case 0:
	            	break;
	            default:
	            	System.out.println("Don't recognize input.");
	        }
		}
	}

	private void returnDoc(int id ) {
        long isbn = 0;
		int documentType;	// book or journal
        LinkedList<Borrowed> borrowedList = null;
        LinkedList<Borrowed> borrowList = null;
        ArrayList<Document> bookList = null;

        // Get the document type: book or journal
        documentType = documentSelectiontMenu();
        // Get the title of the document
        System.out.println("Enter the title of the document: ");
        Scanner in2 = new Scanner(System.in);
        String documentTitle = in2.nextLine();

        // increment the number of books on file
        if (documentType == 1) {
            ArrayList<Document> books = Document.getSerializedObject(FileReading.getBooksSer());
            for (Document book: books){
                if (book.getTitle().equalsIgnoreCase(documentTitle)) {
                    if (book.getCopies() > 0) {
                        book.setCopies(book.getCopies() + 1);
                        isbn = book.getIsbn();
                        break;
                    }
                    else {
                        System.out.println("There are no more copies of '" + book.getTitle() + "' for checkout.");
                        return;
                    }
                }
            }
            // store the updated number of copies
            Document.setSerializedObject(books, FileReading.getBooksSer());
        }
        // increment the number of journals on file
        if (documentType == 2) {
            ArrayList<Document> journals = Document.getSerializedObject(FileReading.getJournalsSer());
            for (Document journal: journals){
                if (journal.getTitle().equalsIgnoreCase(documentTitle)) {
                    if (journal.getCopies() > 0) {
                        journal.setCopies(journal.getCopies() + 1);
                        break;
                    }
                    else {
                        System.out.println("There are no more copies of '" + journal.getTitle() + "' for checkout.");
                        return;
                    }
                }
            }
            // store the updated number of copies
            Document.setSerializedObject(journals, FileReading.getBooksSer());
        }
        // remove the borrowed item from the list of borrowed documents and store information to a serialized object
        if ( new File(Borrowed.borrowedSer).exists()) {
            borrowedList = Borrowed.getSerializedList();
            for (Borrowed object : borrowedList){
                if (object.getId() == id && documentType == 1 && object.getIsbn() == isbn)
                    borrowedList.remove(object);
                else if (object.getId() == id && documentType == 2 && object.getTitle().equals(documentTitle))
                    borrowedList.remove(object);
            }
        }
        Borrowed.setSerializedList(borrowedList);
        bookList = Document.getSerializedObject(FileReading.getBooksSer());
        borrowList = Borrowed.getSerializedList();
        int a = 1;
	}

	 
	public static void displayLoanItems() {
        LinkedList<Borrowed> borrowedList;

        System.out.println("ID\t\t\t" + "Document on Loan\t\t\t" + "ISBN\t\t\t\t" + "Due Date" );
        if ( new File(Borrowed.borrowedSer).exists()) {
            borrowedList = Borrowed.getSerializedList();
            for (Borrowed object : borrowedList) {
                System.out.println(object.getId() + "\t\t\t" + object.getTitle() + "\t\t\t"
                        + object.getIsbn() + "\t\t\t" + object.getDate());
            }
            System.out.println("\n");
        }
	}

	public void addDocument() {
		int menuItem = -1;
		while(menuItem != 0) {
	        menuItem = documentMenu();
	        switch(menuItem) {
	        	case 1:
	        		System.out.println("Enter the name of the book: ");
	        		Scanner in1 = new Scanner(System.in);
	        		String bookTitle = in1.nextLine();
	        		System.out.println("Enter the name of the publisher: ");
	        		String bookPublisher = in1.nextLine();
	        		System.out.println("Enter the date of publishing: ");
	        		String dateOfBookPublishing = in1.nextLine();
	        		System.out.println("Enter the ISBN: ");
	        		String isbn = in1.nextLine();
	        		System.out.println("Enter the authors: ");
	        		String authors = in1.nextLine();
	        		System.out.println("Enter the location: ");
	        		String location = in1.nextLine();
	        		System.out.println("Enter the call number: ");
	        		String callNumber = in1.nextLine();
	        		Book.addBook(bookTitle, bookPublisher, dateOfBookPublishing, isbn, authors, location, callNumber);
	        		break;
	            case 2:
	        		System.out.println("Enter the name of the journal: ");
	        		Scanner in2 = new Scanner(System.in);
	        		String journalTitle = in2.nextLine();
	        		System.out.println("Enter the date of publishing: ");
	        		String dateOfJournalPublishing = in2.nextLine();
	        		System.out.println("Enter the volume: ");
	        		String volume = in2.nextLine();
	        		System.out.println("Enter the issue: ");
	        		String issue = in2.nextLine();
	        		System.out.println("Enter the publisher: ");
	        		String publisher = in2.nextLine();
	        		System.out.println("Enter articles: ");
	        		String articles = in2.nextLine();
	        		Journal.addJournal(journalTitle, dateOfJournalPublishing, volume, issue, publisher, articles);
	        		break;
	            case 0:
	               break;
	            default:
	               System.out.println("Don't recognize input.");
	        }
		}
	}
	
	private static int documentMenu(){
	      int choice;
	      Scanner input = new Scanner(System.in);
	      System.out.println("\nDocument Menu\n");
	      System.out.println("0. Exit the menu");
	      System.out.println("1. Add a book");
	      System.out.println("2. Add a journal");  
	      System.out.println();
	      System.out.print("Enter a choice: ");
	      choice = input.nextInt();
	      return choice;
	}
	
	public void registerUser() {
		int menuItem = -1;
		while(menuItem != 0) {
	        menuItem = userMenu();
	        switch(menuItem) {
	        	case 1:
	        		System.out.println("Enter the name of the Faculty member you want to add: ");
	        		Scanner in1 = new Scanner(System.in);
	        		String facultyName = in1.nextLine();
	        		Faculty.addFaculty(facultyName);
	        		break;
	            case 2:
	        		System.out.println("Enter the name of the Staff member you want to add: ");
	        		Scanner in2 = new Scanner(System.in);
	        		String staffName = in2.nextLine();
	        		Staff.addStaff(staffName);
	        		break;
	            case 3:
	        		System.out.println("Enter the name of the Student member you want to add: ");
	        		Scanner in3 = new Scanner(System.in);
	        		String studentName = in3.nextLine();
	        		Student.addStudent(studentName);
	               break;
	            case 0:
	               break;
	            default:
	               System.out.println("Don't recognize input.");
	        }
		}
	}
	
	private static int userMenu(){
	      int choice;
	      Scanner input = new Scanner(System.in);
	      System.out.println("\nUser Selection Menu\n");
	      System.out.println("0. Exit the menu");
	      System.out.println("1. Faculty");
	      System.out.println("2. Staff");
	      System.out.println("3. Student");     
	      System.out.println();
	      System.out.print("Enter a choice: ");
	      choice = input.nextInt();
	      return choice;
	}
}
