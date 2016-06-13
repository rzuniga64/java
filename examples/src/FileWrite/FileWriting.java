package FileWrite;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriting {

	public static void main(String[] args) {
		ZStudent[] zstudents = {
				new ZStudent(50, "Blue", "M", "Monday", 50.0F),
				new ZStudent(100, "Gray", "G", "Tuesday", 60.0F),
				new ZStudent(150, "Green", "G", "Wednesday", 70.0F),
				new ZStudent(200, "Pink", "P", "Thursday", 80.0F),
				new ZStudent(300, "Red", "R", "Friday", 90.0F),
				new ZStudent(400, "Orange", "R", "Friday", 95.0F)};
				
			 	try {
			 	// FileWriter is for writing streams of characters, for writing 
			 		// streams of byte, use FileOutputStream
			 		// FileWriter will throws an IOException
				FileWriter fw = new FileWriter("src\\zStudentFileo.txt");
				BufferedWriter bw = new BufferedWriter(fw);
				for (ZStudent zstudent: zstudents) {
					bw.write(zstudent.toString());
					bw.newLine();// to write 1 obj at a time
					System.out.println(zstudent.toString());
			          }
				bw.close(); 
			 	} catch (IOException e){
			 		System.out.println("Error:" + e);
			 	}
	}
	}

