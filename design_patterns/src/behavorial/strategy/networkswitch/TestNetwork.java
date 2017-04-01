package behavorial.strategy.networkswitch;

/**
 * TestNetwork class.
 */
public class TestNetwork {

    public static void main(final String[] args) {
        byte[] msg = {'H', 'i'};
        LocationManager lm = new LocationManager();
        lm.doLocation();
        lm.networkConnection.send(msg);
        System.out.println("Recieving message: "
                + lm.networkConnection.receive().toString());
    }
}
