package edu.txstate.cs.simpleLib;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Book subclass
 * @author Antonio Villegas
 *
 */
public class Book extends Document implements Serializable
{
	/**
	 * fields
	 * The serializable class Book declare a static 
	 * final serialVersionUID field of type long
	 */
	private static final long serialVersionUID = 1L;
	private long isbn;
	private int copies;

	/**
	 * Constructor
	 */
	public Book()
	{
		super();
	}

	/**
	 * Explicit Constructor
	 * @param title String representing Document title
	 * @param publisher String representing Document publisher
	 * @param isbn integer representing book isbn
	 * @param copies integer representing book copies
	 */
	public Book(String title, String publisher, String date, ArrayList<Author> authors,
			    long isbn, int copies)
	{
		super(title, publisher, date, authors);
		this.isbn = isbn;
		this.copies = copies;
	}

	/**
	 * Get the isbn of the book.
	 * @return integer representing the isbn of the book.
	 */
	public long getIsbn() 
	{
		return isbn;
	}

	/**
	 * Set the isbn of the book.
	 * @param isbn integer representing the isbn of the book.
	 */
	public void setIsbn(int isbn) 
	{
		this.isbn = isbn;
	}

	/**
	 * Get the copies of the book.
	 * @return integer representing the copies of the book.
	 */
	public int getCopies() 
	{
		return copies;
	}

	/**
	 * Set the copies of the book.
	 * @param copies integer representing the copies of the book.
	 */
	public void setCopies(int copies) 
	{
		this.copies = copies;
	}
	
	/**
	 * Get the book toString() details.
	 * @return String representing Book details.
	 */
	public String toString()
	{
		return super.toString() + "\t\tISBN: " + this.getIsbn() + "\t\tCopies: " +
			   this.getCopies();
	}
}
