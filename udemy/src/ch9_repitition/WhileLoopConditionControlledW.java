package ch9_repitition;

import java.util.Scanner;

public class WhileLoopConditionControlledW
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      int grade, total, count;
      double average = 0.0;
      total = 0; 
      count = 0;
      System.out.print("Enter a grade (-1 to quit): ");
      grade = input.nextInt();
      while (grade != -1) {
         total += grade;
         ++count;
         System.out.print("Enter a grade (-1 to quit): ");
         grade = input.nextInt();
      }
      average = total / count;
      System.out.println("The average grade is: " + average);
   }
}