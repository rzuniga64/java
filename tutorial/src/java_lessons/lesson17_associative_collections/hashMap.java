package java_lessons.lesson17_associative_collections;

import java.util.HashMap;

/**
 *  The type Hash map. A HashMap cannot guarantee the order of the items in the
 *  collection.
 *
 *  Hash table based implementation of the Map interface. This implementation
 *  provides all of the optional map operations, and permits null values and
 *  the null key. (The HashMap class is roughly equivalent to Hashtable, except
 *  that it is unsynchronized and permits nulls.) This class makes no guarantees
 *  as to the order of the map; in particular, it does not guarantee that the
 *  order will remain constant over time.
 *
 *  This implementation provides constant-time performance for the basic
 *  operations (get and put), assuming the hash function disperses the elements
 *  properly among the buckets. Iteration over collection views requires time
 *  proportional to the "capacity" of the HashMap instance (the number of
 *  buckets) plus its size (the number of key-value mappings). Thus, it's
 *  very important not to set the initial capacity too high (or the load factor
 *  too low) if iteration performance is important.
 *
 *  An instance of HashMap has two parameters that affect its performance:
 *  initial capacity and load factor. The capacity is the number of buckets
 *  in the hash table, and the initial capacity is simply the capacity at the
 *  time the hash table is created. The load factor is a measure of how full
 *  the hash table is allowed to get before its capacity is automatically
 *  increased. When the number of entries in the hash table exceeds the product
 *  of the load factor and the current capacity, the hash table is rehashed
 *  (that is, internal data structures are rebuilt) so that the hash table has
 *  approximately twice the number of buckets.
 *
 *  As a general rule, the default load factor (.75) offers a good tradeoff
 *  between time and space costs. Higher values decrease the space overhead but
 *  increase the lookup cost (reflected in most of the operations of the HashMap
 *  class, including get and put). The expected number of entries in the map and
 *  its load factor should be taken into account when setting its initial
 *  capacity, so as to minimize the number of rehash operations. If the initial
 *  capacity is greater than the maximum number of entries divided by the load
 *  factor, no rehash operations will ever occur.
 *
 *  If many mappings are to be stored in a HashMap instance, creating it with a
 *  sufficiently large capacity will allow the mappings to be stored more
 *  efficiently than letting it perform automatic rehashing as needed to grow
 *  the table. Note that using many keys with the same hashCode() is a sure way
 *  to slow down performance of any hash table. To ameliorate impact, when keys
 *  are Comparable, this class may use comparison order among keys to help break
 *  ties.
 */
public final class hashMap {

    /** Constructor. */
    private hashMap() { }

    /**
     * Utility tests for hashMap class.
     * @param args the args
     */
    public static void main(final String[] args) {

        HashMap<String, Integer> grades = new HashMap<>();

        grades.put("Smith", 88);
        grades.put("Brown", 100);
        grades.put("Jones", 77);
        grades.put("Green", 90);

        System.out.println("Smith's grade: " + grades.get("Smith"));
        System.out.println("Size of grades: " + grades.size());

        if (grades.containsKey("Brown")) {
            grades.remove("Brown");
            System.out.println("Record successfully removed.");
        }

        System.out.println("Size of grades: " + grades.size());
    }
}

