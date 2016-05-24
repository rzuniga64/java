package edu.txstate.librarysystem;

import java.io.*;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Book extends Document implements Serializable {
	private long isbn;
	private String authors;
	private String location;
	private String callNumber;
	//private String[] listOfAuthors;
	//private ArrayList<Author> authorList = new ArrayList<Author>();
	public Book(String title, String publisher, String dateOfPublishing, long isbn,
			int copies, String authors, String location, String callNumber) {
		super(title, publisher, dateOfPublishing, copies);
		this.isbn = isbn;
		this.authors = authors;
		this.location = location;
		this.callNumber = callNumber;
//		listOfAuthors = authors.split(",");
//		for (String a: listOfAuthors) {
//			Author author = new Author(a);
//			authorList.add(author);
//		}
	}

	public String toString() { 
		return "ISBN = " + isbn + super.toString(); 
//		for (Author a: authorList) {
//			data += a.toString();
//		}
	}
	public Long getIsbn() { return this.isbn; }
	public void setIsbn(int isbn) { this.isbn = isbn; }
	public String getAuthors() { return this.authors; }
	public void setAuthors(String authors) { this.authors = authors; }
	public String getLocation() { return this.location; }
	public void setLocation(String location) { this.location = location; }
	public String getCallNumber() { return this.callNumber; }
	public void setCallNumber(String callNumber) { this.callNumber = callNumber; }
	
    public static void searchByTitle(String title) {
		ArrayList<Document> books = getSerializedObject(FileReading.getBooksSer());
		for (Document book: books){
			if (book.getTitle().equalsIgnoreCase(title)) {
				System.out.println("Location: " + book.getLocation());
				System.out.println("Call Number: " + book.getCallNumber());
			}
		}
    }
    
    public static void searchByAuthor(String author) {
		ArrayList<Document> books = getSerializedObject(FileReading.getBooksSer());
		for (Document book: books){
			if (book.getAuthors().equalsIgnoreCase(author)) {
				System.out.println("Location: " + book.getLocation());
				System.out.println("Call Number: " + book.getCallNumber());
			}
		}
    }
    
    public static void addBook(String title, String publisher, String dateOfPublishing, String isbn, String authors, String location, String callNumber) {
		ArrayList<Document> books = getSerializedObject(FileReading.getBooksSer());
		try {
			FileOutputStream fos = new FileOutputStream(FileReading.getBooksSer());
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			Book newBook = new Book(title, publisher, dateOfPublishing, Integer.parseInt(isbn), 1, authors, location, callNumber);
        	books.add(newBook);
        	oos.writeObject(books);
          	System.out.println("Book '" + title + "' has been added.");
		} catch (FileNotFoundException e) {
	        System.err.println("input file not found.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Can't access file");
			e.printStackTrace();
		} 
    }
}
