package java_lessons.lesson12_arrays;

import java.util.Random;

/**
 * ShuffleDeckOfCards class.
 */
public final class ShuffleDeckOfCards {

    /** Constructor. */
    private ShuffleDeckOfCards() { }

    /**
     * Initialize a deck of cards.
     * @param arr the array representing the deck.
     */
    private static void initDeck(final int[][] arr) {

        for (int r = 0; r < 4; ++r) {
            for (int c = 0; c < 13; ++c) {
                arr[r][c] = 0;
            }
        }
    }

    /**
     * Display the deck of cards.
     * @param arr the array representing the deck of cards.
     */
    private static void displayDeck(final int[][] arr) {

        for (int r = 0; r < 4; ++r) {
            for (int c = 0; c < 13; ++c) {
                System.out.print(arr[r][c] + " ");
            }
            //System.out.println();
        }
    }

    /**
     * Shuffle the deck of cards.
     * @param arr the array representing the deck of cards.
     */
   private static void shuffleDeck(final int[][] arr) {

      int row, col;
      Random rand = new Random(System.currentTimeMillis());

      for (int card = 1; card <= 52; ++card) {
         row = rand.nextInt(4);
         col = rand.nextInt(13);

         if (arr[row][col] == 0) {
             arr[row][col] = card;
         } else {
             while (arr[row][col] != 0) {
                 row = rand.nextInt(4);
                 col = rand.nextInt(13);
            }
            arr[row][col] = card;
         }
      }
   }

    /**
     * Unit tests.
     * @param args the arguments
     */
    public static void main(final String[] args) {

        final int rows = 4;
        final int cols = 13;
        int[][] deck = new int[rows][cols];
        initDeck(deck);
        shuffleDeck(deck);
        displayDeck(deck);
    }
}