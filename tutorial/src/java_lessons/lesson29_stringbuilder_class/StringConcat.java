package java_lessons.lesson29_stringbuilder_class;

import java.io.*;
/**
 *  The type String concat.
 *
 *  The StringBuilder class is provided as a way to perform string operations in a more efficient manner when working
 *  with long strings or many string operations at once. For example, a lot of strong concatenations that have to be
 *  performed one after another. In those situations the StringBuilder class is more efficient than the String class
 *  because with a String variable every time you make a change to it you are making a copy into a new variable.
 *  In Java Strings are immutable whereas with the StringBuilder class you build one object and think of it like an
 *  array. Every time you append or concatenate new strings onto the current string you are modifying the contents
 *  of an array rather than creating a new copy of a variable.
 */
public class StringConcat {
    /**
     * The entry point of application. Build a comma delimited string out of animal names.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        BufferedReader input;
        String word, words;
        word = words = "";
        String file = "tutorial\\src\\java_lessons\\lesson29_stringbuilder_class\\animals.txt";
        long startTime, stopTime, duration;
        startTime = stopTime = duration = 0;

        try{
            input = new BufferedReader(new FileReader(file));
            startTime = System.nanoTime();
            while ((word = input.readLine()) != null)
                words = words + word + ",";
            stopTime = System.nanoTime();
            duration = stopTime - startTime;
        } catch (IOException e) {
            System.out.println(e.toString());
        }

        System.out.println("Time to concatenate using String: " + duration);

        startTime = stopTime = duration = 0;
        StringBuilder sbWords = new StringBuilder();

        try{
            input = new BufferedReader(new FileReader(file));
            startTime = System.nanoTime();
            while ((word = input.readLine()) != null)
                sbWords.append(word + ",");
            stopTime = System.nanoTime();
            duration = stopTime - startTime;
        } catch (IOException e) {
            System.out.println(e.toString());
        }

        System.out.println("Time to concatenate using StringBuilder: " + duration);
    }
}
