package template_method;

/**
 * The type Hoagie.
 * A Template Pattern contains a method that provides the steps of the algorithm. It allows subclasses to override
 * some of the methods
 */
abstract class Hoagie {

    private boolean afterFirstCondiment = false;

    /**
     *  Make sandwich.
     *  This is the Template Method
     *  Declare this method final to keep subclasses from changing the algorithm.
     */
    final void makeSandwich(){

        cutBun();

        if(customerWantsMeat()){
            addMeat();
            afterFirstCondiment = true;
        }

        if(customerWantsCheese()){
            if(afterFirstCondiment) { System.out.print("\n"); }
            addCheese();
            afterFirstCondiment = true;
        }

        if(customerWantsVegetables()){
            if(afterFirstCondiment) { System.out.print("\n"); }
            addVegetables();
            afterFirstCondiment = true;
        }

        if(customerWantsCondiments()){
            if(afterFirstCondiment) { System.out.print("\n"); }

            addCondiments();
            afterFirstCondiment = true;
        }

        wrapTheHoagie();
    }

    /**
     * Add meat. These methods must be overridden by the extending subclasses
     */
    abstract void addMeat();

    /**
     * Add cheese.
     */
    abstract void addCheese();

    /**
     * Add vegetables.
     */
    abstract void addVegetables();

    /**
     * Add condiments.
     */
    abstract void addCondiments();

    /**
     *  Cut bun.
     */
    private void cutBun(){

        System.out.println("The Hoagie is Cut");
    }

    /*
     *  These are called hooks.
     *  If the user wants to override these they can.
     *
     *  Use abstract methods when you want to force the user to override and use a hook when you want it to be optional
     */

    /**
     * Customer wants meat boolean.
     *
     * @return the boolean
     */
    boolean customerWantsMeat() { return true; }

    /**
     * Customer wants meat boolean.
     *
     * @return the boolean
     */
    boolean customerWantsCheese() { return true; }

    /**
     * Customer wants cheese boolean.
     *
     * @return the boolean
     */
    private boolean customerWantsVegetables() { return true; }

    /**
     * Customer wants Condiments boolean.
     *
     * @return the boolean
     */
    private boolean customerWantsCondiments() { return true; }

    /**
     * Wrap the Hoagie.
     */
    private void wrapTheHoagie(){ System.out.println("\nWrap the Hoagie"); }

    /**
     * After first condiment.
     */
    public void afterFirstCondiment(){

        System.out.println("\n");
    }
}