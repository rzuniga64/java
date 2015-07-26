package singleton;

// /What is a Singleton Patter?
//  -   it is used when you want to eliminate the option of instantiating more than one object.
//. -   A demonstration will be used that holds all the Potential Scrabble letters and spits out new ones upon request.
//  -   Each player will share the same potential letter list.
//  -   Each player has their own set of letters.

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Singleton {

    // firstInstance will hold the one and only instance of the class Singleton.
    // It is static because because objects like this usually need to be available
    // on a global basis.
    private static Singleton firstInstance = null;

    String[] scrabbleLetters = {"a", "a", "a", "a", "a", "a", "a", "a", "a",
                            "b", "b", "c", "c", "d", "d", "d", "d", "e", "e", "e", "e", "e",
                            "e", "e", "e", "e", "e", "e", "e", "f", "f", "g", "g", "g", "h",
                            "h", "i", "i", "i", "i", "i", "i", "i", "i", "i", "j", "k", "l",
                            "l", "l", "l", "m", "m", "n", "n", "n", "n", "n", "n", "o", "o",
                            "o", "o", "o", "o", "o", "o", "p", "p", "q", "r", "r", "r", "r",
                            "r", "r", "s", "s", "s", "s", "t", "t", "t", "t", "t", "t", "u",
                            "u", "u", "u", "v", "v", "w", "w", "x", "y", "y", "z",};

    // put arrays of strings into a linked list
    private LinkedList<String> letterList = new LinkedList<>(Arrays.asList(scrabbleLetters));

    // used to slow down firstThread
    static boolean firstThread = true;

    // Created to keep users from instantiation
    // Only Singleton will be able to instantiate this class
    private Singleton(){ }

    /** We could make getFirstInstance a synchronized method to force every thread to
     *  wait its turn.  That way only one thread can access a method at a time.
     *  This can really slow everything down though.
     *
     * @return firstInstance
     */
    public static Singleton getInstance() {

        if (firstInstance == null) {
            // This is here to test what happens if threads try to create instances of this class
            if (firstThread) {
                try {
                    // slow down the current thread to allow another thread the opportunity to cause havoc.
                    Thread.currentThread();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // This makes this a synchronized method until the first object is created.
            // There after it will not be considered to be a synchronized class.
            synchronized(Singleton.class) {
                if (firstInstance == null) {
                    firstInstance = new Singleton();    // Lazy instantiation: if the instance it isn't created
                    Collections.shuffle(firstInstance.letterList); // Shuffle the letters in the list
                }
            }
        }
        return firstInstance;
    }

    /**
     * @function getLetterList
     * @return a list of Scrabble letters
     */
    public LinkedList<String> getLetterList() {
        return letterList;
    }

    /**
     * @function getTiles
     * @param howManyTiles the number of letter tiles requested
     * @return Return the number of letter tiles requested
     */
    public LinkedList<String> getTiles(int howManyTiles) {
        LinkedList<String> tilesToSend = new LinkedList<>();    // Tiles to be returned to the user

        // Cycle through the linked list, letterList, while adding
        // the starting Strings to the returned linked list while
        // deleting them from letterList.
        for (int i = 0; i < howManyTiles; i++)
            tilesToSend.add(firstInstance.letterList.remove(0));

        return tilesToSend;
    }
}
