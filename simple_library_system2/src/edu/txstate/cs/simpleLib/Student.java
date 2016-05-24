package edu.txstate.cs.simpleLib;


import java.io.Serializable;

/**
 * Student subclass
 * @author Antonio Villegas
 *
 */
public class Student extends User implements Serializable
{
	/**
	 * fields
	 * The serializable class Journal declare a static 
	 * final serialVersionUID field of type long
	 */
	private static final long serialVersionUID = 1L;
	public static final int LONG_TERM_LOAN_PERIOD = 6;
	private int maximumItems;
	
	/**
	 * Constructor
	 */
	public Student() 
	{
		super();
	}

	/**
	 * Explicit Constructor
	 * @param name String representing User name
	 * @param itemsBorrowed integer representing User itemsBorrowed
	 * @param maximumItems integer representing student maximumItems
	 */
	public Student(String name, int id, int itemsBorrowed, int maximumItems) 
	{
		super(name, id, itemsBorrowed);
		this.maximumItems = 6;
	}

	/**
	 * Get the maximumItems of the student.
	 * @return the maximumItems.
	 */
	public int getMaximumItems() 
	{
		return maximumItems;
	}

	/**
	 * Set the maximumItems of the student.
	 * @param maximumItems the maximumItems to set.
	 */
	public void setMaximumItems(int maximumItems) 
	{
		this.maximumItems = maximumItems;
	}
	
	/**
	 * Get student toString() details.
	 * @return String representing Student details.
	 */
	public String toString()
	{
		return super.toString() + "\t\tMaximum Items per Student: " + this.getMaximumItems();
	}
}
