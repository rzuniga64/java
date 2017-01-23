package java_lessons.lesson29_stringbuilder_class;

import java.util.*;

/**
 * The type Grammar.
 */
public final class Grammar {

    /** Constructor. */
    private Grammar() { }

   /**
    * The unit tests for Grammar class.
    * @param args the input arguments
    */
   public static void main(final String[] args) {

       String[] determiners = new String[]{"A", "The", "An", "Some"};
       String[] adjectives = new String[]{"green", "ugly", "small", "huge"};
       String[] nouns = new String[]{"frog", "monster", "king", "alien"};
       String[] verbs = new String[]{"sings", "sits", "stands", "dances"};

       StringBuilder sentence = new StringBuilder();
       Random randNum = new Random();

       for (int i = 0; i < 4; ++i) {
           int rnum = randNum.nextInt(3) + 1;
            sentence.append(determiners[rnum] + " ");
            rnum = randNum.nextInt(3) + 1;
            sentence.append(adjectives[rnum] + " ");
            rnum = randNum.nextInt(3) + 1;
            sentence.append(nouns[rnum] + " ");
            rnum = randNum.nextInt(3) + 1;
            sentence.append(verbs[rnum] + " ");
            System.out.println(sentence.toString());
            sentence = new StringBuilder();
      }
   }
}