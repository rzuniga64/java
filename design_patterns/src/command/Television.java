package command;

/**
 * The type Television.
 */
class Television implements ElectronicDevice {

    private int volume = 0;

    /**
     *  Method to turn television on
     */
    public void on() {

        System.out.println("TV is on");
    }

    /**
     *  Method to turn television off
     */
    public void off() {

        System.out.println("TV is off");
    }

    /**
     *  Method to turn television volume up
     */
    public void volumeUp() {

        volume++;
        System.out.println("TV Volume is at: " + volume);
    }

    /**
     *  Method to turn television volume down
     */
    public void volumenDown() {

        volume--;
        System.out.println("TV Volume is at: " + volume);
    }
}