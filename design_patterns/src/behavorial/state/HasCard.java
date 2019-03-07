package behavorial.state;

/**
 * The type HasCard.
 */
class HasCard implements ATMState {

    private ATMMachine atmMachine;

    /**
     *  Instantiates a new Has card.
     *  @param newATMMachine the new atm machine.
     */
    HasCard(ATMMachine newATMMachine){

        atmMachine = newATMMachine;
    }

    /**
     *  Insert card.
     */
    public void insertCard() {

        System.out.println("You can only insert one card at a time");
    }

    /**
     *  Eject card.
     */
    public void ejectCard() {

        System.out.println("Your card is ejected");
        atmMachine.setATMState(atmMachine.getNoCardState());
    }

    /**
     *  Request cash.
     *  @param cashToWithdraw the cash to withdraw.
     */
    public void requestCash(int cashToWithdraw) {

        System.out.println("You have not entered your PIN");
    }

    /**
     *  Insert pin.
     *  @param pinEntered the pin entered
     */
    public void insertPin(int pinEntered) {

        if (pinEntered == 1234) {

            System.out.println("You entered the correct PIN");
            atmMachine.correctPinEntered = true;
            atmMachine.setATMState(atmMachine.getHasPin());
        } else {
            System.out.println("You entered the wrong PIN");
            atmMachine.correctPinEntered = false;
            System.out.println("Your card is ejected");
            atmMachine.setATMState(atmMachine.getNoCardState());
        }
    }
}
