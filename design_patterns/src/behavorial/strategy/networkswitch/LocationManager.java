package behavorial.strategy.networkswitch;

/**
 * LocationManager class. Client.
 *  - Based on location (available network connections) switch between different
 *    types of network connections.
 *  - LocationManager configures NetworkConnection with a concrete
 *    NetworkInterface based on the current location.
 *  - Application uses the NetworkConnection independently of concrete
 *    Network interfaces (NetworkConnection uses delegation).
 */
public class LocationManager {

    NetworkConnection networkConnection;

    /**
     * called by event handler when location has changed.
     */
    public void doLocation() {

        NetworkInterface networkIntf = null;

        if (isEthernetAvailable()) {
            networkIntf = new EthernetNetwork();
        } else if (isWaveLANAvailable()) {
            networkIntf = new WaveLanNetwork();
        } else if (isUMTSAvailalbe()) {
            networkIntf = new UMTSNetwork();
        }

        networkConnection = new NetworkConnection("Ethernet", networkIntf);
        networkConnection.setNetworkInterface(networkIntf);
    }

    public boolean isEthernetAvailable() {
        return true;
    }

    public boolean isWaveLANAvailable() {
        return false;
    }

    public boolean isUMTSAvailalbe() {
        return false;
    }
}