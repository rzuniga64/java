package behavorial.state;

/**
 *  The type NoCard. Implements a behavior associated with a state of the Context. When there is no card and the user
 *  enters a card.
 */
class NoCard implements ATMState {

    private ATMMachine atmMachine;

    /**
     *  Instantiates a new No card.
     *  @param newATMMachine the new atm machine.
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

        System.out.println("You have not entered your card.");
    }

    /**
     *  Request cash.
     *  @param cashToWithdraw the cash to withdraw.
     */
    public void requestCash(int cashToWithdraw) {

        System.out.println("You have not entered your card.");
    }

    /**
     *  Insert pin.
     *  @param pinEntered the pin entered.
     */
    public void insertPin(int pinEntered) {

        System.out.println("You have not entered your card.");
    }
}
