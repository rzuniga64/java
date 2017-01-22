package java_lessons.lesson14_file_processing;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * WritingCharsToFile class.
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

      String fileName = "chars.txt";
      PrintWriter outFile = new PrintWriter(new FileWriter(fileName));
      String sentence = "now is the time for all good people";
      for (int i = 0; i < sentence.length(); ++i) {
         outFile.write(sentence.charAt(i));
         outFile.write('\n');
      }
      outFile.close();
   }
}
