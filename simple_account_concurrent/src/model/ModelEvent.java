package model;

import java.awt.event.ActionEvent;

/**
 * The type Model event.
 */
public class ModelEvent extends ActionEvent{
    private double balance;

    /**
     * Instantiates a new Model event.
     *
     * @param obj     the obj
     * @param id      the id
     * @param message the message
     * @param balance the balance
     */
    public ModelEvent (Object obj, int id, String message, double balance) {
        super(obj, id, message);
        this.balance = balance;
    }

    /**
     * Gets balance.
     *
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }
}
