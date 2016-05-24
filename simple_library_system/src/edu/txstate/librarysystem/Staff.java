package edu.txstate.librarysystem;

import java.io.*;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Staff extends User implements Serializable {
	public static final int LONG_TERM_LOAN_PERIOD = 12;
	public static final int MAXIMUM_LOAN_ITEMS = 12;
	
	public Staff(String firstName, String lastName, int staffID, String email ) {
		super(firstName, lastName, staffID, email);
	}

	public String toString() {
		return super.toString();
	}

	public static boolean isStaff(String name){
		String[] fullname = name.split("\\s");
        if (User.isRegistered(fullname[0], fullname[1], FileReading.getStaffSer())) 
        	return true;
        else 
        	return false;
	}
	
    public static void addStaff(String name) {
		String[] fullname = name.split("\\s");
        if (!isStaff(name)) {
    		ArrayList<User> staff = getSerializedObject(FileReading.getStaffSer());
			try {
				FileOutputStream fos = new FileOutputStream(FileReading.getStaffSer());
				ObjectOutputStream oos = new ObjectOutputStream(fos);
	        	Staff staffMember = new Staff(fullname[0], fullname[1], staff.size(), "librarian");
	        	staff.add(staffMember);
	        	oos.writeObject(staff);
	        	System.out.println("Staff member " + name + " is now registered!");
			} catch (FileNotFoundException e) {
		        System.err.println("input file not found.");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Can't access file");
				e.printStackTrace();
			}
        }
        else 
        	System.out.println("Staff member " + name + " is already registered!");
    }
}
