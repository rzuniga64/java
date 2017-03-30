package creational.abstract_factory.house;

/**
 * EIBFactory class.
 */
class EIBFactory extends HouseFactory {

    /**
     * createBulb class.
     * @return Lightbulb
     */
    public LightBulb createBulb() {
        return new EIBBulb();
    }

    /**
     * createBlind class.
     * @return Blind
     */
    public Blind createBlind() {
        return new EIBBlind();
    }
}
