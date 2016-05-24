package edu.txstate.librarysystem;

import java.io.*;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class User implements Serializable {
	private String firstName;
	private String lastName;
	private int id;
	private String userType;

	public User() { }
	public User(String firstName, String lastName, int id, String userType) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.userType = userType;
	}

	public String toString() {
		return "first name = " + getFirstName() + ", last name = " + getLastName() 
		+ ", ID = " + getId() + ", User Type = " + getUserType() +"]";
	}
	
	public int getId() { return id; }
	public String getFirstName() { return firstName; }
	public String getLastName() { return lastName; }
	public String getUserType() { return userType; }
	
	@SuppressWarnings("unchecked")
	public static ArrayList<User> getSerializedObject(String serFile) {
    	ArrayList<User> sbuf = null;
		try {
			FileInputStream fis = new FileInputStream(serFile);
		    ObjectInputStream ois = new ObjectInputStream(fis);
	    	sbuf = (ArrayList<User>) ois.readObject();
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
	
	public static boolean isRegistered(String fname, String lname, String serFile) {
		ArrayList<User> faculty = getSerializedObject(serFile);
		for (User user: faculty) {
			if (user.getFirstName().equalsIgnoreCase(fname) && user.getLastName().equalsIgnoreCase(lname))
				return true;
		}
		return false;
	}

	public static int getUserID(String fname, String lname, String serFile) {
		ArrayList<User> faculty = getSerializedObject(serFile);
		for (User user: faculty) {
			if (user.getFirstName().equalsIgnoreCase(fname) && user.getLastName().equalsIgnoreCase(lname))
				return user.getId();
		}
		return 0;
	}
}
