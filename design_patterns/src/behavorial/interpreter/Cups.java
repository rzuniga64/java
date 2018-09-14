package behavorial.interpreter;

/**
 * The type Cups.
 */
public class Cups extends Expression{

    /**
     *  Convert cups to gallons.
     *  @param quantity
     *  @return the number of gallons
     */
    public String gallons(double quantity) {

        return Double.toString(quantity/16);
    }

    /**
     *  Convert cups to quarts
     *  @param quantity
     *  @return the number of quarts.
     */
    public String quarts(double quantity) {

        return Double.toString(quantity/4);
    }

    /**
     *  Convert cups to pints.
     *  @param quantity
     *  @return the number of pints.
     */
    public String pints(double quantity) {

        return Double.toString(quantity/2);
    }

    /**
     *  Convert cups to cups.
     *  @param quantity
     *  @return the number of cups.
     */
    public String cups(double quantity) {

        return Double.toString(quantity);
    }

    /**
     *  Convert cups to tablespoons.
     *  @param quantity
     *  @return the number of tablespoons.
     */
    public String tablespoons(double quantity) {

        return Double.toString(quantity*16);
    }
}