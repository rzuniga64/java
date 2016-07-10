package java_lessons.lesson19_sort_and_search.search;

/**
 * The type Linear search.
 */
public class LinearSearch {

    /**
     *  This method performs a Linear search. A Linear search can work on unsorted data.
     *
     *  @param arr the arr
     *  @param key the key
     *  @return the int
     *
     *  A  linear search starts at the first element of a data collection and searches element by element for a
     *  particular item.
     *
     *  Runtime analysis
     *  Best    Average     Worst
     *  O(1)    O(n)      O(n)
     */
    static int linearSearch(int[] arr, int key) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == key)
                return i;
        }
        return -1;
    }

    /**
     * This method performs a Linear search to find the minimum value of a data list.
     *
     * @param arr the arr
     * @return the int
     */
    private static int min(int[] arr) {
        int minimum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minimum)
                minimum = arr[i];
        }
        return minimum;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int[] data = new int[]{5, 10, 1, 9, 4, 8, 3, 6, 2, 7};
        int minimum = min(data);
        System.out.println("The minimum value is: " + minimum);
    }
}
