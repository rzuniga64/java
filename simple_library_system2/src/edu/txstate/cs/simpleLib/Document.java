package edu.txstate.cs.simpleLib;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Document superclass
 * @author Antonio Villegas
 *
 */
public class Document implements Serializable
{
	/**
	 * fields
	 * The serializable class Document declare a static 
	 * final serialVersionUID field of type long
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private String publisher;
//	private String author;
	private String date;
	private ArrayList<Author> authors;
	User user;
	
	/**
	 * Default Constructor
	 */
	public Document()
	{
		
	}
	
	/**
	 * Explicit Constructor
	 * @param title String representing Document title
	 * @param publisher String representing Document publisher
	 * @param author String representing Document author
	 */
	public Document(String title, String publisher, String date, ArrayList<Author> authors)
	{
		this.title = title;
		this.publisher = publisher;
//		this.author = author;
		this.date = date;
		this.authors = new ArrayList<Author>();
		this.authors = authors;
	}

	/**
	 * Get the title of the document.
	 * @return String representing the title of the document.
	 */
	public String getTitle() 
	{
		return title;
	}
	
	/**
	 * Set the title of the document.
	 * @param title String representing Document title.
	 */
	public void setTitle(String title) 
	{
		this.title = title;
	}

	/**
	 * Get the publisher of the document.
	 * @return String representing the publisher of the document.
	 */
	public String getPublisher() 
	{
		return publisher;
	}

	/**
	 * Set the publisher of the document.
	 * @param publisher String representing the publisher.
	 */
	public void setPublisher(String publisher) 
	{
		this.publisher = publisher;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
	/**
	 * Get the author of the document.
	 * @return String representing the author of the document.
	 */
//	public String getAuthor()
//	{
//		return author;
//	}
	public ArrayList<Author> getAuthor()
	{
		return authors;
	}	

	/**
	 * Set the author of the document.
	 * @param author String representing the author of the document.
	 */
//	public void setAuthor(String author) 
//	{
//		this.author = author;
//	}
	public void setAuthor(ArrayList<Author> authors)
	{
		this.authors = authors;
	}
	
	
	/**
	 * Get the user.
	 * @return the user.
	 */
	public User getUser() 
	{
		return user;
	}

	/**
	 * Set the user.
	 * @param user the user to set
	 */
	public void setUser(User user) 
	{
		this.user = user;
	}

	/**
	 * Get the document toString() details.
	 * @return String representing Document details.
	 */
	@Override
	public String toString()
	{
		return "Title: " + this.getTitle() + "\t\tPublisher: " + this.getPublisher() 
			    + "\t\tDate: " + this.getDate()
				+ "\t\tAuthor(s): " + this.getAuthor();
	}
}