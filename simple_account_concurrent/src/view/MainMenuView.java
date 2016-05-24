package view;

import controller.AccountController;
import model.AccountModel;
import model.ModelEvent;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

/**
 * The type Main menu view.
 */
public class MainMenuView extends JFrameView {
    /**
     * The constant USD.
     */
    public final static double USD = 1.0;
    /**
     * The constant EURO.
     */
    public final static double EURO = 0.88;
    /**
     * The constant YUAN.
     */
    public final static double YUAN = 6.47;

    private static MainMenuView firstInstance = null;

    private JButton usdButton, euroButton, yuanButton, saveButton, exitButton;
    private JButton depositAgentButton, withdrawAgentButton;
    private JList accountList;
    private DefaultListModel defListModel = new DefaultListModel();
    private JScrollPane scroller;
    private Box setBox, setBox2, setBox3, setBox4;
    private JPanel thePanel;
    private ArrayList<AccountModel> accounts;
    private String id;
    private String name;
    private double balance;

    /**
     * Gets instance.
     *
     * @param model      the model
     * @param controller the controller
     * @return the instance
     */
    public static MainMenuView getInstance(AccountModel model, AccountController controller) {
        if (firstInstance == null) {
            firstInstance = new MainMenuView(model, controller);
        }
        return firstInstance;
    }

    private MainMenuView(AccountModel model, AccountController controller) {
        super(model, controller);
        id = "";
        name = "";
        balance = 0.0;
        accounts = AccountModel.readAccountInfo();

        SaveHandler saveHandler = new SaveHandler();
        ExitHandler exitHandler = new ExitHandler(this);
        ListHandler listHandler = new ListHandler();
        CurrencyHandler currencyHandler = new CurrencyHandler();
        DepositAgentHandler depositAgentHandler = new DepositAgentHandler();
        WithdrawalAgentHandler withdrawalAgentHandler = new WithdrawalAgentHandler();
        this.setSize(600, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Main Menu");

		thePanel = new JPanel();     // Create a flow layout (Default)
		thePanel.setLayout(new GridBagLayout());

        setBox = Box.createVerticalBox();
        usdButton = new JButton("Edit in USD");
        usdButton.addActionListener(currencyHandler);
        euroButton = new JButton("Edit in Euros");
        euroButton.addActionListener(currencyHandler);
        yuanButton = new JButton("Edit in Yuan");
        yuanButton.addActionListener(currencyHandler);

        setBox.add(Box.createVerticalStrut(10));
        setBox.add(usdButton);
        setBox.add(Box.createHorizontalStrut(10));
        setBox.add(Box.createVerticalStrut(10));
        setBox.add(euroButton);
        setBox.add(Box.createHorizontalStrut(10));
        setBox.add(Box.createVerticalStrut(10));
        setBox.add(yuanButton);
        setBox.add(Box.createVerticalStrut(10));
        setBox.setBorder(BorderFactory.createEtchedBorder());
        addComp(thePanel, setBox, 0, 0, 2, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);

        // Load list of accounts into a DefaultListModel
        for (AccountModel account: accounts) {
            defListModel.addElement(account.getID() + " " + account.getName());
        }

        accountList = new JList(defListModel);   // Create a List box filled with items in the DefaultListModel
        accountList.setVisibleRowCount(3);       // Only display 1 items at a time
        accountList.setSelectedIndex(0);
        accountList.addListSelectionListener(listHandler);
        id = accounts.get(0).getID();
        name = accounts.get(0).getName();
        balance = accounts.get(0).getBalance();

        // Create a scroll bar panel to hold the list box
        scroller = new JScrollPane(accountList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        accountList.setFixedCellHeight(30);      // Define the height of each cell
        accountList.setFixedCellWidth(150);      // Define the width of each cell
        setBox4 = Box.createVerticalBox();
        setBox4.add(scroller);
        setBox4.add(Box.createVerticalStrut(75));
        

        setBox2 = Box.createHorizontalBox();
        saveButton = new JButton("Save");
        saveButton.addActionListener(saveHandler);
        exitButton = new JButton("Exit");
        exitButton.addActionListener(exitHandler);
        setBox2.add(Box.createHorizontalStrut(10));
        setBox2.add(Box.createVerticalStrut(10));
        setBox2.add(saveButton);
        setBox2.add(Box.createHorizontalStrut(10));
        setBox2.add(exitButton);
        setBox2.add(Box.createHorizontalStrut(10));
        setBox2.add(Box.createVerticalStrut(10));
        setBox2.setBorder(BorderFactory.createEtchedBorder());

        setBox3 = Box.createHorizontalBox();
        depositAgentButton = new JButton("Create Deposit Agent");
        depositAgentButton.addActionListener(depositAgentHandler);
        withdrawAgentButton = new JButton("Create Withdrawal Agent");
        withdrawAgentButton.addActionListener(withdrawalAgentHandler);
        setBox3.add(Box.createHorizontalStrut(10));
        setBox3.add(Box.createVerticalStrut(10));
        setBox3.add(depositAgentButton);
        setBox3.add(Box.createHorizontalStrut(10));
        setBox3.add(withdrawAgentButton);
        setBox3.add(Box.createHorizontalStrut(10));
        setBox3.add(Box.createVerticalStrut(10));
        setBox3.setBorder(BorderFactory.createEtchedBorder());

        setBox4.add(setBox3);
        setBox4.add(setBox2);
        addComp(thePanel, setBox4, 6, 0, 2, 1, GridBagConstraints.CENTER, GridBagConstraints.WEST);

        this.add(thePanel);
        this.setResizable(false);
    }

    private void addComp(JPanel thePanel, JComponent comp, int xPos, int yPos, int compWidth, int compHeight, int place, int stretch){
        GridBagConstraints gridConstraints = new GridBagConstraints();

        gridConstraints.gridx = xPos;
        gridConstraints.gridy = yPos;
        gridConstraints.gridwidth = compWidth;
        gridConstraints.gridheight = compHeight;
        gridConstraints.weightx = 100;
        gridConstraints.weighty = 100;
        gridConstraints.insets = new Insets(5,5,5,5);
        gridConstraints.anchor = place;
        gridConstraints.fill = stretch;

        thePanel.add(comp, gridConstraints);
    }

    // Now implement the necessary event handling code
    public void modelChanged(ModelEvent event) {

    }

    /**
     * Display error message.
     *
     * @param errorMessage the error message
     */
// Open a popup that contains the error message passed
    public void displayErrorMessage(String errorMessage){
        JOptionPane.showMessageDialog(this, errorMessage);
    }

    // Inner classes for Event Handling
    private class ListHandler implements ListSelectionListener {
        // Event handling is handled locally
        @Override
        public void valueChanged(ListSelectionEvent e) {
            String [] acct = accountList.getSelectedValue().toString().split("\\s");
            id = acct[0];
            name = acct[1] + " " + acct[2];
            for (AccountModel account: accounts) {
                if (account.getID().equals(id) && account.getName().equals(name)) {
                    balance = account.getBalance();
                    return;
                }
            }
        }
    }

    // Inner classes for Event Handling
    private class CurrencyHandler implements ActionListener {
        // Event handling is handled locally
        public void actionPerformed(ActionEvent e) {
            try {
                if (e.getActionCommand().equalsIgnoreCase("Edit in USD")) {
                    (getController()).setAccountView(new AccountView(getModel(), getController(), id, name, balance, USD));
                } else if (e.getActionCommand().equalsIgnoreCase("Edit in Euros")) {
                    (getController()).setAccountView(new AccountView(getModel(), getController(), id, name, balance, EURO));
                } else if (e.getActionCommand().equalsIgnoreCase("Edit in Yuan")) {
                    (getController()).setAccountView(new AccountView(getModel(), getController(), id, name, balance, YUAN));
                }
                (getController()).getAccountView().setVisible(true);
            } catch (NullPointerException npe) {
                npe.printStackTrace();
            }
        }
    }

    private class DepositAgentHandler implements ActionListener {
        // Event handling is handled locally
        public void actionPerformed(ActionEvent e) {
            try {
                if (e.getActionCommand().equalsIgnoreCase("Create Deposit Agent")) {
                    (getController()).setDepositAgentView(new DepositAgentView(getModel(), getController(), id, name, balance, USD));
                }
                (getController()).getDepositAgentView().setVisible(true);
            } catch (NullPointerException npe) {
                npe.printStackTrace();
            }
        }
    }

    private class WithdrawalAgentHandler implements ActionListener {
        // Event handling is handled locally
        public void actionPerformed(ActionEvent e) {
            try {
                if (e.getActionCommand().equalsIgnoreCase("Create Withdrawal Agent")) {
                    (getController()).setWithdrawalAgentView(new WithdrawalAgentView(getModel(), getController(), id, name, balance, USD));
                }
                (getController()).getWithdrawalAgentView().setVisible(true);
            } catch (NullPointerException npe) {
                npe.printStackTrace();
            }
        }
    }

    // Inner classes for Event Handling
    private class SaveHandler implements ActionListener {
        // Event handling is handled locally
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("Save"))
                ((AccountModel) getModel()).writeAccounts(accounts);
            AccountModel.printAccountList();
        }
    }

    // Inner classes for Event Handling
    private class ExitHandler implements ActionListener {
        private MainMenuView mmv;

        /**
         * Instantiates a new Exit handler.
         *
         * @param mmv the mmv
         */
        ExitHandler(MainMenuView mmv) {
            this.mmv = mmv;
        }

        // Event handling is handled locally
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("Exit"))
                ((AccountModel) getModel()).writeAccounts(accounts);
            AccountModel.printAccountList();
            mmv.dispatchEvent(new WindowEvent(mmv, WindowEvent.WINDOW_CLOSING));
        }
    }
}
