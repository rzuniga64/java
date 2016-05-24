package edu.txstate.librarysystem;

import java.io.*;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Journal extends Document implements Serializable {
	private static final int LOAN_PERIOD = 3;
	
	int volume;
	int issue;
	String articles;
	
	public Journal(String title, String dateOfPublishing, int volume,
			int issue, int copies, String publisher, String articles) {
		super(title, publisher, dateOfPublishing, copies);
		this.volume = volume;
		this.issue = issue;
		this.articles = articles;
	}

	public String toString() { 
		return super.toString(); 
	}
	
    public static void searchByTitle(String title) {
		ArrayList<Document> journals = getSerializedObject(FileReading.getJournalsSer());
		for (Document journal: journals){
			if (journal.getTitle().equalsIgnoreCase(title)) {
				System.out.println("Location: " + journal.getLocation());
				System.out.println("Call Number: " + journal.getCallNumber());
			}
		}
    }
    
    public static void searchByAuthor(String author) {
		ArrayList<Document> journals = getSerializedObject(FileReading.getJournalsSer());
		for (Document journal: journals){
			if (journal.getTitle().equalsIgnoreCase(author)) {
				System.out.println("Location: " + journal.getLocation());
				System.out.println("Call Number: " + journal.getCallNumber());
			}
		}
    }
    
    public static void addJournal( String title, String dateOfPublishing, String volume, 
    							   String issue, String publisher, String articles ) {
		ArrayList<Document> journal = getSerializedObject(FileReading.getJournalsSer());
		try {
			FileOutputStream fos = new FileOutputStream(FileReading.getJournalsSer());
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			Journal newJournal = new Journal(title, dateOfPublishing, Integer.parseInt(volume), 
								Integer.parseInt(issue), 1, publisher, articles);
        	journal.add(newJournal);
        	oos.writeObject(journal);
        	System.out.println("Book " + title + " has been added.");
		} catch (FileNotFoundException e) {
	        System.err.println("input file not found.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Can't access file");
			e.printStackTrace();
		}
    }
}
