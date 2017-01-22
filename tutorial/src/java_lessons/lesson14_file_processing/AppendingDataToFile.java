package java_lessons.lesson14_file_processing;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * AppendingDataToFile class.
 */
public final class AppendingDataToFile {

   /** Constructor. */
   private AppendingDataToFile() { }

   /**
    * Unit tests.
    * @param args the arguments
    * @throws IOException IOException
    */
   public static void main(final String[] args) throws IOException {

       String fileName = "tutorial\\src\\java_lessons\\lesson14_file_processing"
              + "\\grades.txt";
        PrintWriter outFile = new PrintWriter(new FileWriter(fileName, true));
        Scanner input = new Scanner(System.in);
        int grade;
        System.out.print("Enter a grade (-1 to quit): ");
        grade = input.nextInt();

        while (grade != -1) {
            outFile.println(grade);
            System.out.print("Enter a grade (-1 to quit): ");
            grade = input.nextInt();
        }
        outFile.close();
    }
}

