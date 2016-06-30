package proxy;

public class ATMMachine implements GetATMData{

    private ATMState hasCard;
    private ATMState noCard;
    private ATMState hasCorrectPin;
    private ATMState atmOutOfMoney;
    private ATMState atmState;

    int cashInMachine = 2000;
    boolean correctPinEntered = false;

    public ATMMachine(){

        hasCard = new HasCard(this);
        noCard = new NoCard(this);
        hasCorrectPin = new HasPin(this);
        atmOutOfMoney = new NoCash(this);

        atmState = noCard;

        if(cashInMachine < 0)
            atmState = atmOutOfMoney;
    }

    void setATMState(ATMState newATMState){ atmState = newATMState; }
    void setCashInMachine(int newCashInMachine){ cashInMachine = newCashInMachine; }

    public void insertCard() { atmState.insertCard(); }
    public void ejectCard() { atmState.ejectCard(); }
    public void requestCash(int cashToWithdraw) {  atmState.requestCash(cashToWithdraw); }
    public void insertPin(int pinEntered){ atmState.insertPin(pinEntered); }

    ATMState getYesCardState() { return hasCard; }
    ATMState getNoCardState() { return noCard; }
    ATMState getHasPin() { return hasCorrectPin; }
    ATMState getNoCashState() { return atmOutOfMoney; }

    // NEW STUFF
    public ATMState getATMState() { return atmState; }
    public int getCashInMachine() { return cashInMachine; }
}