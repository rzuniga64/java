package facade;

/**
 * The type Funds check.
 */
class FundsCheck {

    private double cashInAccount = 1000.00;

    private double getCashInAccount() {

        return cashInAccount;
    }

    private void decreaseCashInAccount(double cashWithdrawn) {

        cashInAccount -= cashWithdrawn;
    }

    private void increaseCashInAccount(double cashDeposited) {

        cashInAccount += cashDeposited;
    }

    /**
     * Have enough money boolean.
     *
     * @param cashToWithdrawal the cash to withdrawal
     * @return the boolean
     */
    boolean haveEnoughMoney(double cashToWithdrawal) {

        if(cashToWithdrawal > getCashInAccount()) {

            System.out.println("Error: You don't have enough money");
            System.out.println("Current Balance: " + getCashInAccount());

            return false;
        } else {
            decreaseCashInAccount(cashToWithdrawal);
            System.out.println("Withdrawal Complete: Current Balance is " + getCashInAccount());

            return true;
        }
    }

    /**
     * Make deposit.
     *
     * @param cashToDeposit the cash to deposit
     */
    void makeDeposit(double cashToDeposit) {

        increaseCashInAccount(cashToDeposit);
        System.out.println("Deposit Complete: Current Balance is " + getCashInAccount());
    }
}
