package behavorial.strategy.networkswitch;

/**
 *  NetworkConnection class.  Context Object.
 *  - Based on location (available network connections) switch between different
 *    types of network connections.
 *  - LocationManager configures NetworkConnection with a concrete
 *    NetworkInterface based on the current location.
 *  - Application uses the NetworkConnection independently of concrete
 *    Network interfaces (NetworkConnection uses delegation).
 */
public class NetworkConnection {

    private String destination;
    private NetworkInterface intf;
    private StringBuffer queue;

    public NetworkConnection(final String newDestination,
                             final NetworkInterface newIntf) {

        this.destination = newDestination;
        this.intf = newIntf;
        this.intf.open(destination);
    }

    public void send(final byte[] msg) {

        queue.append(msg.toString());
        if (intf.isReady()) {
            intf.send(queue);
            queue.setLength(0);
        }
    }

    public byte[] receive() {

        return intf.receive();
    }

    public void setNetworkInterface(final NetworkInterface newIntf) {

        intf.close();
        newIntf.open(destination);
        intf = newIntf;
    }
}
