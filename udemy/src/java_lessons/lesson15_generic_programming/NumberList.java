package java_lessons.lesson15_generic_programming;

public class NumberList<T> implements IList<T> {
    private T[] data;
    private int size;
    private int capacity;

    public NumberList(int numElements) {
        size = numElements;
        capacity = 0;
        data = (T[]) new Object[size];
    }

    public void add(T element) {
        data[capacity] = element;
        ++capacity;
    }

    public T get(int n) {
        return data[n];
    }
}
