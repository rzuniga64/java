package java_lessons.lesson16_sequential_collections;

import java.util.TreeSet;

/**
 * treeSet class. A set is an unordered collection of unique objects.
 * The difference between HashSet and TreeSet is that TreeSet will store data
 * in a natural order. Example, alphabetic order if data are strings or
 * ascending order if data are numbers.
 */
public final class treeSet {

    /** Constructor. */
    private treeSet() { }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(final String[] args) {

        TreeSet<String> names = new TreeSet<String>();
        names.add("Mau Mau");
        names.add("Randy");
        names.add("Cinnamon");
        names.add("Raymond");
        names.add("Jennifer");
        names.add("Bryan");

        System.out.println("Number of names = " + names.size());

        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("Name before Jennifer: " + names.lower("Jennifer"));
        System.out.println("Name after Jennifer: " + names.higher("Jennifer"));
        System.out.println("First element: " + names.first());
        System.out.println("Last element: " + names.last());
    }
}
