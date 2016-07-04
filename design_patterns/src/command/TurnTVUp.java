package command;

/**
 * The type Turn tv up.
 */
class TurnTVUp implements Command {

    private ElectronicDevice theDevice;

    /**
     * Instantiates a new Turn tv up.
     *
     * @param newDevice the new device
     */
    TurnTVUp(ElectronicDevice newDevice){

        theDevice = newDevice;
    }

    /**
     * Method to turn the volume up on a Electronic Device
     */
    public void execute() {
        theDevice.volumeUp();
    }

    /**
     * Method to turn down the volume on a Electronic Device
     */
    public void undo() {
        theDevice.volumenDown();
    }
}
