package structural.proxy;

// In this situation the structural.proxy both creates and destroys an ATMMachine Object
class ATMProxy implements GetATMData {

    // Allows the user to access getATMState in the Object ATMMachine
    public ATMState getATMState() {

        ATMMachine realATMMachine = new ATMMachine();
        return realATMMachine.getATMState();
    }

    // Allows the user to access getCashInMachine in the Object ATMMachine
    public int getCashInMachine() {

        ATMMachine realATMMachine = new ATMMachine();
        return realATMMachine.getCashInMachine();
    }
}