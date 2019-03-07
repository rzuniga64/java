package behavorial.command;

/**
 * The type Radio.
 */
class Radio implements ElectronicDevice {

    private int volume = 0;

    /**
     * Turns the radio device on.
     */
    public void on() {

        System.out.println("Radio is on");
    }

    /**
     * Turns the radio device off.
     */
    public void off() {

        System.out.println("Radio is off");
    }

    /**
     * Turns the volume up on the radio.
     */
    public void volumeUp() {

        volume++;
        System.out.println("Radio Volume is at: " + volume);
    }

    /**
     * Turns the volume down on the radio.
     */
    public void volumenDown() {

        volume--;
        System.out.println("Radio Volume is at: " + volume);
    }
}
