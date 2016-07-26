package observer;

/**
 * The interface Subject handles adding, deleting and updating all observers.

 */
public interface Subject {

    /**
     * Register.
     *
     * @param observer
     */
    public void register(Observer observer);

    /**
     * Unregister.
     *
     * @param observer
     */
    public void unregister(Observer observer);

    /**
     * Notify observer
     */
    public void notifyObserver();
}
