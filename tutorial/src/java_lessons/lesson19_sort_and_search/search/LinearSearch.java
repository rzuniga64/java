package java_lessons.lesson19_sort_and_search.search;

public class LinearSearch {

    static int linearSearch(int[] arr, int key) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == key)
                return i;
        }
        return -1;
    }

    private static int min(int[] arr) {
        int minimum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minimum)
                minimum = arr[i];
        }
        return minimum;
    }

    public static void main(String[] args) {
        int[] data = new int[]{5, 10, 1, 9, 4, 8, 3, 6, 2, 7};
        int minimum = min(data);
        System.out.println("The minimum value is: " + minimum);
    }
}
