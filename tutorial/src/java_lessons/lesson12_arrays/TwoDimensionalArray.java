package java_lessons.lesson12_arrays;

import com.sun.java.accessibility.util.TopLevelWindowListener;

import java.util.Random;

/**
 *  TwoDimensionalArray class.
 */
public final class TwoDimensionalArray {

    /** Constructor. */
    private TwoDimensionalArray() { }

    /**
     * Unit tests.
     * @param args the arguments.
     */
    public static void main(final String[] args) {

        int[][] nums = {{10,20,30,40}, {20,30,40,50}, {30,40,50,60}};

        final int rows1 = 5;
        final int cols1 = 5;
        Random rand = new Random(System.currentTimeMillis());
        int[][] numbers = new int[rows1][cols1];

        for (int r = 0; r < rows1; ++r) {
            for (int c = 0; c < cols1; ++c) {
                numbers[r][c] = rand.nextInt(101);
            }
        }

        final int rows = 3;
        final int cols = 5;
        int total = 0;
        double average = 0;
        int min = 50;
        int max = 100;

        int[][] grades = new int[rows][cols];

        for (int r = 0; r < rows; ++r) {
            for (int c = 0; c < cols; ++c) {
                grades[r][c] = rand.nextInt(max - min + 1) + min;
            }
        }

        for (int r = 0; r < rows; ++r) {
            System.out.print("Student " + (r + 1) + ": ");
            for (int c = 0; c < cols; ++c) {
                System.out.print(grades[r][c] + " ");
            }
            System.out.println();
        }

        for (int r = 0; r < rows; ++r) {
            for (int c = 0; c < cols; ++c) {
                total += grades[r][c];
            }
            average = total / cols;
            System.out.println("The average for student " + (r + 1) + " is: "
                    + average);
            total = 0;
            average = 0.0;
        }
    }
}