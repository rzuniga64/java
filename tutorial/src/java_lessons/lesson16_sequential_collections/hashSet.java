package java_lessons.lesson16_sequential_collections;

import java.util.HashSet;

/**
 * The type Hash set. A set is an unordered collection of unique objects.
 * The HashSet will NOT store data in a natural order.For example, alphabetic
 * order if data are strings or ascending order if data are numbers.
 */
public final class hashSet {

    /** Constructor. */
    private hashSet() { }

    /**
     * Unit Tests for hashSet class.
     * @param args the input arguments
     */
    public static void main(final String[] args) {

        HashSet<String> names = new HashSet<>();
        names.add("David");
        names.add("Bryan");
        names.add("Cynthia");
        names.add("David");
        System.out.println("The number of names is " + names.size());

        for (String name : names) {
            System.out.println(name);
        }
        names.remove("David");
        names.add("Raymond");
        String name = "David";
        if (names.contains("name")) {
            System.out.println(name + " is in the collection.");
        } else {
            System.out.println(name + " is not in the collection.");
        }
        names.clear();
        System.out.println("The number of names is " + names.size());
    }
}
