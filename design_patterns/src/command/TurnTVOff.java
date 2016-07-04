package command;

/**
 * The type Turn tv off.
 */
class TurnTVOff implements Command {

    private ElectronicDevice theDevice;

    /**
     * Instantiates a new Turn tv off.
     *
     * @param newDevice the new device
     */
    TurnTVOff(ElectronicDevice newDevice){

        theDevice = newDevice;
    }

    /**
     * Method to turn on a Electronic Device
     */
    public void execute() {
        theDevice.off();
    }

    /**
     * Method to turn on a Electronic Device. Used if you want to allow for undo. Do the opposite of execute()
     */
    public void undo() {
        theDevice.on();
    }
}
