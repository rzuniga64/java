package edu.txstate.cs.simpleLib;

import java.io.Serializable;

public class Author implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String author;
	
	
	public Author()
	{
		
	}
	
	public Author(String author)
	{
		this.author = author;
	}
	
	public String getAuthor()
	{
		return author;
	}
	
	public void setAuthor(String author)
	{
		this.author = author;
	}
	
	public String toString()
	{
		return this.getAuthor();
	}
}

