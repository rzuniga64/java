package structural.facade;

/**
 *  A class to check security code.
 */
class SecurityCodeCheck {

    private int securityCode = 1234;

    /**
     *  Get the security code.
     *  @return the security code.
     */
    private int getSecurityCode() {

        return securityCode;
    }

    /**
     *  Determine if security code is correct.
     *  @param secCodeToCheck the sec code to check
     *  @return the boolean
     */
    boolean isCodeCorrect(int secCodeToCheck){

        return (secCodeToCheck == getSecurityCode());
    }
}