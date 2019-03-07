package behavorial.interpreter;

/**
 * The type Pints.
 */
public class Pints extends Expression{

    /**
     *  Convert pints to gallons.
     *  @param quantity
     *  @return the number of gallons
     */
    public String gallons(double quantity) {

        return Double.toString(quantity/8);
    }

    /**
     *  Convert pints to quarts.
     *  @param quantity
     *  @return the number of quarts.
     */
    public String quarts(double quantity) {

        return Double.toString(quantity/2);
    }

    /**
     *  Convert pints to pints.
     *  @param quantity
     *  @return the number of pints.
     */
    public String pints(double quantity) {

        return Double.toString(quantity);
    }

    /**
     *  Convert pints to cups.
     *  @param quantity
     *  @return the number of cups.
     */
    public String cups(double quantity) {

        return Double.toString(quantity * 2);
    }

    /**
     *  Convert pints to tablespoons.
     *  @param quantity
     *  @return the number of tablespoons.
     */
    public String tablespoons(double quantity) {

        return Double.toString(quantity * 32);
    }
}