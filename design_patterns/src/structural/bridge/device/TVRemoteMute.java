package structural.bridge.device;

/**
 *  Refined Abstraction.
 *  If I decide I want to further extend the remote I can.
 */
class TVRemoteMute extends RemoteButton {

    /**
     * Constructor.
     * @param newDevice new entertainment device.
     */
    TVRemoteMute(final EntertainmentDevice newDevice) {

        super(newDevice);
    }

    /** Button nine mutes the TV. */
    public void buttonNinePressed() {

        System.out.println("TV was Muted");
    }
}
