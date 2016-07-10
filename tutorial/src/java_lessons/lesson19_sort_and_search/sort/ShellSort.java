package java_lessons.lesson19_sort_and_search.sort;

/**
 * The type Shell sort.
 */
public class ShellSort {

    /**
     *  Shell sort is a sub quadratic algorithm whose code is only slightly longer than the insertion sort, making it the
     *  simplest of the faster algorithms. It compares elements that are far apart and then by comparing elements that are
     *  less far apart, and so on, gradually shrinking toward the basic insertion sort.  Shell sort is known as a
     *  diminishing gap sort. When gap is 1 the loop is identical to an insertion sort.
     *
     *  The running time of Shell sort depends heavily on the choice of increment sequences.  A sequence which performs well
     *  in practice but has no theoretical basis, is to have a starting gap of N/2.2. This divisor appears to bring the
     *  average running time to below O(pow(N, 5/4)).  For 100, 000, to 1,000,000 items, it typically improves performance
     *  by about to 25 to 35 percent over Shell's Increments, although nobody knows why.  The performance of Shell sort is
     *  quite acceptable in practice, even for N in the tens of thousands. The simplicity of the code makes it the algorithm
     *  of choice for sorting up to moderately large input.  it is also a fine example of a very simple algorithm with an
     *  extremely complex analysis.
     *
     *  Runtime analysis
     *  Best        Average         Worst
     *  O(n log n)  depends on gap  O(n log n * log n)
     *
     *  Original        81  94  11  96  12  35  17  95  28  58  41  75  15
     *  After 5-sort    35  17  11  28  12  41  75  15  96  58  81  94  95
     *                  --                  --                  --
     *  After 3-sort    28  12  11  35  15  41  58  17  94  75  81  96  95
     *                  --          --          --          --          --
     *  After 1-sort    11  12  15  17  28  35  41  58  75  81  94  95  96
     */
    static void shellsort(int[] theArray) {
        int arraySize = theArray.length;
        int temp;
        int j;

        // Keep looping until the interval is 1. Then this becomes an insertion sort
        for (int gap = arraySize/2; gap > 0; gap = (gap == 2) ? 1 : (new Double(gap/2.2)).intValue()) {
            for (int i = gap; i < arraySize; i++) {
                temp = theArray[i];

                // While there is a number bigger than temp move it further up in the array
                for (j = i; j >= gap && temp < theArray[j - gap]; j -= gap)
                    theArray[j] = theArray[j - gap];
                theArray[j] = temp;
            }
        }
    }

    /**
     * Display.
     *
     * @param arr the arr
     */
    public static void display(int[] arr) {
        for (int num : arr) {
            System.out.println(num);
        }
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int[] data = new int[] {5,10,1,9,4,8,3,6,2,7};
        System.out.println("Unsorted array: ");
        display(data);
        System.out.println();
        shellsort(data);
        System.out.println();
        System.out.println("Sorted array: ");
        display(data);
    }
}
