package view;

import controller.AccountController;
import controller.Controller;
import model.Model;
import model.ModelEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;

/**
 * The type Account view.
 */
public class AccountView extends JFrameView {
    /**
     * The constant DEPOSIT.
     */
    public static final String DEPOSIT = "Deposit";
    /**
     * The constant WITHDRAWAL.
     */
    public static final String WITHDRAWAL = "Withdrawal";

    private JButton depositButton, withdrawalButton, dismissButton;
    private JLabel fundsLabel, amountLabel, funds, type;
    private JTextField amountField;
    private String id;
    private String name;
    private double balance;
    private double exchangeRate;

    /**
     * Instantiates a new Account view.
     *
     * @param model        the model
     * @param controller   the controller
     * @param id           the id
     * @param name         the name
     * @param balance      the balance
     * @param exchangeRate the exchange rate
     */
    public AccountView(Model model, Controller controller, String id, String name, double balance, double exchangeRate) {
        super(model, controller);
        Handler handler = new Handler();
        DismissHandler dismissHandler = new DismissHandler(this);

        this.id = id;
        this.name = name;
        this.balance = balance;
        this.exchangeRate = exchangeRate;
        this.setSize(500, 250);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel thePanel = new JPanel();     // Create a flow layout (Default)
        thePanel.setLayout(new GridBagLayout());

        if (exchangeRate == MainMenuView.USD) {
            this.setTitle("Account Holder: " + id + " " + name + " (USD)");
            amountLabel = new JLabel("Enter Amount in USD: ");
            funds = new JLabel(Double.toString(balance * exchangeRate));
        }
        else if (exchangeRate == MainMenuView.EURO) {
            this.setTitle("Account Holder: " + id + " " + name + " (Euro)");
            amountLabel = new JLabel("Enter Amount in Euro: ");
            funds = new JLabel(Double.toString(balance * exchangeRate));
        }
        else if (exchangeRate == MainMenuView.YUAN) {
            this.setTitle("Account Holder: " + id + " " + name + " (Yuan)");
            amountLabel = new JLabel("Enter Amount in Yuan: ");
            funds = new JLabel(Double.toString(balance * exchangeRate));
        }

        fundsLabel = new JLabel("Your Available Funds: ");
        amountField = new JTextField("0.0", 100);

        Box setBox2 = Box.createVerticalBox();
        Box setBox3 = Box.createHorizontalBox();
        Box setBox4 = Box.createHorizontalBox();

        setBox2.add(Box.createVerticalStrut(10));
        setBox3.add(fundsLabel);
        setBox3.add(funds);
        setBox2.add(setBox3);
        setBox2.add(Box.createVerticalStrut(10));
        setBox4.add(amountLabel);
        setBox2.add(Box.createVerticalStrut(10));
        setBox4.add(amountField);
        setBox2.add(setBox4);
        addComp(thePanel, setBox2, 0, 0, 2, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);

        Box setBox = Box.createHorizontalBox();
        depositButton = new JButton("Deposit");
        withdrawalButton = new JButton("Withdrawal");
        dismissButton = new JButton("Dismiss");
        setBox.add(depositButton);
        depositButton.addActionListener(handler);
        setBox.add(Box.createHorizontalStrut(10));
        setBox.add(withdrawalButton);
        withdrawalButton.addActionListener(handler);
        setBox.add(Box.createHorizontalStrut(10));
        setBox.add(dismissButton);
        dismissButton.addActionListener(dismissHandler);
        addComp(thePanel, setBox, 3, 6, 2, 1, GridBagConstraints.SOUTH, GridBagConstraints.NONE);

        this.add(thePanel);
        this.setVisible(true);
        this.setResizable(false);
    }

    private void addComp(JPanel thePanel, JComponent comp, int xPos, int yPos, int compWidth, int compHeight, int place,
                                int stretch){
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

    /**
     * Updates the balance based on exchange rate
     *
     * @param event the Model event
     */
    public void modelChanged(ModelEvent event) {
        String msg = "";
        // Formats decimals to 2 places
        DecimalFormat df = new DecimalFormat("#.##");
        if (exchangeRate == MainMenuView.USD)
            msg = df.format(event.getBalance()) + "";
        else if (exchangeRate == MainMenuView.EURO)
            msg = df.format(event.getBalance() * MainMenuView.EURO) + "";
        else if (exchangeRate == MainMenuView.YUAN)
            msg = df.format(event.getBalance() * MainMenuView.YUAN) + "";

        funds.setText(msg);
        amountField.setText("0.0");
    }

    /**
     * Display error message.
     *
     * @param errorMessage the error message
     */
// Open a popup that contains the error message passed
    void displayErrorMessage(String errorMessage){
        JOptionPane.showMessageDialog(this, errorMessage);
    }

    /**
     * The type Invalid number exception.
     */
    public class InvalidNumberException extends Exception {
        /**
         * Instantiates a new Invalid number exception.
         *
         * @param message the message
         */
        public InvalidNumberException(String message){
            super(message);
        }
    }

    //Inner classes for Event Handling
    private class Handler implements ActionListener {
        @Override
        // Event handling is handled locally
        public void actionPerformed(ActionEvent e) {

            try {
                double amount = Double.parseDouble(amountField.getText());
                if (amount < 0)
                    throw new InvalidNumberException("Amount must not be negative");
                ((AccountController) getController()).operation(e.getActionCommand(), id, amount, exchangeRate);
            } catch (NumberFormatException nfe) {
                displayErrorMessage("You need to enter an amount");
            } catch (InvalidNumberException ex) {
                displayErrorMessage(ex.getMessage());
            }
        }
    }

    //Inner classes for Event Handling
    private class DismissHandler implements ActionListener {
        private AccountView av;

        /**
         * Instantiates a new Dismiss handler.
         *
         * @param av the av
         */
        DismissHandler(AccountView av) {
            this.av = av;
        }

        @Override
        // Event handling is handled locally
        public void actionPerformed(ActionEvent e) {
             av.dispatchEvent(new WindowEvent(av, WindowEvent.WINDOW_CLOSING));
        }
    }
}


