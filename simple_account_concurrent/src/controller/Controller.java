package controller;


import model.Model;
import view.AccountView;
import view.DepositAgentView;
import view.MainMenuView;
import view.WithdrawalAgentView;
import view.DepositView;
import view.WithdrawalView;

/**
 * The interface Controller.
 */
public interface Controller {
    /**
     * Gets simpleAccount.view.model.
     *
     * @return the simpleAccount.view.model
     */
    Model getModel();

    /**
     * Sets simpleAccount.view.model.
     *
     * @param model the simpleAccount.view.model
     */
    void setModel(Model model);

    /**
     * Gets main menu simpleAccount.view.
     *
     * @return the main menu simpleAccount.view
     */
    MainMenuView getMainMenuView();

    /**
     * Sets main menu simpleAccount.view.
     *
     * @param mainMenuView the main menu simpleAccount.view
     */
    void setMainMenuView(MainMenuView mainMenuView);

    /**
     * Gets account simpleAccount.view.
     *
     * @return the account simpleAccount.view
     */
    AccountView getAccountView();

    /**
     * Sets account simpleAccount.view.
     *
     * @param accountView the account simpleAccount.view
     */
    void setAccountView(AccountView accountView);

    /**
     * Gets view simpleAccount.DepositAgentView.
     *
     * @return the view simpleAccount.DepositAgentView
     */
    DepositAgentView getDepositAgentView();

    /**
     * Sets account simpleAccount.DepositAgentView.
     *
     * @param depositAgentView the view simpleAccount.DepositAgentView
     */
    void setDepositAgentView(DepositAgentView depositAgentView);

    /**
     * Gets view simpleAccount.DepositAgentView.
     *
     * @return the view simpleAccount.DepositAgentView
     */
    WithdrawalAgentView getWithdrawalAgentView();

    /**
     * Sets account simpleAccount.DepositAgentView.
     *
     */
    void setWithdrawalAgentView(WithdrawalAgentView withdrawalAgentView);

    /**
     * Gets view simpleAccount.DepositAgentView.
     *
     * @return the view simpleAccount.DepositAgentView
     */
    DepositView getDepositView();

    /**
     * Sets account simpleAccount.DepositAgentView.
     *
     * @param depositView the view simpleAccount.DepositAgentView
     */
    void setDepositView(DepositView depositView);

    /**
     * Sets view simpleAccount.WithdrawalView.
     *
     * @return the view simpleAccount.WithdrawalView
     */
    WithdrawalView getWithdrawalView();

    /**
     * Sets account simpleAccount.WithdrawalView.
     *
     */
    void setWithdrawalView(WithdrawalView withdrawalView);
}
