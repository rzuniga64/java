package learn_java.ch17_file_processing;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WritingCharsToFile
{
   public static void main(String[] args) throws IOException
   {
      String fileName = "chars.txt";
      PrintWriter outFile = new PrintWriter(new FileWriter(fileName));
      String sentence = "now is the time for all good people";
      for(int i = 0; i < sentence.length(); ++i) {
         outFile.write(sentence.charAt(i));
         outFile.write('\n');
      }
      outFile.close();
   }
}