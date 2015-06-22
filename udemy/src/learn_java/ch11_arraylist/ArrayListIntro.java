package learn_java.ch11_arraylist;

import java.util.ArrayList;

public class ArrayListIntro
{
   public static void main(String[] args)
   {
      double average;
      int total = 0;
      ArrayList<Integer> grades = new ArrayList<Integer>();
      grades.add(78);
      grades.add(84);
      grades.add(90);
      for(int grade : grades)
         total += grade;
      average = total / grades.size();
      System.out.println("The average is " + average);
   }
}      