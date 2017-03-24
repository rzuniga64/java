package behavorial.command;

import java.util.List;

/**
 * The type Turn it all off.
 */
class TurnItAllOff implements Command {

    private List<ElectronicDevice> theDevices;

    /**
     * Instantiates a new Turn it all off.
     *
     * @param newDevices the new devices
     */
    TurnItAllOff(List<ElectronicDevice> newDevices) {
        theDevices = newDevices;
    }

    /**
     * Method to turn all devices on
     */
    public void execute() {

        for (ElectronicDevice device : theDevices)
            device.off();
    }

    /**
     * Method to shut all devices off.
     */
    public void undo() {

        for (ElectronicDevice device : theDevices)
            device.on();
    }
}
