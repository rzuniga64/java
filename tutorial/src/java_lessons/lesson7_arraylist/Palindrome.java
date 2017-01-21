package java_lessons.lesson7_arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Palindrome class.
 */
public final class Palindrome {

   /**
    * Constructor.
    */
   private Palindrome() { }

   /**
    * Display the array.
    * @param arr the array
    */
   static void display(final ArrayList arr) {

      for (Object item: arr) {
          System.out.print(item + " ");
      }
      System.out.println();
   }

    /**
     * BuildAL method.
     * @param pword the pword
     * @param word the word
     */
   private static void buildAL(final ArrayList<String> pword,
                               final String word) {

       for (int i = 0; i < word.length(); ++i) {
           pword.add(word.charAt(i) + "");
       }
   }

    /**
     * Is the word a palindrome?
     * @param word the word
     * @return true if word is palindrome; false otherwise
     */
   private static boolean isPalindrome(final ArrayList<String> word) {

      ArrayList<String> rword = new ArrayList<>();
      rword.addAll(word);
      Collections.reverse(rword);
      for (int i = 0; i < word.size(); ++i) {
          if (!(rword.get(i).equals(word.get(i)))) {
              return false;
          }
      }
      return true;
   }

   /**
    * Unit tests.
    * @param args the arguments.
    */
   public static void main(final String[] args) {

      String palindrome;
      System.out.print("Enter a word to test: ");
      Scanner input = new Scanner(System.in);
      palindrome = input.nextLine();

      ArrayList<String> p = new ArrayList<>();
      buildAL(p, palindrome);
      if (isPalindrome(p)) {
          System.out.println(palindrome + " is a palindrome.");
      } else {
          System.out.println(palindrome + " is not a palindrome.");
      }
   }
}