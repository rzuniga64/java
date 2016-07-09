package java_lessons.lesson30_regex;

import java.util.regex.*;

public class RegEx1 {
    public static void main(String[] args) {
        String words = "now is the time or now is not the time";
        String patt = "now";
        Pattern pattern = Pattern.compile(patt);
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
