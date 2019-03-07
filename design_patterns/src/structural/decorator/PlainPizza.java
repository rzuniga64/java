package structural.decorator;

/**
 *  Implements the Pizza interface with only the required methods from the interface. Every Pizza made will start as a
 *  PlainPizza
*/
class PlainPizza implements Pizza {

    /**
     *  Get a description of a plain pizza.
     *  @return the description.
     */
    public String getDescription() {

        return "Thin dough";
    }

    /**
     *  Get the cost of a plain pizza.
     *  @return the cost.
     */
    public double getCost() {

        System.out.println("Cost of Dough: " + 4.00);
        return 4.00;
    }
}