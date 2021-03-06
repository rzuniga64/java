package behavorial.visitor;

/**
 * The type Tobacco.
 */
class Tobacco implements Visitable {

    private double price;

    /**
     *  Constructor.
     *  @param item the item
     */
    Tobacco(double item) {

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
     *  @param visitor the visitor
     */
    public double accept(Visitor visitor) {

        return visitor.visit(this);
    }
}