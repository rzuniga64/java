package creational.abstract_factory.house;

/**
 * HouseFactory class.
 */
public abstract class HouseFactory {

    /**
     * getFactory method.
     * @return HouseFactory
     */
    public static HouseFactory getFactory() {

        int man = readFromConfigFile("MANUFACTURING_TYPE");
        if (man == 0) {
            return new EIBFactory();
        } else {
            return new LuxmateFactory();
        }
    }

    /**
     * createBulb method.
     * @return LightBulb
     */
    public abstract LightBulb createBulb();

    /**
     * createBlind method.
     * @return Blind
     */
        public abstract Blind createBlind();

    /**
     * readFromConfigFile method.
     * @param s manufacturing type
     * @return manufacturing type
     */
    private static int readFromConfigFile(final String s) {
        return 0;
    }
}



