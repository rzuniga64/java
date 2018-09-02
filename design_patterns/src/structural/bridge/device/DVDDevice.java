package structural.bridge.device;

/**
 *  Concrete Implementor
 *  Here is an implementation of the EntertainmentDevice abstract class. I'm specifying what makes it different from
 *  other devices
 */
class DVDDevice extends EntertainmentDevice {

    /**
     * Constructor.
     * @param newDeviceState new device state.
     * @param newMaxSetting new maximum setting.
     */
    DVDDevice(final int newDeviceState, final int newMaxSetting) {

        super.deviceState = newDeviceState;
        super.maxSetting = newMaxSetting;
    }

    /**
     *  Button five skips to previous chapter.
     */
    public void buttonFivePressed() {

        System.out.println("DVD Skips to Chapter");
        deviceState--;
    }

    /**
     *  Button six skips to next chapter.
     */
    public void buttonSixPressed() {

        System.out.println("DVD Skips to Next Chapter");
        deviceState++;
    }
}
