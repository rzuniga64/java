package java_lessons.lesson19_sort_and_search.sort;

/**
 * The type Insertion sort.
 */
public class InsertionSort {

    /**
     *  This method performs an Insertion sort.
     *
     *  @param data the data to sort.
     *
     *  The Insertion sort.SelectionSort is normally the best of the elementary sorts.
     *  Unlike the other sorts that had a group sorted at any given time, groups are only partially sorted here.
     *
     *  Runtime analysis
     *  Best    Average     Worst
     *  O(n)    O(n*n)      O(n*n)
     *
     * Insertion sort is a simple sorting algorithm that is appropriate for small inputs
     * The basic action of insertion sort is to sort the elements in positions 0 through p (where p ranges from 1 through
     * N-1). In each behavorial.state p increases by 1. That is what the outer loop is controlling.
     *
     * When the body of the for loop is entered we are guaranteed that the elements in array positions 0 through p-1 have
     * already been sorted and that we need to extend this to positions 0 to p.
     *
     * At each step the underlined element needs to be added to the previously sorted part of the array. We can easily
     * do that by placing it in a temporary variable and sliding all the elements that ARE LARGER THAN IT on position
     * to the right. We then copy the temporary variable into the former position of the leftmost relocated
     * element. We keep a counter j, which is the position in which the temporary variable should be written back.
     * Every time an element is slid, j decreases by 1.
     *
     * Array Position           0   1   2   3   4   5
     * ----------------------------------------------
     * Initial behavorial.state            8|  5   9   2   6   3   temp = 5
     *                              -
     * After a[0..1] is sorted  5   8|  9   2   6   3   temp = 9
     *                                  -
     * After a[0..2] is sorted  5   8   9|  2   6   3   temp = 2
     *                                      -
     * After a[0..3] is sorted  2   5   8   9|  6   3   temp = 6
     *                                          -
     * After a[0..4] is sorted  2   5   6   8   9|  3   temp = 3
     *                                              -
     * After a[0..5] is sorted  2   3   5   6   8   9|
     **/
    static void insertionSort(int[] data) {

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

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
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
