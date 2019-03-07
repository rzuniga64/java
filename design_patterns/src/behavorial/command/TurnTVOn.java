package behavorial.command;

/**
 *  The type TurnTVOn.
 */
class TurnTVOn implements Command {

    private ElectronicDevice theDevice;

    /**
     *  Instantiates a new TurnTVOn.
     *  @param newDevice the new device
     */
    TurnTVOn(ElectronicDevice newDevice){

        theDevice = newDevice;
    }

    /**
     *  Turn on a Electronic Device
     */
    public void execute() {

        theDevice.on();
    }

    /**
     *  Turn off a Electronic Device
     */
    public void undo() {

        theDevice.off();
    }
}