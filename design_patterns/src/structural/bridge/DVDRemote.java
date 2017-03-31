package structural.bridge;

/**
 *  Refined Abstraction.
 *  If I decide I want to further extend the remote I can.
 */
class DVDRemote extends RemoteButton{

    /** play variable. */
    private boolean play = true;

    /**
     * Constructor.
     * @param newDevice new entertainment device
     */
    DVDRemote(final EntertainmentDevice newDevice) {
        super(newDevice);
    }

    /** Button nine plays the DVD. */
    public void buttonNinePressed() {

        play = !play;
        System.out.println("DVD is Playing: " + play);
    }
}
