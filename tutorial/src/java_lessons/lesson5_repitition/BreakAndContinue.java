package java_lessons.lesson5_repitition;

import java.util.Scanner;

public class BreakAndContinue
{
   public static void main(String[] args)
   {
      String spaces = "there are spaces in this string";
      int numSpaces = 0;
      for(int i = 0; i < spaces.length(); ++i) {
         if (spaces.charAt(i) != ' ')
            continue;
         ++numSpaces;
      }
      System.out.println("There are " + numSpaces + " spaces.\n");
      
      Scanner input = new Scanner(System.in);
      int number = 7;
      int guess;
      while(true) {
          System.out.print("Enter your guess: ");
          guess = input.nextInt();
          if (guess == number)
             break;
      }
   }
}