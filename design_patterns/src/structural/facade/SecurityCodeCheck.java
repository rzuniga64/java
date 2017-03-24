package structural.facade;

/**
 * The type Security code check.
 */
class SecurityCodeCheck {

    private int securityCode = 1234;
    private int getSecurityCode() { return securityCode; }

    /**
     * Is code correct boolean.
     *
     * @param secCodeToCheck the sec code to check
     * @return the boolean
     */
    boolean isCodeCorrect(int secCodeToCheck){

        return (secCodeToCheck == getSecurityCode());
    }
}