package facade;

class SecurityCodeCheck {

    private int securityCode = 1234;
    private int getSecurityCode() { return securityCode; }

    boolean isCodeCorrect(int secCodeToCheck){

        return (secCodeToCheck == getSecurityCode());
    }
}