package edu.txstate.librarysystem;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Librarian extends Staff implements Serializable{
	public Librarian(String firstName, String lastName, int staffID,
			String userType) {
		super(firstName, lastName, staffID, userType);
	}

	public String toString() {
		return super.toString();
	}
}
