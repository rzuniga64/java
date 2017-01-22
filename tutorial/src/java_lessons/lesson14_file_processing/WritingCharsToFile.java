package java_lessons.lesson14_file_processing;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *  WritingCharsToFile class.
 *  PrintWrite is the class that allows us to write data to a file.
 *  FileWrite opens a file for output.
 *  Must add throws IOException to the main function.
 */
public final class WritingCharsToFile {

    /** Constructor. */
    private WritingCharsToFile() { }

    /**
     * Unit Tests.
     * @param args the arguments
     * @throws IOException IOException
     */
   public static void main(final String[] args) throws IOException {

       String fileName = "tutorial\\src\\java_lessons\\lesson14_file_processing"
               + "\\chars.txt";

      PrintWriter outFile = new PrintWriter(new FileWriter(fileName));
      String sentence = "now is the time for all good people";

      for (int i = 0; i < sentence.length(); ++i) {
         outFile.write(sentence.charAt(i));
         outFile.write('\n');
      }
      outFile.close();
   }
}
