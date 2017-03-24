package behavorial.observer;

import java.util.ArrayList;

/**
 * The type Stock grabber. Uses the Subject interface to update all Observers.
 */
class StockGrabber implements Subject{

    private ArrayList<Observer> observers;
    private double ibmPrice;
    private double aaplPrice;
    private double googPrice;

    /**
     * Instantiates a new Stock grabber.
     */
    StockGrabber(){ observers = new ArrayList<Observer>(); }

    /**
     * This method adds a new behavorial.observer to the ArrayList.
     */
    public void register(Observer newObserver) {

        observers.add(newObserver);
    }

    /**
     * This method removes an behavorial.observer to the ArrayList.
     */
    public void unregister(Observer deleteObserver) {

        // Get the index of the behavorial.observer to delete
        int observerIndex = observers.indexOf(deleteObserver);

        // Print out message (Have to increment index to match)
        System.out.println("Observer " + (observerIndex + 1) + " deleted");

        // Removes behavorial.observer from the ArrayList
        observers.remove(observerIndex);
    }

    /**
     * This method cycles through all observers and notifies them of price changes
     */
    public void notifyObserver() {

        for(Observer observer : observers){
            observer.update(ibmPrice, aaplPrice, googPrice);
        }
    }

    /**
     * Set ibm price. Change prices for IBM stock and notifies observers of changes
     *
     * @param newIBMPrice the new ibm price
     */
    void setIBMPrice(double newIBMPrice){

        this.ibmPrice = newIBMPrice;
        notifyObserver();
    }

    /**
     * Set aapl price. Change prices for AAPL stock and notifies observers of changes
     *
     * @param newAAPLPrice the new aapl price
     */
    void setAAPLPrice(double newAAPLPrice){

        this.aaplPrice = newAAPLPrice;
        notifyObserver();
    }

    /**
     * Set goog price. Change prices for GOOG stock and notifies observers of changes
     *
     * @param newGOOGPrice the new goog price
     */
    void setGOOGPrice(double newGOOGPrice){

        this.googPrice = newGOOGPrice;
        notifyObserver();
    }
}