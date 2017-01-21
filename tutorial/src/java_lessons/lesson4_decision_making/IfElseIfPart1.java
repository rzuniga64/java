package java_lessons.lesson4_decision_making;

import java.util.Scanner;

/**
 *  IfElseIfPart1 class.
 *
 *  if (relational expression) {
 *      statements;
 *  } else if (relational expression) {
 *      statements;
 *  } else if (relational expression) {
 *      statements;
 *  } else {
 *      statements;
 *  }
*/
public final class IfElseIfPart1 {
    /** Constructor. */
    private IfElseIfPart1() { }

    /**
     * Unit tests.
     * @param args the arguments.
     */
    public static void main(final String[] args) {
      int grade;
      String letterGrade = "";
      Scanner input = new Scanner(System.in);
      System.out.print("Enter a grade: ");
      grade = input.nextInt();
      if (grade >= 90) {
         letterGrade = "A";
      } else if (grade >= 80) {
         letterGrade = "B";
      } else if (grade >= 70) {
         letterGrade = "C";
      } else if (grade >= 60) {
         letterGrade = "D";
      } else if (grade >= 0) {
         letterGrade = "F";
      } else {
          System.out.println("Didn't recognize input.");
      }
      System.out.println("A grade of " + grade + " is a " + letterGrade + ".");
   }
}
