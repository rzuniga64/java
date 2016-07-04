package command;

/**
 * The type Turn tv on.
 */
class TurnTVOn implements Command {

    private ElectronicDevice theDevice;

    /**
     * Instantiates a new Turn tv on.
     *
     * @param newDevice the new device
     */
    TurnTVOn(ElectronicDevice newDevice){
        theDevice = newDevice;
    }

    /**
     * Method to turn on a Electronic Device
     */
    public void execute() {
        theDevice.on();
    }

    /**
     * Method to turn off a Electronic Device
     */
    public void undo() {
        theDevice.off();
    }
}