package behavorial.state;

/**
 * The type No card.
 */
class NoCard implements ATMState {

    private ATMMachine atmMachine;

    /**
     * Instantiates a new No card.
     *
     * @param newATMMachine the new atm machine
     */
    NoCard(ATMMachine newATMMachine){

        atmMachine = newATMMachine;
    }

    /**
     * Insert card.
     */
    public void insertCard() {

        System.out.println("Please enter your pin");
        atmMachine.setATMState(atmMachine.getYesCardState());
    }

    /**
     *  Eject card.
     */
    public void ejectCard() {

        System.out.println("You didn't enter a card");
    }

    /**
     *  Request cash.
     */
    public void requestCash(int cashToWithdraw) {

        System.out.println("You have not entered your card");
    }

    /**
     *  Insert pin.
     */
    public void insertPin(int pinEntered) {

        System.out.println("You have not entered your card");
    }
}
