package controller;

import model.AccountModel;
import view.AccountView;
import view.MainMenuView;

import java.util.Scanner;

/**
 * The type Account controller.
 */
public class AccountController extends AbstractController{
    private static AccountController firstInstance = null;

    /**
     * Gets instance.
     *
     * @return the instance
     */
// Make AccountController a singleton
    //public static AccountController getInstance(String filename) {
    public static AccountController getInstance() {
        if (firstInstance == null) {
            //firstInstance = new AccountController(filename);
            firstInstance = new AccountController();
        }
        return firstInstance;
    }

    /**
     * Instantiates a new Account controller.
     *
     */
    //public AccountController(String filename) {
    public AccountController() {
        //AccountModel.readAccountInputFile(filename);
        AccountModel.readAccountInputFile();
        AccountModel.accounts = AccountModel.readAccountInfo();
        setModel(new AccountModel());
        setMainMenuView(MainMenuView.getInstance((AccountModel)getModel(), this));
        (getMainMenuView()).setVisible(true);
    }

    /**
     * Operation.
     *
     * @param option       the option
     * @param id           the id
     * @param amount       the amount
     * @param exchangeRate the exchange rate
     */
    public void operation(String option, String id, double amount, double exchangeRate){

            if (option.equalsIgnoreCase(AccountView.DEPOSIT)) {
                if (exchangeRate == MainMenuView.USD)
                    ((AccountModel) getModel()).deposit(id, amount);
                else if (exchangeRate == MainMenuView.EURO)
                    ((AccountModel) getModel()).deposit(id, amount / exchangeRate);
                else if (exchangeRate == MainMenuView.YUAN)
                    ((AccountModel) getModel()).deposit(id, amount / exchangeRate);
            } else if (option.equalsIgnoreCase(AccountView.WITHDRAWAL)) {
                try {
                if (exchangeRate == MainMenuView.USD)
                    ((AccountModel) getModel()).withdrawal(id, amount);
                else if (exchangeRate == MainMenuView.EURO)
                    ((AccountModel) getModel()).withdrawal(id, amount / exchangeRate);
                else if (exchangeRate == MainMenuView.YUAN)
                    ((AccountModel) getModel()).withdrawal(id, amount / exchangeRate);
                } catch (IllegalArgumentException e) {
                    (getMainMenuView()).displayErrorMessage(e.getMessage());
                }
            }
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        //System.out.println("Enter a filename (Should be  'src\\\\simpleAccount\\\\model\\\\accounts.txt'): ");
        //Scanner input = new Scanner(System.in);
        //String filename = input.nextLine();
        //AccountController.getInstance(filename);
        AccountController.getInstance();
    }
}
