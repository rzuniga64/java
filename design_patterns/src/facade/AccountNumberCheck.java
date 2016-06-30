package facade;

class AccountNumberCheck{

    private int accountNumber = 12345678;

    private int getAccountNumber() { return accountNumber; }

    boolean accountActive(int acctNumToCheck){

        return (acctNumToCheck == getAccountNumber());
    }
}