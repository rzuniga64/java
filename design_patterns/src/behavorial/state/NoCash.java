package behavorial.state;

/**
 * The type No cash.
 */
public class NoCash implements ATMState {

    private ATMMachine atmMachine;

    /**
     *  Instantiates a new No cash.
     *  @param newATMMachine the new atm machine
     */
    NoCash(ATMMachine newATMMachine){

        atmMachine = newATMMachine;
    }

    /**
     *  Insert card.
     */
    public void insertCard() {

        System.out.println("We don't have any money");
        System.out.println("Your card is ejected");
    }

    /**
     *  Insert eject card.
     */
    public void ejectCard() {

        System.out.println("We don't have any money");
        System.out.println("You didn't enter a card.");
    }


    /**
     *  Request cash.
     *  @param cashToWithdraw the cash to withdraw.
     */
    public void requestCash(int cashToWithdraw) {

        System.out.println("We don't have any money");
    }

    /**
     *  Insert pin.
     *  @param pinEntered the pin entered.
     */
    public void insertPin(int pinEntered) {

        System.out.println("We don't have any money");
    }
}