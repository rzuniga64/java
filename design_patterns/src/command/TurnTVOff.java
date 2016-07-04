package command;

class TurnTVOff implements Command {

    private ElectronicDevice theDevice;

    TurnTVOff(ElectronicDevice newDevice){
        theDevice = newDevice;
    }

    public void execute() {
        theDevice.off();
    }

    // Used if you want to allow for undo. Do the opposite of execute()
    public void undo() {
        theDevice.on();
    }
}
