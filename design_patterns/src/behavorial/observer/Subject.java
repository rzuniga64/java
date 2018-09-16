package behavorial.observer;

/**
 * The interface Subject handles adding, deleting and updating all observers.
 */
public interface Subject {

    /**
     * Register.
     * @param observer the observer.
     */
    void register(Observer observer);

    /**
     * Unregister.
     * @param observer the observer.
     */
    void unregister(Observer observer);

    /**
     * Notify observer
     */
    void notifyObserver();
}
