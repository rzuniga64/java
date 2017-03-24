package behavorial.command;

/**
 * The type Tv remote.
 */
class TVRemote {

    /**
     * Get device electronic device.
     *
     * @return the electronic device you want to use
     */
    static ElectronicDevice getDevice(){
        return new Television();
    }
}
