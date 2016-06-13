package Serialization;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileReading {
	public static void main(String[] args) {
		
	       ArrayList<ZStudent> studlist = new ArrayList<ZStudent>();
	      
	        try {
	            FileReader fr = new FileReader("zStudentFileo.txt");
	            BufferedReader br  = new BufferedReader(fr);
	            String currentLine = br.readLine();
	            while (currentLine != null) {
	            //parse the data
	               String[] content = currentLine.split(" ");
	               for (String s: content) {
	            	    System.out.println(s);
	               }
	               System.out.println(content.length);
	               ZStudent stud = new ZStudent();
	               stud.setNo(Integer.parseInt(content[0]));
	               stud.setFirst(content[1]);
	               stud.setMid(content[2]);
	               stud.setLast(content[3]);
	               stud.setAve(Float.parseFloat(content[4]));
	               studlist.add(stud);
	               currentLine = br.readLine();
	            }	                     
	            fr.close();
	    
	        } catch (FileNotFoundException ex) {
	            System.err.println("input file not found.");
	        } catch (IOException ex) {
	            System.err.println(ex.toString());
	        } 
	        System.out.println("Done.");
	        for (ZStudent s: studlist) {
	        	System.out.println(s.toString());
	        }
	} // end of main    
}
