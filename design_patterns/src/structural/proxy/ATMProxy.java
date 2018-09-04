package structural.proxy;

/**
 *  In this situation the structural.proxy both creates and destroys ATMMachine Objects.
 */
class ATMProxy implements GetATMData {

    /**
     *  Allows the user to access getATMState in the Object ATMMachine.
     *  @return ATMState
     */
    public ATMState getATMData() {

        ATMMachine realATMMachine = new ATMMachine();
        return realATMMachine.getATMData();
    }

    /**
     *  Allows the user to access getCashInMachine in the Object ATMMachine.
     *  @return the amount of cash in the ATM.
     */
    public int getCashInMachine() {

        ATMMachine realATMMachine = new ATMMachine();
        return realATMMachine.getCashInMachine();
    }
}