package java_lessons.lesson17_associative_collections;

import java.util.TreeMap;
import java.util.Set;

/**
 *  The treeMap class. A TreeMap guarantees the order of the items in the
 *  collection.  It is an associate collection type mapping keys to values.
 *
 *  A Red-Black tree based NavigableMap implementation. The map is sorted
 *  according to the natural ordering of its keys, or by a Comparator provided
 *  at map creation time, depending on which constructor is used.
 *  This implementation provides guaranteed log(n) time cost for the
 *  containsKey, get, put and remove operations. Algorithms are adaptations of
 *  those in Cormen, Leiserson, and Rivest's Introduction to Algorithms.
 *
 *  Note that the ordering maintained by a tree map, like any sorted map, and
 *  whether or not an explicit comparator is provided, must be consistent with
 *  equals if this sorted map is to correctly implement the Map interface.
 *  (See Comparable or Comparator for a precise definition of consistent with
 *  equals.) This is so because the Map interface is defined in terms of the
 *  equals operation, but a sorted map performs all key comparisons using its
 *  compareTo (or compare) method, so two keys that are deemed equal by this
 *  method are, from the standpoint of the sorted map, equal. The behavior of a
 *  sorted map is well-defined even if its ordering is inconsistent with equals;
 *  it just fails to obey the general contract of the Map interface.
 */
public final class treeMap {

    /** Constructor. */
    private treeMap() { }

    /**
     * Unit tests for treeMap class.
     * @param args the input arguments
     */
    public static void main(final String[] args) {

        TreeMap<String, String> numbers = new TreeMap<>();
        Set<String> keys;

        numbers.put("David", "2333");
        numbers.put("Raymond", "2334");
        numbers.put("Cynthia", "2335");
        numbers.put("Bryan", "2336");

        keys = numbers.keySet();
        for (String key : keys) {
            System.out.println("The number for " + key + " is "
                    + numbers.get(key));
        }

        System.out.println("Cynthia: " + numbers.get("Cynthia"));

        numbers.put("Jennifer", "2337");
        System.out.println("Size of numbers: " + numbers.size());

        numbers.remove("David");
        System.out.println("Size of numbers: " + numbers.size());
    }
}

