package structural.bridge.device;

/**
 *  Abstraction Layer
 *  This is an abstract class that will represent numerous ways for the remote to work with each device.
 */
abstract class RemoteButton{

    private EntertainmentDevice theDevice;  // A reference to a generic device using composition.

    /**
     * Constructor
     * @param newDevice new device
     */
    RemoteButton(final EntertainmentDevice newDevice){

        theDevice = newDevice;
    }

    /**
     *  Button five is pressed on the remote.
     */
    void buttonFivePressed() {

        theDevice.buttonFivePressed();
    }

    /**
     *  Button six is pressed on the remote.
     */
    void buttonSixPressed() {

        theDevice.buttonSixPressed();
    }

    /**
     * Specifies what channel or chapter device is on.
     */
    void deviceFeedback(){

        theDevice.deviceFeedback();
    }

    /**
     *  Define the things that those remotes that are going to implement this abstract class are going to need to extend.
     */
    public abstract void buttonNinePressed();
}