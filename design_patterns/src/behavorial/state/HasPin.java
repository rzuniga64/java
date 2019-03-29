package behavorial.state;

/**
 * The type HasPin. Implements a behavior associated with a state of the Context.
 */
class HasPin implements ATMState {

    private ATMMachine atmMachine;

    /**
     *  Instantiates a new Has pin.
     *  @param newATMMachine the new atm machine.
     */
    HasPin(ATMMachine newATMMachine){

        atmMachine = newATMMachine;
    }

    /**
     *  Insert card.
     */
    public void insertCard() {

        System.out.println("You can't enter more than one card.");
    }

    /**
     *  Eject card.
     */
    public void ejectCard() {

        System.out.println("Your card is ejected");
        atmMachine.setATMState(atmMachine.getNoCardState());
    }

    /**
     * Insert pin.
     * @param pinEntered the pin entered.
     */
    public void insertPin(int pinEntered) {

        System.out.println("You already entered a PIN");
    }

    /**
     *  Request cash.
     *  @param cashToWithdraw the cash to withdraw.
     */
    @SuppressWarnings("Duplicates")
    public void requestCash(int cashToWithdraw) {

        if (cashToWithdraw > atmMachine.cashInMachine) {

            System.out.println("Don't have that much cash available");
            System.out.println("Your card is ejected");
            atmMachine.setATMState(atmMachine.getNoCardState());

        } else {
            System.out.println(cashToWithdraw + " is provided by the machine");
            atmMachine.setCashInMachine(atmMachine.cashInMachine - cashToWithdraw);

            System.out.println("Your card is ejected");
            atmMachine.setATMState(atmMachine.getNoCardState());

            if(atmMachine.cashInMachine <= 0) {
                atmMachine.setATMState(atmMachine.getNoCashState());
            }
        }
    }
}
