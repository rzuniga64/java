package edu.txstate.librarysystem;

import java.io.FileReader;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReading {
	private final static String usersFile =    	"src\\edu\\txstate\\librarysystem\\files\\users.txt";
	private final static String booksFile =    	"src\\edu\\txstate\\librarysystem\\files\\books.txt";
	private final static String journalsFile =  "src\\edu\\txstate\\librarysystem\\files\\journals.txt";

	private static final String studentsSer = 	"src\\edu\\txstate\\librarysystem\\files\\students.ser";
	private static final String staffSer =    	"src\\edu\\txstate\\librarysystem\\files\\staff.ser";
	private static final String facultySer =  	"src\\edu\\txstate\\librarysystem\\files\\faculty.ser";
	private static final String booksSer =    	"src\\edu\\txstate\\librarysystem\\files\\books.ser";
	private static final String journalsSer = 	"src\\edu\\txstate\\librarysystem\\files\\journals.ser";
	
	private static FileReading firstInstance = null;
	
	public FileReading(){}
	
	public static String getStudentsSer() { return studentsSer; }
	public static String getStaffSer() { return staffSer; }
	public static String getFacultySer() { return facultySer; }
	public static String getBooksSer() { return booksSer; }
	public static String getJournalsSer() { return journalsSer; }
	
	public static FileReading getInstance() {
        if (firstInstance == null) {
            firstInstance = new FileReading(); 
            readUsersFile(usersFile);
            readBooksFile(booksFile);
            readJournalsFile(journalsFile);
        }
        return firstInstance;
	}
	
	public static void readUsersFile(String usersFile) {
		ArrayList<Student> studentList = new ArrayList<Student>();
		ArrayList<Faculty> facultyList = new ArrayList<Faculty>();
		ArrayList<Librarian> librarianList = new ArrayList<Librarian>();
		try {
			Scanner inFile = new Scanner(new FileReader(usersFile));
			FileOutputStream fos1  = new FileOutputStream(studentsSer);
			ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
			FileOutputStream fos2  = new FileOutputStream(facultySer);
			ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
			FileOutputStream fos3  = new FileOutputStream(staffSer);
			ObjectOutputStream oos3 = new ObjectOutputStream(fos3);
			
			while (inFile.hasNextLine()) {
				String[] content = inFile.nextLine().split(" ");
				if (content[3].equals("student")) {
					Student student = new Student(content[0], content[1], Integer.parseInt(content[2]),content[3]);
					studentList.add(student);
				}
				if (content[3].equals("faculty")) {
					Faculty faculty = new Faculty(content[0], content[1], Integer.parseInt(content[2]),content[3]);
					facultyList.add(faculty);
				}
				if (content[3].equals("librarian")) {
					Librarian librarian = new Librarian(content[0], content[1], Integer.parseInt(content[2]),content[3]);
					librarianList.add(librarian);
				}
			}
			oos1.writeObject(studentList);
			oos2.writeObject(facultyList);
			oos3.writeObject(librarianList);
			
			inFile.close();
			oos1.close();
			oos2.close();
			oos3.close();
	    } catch (FileNotFoundException e) {
	        System.err.println("input file not found.");
	        e.printStackTrace();
	    } catch (IOException e){
			System.out.println("Can't access file");
	        e.printStackTrace();
		} 
	}
	
	public static void readBooksFile(String booksFile) {
		ArrayList<Book> bookList = new ArrayList<Book>();
		try {
			Scanner inFile = new Scanner(new FileReader(booksFile));
			FileOutputStream fos  = new FileOutputStream(booksSer);	
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			while (inFile.hasNextLine()) {
				if (inFile.hasNext("Title")){ 
					inFile.nextLine();
					continue;
				}
				else {
					String[] content = inFile.nextLine().split("\\$");
					Book book = new Book(content[0].replaceAll("\\t",""), 
										 content[1].replaceAll("\\t",""),
										 content[2].replaceAll("\\t",""), 
										 Long.parseLong(content[3].replaceAll("\\t","")), 
										 Integer.parseInt(content[4].replaceAll("\\t","")), 
										 content[5].replaceAll("\\t",""),
										 content[6].replaceAll("\\t",""),
										 content[7].replaceAll("\\t",""));
					bookList.add(book);
				}
			}

			oos.writeObject(bookList);		
			inFile.close();
			oos.close();;
	    } catch (FileNotFoundException ex) {
	        System.err.println("input file not found.");
	    } catch (IOException e){
			System.out.println("Can't access file");
		}
	}
	
	public static void readJournalsFile(String journalsFile) {
		ArrayList<Journal> journalList = new ArrayList<Journal>();
		try {
			Scanner inFile = new Scanner(new FileReader(journalsFile));
			FileOutputStream fos  = new FileOutputStream(journalsSer);	
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			while (inFile.hasNextLine()) {
				if (inFile.hasNext("Title")){ 
					inFile.nextLine();
					continue;
				}
				else {
					String[] content = inFile.nextLine().split("\\$");
					Journal journals = new Journal(content[0].replaceAll("\\t",""), 
										 content[1].replaceAll("\\t",""),
										 Integer.parseInt(content[2].replaceAll("\\t","")), 
										 Integer.parseInt(content[3].replaceAll("\\t","")), 
										 Integer.parseInt(content[4].replaceAll("\\t","")), 										 
										 content[5].replaceAll("\\t",""), 
										 content[6].replaceAll("\\t",""));
					journalList.add(journals);
				}
			}

			oos.writeObject(journalList);		
			inFile.close();
			oos.close();;
	    } catch (FileNotFoundException e) {
	        System.err.println("input file not found.");
	        e.printStackTrace();
	    } catch (IOException e){
			System.out.println("Can't access file");
			e.printStackTrace();
		}
	}
}
