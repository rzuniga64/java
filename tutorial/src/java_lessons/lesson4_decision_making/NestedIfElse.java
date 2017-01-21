package java_lessons.lesson4_decision_making;

import java.util.Scanner;

/**
 *  IfElse class.
 *  if (rel expression)
 *    if (rel expression)
 *       if (rel exp)
 *          set of statements;
 *       else
 *          set of statements;
 */
public final class NestedIfElse {

   /** Constructor. */
   private NestedIfElse() { }

   /**
    * Unit tests.
    * @param args the arguments.
    */
   public static void main(final String[] args) {

        int grade;
        String letterGrade;
        System.out.print("Enter a grade: ");
        Scanner input = new Scanner(System.in);

        grade = input.nextInt();

        if (grade >= 90) {
            if (grade >= 95) {
                letterGrade = "A+";
            }
            if (grade >= 93) {
                letterGrade = "A";
            } else {
                letterGrade = "A-";
            }
            System.out.println("Your letter grade is " + letterGrade);
        } else {
            System.out.println("Sorry, you didn't make an A.");
        }
   }
}
