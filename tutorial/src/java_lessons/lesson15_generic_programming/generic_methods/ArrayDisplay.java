package java_lessons.lesson15_generic_programming.generic_methods;

/**
 * The ArrayDisplay class.
 */
public final class ArrayDisplay {

    /** Constructor. */
    private ArrayDisplay() { }

    /**
     * Display.
     * @param <T> the type parameter
     * @param array the array
     */
    private static <T> void display(final T[] array) {
        for (T element: array) {
            if (element != null) {
                System.out.print(element + " ");
            }
        }
    }

    /**
     * Unit tests for the ArrayDisplay class.
     * @param args the input arguments
     */
    public static void main(final String[] args) {
        String[] names = new String[10];
        names[0] = "David";
        names[1] = "Cynthia";
        names[2] = "Raymond";
        names[3] = "Jennifer";
        names[4] = "Bryan";
        names[5] = "Clayton";
        names[6] = "Terrill";
        names[7] = "Danny";
        display(names);
        Integer[] numbers = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println();
        display(numbers);
    }
}

