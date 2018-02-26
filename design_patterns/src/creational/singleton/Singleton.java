package creational.singleton;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 *  What is a Singleton Pattern?
 *  -   It is used when you want to eliminate the option of instantiating more than one object.
 *  -   A demonstration will be used that holds all the Potential Scrabble letters and spits out new ones upon request.
 *  -   Each player will share the same potential letter list.
 *  -   Each player has their own set of letters.
 */
public final class Singleton {

    /**
     *  firstInstance will hold the one and only instance of the class Singleton. It is static because objects like this
     *  usually need to be available on a global basis.
     */
    private static Singleton firstInstance = null;

    private String[] scrabbleLetters
            = { "a", "a", "a", "a", "a", "a", "a", "a", "a",
                "b", "b", "c", "c", "d", "d", "d", "d", "e", "e", "e", "e", "e",
                "e", "e", "e", "e", "e", "e", "e", "f", "f", "g", "g", "g", "h",
                "h", "i", "i", "i", "i", "i", "i", "i", "i", "i", "j", "k", "l",
                "l", "l", "l", "m", "m", "n", "n", "n", "n", "n", "n", "o", "o",
                "o", "o", "o", "o", "o", "o", "p", "p", "q", "r", "r", "r", "r",
                "r", "r", "s", "s", "s", "s", "t", "t", "t", "t", "t", "t", "u",
                "u", "u", "u", "v", "v", "w", "w", "x", "y", "y", "z" };

    /** put arrays of strings into a linked list. */
    private LinkedList<String> letterList = new LinkedList<>(Arrays.asList(scrabbleLetters));

    /** used to slow down firstThread. */
    private static boolean firstThread = true;

    /**
     *  The constructor is private because we want only instance of the class Singleton. If a user tries to create a new
     *  one it will generate an error.
     */
     private Singleton() { }

    /**
     *  getInstance() is almost universally used a method for the Singleton pattern. We only create a Singleton object
     *  if one doesn't exist already. We could make getFirstInstance a synchronized method to force every thread to wait
     *  its turn. That way only one thread can access a method at a time. This can really slow everything down though.
     *
     * @return firstInstance
     */
    static Singleton getInstance() {

        if (firstInstance == null) {
            // This is here to test what happens if threads try to create instances of this class
            if (firstThread) {

                firstThread = false;

                try {
                    // slow down the current thread to allow another thread the opportunity to cause havoc.
                    Thread.currentThread();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            /**
             *  FIX THE ISSUE WITH MULTIPLE THREADS CREATING MORE THAN ONE OBJECT USING SYNCHRONIZED KEYWORD!
             *  This makes this a synchronized method until the first object is created. Thereafter it will not be
             *  considered a synchronized class.
             */
            synchronized (Singleton.class) {
                // Lazy instantiation: if the instance isn't needed it isn't created
                if (firstInstance == null) {
                    firstInstance = new Singleton();
                    // Shuffle the letters in the list
                    Collections.shuffle(firstInstance.letterList);
                }
            }
        }
        return firstInstance;
    }

    /**
     * @function getLetterList
     * @return a list of Scrabble letters
     */
    LinkedList<String> getLetterList() {

        return firstInstance.letterList;
    }

    /**
     * @function getTiles
     * @param howManyTiles the number of letter tiles requested
     * @return Return the number of letter tiles requested
     */
    LinkedList<String> getTiles(final int howManyTiles) {

        // Tiles to be returned to the user
        LinkedList<String> tilesToSend = new LinkedList<>();

        // Cycle through the linked list, letterList, while adding the starting Strings to the returned linked list
        // while deleting them from letterList.
        for (int i = 0; i < howManyTiles; i++) {

            tilesToSend.add(firstInstance.letterList.remove(0));
        }
        return tilesToSend;
    }
}