package java_lessons.lesson3_io;

import java.util.Scanner;

/**
 * Scanner2 class.
 */
public final class Scanner2 {

   /**
    *  Scanner 1 class.
    *  Console represented by System.out.
    *  Keyboard represented by System.in.
    */

   /** Constructor. */
   private Scanner2() { }

   /**
    * Unit tests.
    * @param args the arguments.
    */
   public static void main(final String[] args) {
      String name;
      Scanner input = new Scanner(System.in);
      System.out.print("Enter your name: ");
      name = input.nextLine();
      System.out.println("Your name is " + name);
   }
}
