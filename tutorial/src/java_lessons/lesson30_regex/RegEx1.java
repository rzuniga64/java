package java_lessons.lesson30_regex;

import java.util.regex.*;

/**
 *  The type RegEx1.
 *
 *  Regular Expressions are strings of characters that represent a character sequence.
 *  We call that character sequence with a regex a character class - [Java]
 *  For example if the word that is looked for is the word 'Java'in a text then the word 'Java' would be the character
 *  class. The character class would specify the pattern we are looking for.
 *
 *  . (dot) wildcard character matches any character
 *  Quantifiers specify matches that can be made.
 *  + match one or more of the character class   Example: Ja+ match one or more character sequences of 'Ja'
 *  * match zero or more  Example: ie* match zero or more character sequences of 'ie'
 *  ? match zero or more  Example: J?? match any two characters after 'J'
 */
public class RegEx1 {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        String words = "now is the time or now is not the time";
        String patt = "now";
        Pattern pattern = Pattern.compile(patt); // put pattern in form regular expression engine can use
        // gets the pattern and combines it with our string to create a set of matches.
        Matcher match = pattern.matcher(words);
        System.out.println(words);

        /**
         * find will go through the string starting with the first character and look for matches of our pattern
         * in the string and every time it finds it its going to mark the index location of where it found the match.
         */
        while (match.find()) {
            System.out.println("Found " + patt + " at: " + match.start());

            // group returns the sequence of characters that the regex matched.
            System.out.println("Match: " + match.group());
        }
    }
}
