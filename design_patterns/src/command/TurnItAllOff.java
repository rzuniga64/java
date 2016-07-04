package command;

import java.util.List;

class TurnItAllOff implements Command {

    private List<ElectronicDevice> theDevices;

    TurnItAllOff(List<ElectronicDevice> newDevices) {
        theDevices = newDevices;
    }

    public void execute() {

        for (ElectronicDevice device : theDevices)
            device.off();
    }

    public void undo() {

        for (ElectronicDevice device : theDevices)
            device.on();
    }
}
