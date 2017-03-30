package java_lessons.lesson10_inheritance;

import java.util.Hashtable;
/**
 *  Implementation inheritance is teh use of inheritance for the sole purpose
 *  of reusing code (from the superclass).
 *  - The generalization/specialization relationship is usually lacking.
 *  - Example: Set implemented by inheriting from Hashtable.
 *
 *  Good: code reuse.
 *  Bad: Set is not a specialization of Hashtable.
 *  - it inherits methods that don't make sens for it: put(Object key),
 *    containsKey(Object key).
 *  - Potential problem: a client class uses these methods on MySet, and then
 *    MySet is re-implemented by inheriting from some other class (like List).
 *  - It doesn't work as a Hashtable. it cannot be used correctly as a special
 *    kind of Hashtable (i.e. passed to a function that takes a Hashtable as an
 *    argument).
 *  - Specifically containsValue(Object key) will not work as expected.
 *
 *  Liskov Substitution Principle: if S is a subclass of T, then objects of type
 *  T may be replaced with objects of type S without altering any of the
 *  desirable properties of teh program.
 */
public class MySet extends Hashtable {

    /** Constructor. */
    public MySet() { }

    /**
     * put method.
     * @param key the key
     */
    public void put(final Object key) {
        if (!containsKey(key)) {
            put(key, this);
        }
    }

    /**
     * containsValue method.
     * @param key the key
     * @return the value
     */
    public boolean containsValue(final Object key) {
        return containsKey(key);
    }
}

/**
 * Specification inheritance is the classification of concepts into type
 * hierarchies
 * - Conceptually, subclass is a specialization of its superclass.
 * - Conceptually, superclass is a generalization of all of its subclasses.
 */
