package observer;

import java.text.DecimalFormat;
import java.lang.Double;

/**
 * The type Get the stock.
 */
public class GetTheStock implements Runnable{

    private int startTime;  // Could be used to set how many seconds to wait in Thread.sleep() below
    private String stock;
    private double price;
    private Subject stockGrabber;     // Will hold reference to the StockGrabber object

    /**
     * Instantiates a new Get the stock.
     *
     * @param stockGrabber the stock grabber
     * @param newStartTime the new start time
     * @param newStock     the new stock
     * @param newPrice     the new price
     */
    public GetTheStock(Subject stockGrabber, int newStartTime, String newStock, double newPrice){

        // Store the reference to the stockGrabber object so I can make calls to its methods
        this.stockGrabber = stockGrabber;

        startTime = newStartTime;
        stock = newStock;
        price = newPrice;
    }

    /**
     * Implement the Runnable interface's run method.
     */
    public void run(){

        for(int i = 1; i <= 20; i++){
            try{
                Thread.sleep(2000); // Sleep for 2 seconds. Use Thread.sleep(startTime * 1000); to make sleep time variable
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }

            // Generates a random number between -.03 and .03 cents
            double randNum = (Math.random() * (.06)) - .03;

            // Formats decimals to 2 places
            DecimalFormat df = new DecimalFormat("#.##");

            // Change the price and then convert it back into a double
            price = Double.valueOf(df.format((price + randNum)));

            // stockGrabber is a Subject while setXXXPrice is a member of StockGrabber so have to cast to StockGrabber.
            if(stock.equals("IBM")) ((StockGrabber) stockGrabber).setIBMPrice(price);
            if(stock.equals("AAPL")) ((StockGrabber) stockGrabber).setAAPLPrice(price);
            if(stock.equals("GOOG")) ((StockGrabber) stockGrabber).setGOOGPrice(price);

            System.out.println(stock + ": " + df.format((price + randNum)) + " " + df.format(randNum));
            System.out.println();
        }
    }
}