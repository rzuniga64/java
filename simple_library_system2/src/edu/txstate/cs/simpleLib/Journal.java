package edu.txstate.cs.simpleLib;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Journal subclass
 * @author Antonio Villegas
 *
 */
public class Journal extends Document implements Serializable
{
	/**
	 * fields
	 * The serializable class Journal declare a static 
	 * final serialVersionUID field of type long
	 */
	private static final long serialVersionUID = 1L;
	private int volume;
	private int issue;
	private int copies;
	
	/**
	 * Constructor 
	 */
	public Journal() 
	{
		super();
	}

	/**
	 * Explicit Constructor
	 * @param title String representing Document title
	 * @param publisher String representing Document publisher
	 * @param volume integer representing journal volume
	 * @param issue integer representing journal issue
	 */
	public Journal(String title, String publisher, String date, ArrayList<Author> authors,
			       int volume, int issue) 
	{
		super(title, publisher, date, authors);
		this.volume = volume;
		this.issue = issue;
		this.copies = 1;
	}

	/**
	 * Get the volume of the journal.
	 * @return integer representing the volume of the journal.
	 */
	public int getVolume() 
	{
		return volume;
	}

	/**
	 * Set the volume of the journal.
	 * @param volume integer representing the volume of the journal.
	 */
	public void setVolume(int volume) 
	{
		this.volume = volume;
	}

	/**
	 * Get the issue of the journal.
	 * @return integer representing the issue of the journal.
	 */
	public int getIssue() 
	{
		return issue;
	}

	/** 
	 * Set the issue of the journal.
	 * @param issue integer representing the issue of the journal.
	 */
	public void setIssue(int issue) 
	{
		this.issue = issue;
	}
	
	/**
	 * Get the number of copies of the journal.
	 * @return integer representing the number of copies of the journal.
	 */
	public int getCopies() 
	{
		return copies;
	}

	/** 
	 * Set the number of copies of the journal.
	 * @param issue integer representing the number of copies of the journal.
	 */
	public void setCopies(int copies) 
	{
		if (this.copies != 0 && this.copies != 1)
			this.copies = copies;
	}
	
	
	public String toString()
	{
		return super.toString() + "\t\tVolume: " + this.getVolume() + "\t\tIssue: " +
	           this.getIssue();
	}
}