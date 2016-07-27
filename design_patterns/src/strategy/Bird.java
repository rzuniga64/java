package strategy;

/**
 * The type Bird.
 */
class Bird extends Animal{

    /**
     * Instantiates a new Bird.
     */
    Bird(){

        super();
        setSound("Tweet");
        flyingType = new ItFlys();
    }
}