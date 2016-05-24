package edu.txstate.cs.simpleLib;

import java.io.Serializable;

/**
 * Faculty subclass
 * @author Antonio Villegas
 *
 */
public class Faculty extends User implements Serializable 
{
	/**
	 * fields
	 * The serializable class Journal declare a static 
	 * final serialVersionUID field of type long
	 */
	private static final long serialVersionUID = 1L;
	public static final int LONG_TERM_LOAN_PERIOD = 12;
	private int maximumItems;
	
	/**
	 * Constructor
	 */
	public Faculty() 
	{
		super();
	}

	/**
	 * Explicit Constructor
	 * @param name String representing User name
	 * @param itemsBorrowed integer representing User itemsBorrowed
	 * @param maximumItems integer representing faculty maximumItems
	 */
	public Faculty(String name, int id, int itemsBorrowed, int maximumItems) 
	{
		super(name, id, itemsBorrowed);
		this.maximumItems = 12;
	}
	
	/**
	 * Get the maximumItems of the user.
	 * @return the maximumItems.
	 */
	public int getMaximumItems() 
	{
		return maximumItems;
	}

	/**
	 * Set the maximumItems of the user.
	 * @param maximumItems the maximumItems to set.
	 */
	public void setMaximumItems(int maximumItems) 
	{
		this.maximumItems = maximumItems;
	}
	
	/**
	 * Get faculty toString() details.
	 * @return String representing Faculty details.
	 */
	public String toString()
	{
		return super.toString() + "\t\tMaximum Items per Faculty: " + this.getMaximumItems();
	}

}
