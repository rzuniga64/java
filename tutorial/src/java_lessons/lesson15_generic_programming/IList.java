package java_lessons.lesson15_generic_programming;

/*  Interface provides us with a means to build upon
    a hierarchy of objects. We can do this generically
    by creating a generic interface.
*/
public interface IList<T> {
    void add(T element);
    T get(int n);
}
