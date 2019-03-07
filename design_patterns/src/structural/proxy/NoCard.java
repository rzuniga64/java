package structural.proxy;

/**
 *  Class determines if no card is inserted into an ATM machine.
 */
class NoCard implements ATMState {

    private ATMMachine atmMachine;

    NoCard(ATMMachine newATMMachine){

        atmMachine = newATMMachine;
    }

    /**
     *  Determines if the client's card was inserted correctly.
     */
    public void insertCard() {

        System.out.println("Please enter your pin");
        atmMachine.setATMState(atmMachine.getYesCardState());
    }

    /**
     *  Eject the client's card.
     */
    public void ejectCard() {

        System.out.println("You didn't enter a card");
    }

    /**
     *  Determines if the user can withdrawal an amount of cash.
     *  @param cashToWithdraw
     */
    public void requestCash(int cashToWithdraw) {

        System.out.println("You have not entered your card");
    }

    /**
     *  Determines if the client's PIN number is inserted correctly.
     *  @param pinEntered
     */
    public void insertPin(int pinEntered) {

        System.out.println("You have not entered your card");
    }
}
