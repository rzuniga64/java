package edu.txstate.librarysystem;

import java.io.*;
import java.util.LinkedList;

@SuppressWarnings("serial")
public class Borrowed implements Serializable {
    static final String borrowedSer = "src\\edu\\txstate\\cs\\librarysystem\\edu.txstate.librarysystem.files\\borrowed.ser";

	private int userid;
    private String title;
	private Long isbn;
	private String date;

	public Borrowed() { }
	public Borrowed(int id, String title, Long isbn, String date) {
		super();
        this.title = title;
		this.userid = id;
		this.isbn = isbn;
        this.date = date;
	}

	public String toString() {
		return "user id = " + getId() + ", isbn = " + getIsbn() + ", date = " + getDate() +"]";
	}

	public int getId() { return this.userid; }
    public String getTitle() { return this.title; }
	public Long getIsbn() { return this.isbn; }
    public String getDate() { return date; }

	@SuppressWarnings("unchecked")
	public static void setSerializedObject(Borrowed borrowedDocument) {
        LinkedList<Borrowed> borrowedList;
		if ( new File(borrowedSer).exists())
            borrowedList = Borrowed.getSerializedList();
        else
			borrowedList = new LinkedList<Borrowed>();
		try {
			FileOutputStream fos = new FileOutputStream(borrowedSer);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
            borrowedList.add(borrowedDocument);
			oos.writeObject(borrowedList);
			oos.close();
		} catch (FileNotFoundException e) {
			System.err.println("input file not found.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Can't access file");
			e.printStackTrace();
		}
    }

    @SuppressWarnings("unchecked")
    public static LinkedList<Borrowed> getSerializedList() {
        LinkedList<Borrowed> borrowedList = null;
        try {
            FileInputStream fis = new FileInputStream(borrowedSer);
            ObjectInputStream ois = new ObjectInputStream(fis);
            borrowedList = (LinkedList<Borrowed>) ois.readObject();
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
        return borrowedList;
    }

    public static void setSerializedList(LinkedList borrowedList) {
        try {
            FileOutputStream fos = new FileOutputStream(Borrowed.borrowedSer);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(borrowedList);
            oos.close();
        } catch (FileNotFoundException e) {
            System.err.println("input file not found.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Can't access file");
            e.printStackTrace();
        }
    }
}
