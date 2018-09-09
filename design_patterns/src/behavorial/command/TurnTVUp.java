package behavorial.command;

/**
 *  The type TurnTVUp.
 */
class TurnTVUp implements Command {

    private ElectronicDevice theDevice;

    /**
     *  Instantiates a new TurnTVUp.
     *  @param newDevice the new device
     */
    TurnTVUp(ElectronicDevice newDevice){

        theDevice = newDevice;
    }

    /**
     *  Turn the volume up on a Electronic Device
     */
    public void execute() {

        theDevice.volumeUp();
    }

    /**
     *  Turn down the volume on a Electronic Device
     */
    public void undo() {

        theDevice.volumenDown();
    }
}
