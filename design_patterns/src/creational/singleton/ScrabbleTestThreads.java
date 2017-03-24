package creational.singleton;

public class ScrabbleTestThreads {
    public static void main(String[] args) {

        // Create a new Thread using the Runnable interface
        Runnable getTiles = new GetTheTiles();
        Runnable getTilesAgain = new GetTheTiles();

        // Call for the code in the run method to execute
        new Thread(getTiles).start();
        new Thread(getTilesAgain).start();
    }
}

