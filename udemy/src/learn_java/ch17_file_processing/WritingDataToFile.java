import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class WritingDataToFile
{
   public static void main(String[] args) throws IOException
   {
      String fileName = "grades.txt";
      PrintWriter outFile = new PrintWriter(new FileWriter(fileName));
      outFile.println(85);
      outFile.println(77);
      outFile.close();
   }
}