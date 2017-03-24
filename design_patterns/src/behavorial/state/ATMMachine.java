package behavorial.state;

/**
 * The type Atm machine (Context).
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

        if(cashInMachine < 0)
            atmState = atmOutOfMoney;
    }

    /**
     * Set atm behavorial.state.
     *
     * @param newATMState the new atm behavorial.state
     */
    void setATMState(ATMState newATMState){

        atmState = newATMState;
    }

    /**
     * Set cash in machine.
     *
     * @param newCashInMachine the new cash in machine
     */
    void setCashInMachine(int newCashInMachine){

        cashInMachine = newCashInMachine;
    }

    /**
     * Insert card.
     */
    public void insertCard() {

        atmState.insertCard();
    }

    /**
     * Eject card.
     */
    public void ejectCard() {

        atmState.ejectCard();
    }

    /**
     * Request cash.
     *
     * @param cashToWithdraw the cash to withdraw
     */
    public void requestCash(int cashToWithdraw) {

        atmState.requestCash(cashToWithdraw);
    }

    /**
     * Insert pin.
     *
     * @param pinEntered the pin entered
     */
    public void insertPin(int pinEntered){

        atmState.insertPin(pinEntered);
    }

    /**
     * Gets yes card behavorial.state.
     *
     * @return the yes card behavorial.state
     */
    ATMState getYesCardState() { return hasCard; }

    /**
     * Gets no card behavorial.state.
     *
     * @return the no card behavorial.state
     */
    ATMState getNoCardState() { return noCard; }

    /**
     * Gets has pin.
     *
     * @return the has pin
     */
    ATMState getHasPin() { return hasCorrectPin; }

    /**
     * Gets no cash behavorial.state.
     *
     * @return the no cash behavorial.state
     */
    ATMState getNoCashState() { return atmOutOfMoney; }
}
