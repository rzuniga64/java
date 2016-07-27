package template_method;

/**
 * The type Italian hoagie.
 */
class ItalianHoagie extends Hoagie{

    private String[] meatUsed = { "Salami", "Pepperoni", "Capicola Ham" };
    private String[] cheeseUsed = { "Provolone" };
    private String[] veggiesUsed = { "Lettuce", "Tomatoes", "Onions", "Sweet Peppers" };
    private String[] condimentsUsed = { "Oil", "Vinegar" };

    /**
     * Add meat.
     */
    public void addMeat(){

        System.out.print("Adding the Meat: ");

        for (String meat : meatUsed)
            System.out.print(meat + " ");
    }

    /**
     *  Add cheese.
     */
    public void addCheese(){

        System.out.print("Adding the Cheese: ");

        for (String cheese : cheeseUsed)
            System.out.print(cheese + " ");
    }

    /**
     *  Add vegetables.
     */
    public void addVegetables(){

        System.out.print("Adding the Vegetables: ");

        for (String vegetable : veggiesUsed)
            System.out.print(vegetable + " ");
    }

    /**
     *  Add condiments.
     */
    public void addCondiments(){

        System.out.print("Adding the Condiments: ");

        for (String condiment : condimentsUsed)
            System.out.print(condiment + " ");
    }
}