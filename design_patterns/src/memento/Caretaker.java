package memento;

import java.util.ArrayList;

/**
 * The type Caretaker.
 */
class Caretaker {

    // Where all mementos are saved
    private ArrayList<Memento> savedArticles = new ArrayList<>();

    /**
     * Add memento to the ArrayList.
     *
     * @param momento the momento
     */
    void addMemento(Memento momento) { savedArticles.add(momento); }

    /**
     * Get the memento requested from the ArrayList
     *
     * @param index the index
     * @return the memento
     */
    Memento getMemento(int index) { return savedArticles.get(index); }
}
