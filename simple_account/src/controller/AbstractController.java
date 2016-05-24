package controller;

import model.Model;
import view.AccountView;
import view.MainMenuView;

/**
 * The type Abstract controller.
 */
public abstract class AbstractController implements Controller {
    private MainMenuView mainMenuView;
    private AccountView accountView;
    private Model model;

    public void setModel(Model model){this.model = model;}

    public Model getModel(){return model;}

    public MainMenuView getMainMenuView(){return mainMenuView;}

    public void setMainMenuView(MainMenuView mainMenuView){this.mainMenuView = mainMenuView;}

    public AccountView getAccountView(){return accountView;}

    public void setAccountView(AccountView accountView){this.accountView = accountView;}
}
