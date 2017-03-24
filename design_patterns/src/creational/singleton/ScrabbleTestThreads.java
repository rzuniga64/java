package creational.singleton;

/**
 *  Client to test Scrabble class.
 */
public final class ScrabbleTestThreads {

    /** Default constructor. */
    private ScrabbleTestThreads() { }
    /**
     * Unit tests for Scrabble class.
     * @param args argumetns
     */
    public static void main(final String[] args) {

        // Create a new Thread using the Runnable interface
        Runnable getTiles = new GetTheTiles();
        Runnable getTilesAgain = new GetTheTiles();

        // Call for the code in the run method to execute
        new Thread(getTiles).start();
        new Thread(getTilesAgain).start();
    }
}

