package bridge;

// Abstraction
// This is an abstract class that will represent numerous ways to work with each device

abstract class RemoteButton{

    // A reference to a generic device using aggregation
    private EntertainmentDevice theDevice;

    RemoteButton(EntertainmentDevice newDevice){

        theDevice = newDevice;
    }

    void buttonFivePressed() {

        theDevice.buttonFivePressed();
    }

    void buttonSixPressed() {

        theDevice.buttonSixPressed();
    }

    void deviceFeedback(){

        theDevice.deviceFeedback();
    }

    public abstract void buttonNinePressed();
}