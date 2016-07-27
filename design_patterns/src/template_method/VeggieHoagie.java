package template_method;

/**
 * The type Veggie hoagie.
 */
class VeggieHoagie extends Hoagie{

    private String[] veggiesUsed = { "Lettuce", "Tomatoes", "Onions", "Sweet Peppers" };
    private String[] condimentsUsed = { "Oil", "Vinegar" };

    /**
     * Customer wants meet.
     */
    boolean customerWantsMeat() { return false; }

    /**
     * Customer wants cheese.
     */
    boolean customerWantsCheese() { return false; }

    /**
     * add Vegetables
     */
    public void addVegetables(){

        System.out.print("Adding the Vegetables: ");

        for (String vegetable : veggiesUsed)
            System.out.print(vegetable + " ");
    }

    /**
     * Add condiments.
     */
    public void addCondiments(){

        System.out.print("Adding the Condiments: ");

        for (String condiment : condimentsUsed)
            System.out.print(condiment + " ");
    }

    /**
     * Add meat.
     */
    void addMeat() {}

    /**
     * Add cheese.
     */
    void addCheese() {}
}