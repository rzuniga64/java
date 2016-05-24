package edu.txstate.librarysystem;

@SuppressWarnings("serial")
public class AudioTape extends Tape {

	public AudioTape(String title, String publisher, String dateOfPublishing,
			int copies, String authors) {
		super(title, publisher, dateOfPublishing, copies, authors);
	}

	public String toString() {
		return super.toString();
	}
}
