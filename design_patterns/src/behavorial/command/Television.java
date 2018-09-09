package behavorial.command;

/**
 * The type Television.
 */
class Television implements ElectronicDevice {

    private int volume = 0;

    /**
     * Turns the television device on.
     */
    public void on() {

        System.out.println("TV is on");
    }

    /**
     * Turns the television device off.
     */
    public void off() {

        System.out.println("TV is off");
    }

    /**
     * Turns the volume up on the television.
     */
    public void volumeUp() {

        volume++;
        System.out.println("TV Volume is at: " + volume);
    }

    /**
     * Turns the volume down on the television.
     */
    public void volumenDown() {

        volume--;
        System.out.println("TV Volume is at: " + volume);
    }
}