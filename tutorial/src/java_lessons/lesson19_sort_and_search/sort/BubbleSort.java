package java_lessons.lesson19_sort_and_search.sort;


/**
 * The type Bubble sort.
 */
public class BubbleSort {

    /**
     *  This method performs a Bubble sort.
     *
     *  @param data the data to sort.
     *
     *	On each pass: Compare first two elements. If the first is bigger, they exchange places (swap). Compare second and
     *	third elements. If second is bigger, exchange them. Repeat until last two elements of  the list  are compared.
     *	Repeat this pr. ocess until a pass completes with no exchangesAt the end of the first pass, the largest element is
     *	moved to the end (it is bigger than all its neighbors)
     *
     *	At the end of the second pass, the second largest element is moved to just before the last element. The back end
     *   (tail) of the list remains sorted. Each pass increases the size of the sorted portion. No exchanges implies each
     *   element is smaller than its next neighbor (so the list is sorted).
     *
     *   If you change the algorithm to look at only the unsorted part of the array in each pass, it is exactly like the
     *	selection sort
     *
     *   Runtime analysis
     *   Best    Average     Worst
     *   O(n)    O(n*n)      O(n*n)
     *
     *	7 2 3 8 9 1     7 > 2, swap
     *   - -
     *	2 7 3 8 9 1     7 > 3, swap
     *     - -
     *	2 3 7 8 9 1     !(7 > 8), no swap
     *       - -
     *	2 3 7 8 9 1     !(8 > 9), no swap
     *		  - -
     *	2 3 7 8 9 1     9 > 1, swap
     *           - -
     *	2 3 7 8 1 9     finished pass 1, did 3 swaps
     *
     *	2 3 7 8 1 9     2<3<7<8, no swap, !(8<1), swap
     *         - -
     *	2 3 7 1 8 9     (8<9) no swap finished pass 2, did one swap
     *
     *	2 3 7 1 8 9     2<3<7, no swap, !(7<1), swap
     *       - -
     *	2 3 1 7 8 9     7<8<9, no swap finished pass 3, did one swap
     *	2 3 1 7 8 9     2<3, !(3<1) swap, 3<7<8<9
     *     - -
     *	2 1 3 7 8 9     finished pass 4, did one swap
     *	2 1 3 7 8 9     !(2<1) swap, 2<3<7<8<9
     *   - -
     *	1 2 3 7 8 9     finished pass 5, did one swap
     *   1 2 3 7 8 9	    1<2<3<7<8<9, no swaps finished pass 6, no swaps, list is sorted!
     */
    static void bubbleSort(int[] data) {

        int size = data.length;

        // i starts at the end of the array. As it is decremented all indexes greater then it are sorted
        // The inner loop starts at the beginning of the array and compares each value next to each other.
        // If the value is greater then they are swapped.
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

        bubbleSort(data);

        System.out.println("\nAfter sorting: ");
        for (int i = 0; i < size; i++)
            System.out.println(data[i]);
    }
}
