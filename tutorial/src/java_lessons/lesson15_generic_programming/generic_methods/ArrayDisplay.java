package java_lessons.lesson15_generic_programming.generic_methods;

/**
 * The type Array display.
 */
public class ArrayDisplay {

    /**
     * Display.
     *
     * @param <T> the type parameter
     * @param array the array
     */
    private static <T> void Display(T[] array) {
        for (T element: array) {
            if (element != null)
                System.out.print(element + " ");
        }
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        String[] names = new String[10];
        names[0] = "David";
        names[1] = "Cynthia";
        names[2] = "Raymond";
        names[3] = "Jennifer";
        names[4] = "Bryan";
        names[5] = "Clayton";
        names[6] = "Terrill";
        names[7] = "Danny";
        Display(names);
        Integer[] numbers = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        System.out.println();
        Display(numbers);
    }
}
