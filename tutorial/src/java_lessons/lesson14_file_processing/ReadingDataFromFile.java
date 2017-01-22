package java_lessons.lesson14_file_processing;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *  ReadingDataFromFile class.
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

      String fileName = "grades.txt";
      Scanner inFile = new Scanner(new FileReader(fileName));
      int grade;

      while (inFile.hasNextLine()) {
         grade = Integer.parseInt(inFile.nextLine());
         System.out.println(grade);
      }
   }
}