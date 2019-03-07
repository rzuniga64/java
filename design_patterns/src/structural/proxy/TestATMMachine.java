package structural.proxy;

public class TestATMMachine {

    public static void main(String[] args){

        ATMMachine atmMachine = new ATMMachine();

        atmMachine.insertCard();
        atmMachine.ejectCard();
        atmMachine.insertCard();
        atmMachine.insertPin(1234);
        atmMachine.requestCash(2000);
        atmMachine.insertCard();
        atmMachine.insertPin(1234);

        // The interface limits access to just the methods you want made accessible
        GetATMData realATMMachine = new ATMMachine();
        GetATMData atmProxy = new ATMProxy();
        System.out.println("\nCurrent ATM State " + atmProxy.getATMData());
        System.out.println("\nCash in ATM Machine $" + atmProxy.getCashInMachine());

        // The user can't perform this action because ATMProxy doesn't have access to that potentially harmful method.
        // atmProxy.setCashInMachine(10000);
    }
}