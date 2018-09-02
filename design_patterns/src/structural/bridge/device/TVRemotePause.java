package structural.bridge.device;

/**
 *  Refined Abstraction. If I decide I want to further extend the remote I can.
 */
class TVRemotePause extends RemoteButton {

    /**
     * Constructor.
     * @param newDevice new entertainment device.
     */
    TVRemotePause(final EntertainmentDevice newDevice) {

        super(newDevice);
    }

    /**
     *  Button nine pauses the TV.
     */
    public void buttonNinePressed() {

        System.out.println("TV was Paused");
    }
}
