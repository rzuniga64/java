package behavorial.observer;

/**
 * The Observers update method is called when the Subject changes.
 */
public interface Observer {

    /**
     * Update.
     * @param ibmPrice  the ibm price
     * @param aaplPrice the aapl price
     * @param googlPrice the goog price
     */
    public void update(double ibmPrice, double aaplPrice, double googlPrice);
}