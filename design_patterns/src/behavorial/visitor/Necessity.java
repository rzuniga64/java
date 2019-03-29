package behavorial.visitor;

/**
 *  The type Necessity.
 */
class Necessity implements Visitable {

    private double price;

    /**
     *  Instantiates a new Necessity.
     *  @param item the item
     */
    Necessity(double item) {

        price = item;
    }

    /**
     *  Gets price.
     *  @return the price
     */
    public double getPrice() {

        return price;
    }

    /**
     *  Accept method.
     *  @param visitor the visitor.
     */
    public double accept(Visitor visitor) {

        return visitor.visit(this);
    }
}