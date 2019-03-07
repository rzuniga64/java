package structural.facade;

/**
 *  A class to check account number.
 */
class AccountNumberCheck{

    private int accountNumber = 12345678;

    /**
     *  Get account number
     *  @return the account number.
     */
    private int getAccountNumber() {

        return accountNumber;
    }

    /**
     *  Determine if account is active.
     *  @param acctNumToCheck the acct num to check
     *  @return the boolean
     */
    boolean accountActive(int acctNumToCheck){

        return (acctNumToCheck == getAccountNumber());
    }
}