package java_lessons.lesson10_inheritance;

import java.util.Hashtable;

/**
 *  Specification inheritance is the classification of concepts into type
 *  hierarchies
 *  - Conceptually, subclass is a specialization of its superclass.
 *  - Conceptually, superclass is a generalization of all of its subclasses.
 *
 *  Set implemented using delegation.  Delegation is a special form of
 *  composition.
 *  - One class(A) contains a reference to another class(B) (via member/instance
 *    variable).
 *  - Makes explicit the dependencies between A and B.
 *
 *  Addresses problems of implementation inheritance.
 *  - Extensibility (allowing for change to implementation)
 *    Internal representation of A can be changed without impacting clients of A
 *    (methods of B are not exposed via A like they would be in inheritance)
 *  - Subtyping. A is not a special case of B so it cannot be accidentally used
 *    as a special kind of B. Does not violate LSP because it does not apply.
 */
public class MySet2 {

    /** table. */
    private Hashtable table;

    /** Constructor. */
    public MySet2() {
        table = new Hashtable();
    }

    /**
     * put method.
     * @param key the key
     */
    public void put(final Object key) {
        if (!table.containsKey(key)) {
            table.put(key, this);
        }
    }

    /**
     * containsValue method.
     * @param key the key
     * @return the value
     */
    public boolean containsValue(final Object key) {
        return table.containsKey(key);
    }
}


