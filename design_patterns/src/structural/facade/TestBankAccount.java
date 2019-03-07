package structural.facade;

/**
 *  Test bank account.
 */
public class TestBankAccount {

    /**
     *  Unit tests.
     *  @param args the args
     */
    public static void main(String[] args){

        BankAccountFacade accessingBank = new BankAccountFacade(12345678, 1234);
        accessingBank.withdrawCash(50.00);
        accessingBank.withdrawCash(990.00);
        accessingBank.depositCash(200.00);
    }
}