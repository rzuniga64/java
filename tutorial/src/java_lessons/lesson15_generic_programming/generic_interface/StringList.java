package java_lessons.lesson15_generic_programming.generic_interface;

class StringList<T> implements IList<T> {
    private T[] data;
    private int size;
    private int capacity;

    StringList(int numElements) {
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

    public String toString() {
        String elements = "";
        for (int i = 0; i < capacity; ++i) {
            elements += data[i] + " ";
        }
        return elements;
    }
}