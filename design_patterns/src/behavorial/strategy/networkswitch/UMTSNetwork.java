package behavorial.strategy.networkswitch;

/**
 *  UMTSNetwork class. Concrete Strategy.
 */
public class UMTSNetwork implements NetworkInterface{

    public void open(final String connection){
        System.out.println(connection + " network is open");
    }

    public void close() {
        System.out.println("UMTS network is closed");
    }

    public byte[] receive() {
        byte[] msg = {'H', 'i'};
        return msg;
    }

    public void send(final StringBuffer queue) {
        System.out.println("UMTS network sending " + queue);
    }

    public boolean isReady() {
        return true;
    }
}
