package structural.bridge;

// Refined Abstraction
// If I decide I want to further extend the remote I can

class TVRemotePause extends RemoteButton{

    TVRemotePause(EntertainmentDevice newDevice) {

        super(newDevice);
    }

    public void buttonNinePressed() {

        System.out.println("TV was Paused");
    }
}