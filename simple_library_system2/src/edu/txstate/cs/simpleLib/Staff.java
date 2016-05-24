package edu.txstate.cs.simpleLib;

import java.io.Serializable;

public class Staff extends User implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int LONG_TERM_LOAN_PERIOD = 12;
	private int maximumItems;
	
	/**
	 * Constructor
	 */
	public Staff() 
	{
		super();
	}
	
	/**
	 * Explicit Constructor
	 * @param name String representing User name
	 * @param itemsBorrowed integer representing User itemsBorrowed
	 * @param maximumItems integer representing student maximumItems
	 */
	public Staff(String name, int id, int itemsBorrowed, int maximumItems) 
	{
		super(name, id, itemsBorrowed);
		this.maximumItems = 12;
	}

	/**
	 * Get the maximumItems of the staff.
	 * @return the maximumItems.
	 */
	public int getMaximumItems() 
	{
		return maximumItems;
	}

	/**
	 * Set the maximumItems of the staff.
	 * @param maximumItems the maximumItems to set.
	 */
	public void setMaximumItems(int maximumItems) 
	{
		this.maximumItems = maximumItems;
	}
	
	/**
	 * Get staff toString() details.
	 * @return String representing Staff details.
	 */
	public String toString()
	{
		return super.toString() + "\t\tMaximum Items per Staff: " + this.getMaximumItems();
	}

}
