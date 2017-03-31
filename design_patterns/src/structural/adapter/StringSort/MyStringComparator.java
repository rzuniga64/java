package structural.adapter.StringSort;

import java.util.Comparator;

/**
 * MyStringComparator class.
 * The new Adapter class.
 */
public class MyStringComparator implements Comparator {

    /**
     * Compare to objects.
     * @param o1 object 1
     * @param o2 object 2
     * @return 1 if o1 > o2; 0 if o1 == o2, -1 if o1 < 02
     */
    public int compare(final Object o1, final Object o2) {

        int result;
        if (((MyString) o1).equals((MyString) o2)) {
            result = 0;
        } else if (((MyString) o1).greaterThan((MyString) o2)) {
            result = 1;
        } else result = -1;

        return result;
    }
}
