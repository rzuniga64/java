package java_lessons.lesson17_associative_collections;

import java.util.TreeMap;

/**
 * The type Tree map. A TreeMap guarantees the order of the items in the collection.

 */
public class treeMap {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        TreeMap<String,String> numbers = new TreeMap<>();

        numbers.put("David", "2333");
        numbers.put("Raymond", "2334");
        numbers.put("Cynthia", "2335");
        numbers.put("Bryan", "2336");

        System.out.println("Cynthia: " + numbers.get("Cynthia"));

        numbers.put("Jennifer", "2337");
        System.out.println("Size of numbers: " + numbers.size());

        numbers.remove("David");
        System.out.println("Size of numbers: " + numbers.size());
    }
}
