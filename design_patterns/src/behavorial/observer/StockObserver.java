package behavorial.observer;

/**
 * The type Stock Observer. Represents each Observer that is monitoring changes in the subject.
 */
public class StockObserver implements Observer {

    private double ibmPrice;
    private double aaplPrice;
    private double googlPrice;

    private static int observerIDTracker = 0;     // Static used as a counter
    private int observerID;                       // Used to track the observers
    private Subject stockGrabber;                 // Will hold reference to the StockGrabber object

    /**
     * Instantiates a new Stock Observer.
     * @param stockGrabber the stock grabber
     */
    StockObserver(Subject stockGrabber){

        // Store the reference to the stockGrabber object so I can make calls to its methods
        this.stockGrabber = stockGrabber;

        // Assign an Observer ID and increment the static counter
        this.observerID = ++observerIDTracker;

        // Message notifies user of new Observer
        System.out.println("New Observer " + this.observerID);

        // Add the Observer to the Subjects ArrayList
        stockGrabber.register(this);
    }

    /**
     *  This method is called to update all the observers.
     *  @param ibmPrice the IBM price
     *  @param aaplPrice the Apple price
     *  @param googlPrice the Google price
     */
    public void update(double ibmPrice, double aaplPrice, double googlPrice) {

        this.ibmPrice = ibmPrice;
        this.aaplPrice = aaplPrice;
        this.googlPrice = googlPrice;

        printThePrices();
    }

    /**
     * Print the prices.
     */
    private void printThePrices(){

        System.out.println(observerID + "\nIBM: " + ibmPrice + "\nAAPL: " + aaplPrice + "\nGOOG: " + googlPrice + "\n");
    }
}