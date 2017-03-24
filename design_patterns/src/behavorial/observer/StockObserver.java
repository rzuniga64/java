package behavorial.observer;

/**
 * The type Stock behavorial.observer. Represents each Observer that is monitoring changes in the subject.
 */
public class StockObserver implements Observer {

    private double ibmPrice;
    private double aaplPrice;
    private double googPrice;

    private static int observerIDTracker = 0;     // Static used as a counter
    private int observerID;                       // Used to track the observers
    private Subject stockGrabber;                 // Will hold reference to the StockGrabber object

    /**
     * Instantiates a new Stock behavorial.observer.
     *
     * @param stockGrabber the stock grabber
     */
    public StockObserver(Subject stockGrabber){

        // Store the reference to the stockGrabber object so I can make calls to its methods
        this.stockGrabber = stockGrabber;

        // Assign an behavorial.observer ID and increment the static counter
        this.observerID = ++observerIDTracker;

        // Message notifies user of new behavorial.observer
        System.out.println("New Observer " + this.observerID);

        // Add the behavorial.observer to the Subjects ArrayList
        stockGrabber.register(this);
    }

    /**
     *  This method is called to update all the observers.
     *
     *  @param ibmPrice the IBM price
     *  @param aaplPrice the Apple price
     *  @param googPrice the Google price
     */
    public void update(double ibmPrice, double aaplPrice, double googPrice) {

        this.ibmPrice = ibmPrice;
        this.aaplPrice = aaplPrice;
        this.googPrice = googPrice;

        printThePrices();
    }

    /**
     * Print the prices.
     */
    public void printThePrices(){

        System.out.println(observerID + "\nIBM: " + ibmPrice + "\nAAPL: " +
                aaplPrice + "\nGOOG: " + googPrice + "\n");

    }
}