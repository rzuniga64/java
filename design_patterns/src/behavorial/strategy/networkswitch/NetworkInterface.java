package behavorial.strategy.networkswitch;

/**
 *  NetworkInterface. Abstract Strategy.
 *  Implemented by EthernetNetwork, WaveLanNetwork, and UMTSNetwork.
 *  - Based on location (available network connections) switch between different
 *    types of network connections.
 *  - LocationManager configures NetworkConnection with a concrete
 *    NetworkInterface based on the current location.
 *  - Application uses the NetworkConnection independently of concrete
 *    Network interfaces (NetworkConnection uses delegation).
 */
public interface NetworkInterface {

     void open(String connection);
     void close();
     byte[] receive();
     void send(StringBuffer queue);
     boolean isReady();
}
