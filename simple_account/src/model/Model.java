package model;

/**
 * The interface Model.
 */
public interface Model {
    /**
     * Notify changed.
     *
     * @param event the event
     */
    void notifyChanged(ModelEvent event);
}
