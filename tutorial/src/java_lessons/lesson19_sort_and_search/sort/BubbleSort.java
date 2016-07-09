package java_lessons.lesson19_sort_and_search.sort;

/**
 * Created by Roy on 7/3/2015.
 */
public class BubbleSort {

    private static void bubbleSort(int[] data) {
        int size = data.length;
        for (int i = 1; i < size; i++) {
            for (int j = 0; j <  size - i; j++) {
                if (data[j] > data[j+1]) {
                    int temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int size = 10;
        int[] data = new int[size];
        for (int i = 0; i < size; i++)
            data[i] = (int) (Math.random() * 100);

        System.out.println("Before sorting: ");
        for (int i = 0; i < size; i++)
            System.out.println(data[i]);

        bubbleSort(data);

        System.out.println("\nAfter sorting: ");
        for (int i = 0; i < size; i++)
            System.out.println(data[i]);
    }
}
