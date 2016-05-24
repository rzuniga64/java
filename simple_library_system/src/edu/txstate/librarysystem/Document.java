package edu.txstate.librarysystem;


import java.io.*;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Document implements Serializable{
	private String title;
	private String publisher;
	private String dateOfPublishing;
	private int copies;
	
	public Document() { }
	public Document(String title, String publisher, String dateOfPublishing, int copies) {
		super();
		this.title = title;
		this.publisher = publisher;
		this.dateOfPublishing = dateOfPublishing;
		this.copies = copies;
	}

    public Long getIsbn() { return null; }
    public void setIsbn(Long isbn) { }
	public String getAuthors() { return null; }
	public void setAuthors(String authors) { }
	public String getLocation() { return null; }
	public void setLocation(String location) { }
	public String getCallNumber() { return null; }
	public void setCallNumber(String callNumber) { }
	
	public String toString() {
		String data =  "Title = " + getTitle() + ", Publisher= " + getPublisher() 
		+ ", Date of Publication = " + getDateOfPublishing() + ", Number of copies = " + getCopies();
		return data;
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Document> getSerializedObject(String serFile) {
    	ArrayList<Document> sbuf = null;
		try {
			FileInputStream fis = new FileInputStream(serFile);
		    ObjectInputStream ois = new ObjectInputStream(fis);
	    	sbuf = (ArrayList<Document>) ois.readObject();
		    ois.close();
	    } catch (FileNotFoundException e) {
	        System.err.println("input file not found.");
	        e.printStackTrace();
	    } catch (IOException e){
			System.out.println("Can't access file");
	        e.printStackTrace();    
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return sbuf;
	}
	
	@SuppressWarnings("unchecked")
	public static void setSerializedObject(ArrayList<Document> listOfDocuments, String serFile) {
    	ArrayList<Document> sbuf = listOfDocuments;
		try {
			FileOutputStream fos  = new FileOutputStream(serFile);	
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(sbuf);
		    oos.close();
	    } catch (FileNotFoundException e) {
	        System.err.println("input file not found.");
	        e.printStackTrace();
	    } catch (IOException e){
			System.out.println("Can't access file");
	        e.printStackTrace();    
		} 
	}
	
	public void checkout() { }
	public void checkin() {	}
	public void incrementNumberOfCopies(int number) { this.copies++;}
	public void decrementNumberOfCopies(int number) { this.copies--;}
	public String getTitle() { return this.title; }
	public void setTitle(String title) { this.title = title; }
	public String getPublisher() { return this.publisher; }
	public void setPublisher(String publisher) { this.publisher = publisher; }
	public String getDateOfPublishing() { return this.dateOfPublishing; }
	public void setDateOfPublishing(String dateOfPublishing) { this.dateOfPublishing = dateOfPublishing; }
	public int getCopies() { return this.copies; }
	public void setCopies(int copies) { this.copies = copies;}
}
