package visitor;

/**
 * The type Liquor.
 */
class Liquor implements Visitable {

    private double price;

    /**
     * Instantiates a new Liquor.
     *
     * @param item the item
     */
    Liquor(double item) {

        price = item;
    }

    /**
     * Accept.
     *
     * @param visitor the visitor
     */
    public double accept(Visitor visitor) {

        return visitor.visit(this);
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public double getPrice() {

        return price;
    }
}