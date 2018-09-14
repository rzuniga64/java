package behavorial.interpreter;

/**
 * The type Gallons.
 */
public class Gallons extends Expression{

    /**
     *  Convert gallons to gallons.
     *  @param quantity
     *  @return the number of gallons.
     */
    public String gallons(double quantity) {

        return Double.toString(quantity);
    }

    /**
     *  Converts gallons to quarts.
     *  @param quantity
     *  @return the number of quarts
     */
    public String quarts(double quantity) {

        return Double.toString(quantity * 4);
    }

    /**
     *  Converts gallons to pints.
     *  @param quantity
     *  @return the number of pints.
     */
    public String pints(double quantity) {

        return Double.toString(quantity * 8);
    }

    /**
     *  Convert gallons to cups.
     *  @param quantity
     *  @return the number of cups.
     */
    public String cups(double quantity) {

        return Double.toString(quantity * 16);
    }

    /**
     *  Convert gallond to tablespoons.
     *  @param quantity
     *  @return the number of tablespoons.
     */
    public String tablespoons(double quantity) {

        return Double.toString(quantity * 256);
    }
}
