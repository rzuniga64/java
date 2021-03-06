package model;

import java.util.ArrayList;

/**
 * The type Abstract simpleAccount.view.model.
 */
public abstract class AbstractModel implements Model {
    private static ArrayList<ModelListener> listeners = new ArrayList<ModelListener>();

    public void notifyChanged(ModelEvent event) {
        ArrayList<ModelListener> ls = (ArrayList<ModelListener>) listeners.clone();
        for (ModelListener listener: ls)
            listener.modelChanged(event);
    }

    /**
     * Add simpleAccount.view.model listener.
     *
     * @param listener the listener
     */
    public void addModelListener(ModelListener listener) {
        listeners.add(listener);
    }

    /**
     * Remove simpleAccount.view.model listener.
     *
     * @param listener the listener
     */
    public void removeModelListener(ModelListener listener) {
        listeners.remove(listener);
    }
}
