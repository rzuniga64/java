package java_lessons.lesson4_decision_making;

import java.util.Scanner;

/**
 *  IfElse class.
 *  if (relational expression)
 *      set of statements;
 *  else
 *      set of statements;
*/
public final class IfElse {

   /** Constructr. */
   private IfElse() { }

   /**
    * Unit tests.
    * @param args the arguments.
    */
   public static void main(final String[] args) {

       final double rate = 25.00;
       int hoursWorked;
       double grossPay;

      Scanner input = new Scanner(System.in);
      System.out.print("Enter hours worked: ");
      hoursWorked = input.nextInt();

      if (hoursWorked > 40) {
         grossPay = (40 * rate) + ((hoursWorked - 40) * (rate * 1.5));
      } else {
         grossPay = hoursWorked * rate;
      }
      System.out.println("The gross pay is " + grossPay);
   }
}
