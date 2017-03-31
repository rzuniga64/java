package structural.bridge;

/**
 *  Abstraction
 *  This is an abstract class that will represent numerous ways to work with
 *  each device
 */
abstract class RemoteButton{

    /** A reference to a generic device using composition. */
    private EntertainmentDevice theDevice;

    /**
     * Constructor
     * @param newDevice new device
     */
    RemoteButton(final EntertainmentDevice newDevice){

        theDevice = newDevice;
    }

    /** Button five is pressed on the remote. */
    void buttonFivePressed() {

        theDevice.buttonFivePressed();
    }

    /** Button six is pressed on the remote. */
    void buttonSixPressed() {

        theDevice.buttonSixPressed();
    }

    /** Specifies what channel or chapter device is on. */
    void deviceFeedback(){

        theDevice.deviceFeedback();
    }

    /**
     *  Define those things the remotes that are going to implement this
     *  abstract class are going to need to extend.
     */
    public abstract void buttonNinePressed();
}