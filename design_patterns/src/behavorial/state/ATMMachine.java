package behavorial.state;

/**
 *  The type ATM machine. Context(Account).  Maintains an instance of a Concrete State subclass that defines the current
 *  state.
 */
public class ATMMachine {

    private ATMState hasCard;
    private ATMState noCard;
    private ATMState hasCorrectPin;
    private ATMState atmOutOfMoney;

    private ATMState atmState;

    int cashInMachine = 2000;
    boolean correctPinEntered = false;

    /**
     * Instantiates a new Atm machine.
     */
    public ATMMachine(){

        hasCard = new HasCard(this);
        noCard = new NoCard(this);
        hasCorrectPin = new HasPin(this);
        atmOutOfMoney = new NoCash(this);

        atmState = noCard;

        if (cashInMachine < 0) {
            atmState = atmOutOfMoney;
        }
    }

    /**
     *  Set ATM state.
     *  @param newATMState the new ATM state.
     */
    void setATMState(ATMState newATMState){

        atmState = newATMState;
    }

    /**
     *  Set cash in machine.
     *  @param newCashInMachine the new cash in machine
     */
    void setCashInMachine(int newCashInMachine){

        cashInMachine = newCashInMachine;
    }

    /**
     *  Insert card.
     */
    public void insertCard() {

        atmState.insertCard();
    }

    /**
     *  Eject card.
     */
    public void ejectCard() {

        atmState.ejectCard();
    }

    /**
     *  Request cash.
     *  @param cashToWithdraw the cash to withdraw.
     */
    public void requestCash(int cashToWithdraw) {

        atmState.requestCash(cashToWithdraw);
    }

    /**
     *  Insert pin.
     *  @param pinEntered the pin entered.
     */
    public void insertPin(int pinEntered){

        atmState.insertPin(pinEntered);
    }

    /**
     *  Determine if they have a card.
     *  @return the yes card state.
     */
    ATMState getYesCardState() {

        return hasCard;
    }

    /**
     *  Gets no card state.
     *  @return the no card state.
     */
    ATMState getNoCardState() {

        return noCard;
    }

    /**
     *  Gets has pin.
     *  @return the has pin.
     */
    ATMState getHasPin() {

        return hasCorrectPin;
    }

    /**
     *  Gets no cash state.
     *  @return the no cash state.
     */
    ATMState getNoCashState() {

        return atmOutOfMoney;
    }
}
