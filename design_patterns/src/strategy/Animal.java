package strategy;

/**
 *  The type Animal.
 *
 *  You don't want to add methods to the super class if it doesn't pertain to any subclass.
 *  You need to separate what is different between subclasses and their super class
 *  Abstract out those things that are different and put just those things that are different inside the classes.
 */
public class Animal {

    private String name;
    private double height;
    private int weight;
    private String favFood;
    private double speed;
    private String sound;

    /**
     *  Use an instance variable that is a subclass of the Flys interface.
     *  Instead of using an interface in a traditional way we use an instance variable that is a subclass of the Flys
     *  interface. Animal doesn't care what flyingType does, it just knows the behavior is available to its subclasses.
     *  This is known as Composition : Instead of inheriting an ability through inheritance the class is composed
     *  with Objects with the right ability. Composition allows you to change the capabilities of objects at run time!
     */
    Flys flyingType;

    public String getName(){ return name; }
    public double getHeight(){ return height; }
    public double getWeight(){ return weight; }
    public String getFavFood(){ return favFood; }
    public double getSpeed(){ return speed; }
    public String getSound(){ return sound; }

    public void setName(String newName){ name = newName; }
    public void setHeight(double newHeight){ height = newHeight; }

    public void setWeight(int newWeight){
        if (newWeight > 0){
            weight = newWeight;
        } else {
            System.out.println("Weight must be bigger than 0");
        }
    }

    public void setFavFood(String newFavFood){ favFood = newFavFood; }
    public void setSpeed(double newSpeed){ speed = newSpeed; }
    void setSound(String newSound){ sound = newSound; }

    /**
     * Try to fly string. Animal pushes off the responsibility for flying to flyingType
     *
     * @return the string
     */
    String tryToFly(){

        return flyingType.fly();
    }

    /**
     * Set flying ability. If you want to be able to change the flyingType dynamically add the following method
     *
     * @param newFlyType the new fly type
     */

    void setFlyingAbility(Flys newFlyType){

        flyingType = newFlyType;
    }
}
