package advanced_java.ch16_stringbuilder_class;

import java.io.*;
import java.util.*;

public class StringConcat {
    public static void main(String[] args) {
        BufferedReader input;
        String word, words;
        word = words = "";
        String file = "C:\\Users\\Roy\\git\\java\\udemy\\src\\advanced_java\\ch16_stringbuilder_class\\animals.txt";
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
