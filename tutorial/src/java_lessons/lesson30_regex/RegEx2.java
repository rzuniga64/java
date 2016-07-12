package java_lessons.lesson30_regex;

import java.util.regex.*;

/**
 *  The type RegEx2.
 *
 *  meta characters  - shortcut for a character class:
 *  \w word any a-z or 0-9 character
 *  \d digit
 *  \s space
 */
public class RegEx2 {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        String words = ("90 percent effort 100 percent of the time");
        //String patt = "\\w+"; // words
        //String patt = "\\d+"; // digits
        String patt = "\\s";    // spaces

        Pattern pattern = Pattern.compile(patt);
        Matcher match = pattern.matcher(words);
        System.out.println(words);

        if (!patt.equals("\\s")) {
            while (match.find()) {
                System.out.println("Found " + patt + " at: " + match.start());
                System.out.println("Match: " + match.group());
            }
        }

        int count = 0;
        while (match.find())
            count++;
        System.out.println("Total spaces = " + count);
    }
}
