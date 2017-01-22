package java_lessons.lesson13_flow_control;

import java.util.Scanner;

/**
 *  SwitchStatementClass.
 *  An integral type is a int, char, or short data type.
 *
 *  switch(integral expression) {
 *  case (expression):
 *     set of statements;
 *     break;
 *  case (expression):
 *     set of statements;
 *     break;
 *  default:
 *     set of statements;
 *  }
 */
public final class SwitchStatement {

    /** Constructor.. */
    private SwitchStatement() { }

    /**
     * Unit tests.
     * @param args the arguments.
     */
   public static void main(final String[] args) {

      char letter;
      String letterGrade;

      Scanner input = new Scanner(System.in);
      System.out.print("Enter a letter grade: ");
      letterGrade = input.nextLine();
      letter = letterGrade.charAt(0);

      switch (letter) {
         case 'A':
            System.out.println("90-100");
            break;
         case 'B':
            System.out.println("80-89");
            break;
         case 'C':
            System.out.println("70-79");
            break;
         case 'D':
            System.out.println("60-69");
            break;
         default:
            System.out.println("Below 60");
      }
   }
}
