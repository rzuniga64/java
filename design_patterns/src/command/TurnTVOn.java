package command;

class TurnTVOn implements Command {

    private ElectronicDevice theDevice;

    TurnTVOn(ElectronicDevice newDevice){
        theDevice = newDevice;
    }

    public void execute() {
        theDevice.on();
    }

    public void undo() {
        theDevice.off();
    }
}