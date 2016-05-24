package edu.txstate.cs.simpleLib;

import java.io.Serializable;

/**
 * User superclass
 * @author Antonio Villegas
 *
 */
public class User implements Serializable
{
	/**
	 * fields
	 * The serializable class Document declare a static 
	 * final serialVersionUID field of type long
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int id;
	private int itemsBorrowed;
	
	/**
	 * Default Constructor
	 */
	public User() 
	{
		this.name = "";
		this.id = 0;
		itemsBorrowed = 0;
	}

	/**
	 * Explicit Constructor
	 * @param name String representing user name
	 * @param itemsBorrowed integer representing user itemsBorrowed
	 */
	public User(String name, int id, int itemsBorrowed)
	{
		this.name = name;
		this.id = id;
		itemsBorrowed = 0;
	}

	/**
	 * Get the name of the user.
	 * @return the name.
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * Set the name of the user.
	 * @param name the name to set.
	 */
	public void setName(String name) 
	{
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	
	/**
	 * Get itemsBorrowed of the user.
	 * @return the itemsBorrowed.
	 */
	public int getItemsBorrowed() 
	{
		return itemsBorrowed;
	}

	/**
	 * Set itemsBorrowed of the user.
	 * @param itemsBorrowed the itemsBorrowed to set.
	 */
	public void setItemsBorrowed(int itemsBorrowed) 
	{
		this.itemsBorrowed = itemsBorrowed;
	}
	/**
	 * Get user toString() details.
	 * @return String representing User details.
	 */
	@Override
	public String toString()
	{
		return "Name: " + this.getName() + "\t\tID: " 
		           + this.getId() + "\t\tItems Borrowed: " 
	           + this.getItemsBorrowed();
	}
	
}