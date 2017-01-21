package java_lessons.lesson6_methods;

import java.util.Scanner;

/**
 * PredicateMethods class.
 * A predicate method returns a Boolean type and checks the condition of the
 * data passed into it.
*/
 public final class PredicateMethods {

   /** Constructor. */
   private PredicateMethods() { }

    /**
     * Is number even?
     * @param number the number
     * @return true if even; false otherwise
     */
   static boolean isEven(final int number) {

      if (number % 2 == 0) {
          return true;
      } else {
          return false;
      }
   }

    /**
     * Is character a vowel?
     * @param c the character
     * @return true if character is a vowel; false otherwise
     */
   static boolean isVowel(final char c) {

      if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
          return true;
      } else {
          return false;
      }
   }

    /**
     * Unit tests.
     * @param args the arguments.
     */
    public static void main(final String[] args) {

      /*Scanner input = new Scanner(System.in);
      int num;
      System.out.print("Enter a number: ");
      num = input.nextInt();
      if (isEven(num))
         System.out.println(num + " is even.");
      else
         System.out.println(num + " is odd.");*/

        String sentence;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        sentence = input.nextLine();
        for (int pos = 0; pos < sentence.length(); ++pos) {
            if (isVowel(sentence.charAt(pos))) {
                System.out.print(sentence.charAt(pos));
            }
        }
    }
}
