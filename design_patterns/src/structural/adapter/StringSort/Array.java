package structural.adapter.StringSort;

import java.util.Comparator;

/**
 *  Array.
 *  Existing Client.
 */
public final class Array {

    /** Constructor. */
    private Array() { }

    /**
     * sort method.
     * @param a Object
     * @param c Object
     */
    static void sort(final Object[] a, final Comparator c) {

        for (int i = 0; i < a.length - 1; i++) {
            if (c.compare(a[i], a[i + 1]) == 1) {
                Object temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
            }
        }
    }
}
