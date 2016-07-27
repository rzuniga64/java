package state;

/**
 * The interface Atm state.
 */
public interface ATMState {

    // Different states expected
    // HasCard, NoCard, HasPin, NoCash

    /**
     * Insert card.
     */
    void insertCard();

    /**
     * Eject card.
     */
    void ejectCard();

    /**
     * Insert pin.
     *
     * @param pinEntered the pin entered
     */
    void insertPin(int pinEntered);

    /**
     * Request cash.
     *
     * @param cashToWithdraw the cash to withdraw
     */
    void requestCash(int cashToWithdraw);
}
