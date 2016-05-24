package edu.txstate.librarysystem;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Tape extends Document implements Serializable{

	public Tape(String title, String publisher, String dateOfPublishing,
			int copies, String authors) {
		super(title, publisher, dateOfPublishing, copies);
	}

	public String toString() {
		return super.toString();
	}
}
