package command;

/**
 * The type Radio.
 */
class Radio implements ElectronicDevice {

    private int volume = 0;

    /**
     * Method to turn a radio on
     */
    public void on() {

        System.out.println("Radio is on");
    }

    /**
     * Method to turn a radio off
     */
    public void off() {

        System.out.println("Radio is off");
    }

    /**
     * Method to turn the volume up on a radio
     */
    public void volumeUp() {
        volume++;
        System.out.println("Radio Volume is at: " + volume);
    }

    /**
     * Method to turn the volume down on a radio
     */
    public void volumenDown() {
        volume--;
        System.out.println("Radio Volume is at: " + volume);
    }
}
