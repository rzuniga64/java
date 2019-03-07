package behavorial.command;

/**
 * The interface Electronic device.
 */
public interface ElectronicDevice {

    /**
     * Turns the electronic device on.
     */
    void on();

    /**
     * Turns the electronic device off.
     */
    void off();

    /**
     * Turns the volume up on the electronic device.
     */
    void volumeUp();

    /**
     * Turns the volume down on the electronic device.
     */
    void volumenDown();
}