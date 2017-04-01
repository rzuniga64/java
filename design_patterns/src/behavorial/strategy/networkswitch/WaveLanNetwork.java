package behavorial.strategy.networkswitch;

/**
 * WaveLanNetwork. Concrete Strategy.
 */
public class WaveLanNetwork implements NetworkInterface{

    public void open(final String connection){
        System.out.println(connection + " network is open");
    }

    public void close() {
        System.out.println("WaveLan network is closed");
    }

    public byte[] receive() {
        byte[] msg = {'H', 'i'};
        return msg;
    }

    public void send(final StringBuffer queue) {
        System.out.println("WaveLan network sending " + queue);
    }

    public boolean isReady() {
        return false;
    }
}
