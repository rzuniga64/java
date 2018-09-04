package structural.proxy;

/**
 *  Class determines if no cash is in an ATM machine.
 */
public class NoCash implements ATMState {

    ATMMachine atmMachine;

    public NoCash(ATMMachine newATMMachine){

        atmMachine = newATMMachine;
    }

    /**
     *  Determines if the client's card was inserted correctly.
     */
    public void insertCard() {

        System.out.println("We don't have any money");
        System.out.println("Your card is ejected");
    }

    /**
     *  Eject the client's card.
     */
    public void ejectCard() {

        System.out.println("We don't have any money");
        System.out.println("There is no card to eject");
    }

    /**
     *  Determines if the user can withdrawal an amount of cash.
     *  @param cashToWithdraw
     */
    public void requestCash(int cashToWithdraw) {

        System.out.println("We don't have any money");
    }

    /**
     *  Determines if the client's PIN number is inserted correctly.
     *  @param pinEntered
     */
    public void insertPin(int pinEntered) {

        System.out.println("We don't have any money");
    }
}