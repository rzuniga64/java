package java_lessons.lesson14_file_processing;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *  ReadingDataFromFile class.
 *  Scanner used to get input from a file.
 *  FileReader is to open up a file for reading.
 *  Must add throws IOException to the main function.
 */
public final class ReadingDataFromFile {

    /** Constructor. */
    private ReadingDataFromFile() { }

    /**
     * Unit tests.
     * @param args the arguments.
     * @throws IOException IOException
     */
   public static void main(final String[] args) throws IOException {

       String fileName = "tutorial\\src\\java_lessons\\lesson14_file_processing"
               + "\\grades.txt";
      Scanner inFile = new Scanner(new FileReader(fileName));
      int grade;

      while (inFile.hasNextLine()) {
         grade = Integer.parseInt(inFile.nextLine());
         System.out.println(grade);
      }
   }
}