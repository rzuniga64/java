package behavorial.interpreter;

/**
 * The type Tablespoons.
 */
public class Tablespoons extends Expression{

    /**
     *  Convert tablespoons to gallons
     *  @param quantity
     *  @return the number of gallons
     */
    public String gallons(double quantity) {

        return Double.toString(quantity/256);
    }

    /**
     *  Convert tablespoons to quarts.
     *  @param quantity
     *  @return the number of quarts.
     */
    public String quarts(double quantity) {

        return Double.toString(quantity/64);
    }

    /**
     *  Convert tablespoons to pints.
     *  @param quantity
     *  @return the number of pints.
     */
    public String pints(double quantity) {

        return Double.toString(quantity/32);
    }

    /**
     *  Convert tablespoons to cups.
     *  @param quantity
     *  @return the number of cups.
     */
    public String cups(double quantity) {

        return Double.toString(quantity/16);
    }

    /**
     *  Convert tablespoons to tablespoonos.
     *  @param quantity
     *  @return the number of tablespoons.
     */
    public String tablespoons(double quantity) {

        return Double.toString(quantity);
    }
}
