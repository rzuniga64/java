package edu.txstate.librarysystem;

@SuppressWarnings("serial")
public class ConferenceProceedings extends Book {
	private String date;
	private int numConferenceProceedings;
	
	public ConferenceProceedings(String title, String publisher,
			String dateOfPublishing, int copies, String author, int isbn, String location,
			String date, int number, String callNumber) {
		super(title, publisher, dateOfPublishing, isbn, copies, author, location, callNumber);
		this.date = dateOfPublishing;
		this.numConferenceProceedings = number;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getNumConferenceProceedings() {
		return numConferenceProceedings;
	}
	public void setNumConferenceProceedings(int numConferenceProceedings) {
		this.numConferenceProceedings = numConferenceProceedings;
	}

}
