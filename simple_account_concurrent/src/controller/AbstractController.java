package controller;

import model.Model;
import view.*;

/**
 * The type Abstract simpleAccount.view.controller.
 */
public abstract class AbstractController implements Controller {
    private MainMenuView mainMenuView;
    private AccountView accountView;
    private DepositAgentView depositAgentView;
    private WithdrawalAgentView withdrawalAgentView;
    private DepositView depositView;
    private WithdrawalView withdrawalView;
    private Model model;

    public void setModel(Model model){this.model = model;}

    public Model getModel(){return model;}

    public MainMenuView getMainMenuView(){return mainMenuView;}

    public void setMainMenuView(MainMenuView mainMenuView){this.mainMenuView = mainMenuView;}

    public AccountView getAccountView(){return accountView;}

    public void setAccountView(AccountView accountView){this.accountView = accountView;}

    public DepositAgentView getDepositAgentView(){return depositAgentView;}

    public void setDepositAgentView(DepositAgentView depositAgentView){this.depositAgentView = depositAgentView;}

    public WithdrawalAgentView getWithdrawalAgentView(){
        return withdrawalAgentView;
    }

    public void setWithdrawalAgentView(WithdrawalAgentView withdrawalAgentView){this.withdrawalAgentView = withdrawalAgentView;}

    public DepositView getDepositView(){return depositView;}

    public void setDepositView(DepositView depositView){this.depositView = depositView;}

    public WithdrawalView getWithdrawalView(){return withdrawalView;}

    public void setWithdrawalView(WithdrawalView WithdrawalView){this.withdrawalView = withdrawalView;}
}
