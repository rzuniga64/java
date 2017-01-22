package java_lessons.lesson16_sequential_collections;

import java.util.TreeSet;

/**
 * Wordlist class. Takes some text and prints out the unique words using a
 * TreeSet.
 */
public final class WordList {

    /** Constructor. */
    private WordList() { }

    /**
     * Unit tests for WordList class.
     * @param args the default argument
     */
    public static void main(final String[] args) {

        final String text = "Either the well was very deep or she fell very"
                + " slowly for she had plenty of time as she went down to look"
                + " about her and to wonder what was going to happen next First"
                + " she tried to look down and make out what she was coming to"
                + " but it was too dard and to see anything when she looked at"
                + " the sides of the well and noticed that they were filled with"
                + " cupboards and book-shelves: here and there she saw maps and"
                + " pictures hung upon pegs She took down a jar from one of the"
                + " shelves as she passed it was labeled ORANGE MARMALADE but"
                + " to her great disappointment it was empty she did no like to"
                + " drop the jar for fear of killing somebody underneath so"
                + " managed to put it into one of the cupboards as she fell"
                + " past";

        String[] words = text.split(" ");

        System.out.println("Total number of words " + text.length());
        TreeSet<String> wordList = new TreeSet<>();
        for (String word : words) {
            wordList.add(word);
        }
        System.out.print("Total number of unique words " + wordList.size());
    }
}

