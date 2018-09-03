package structural.facade;

/**
 *  The Facade Design Pattern decouples or separates the client from all of the sub components.
 *  The Facades aim is to simplify interfaces so you don't have to worry about what is going on under the hood.
 */
class BankAccountFacade {

    private int accountNumber;
    private int securityCode;

    private AccountNumberCheck acctChecker;
    private SecurityCodeCheck codeChecker;
    private FundsCheck fundChecker;
    private WelcomeToBank bankWelcome;

    /**
     * Instantiates a new Bank account structural.facade.
     * @param newAcctNum the new acct num
     * @param newSecCode the new sec code
     */
    BankAccountFacade(int newAcctNum, int newSecCode){

        accountNumber = newAcctNum;
        securityCode = newSecCode;

        bankWelcome = new WelcomeToBank();
        acctChecker = new AccountNumberCheck();
        codeChecker = new SecurityCodeCheck();
        fundChecker = new FundsCheck();
    }

    /**
     *  Get the account number.
     *  @return the account number.
     */
    private int getAccountNumber() {

        return accountNumber;
    }

    /**
     *  get the security code.
     *  @return the security code.
     */
    private int getSecurityCode() {

        return securityCode;
    }

    /**
     *  Withdraw cash.
     *  @param cashToGet the amount of cash to withdrawal.
     */
    void withdrawCash(double cashToGet) {

        if(acctChecker.accountActive(getAccountNumber()) &&
                codeChecker.isCodeCorrect(getSecurityCode()) &&
                fundChecker.haveEnoughMoney(cashToGet)
        ) {
            System.out.println("Transaction Complete\n");
        } else {

            System.out.println("Transaction Failed\n");
        }
    }

    /**
     *  Deposit cash.
     *  @param cashToDeposit the amount of cash to deposit.
     */
    void depositCash(double cashToDeposit) {

        if(acctChecker.accountActive(getAccountNumber()) &&
                codeChecker.isCodeCorrect(getSecurityCode())
        ) {
            fundChecker.makeDeposit(cashToDeposit);
            System.out.println("Transaction Complete\n");
        } else {
            System.out.println("Transaction Failed\n");
        }
    }
}