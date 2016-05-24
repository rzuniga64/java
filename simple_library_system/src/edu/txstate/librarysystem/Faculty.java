package edu.txstate.librarysystem;

import java.io.*;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Faculty extends User implements Serializable {
	public static final int LONG_TERM_LOAN_PERIOD = 12;
	public static final int MAXIMUM_LOAN_ITEMS = 12;
	
	public Faculty(String firstName, String lastName, int facultyID, String userType) {
		super(firstName, lastName, facultyID, userType);
	}

	public String toString() {
		return super.toString();
	}
	
	public static boolean isFaculty(String name){
		String[] fullname = name.split("\\s");
        if (User.isRegistered(fullname[0], fullname[1], FileReading.getFacultySer())) 
        	return true;
        else 
        	return false;
	}
	
    public static void addFaculty(String name) {
		String[] fullname = name.split("\\s");
        if (!isFaculty(name)) {
    		ArrayList<User> faculty = getSerializedObject(FileReading.getFacultySer());
			try {
				FileOutputStream fos = new FileOutputStream(FileReading.getFacultySer());
				ObjectOutputStream oos = new ObjectOutputStream(fos);
	        	Faculty facultyMember = new Faculty(fullname[0], fullname[1], faculty.size()+1, "faculty");
	        	faculty.add(facultyMember);
	        	oos.writeObject(faculty);
	        	System.out.println("Faculty member " + name + " is now registered!");
			} catch (FileNotFoundException e) {
		        System.err.println("input file not found.");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Can't access file");
				e.printStackTrace();
			}
        }
        else 
        	System.out.println("Faculty member " + name + " is already registered!");
    }
}
