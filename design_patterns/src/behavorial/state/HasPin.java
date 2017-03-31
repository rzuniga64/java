package behavorial.state;

/**
 * The type Has pin.
 */
class HasPin implements ATMState {

    private ATMMachine atmMachine;

    /**
     * Instantiates a new Has pin.
     *
     * @param newATMMachine the new atm machine
     */
    HasPin(ATMMachine newATMMachine){

        atmMachine = newATMMachine;
    }
    /**
     * Eject card.
     */
    public void insertCard() {

        System.out.println("You already entered a card");
    }
    /**
     * Eject card.
     */
    public void ejectCard() {

        System.out.println("Your card is ejected");
        atmMachine.setATMState(atmMachine.getNoCardState());
    }

    /**
     * Insert pin.
     */
    public void insertPin(int pinEntered) {

        System.out.println("You already entered a PIN");
    }

    /**
     * Request cash.
     */
    public void requestCash(int cashToWithdraw) {

        if(cashToWithdraw > atmMachine.cashInMachine){
            System.out.println("Don't have that much cash available");
            System.out.println("Your card is ejected");
            atmMachine.setATMState(atmMachine.getNoCardState());

        } else {
            System.out.println(cashToWithdraw + " is provided by the machine");
            atmMachine.setCashInMachine(atmMachine.cashInMachine - cashToWithdraw);

            System.out.println("Your card is ejected");
            atmMachine.setATMState(atmMachine.getNoCardState());

            if(atmMachine.cashInMachine <= 0){
                atmMachine.setATMState(atmMachine.getNoCashState());
            }
        }
    }
}