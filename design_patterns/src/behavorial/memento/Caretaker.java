package behavorial.memento;

import java.util.ArrayList;

/**
 * The type Caretaker.
 */
class Caretaker {

    // Where all mementos are saved
    private ArrayList<Memento> savedArticles = new ArrayList<>();

    /**
     * Add behavorial.memento to the ArrayList.
     *
     * @param momento the momento
     */
    void addMemento(Memento momento) { savedArticles.add(momento); }

    /**
     * Get the behavorial.memento requested from the ArrayList
     *
     * @param index the index
     * @return the behavorial.memento
     */
    Memento getMemento(int index) { return savedArticles.get(index); }
}
