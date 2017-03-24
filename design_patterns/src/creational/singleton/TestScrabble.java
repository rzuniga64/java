package creational.singleton;

import java.util.LinkedList;

public class TestScrabble {
    public static void main(String[] args) {
        // create a new instance of Singleton
        Singleton instanceOne = Singleton.getInstance();

        // Get unique id for instance object
        System.out.println("Instance 1 ID: " + System.identityHashCode(instanceOne));
        // Get all of the letters stored in the list
        System.out.println(instanceOne.getLetterList());

        LinkedList<String> playerOneTiles = instanceOne.getTiles(7);
        System.out.println("\nPlayer 1: " + playerOneTiles + "\n");
        System.out.println(instanceOne.getLetterList());

        // Try to make another instance of Singleton
        // This doesn't work because the constructor is private
        // Singleton instanceTwo = new Singleton();
        Singleton instanceTwo = Singleton.getInstance();

        // Get unique id for instance object
        System.out.println("\nInstance 2 ID: " + System.identityHashCode(instanceOne));

        // THIS RETURNS THE VALUE OF THE FIRST INSTANCE CREATED. WRONG!
        System.out.println(instanceOne.getLetterList());

        // Player 2 draws 7 tiles
        LinkedList<String> playerTwoTiles = instanceOne.getTiles(7);
        System.out.println("\nPlayer 2: " + playerTwoTiles);
    }
}
