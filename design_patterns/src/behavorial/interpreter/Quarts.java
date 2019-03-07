package behavorial.interpreter;

/**
 * The type Quarts.
 */
public class Quarts extends Expression{

    /**
     *  Convert quarts to gallons.
     *  @param quantity
     *  @return the number of gallons.
     */
    public String gallons(double quantity) {

        return Double.toString(quantity/4);
    }

    /**
     *  Converts quarts to quarts.
     *  @param quantity
     *  @return the number of quarts.
     */
    public String quarts(double quantity) {

        return Double.toString(quantity);
    }

    /**
     *  Convert quarts to pints.
     *  @param quantity
     *  @return the number of pints.
     */
    public String pints(double quantity) {

        return Double.toString(quantity*2);
    }

    /**
     *  Convert quarts to cups.
     *  @param quantity
     *  @return the number of cups.
     */
    public String cups(double quantity) {

        return Double.toString(quantity*4);
    }

    /**
     *  Convert quarts to tablespoons.
     *  @param quantity
     *  @return the number of tablespoons.
     */
    public String tablespoons(double quantity) {

        return Double.toString(quantity*64);
    }
}
