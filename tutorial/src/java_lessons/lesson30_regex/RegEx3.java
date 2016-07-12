package java_lessons.lesson30_regex;

import java.util.regex.*;

/**
 * The type RegEx3.
 */
public class RegEx3 {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        String names = ("Mike McMillian Terri McMillen Allison McMillin ");
        String patt = "McM.*? ";

        Pattern pattern = Pattern.compile(patt);
        Matcher match = pattern.matcher(names);

        System.out.println(names);
        names = match.replaceAll("McMillan ");
        System.out.println(names);
    }
}

