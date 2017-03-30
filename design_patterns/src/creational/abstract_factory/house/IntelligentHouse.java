package creational.abstract_factory.house;

/**
 * Itelligent House is not aware of vendor specific buld such as EIB or Luxmate.
 */
public final class IntelligentHouse {

    /** Constructor. */
    private IntelligentHouse() { }

    /**
     * Unit tests.
     * @param args args
     */
    public static void main(final String[] args) {

        HouseFactory factory = HouseFactory.getFactory();
        LightBulb bulb = factory.createBulb();
        Blind blind = factory.createBlind();
        bulb.switchOn();
        blind.open();
    }
}

