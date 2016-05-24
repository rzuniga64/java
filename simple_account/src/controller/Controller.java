package controller;


import model.Model;
import view.AccountView;
import view.MainMenuView;

/**
 * The interface Controller.
 */
public interface Controller {
    /**
     * Gets model.
     *
     * @return the model
     */
    Model getModel();

    /**
     * Sets model.
     *
     * @param model the model
     */
    void setModel(Model model);

    /**
     * Gets main menu view.
     *
     * @return the main menu view
     */
    MainMenuView getMainMenuView();

    /**
     * Sets main menu view.
     *
     * @param mainMenuView the main menu view
     */
    void setMainMenuView(MainMenuView mainMenuView);

    /**
     * Gets account view.
     *
     * @return the account view
     */
    AccountView getAccountView();

    /**
     * Sets account view.
     *
     * @param accountView the account view
     */
    void setAccountView(AccountView accountView);
}
