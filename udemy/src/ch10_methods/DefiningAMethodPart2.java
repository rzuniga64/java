package ch10_methods;

import java.util.Scanner;

public class DefiningAMethodPart2
{
   public static void main(String[] arts) 
   {
      Scanner input = new Scanner(System.in);
      double ctemp, ftemp;
      System.out.print("Enter a temparature in Fahrenheit: ");
      ftemp = input.nextDouble();
      ctemp = ftoc(ftemp);
      System.out.println(ftemp + " F is equal to " + ctemp + " C.");
      
      System.out.print("Enter a temparature in Celcius: ");
      ctemp = input.nextDouble();
      ftemp = ctof(ctemp);
      System.out.println(ctemp + " F is equal to " + ftemp + " C.");
   }
   
   static double ftoc(double temp) {
      double celsius;
      celsius = (temp - 32.0) * (5.0 / 9.0);
      return celsius;
   }

   static double ctof(double temp) {
      double fahrenheit;
      fahrenheit = temp * (9.0 / 5.0) + 32.0;
      return fahrenheit;
   }
}