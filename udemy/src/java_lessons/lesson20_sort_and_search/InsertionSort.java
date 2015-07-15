package java_lessons.lesson20_sort_and_search;


public class InsertionSort {

    public static void insertionSort(int [] data) {
        int size = data.length;

        for (int i = 0; i < size; i++) {
            for (int j = i; j > 0; --j) {
                if (data[j-1] > data[j]) {
                    int temp = data[j];
                    data[j] = data[j-1];
                    data[j-1] = temp;
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

        insertionSort(data);

        System.out.println("\nAfter sorting: ");
        for (int i = 0; i < size; i++)
            System.out.println(data[i]);

    }
}
