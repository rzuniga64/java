package structural.bridge;

// Implementor
// With the Bridge Design Pattern you create 2 layers of abstraction. In this example I'll have an abstract class
// representing different types of devices. I also have an abstract class that will represent different types of remote
// controls. This allows me to use an infinite variety of devices and remotes

abstract class EntertainmentDevice {

    int deviceState; // current channel devices is on or current chapter if dvd
    int maxSetting;  // max channel number possible or max chapter
    private int volumeLevel = 0; // volume setting

    public abstract void buttonFivePressed();
    public abstract void buttonSixPressed();
    void deviceFeedback() {

        if(deviceState > maxSetting || deviceState < 0) { deviceState = 0; }
        System.out.println("On Channel " + deviceState);
    }

    public void buttonSevenPressed() {

        volumeLevel++;
        System.out.println("Volume at: " + volumeLevel);
    }

    public void buttonEightPressed() {

        volumeLevel--;
        System.out.println("Volume at: " + volumeLevel);
    }
}