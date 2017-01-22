package java_lessons.lesson17_associative_collections;

import java.util.TreeMap;
import java.util.*;

/**
 * WordCount class.
 */
public final class WordCount {

    /** Constructor. */
    private WordCount() { }

    /**
     * Unit tests for WordCount class.
     * @param args the input arguments
     */
    public static void main(final String[] args) {
        String text;
        int count = 0;
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

        String[] words = text.split(" ");
        // sort the array in alphabetical order
        Arrays.sort(words);

        TreeMap<String, Integer> wordMap = new TreeMap<>();

        for (String word : words) {
            // if the word has previously been found, increment the value by one
            if (wordMap.containsKey(word)) {
                wordMap.put(word, wordMap.get(word) + 1);
            } else { // if first time finding word create a new entry in map
                wordMap.put(word, 1);
            }
        }

        for (String key : wordMap.keySet())
            System.out.println(key + ": " + wordMap.get(key));
    }
}
