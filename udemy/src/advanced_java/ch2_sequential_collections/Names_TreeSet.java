package advanced_java.ch2_sequential_collections;

import java.util.TreeSet;

/*
    The difference between HashSet and TreeSet is that TreeSet will store
    data in a natural order. Example, alphabetic order if data are strings
    or ascending order if data are numbers.
 */
public class Names_TreeSet {
    public static void main(String[] args) {
        TreeSet<String> names = new TreeSet<String>();
        names.add("Mau Mau");
        names.add("Randy");
        names.add("Cinnamon");
        names.add("Raymond");
        names.add("Jennifer");
        names.add("Bryan");
        System.out.println("Number of names = " + names.size());
        for (String name : names)
            System.out.println(name);

        System.out.println("Name before Jennifer: " + names.lower("Jennifer"));
        System.out.println("Name after Jennifer: " + names.higher("Jennifer"));
        System.out.println("First element: " + names.first());
        System.out.println("Last element: " + names.last());
    }
}
