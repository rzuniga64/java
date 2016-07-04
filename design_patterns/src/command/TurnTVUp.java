package command;

class TurnTVUp implements Command {

    private ElectronicDevice theDevice;

    TurnTVUp(ElectronicDevice newDevice){
        theDevice = newDevice;
    }

    public void execute() {
        theDevice.volumeUp();
    }

    public void undo() {
        theDevice.volumenDown();
    }
}
