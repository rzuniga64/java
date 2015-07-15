package java_lessons.lesson31_regex;

// metacharacters  - shortcut for a character class: \w word \d digit \s space
// \w matches any a-z or 0-9 character
import java.util.regex.*;

public class RegEx2 {
    public static void main(String[] args) {
        String words = ("90 percent effort 100 percent of the time");
        //String patt = "\\w+";
        //String patt = "\\d+";
        String patt = "\\s";
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
