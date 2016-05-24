package edu.txstate.librarysystem;

import java.io.*;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Student extends User implements Serializable {
	public static final int LONG_TERM_LOAN_PERIOD = 6;
	public static final int MAXIMUM_LOAN_ITEMS = 6;
	
	public Student(String firstName, String lastName, int studentID, String userType) {
		super(firstName, lastName, studentID, userType);
	}

	public String toString() {
		return super.toString();
	}
	
	public static boolean isStudent(String name){
		String[] fullname = name.split("\\s");
        if (User.isRegistered(fullname[0], fullname[1], FileReading.getStudentsSer())) 
        	return true;
        else 
        	return false;
	}
	
    public static void addStudent(String name) {
		String[] fullname = name.split("\\s");
        if (!isStudent(name)) {
    		ArrayList<User> student = getSerializedObject(FileReading.getStudentsSer());
			try {
				FileOutputStream fos = new FileOutputStream(FileReading.getStudentsSer());
				ObjectOutputStream oos = new ObjectOutputStream(fos);
	        	Student studentMember = new Student(fullname[0], fullname[1], student.size(), "student");
	        	student.add(studentMember);
	        	oos.writeObject(student);
	        	System.out.println("Student " + name + " is now registered!");
			} catch (FileNotFoundException e) {
		        System.err.println("input file not found.");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Can't access file");
				e.printStackTrace();
			}
        }
        else 
        	System.out.println("Student " + name + " is already registered!");
    }
}
