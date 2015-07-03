package advanced_java.ch4_associative_collections;

import java.util.TreeMap;
import java.util.*;

public class WordCount {
    public static void main(String[] args) {
        String text;
        text = "Either the well was very deep or she fell very slowly "
                + "for she had plenty of time as she went down to look about "
                + "her, and to wonder what was going to happen next First "
                + "she tried to look down and make out what she was coming to "
                + "but it was too dark to see anything then she looked at the "
                + "sides of the well and noticed that they were filled with "
                + "cupboards and book-shelves: here and there she saw maps and "
                + "pictures hung upon pegs She took down a jar from one of the "
                + "shelves as she passed it was labeled ORANGE MARMALADE but "
                + "to her great disappointment it was empty she did not like to "
                + "drop the jar for fear of killing somebody underneath so "
                + "managed to put it into one of the cupboards as she fell past";
        // store each word in an array
        String[] words = text.split(" ");
        // sort the array in alphabetical order
        Arrays.sort(words);
        int count = 0;
        for (String word : words)
            System.out.println("Word: " + word);
        TreeMap<String, Integer> wordMap = new TreeMap<>();

        for(String word : words) {
            // if the word has previously been found,
            // increment the value by one
            if (wordMap.containsKey(word))
                wordMap.put(word, wordMap.get(word) + 1);
            // if first time finding the word create
            // a new entry in the map
            else
                wordMap.put(word, 1);
        }

        for (String key : wordMap.keySet())
            System.out.println(key + ": " + wordMap.get(key));
    }
}