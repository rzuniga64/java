package facade;

/**
 * The type Account number check.
 */
class AccountNumberCheck{

    private int accountNumber = 12345678;

    private int getAccountNumber() { return accountNumber; }

    /**
     * Account active boolean.
     *
     * @param acctNumToCheck the acct num to check
     * @return the boolean
     */
    boolean accountActive(int acctNumToCheck){

        return (acctNumToCheck == getAccountNumber());
    }
}