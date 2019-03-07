package behavorial.command;

import java.util.List;

/**
 * The type TurnItAllOff.
 */
class TurnItAllOff implements Command {

    private List<ElectronicDevice> theDevices;

    /**
     * Instantiates a new Turn it all off.
     * @param newDevices the new devices
     */
    TurnItAllOff(List<ElectronicDevice> newDevices) {

        theDevices = newDevices;
    }

    /**
     *  Turn all devices on.
     */
    public void execute() {

        for (ElectronicDevice device : theDevices) {

            device.off();
        }
    }

    /**
     *  Shut all devices off.
     */
    public void undo() {

        for (ElectronicDevice device : theDevices) {

            device.on();
        }
    }
}
