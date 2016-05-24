package edu.txstate.cs.data;

import java.io.Serializable;
import java.lang.String;
import java.util.LinkedList;

import edu.txstate.cs.data.DataHandler;

/**
 * Is RefinedAbstraction for the Bridge pattern
 *
 * @return .....
 */

public class LibData implements LibraryData, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static LibData firstInstance = null;
	public final static String docsOnLoanFile = "src\\edu\\txstate\\cs\\simpleLib\\files\\documentsOnLoan.txt";
	public final static String docsOnLoanSerFile = "src\\edu\\txstate\\cs\\simpleLib\\files\\documentsOnLoan.ser";
		
	private int userid;
	private String name;
	private String title;
	private String date;
	private LinkedList<LibData> borrowedList;
	private DataHandler dataHandlerAPI;

	public static LibData getInstance() {
        if (firstInstance == null) {
            firstInstance = new LibData(); 
        }
        return firstInstance;
	}
	
	public LibData() {
		this.borrowedList = new LinkedList<LibData>();
	}
	public LibData(int userid, String name, String title, String date, DataHandler dataHandlerAPI) {
		super();
		this.userid = userid;
		this.name = name;
		this.title = title;
		this.date = date;
		this.borrowedList = new LinkedList<LibData>();
		this.dataHandlerAPI = dataHandlerAPI;
	}
	
	public String toString() {
		return "user id = " + getId() + "name = " + getName() + ", date = " + getDate() +"]";
	}

	public int getId() { return this.userid; }
	public String getName() { return this.name; }
    public String getTitle() { return this.title; }
    public String getDate() { return date; }
    public LinkedList<LibData> getBorrowedList() { return borrowedList; }
    
	public void setId(int id) { this.userid = id; }
	public void setName(String name) { this.name = name; }
    public void setTitle(String title) { this.title = title; }
    public void setDate(String date) { this.date = date; }
    
	@Override
	public LibData getLibData(String fileName) {
		return dataHandlerAPI.loadDataFromFile(fileName);
	}

	@Override
	public void saveLibData(String fileName, LibData libData) {
		dataHandlerAPI.saveDataToFile(fileName, libData);
	}
}
