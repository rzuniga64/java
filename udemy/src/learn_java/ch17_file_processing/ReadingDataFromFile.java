package learn_java.ch17_file_processing;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadingDataFromFile
{
   public static void main(String[] args) throws IOException
   {
      String fileName = "grades.txt";
      Scanner inFile = new Scanner(new FileReader(fileName));
      int grade;
      while (inFile.hasNextLine()) {
         grade = Integer.parseInt(inFile.nextLine());
         System.out.println(grade);
      }
   }
}