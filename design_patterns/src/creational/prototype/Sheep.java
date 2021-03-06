package creational.prototype;

class Sheep implements Animal {

    Sheep() {

        System.out.println("Sheep is Made");
    }

    public Animal makeCopy() {

        System.out.println("Sheep is Being Made");
        Sheep sheepObject = null;

        // anytime you clone it needs to be wrapped in a try-catch block.
        try {
            // Calls the Animal super classes clone(). Then casts the results to Sheep
            sheepObject = (Sheep) super.clone();

        } catch (CloneNotSupportedException e) {

            System.out.println("The Sheep was Turned to Mush");
            e.printStackTrace();
        }

        return sheepObject;
    }

    public String toString() {

        return "Dolly is my Hero, Baaaaa";
    }
}
