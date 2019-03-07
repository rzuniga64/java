package behavorial.state;

/**
 * The type NoCard.
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

        System.out.println("ou have not entered your card.");
    }

    /**
     *  Reqeust cash.
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
