package structural.proxy;

/**
 *  Class determines the state of a card inserted into an ATM machine.
 */
class HasCard implements ATMState {

    private ATMMachine atmMachine;

    HasCard(ATMMachine newATMMachine){

        atmMachine = newATMMachine;
    }

    /**
     *  Determines if the client's card was inserted correctly.
     */
    public void insertCard() {

        System.out.println("You can only insert one card at a time");
    }

    /**
     *  Eject the client's card.
     */
    public void ejectCard() {

        System.out.println("Your card is ejected");
        atmMachine.setATMState(atmMachine.getNoCardState());
    }

    /**
     *  Determines if the user can withdrawal an amount of cash.
     *  @param cashToWithdraw
     */
    public void requestCash(int cashToWithdraw) {

        System.out.println("You have not entered your PIN");
    }

    /**
     *  Determines if the client's PIN number is inserted correctly.
     *  @param pinEntered
     */
    public void insertPin(int pinEntered) {

        if(pinEntered == 1234){
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
