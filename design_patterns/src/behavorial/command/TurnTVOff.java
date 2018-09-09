package behavorial.command;

/**
 * The type TurnTVOff.
 */
class TurnTVOff implements Command {

    private ElectronicDevice theDevice;

    /**
     *  Instantiates a new Turn tv off.
     *  @param newDevice the new device
     */
    TurnTVOff(ElectronicDevice newDevice){

        theDevice = newDevice;
    }

    /**
     *  Turn on a Electronic Device
     */
    public void execute() {

        theDevice.off();
    }

    /**
     *  Used if you want to allow for undo. Do the opposite of execute()
     */
    public void undo() {

        theDevice.on();
    }
}
