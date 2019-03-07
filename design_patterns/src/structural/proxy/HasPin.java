package structural.proxy;

/**
 *  Class determines the state of a PIN typed into an ATM machine.
 */
public class HasPin implements ATMState {

    ATMMachine atmMachine;

    public HasPin(ATMMachine newATMMachine){

        atmMachine = newATMMachine;
    }

    /**
     *  Determines if the client's card was inserted correctly.
     */
    public void insertCard() {

        System.out.println("You already entered a card");
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

        if(cashToWithdraw > atmMachine.cashInMachine){
            System.out.println("You don't have that much cash available");
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

    /**
     *  Determines if the client's PIN number is inserted correctly.
     *  @param pinEntered
     */
    public void insertPin(int pinEntered) {

        System.out.println("You already entered a PIN");
    }
}
