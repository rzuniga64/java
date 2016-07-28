package visitor;

/**
 * The type Tobacco.
 */
class Tobacco implements Visitable {

    private double price;

    /**
     * Instantiates a new Tobacco.
     *
     * @param item the item
     */
    Tobacco(double item) {

        price = item;
    }

    /**
     * Accept
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