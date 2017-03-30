package creational.abstract_factory.house;

/**
 * LuxemateFactory class
 */
class LuxmateFactory extends HouseFactory {

    /**
     * createBulb class.
     * @return Lightbulb
     */
    public LightBulb createBulb() {
        return new LuxemateBulb();
    }

    /**
     * createBlind class.
     * @return Blind
     */
    public Blind createBlind() {
        return new LuxemateBlind();
    }
}