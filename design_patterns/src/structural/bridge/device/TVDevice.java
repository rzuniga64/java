package structural.bridge.device;

/**
 *  Concrete Implementor
 *  Here is an implementation of the EntertainmentDevice abstract class. I'm
 *  specifying what makes it different from other devices.
 */
class TVDevice extends EntertainmentDevice {

    /**
     * Constructor.
     * @param newDeviceState new device state.
     * @param newMaxSetting new maximum setting.
     */
    TVDevice(final int newDeviceState, final int newMaxSetting) {

        deviceState = newDeviceState;
        maxSetting = newMaxSetting;
    }

    /** Button five lowers the channel number. */
    public void buttonFivePressed() {

        System.out.println("Channel Down");
        deviceState--;
    }

    /** Button six increases the channel number. */
    public void buttonSixPressed() {

        System.out.println("Channel Up");
        deviceState++;
    }
}
