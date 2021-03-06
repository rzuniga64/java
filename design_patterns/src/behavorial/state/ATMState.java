package behavorial.state;

/**
 *  The interface ATMState. Defines an interface for encapsulating the behavior associated with a particular state of
 *  the Context. Different states expected: HasCard, NoCard, HasPin, NoCash
 */
public interface ATMState {

    /**
     *  Insert card.
     */
    void insertCard();

    /**
     *  Eject card.
     */
    void ejectCard();

    /**
     *  Insert pin.
     *  @param pinEntered the pin entered.
     */
    void insertPin(int pinEntered);

    /**
     *  Request cash.
     *  @param cashToWithdraw the cash to withdraw.
     */
    void requestCash(int cashToWithdraw);
}
