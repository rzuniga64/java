package structural.facade;

/**
 *  A class to check the amount of cash in an account..
 */
class FundsCheck {

    private double cashInAccount = 1000.00;

    /**
     *  Get amount of cash in account
     *  @return the amount of cash in account.
     */
    private double getCashInAccount() {

        return cashInAccount;
    }

    /**
     *  Decrease the amount of cash in account by amount withdrawn.
     *  @param cashWithdrawn amount of cash to withdraw.
     */
    private void decreaseCashInAccount(double cashWithdrawn) {

        cashInAccount -= cashWithdrawn;
    }

    /**
     *  Increase the amount of cash in account by amount deposited.
     *  @param cashDeposited
     */
    private void increaseCashInAccount(double cashDeposited) {

        cashInAccount += cashDeposited;
    }

    /**
     *  Determine if there is enough cash in account to withdrawal.
     *  @param cashToWithdrawal the amount of cash to withdrawal.
     *  @return the boolean
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
     * @param cashToDeposit the cash to deposit
     */
    void makeDeposit(double cashToDeposit) {

        increaseCashInAccount(cashToDeposit);
        System.out.println("Deposit Complete: Current Balance is " + getCashInAccount());
    }
}
