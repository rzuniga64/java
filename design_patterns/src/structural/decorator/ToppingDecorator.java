package structural.decorator;

/**
 *  Has a "Has a" relationship with Pizza. This is an Aggregation Relationship.
 *  We will use the Pizza interface to add toppings to our Pizza type.
 *  It will use the objects that are build of type ToppingDecorator and make changes to the different methods
 *  getDescription as well as getCost.
 */
abstract class ToppingDecorator implements Pizza {

    Pizza tempPizza;

    /**
     *  Assigns the type instance to this attribute of a Pizza. All decorators can dynamically customize the Pizza
     *  instance PlainPizza because of this.
     */
    ToppingDecorator(Pizza newPizza){

        tempPizza = newPizza;
    }

    /**
     *  Get a description of a pizza.
     *  @return the description.
     */
    public String getDescription() {

        return tempPizza.getDescription();
    }

    /**
     *  Get the cost of a pizza.
     *  @return the cost.
     */
    public double getCost() {

        return tempPizza.getCost();
    }
}