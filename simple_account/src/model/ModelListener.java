package model;

/**
 * The interface Model listener.
 */
public interface ModelListener {
    /**
     * Model changed.
     *
     * @param event the event
     */
    void modelChanged(ModelEvent event);
}
