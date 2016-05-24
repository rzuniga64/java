package view;

import controller.AccountController;
import controller.Controller;
import model.Model;
import model.ModelEvent;
import view.DepositView;
import view.DepositView.StartDepositAgentHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;

/**
 * The type Account view.
 */
public class DepositAgentView extends JFrameView {
    public static final String DEPOSIT = "Deposit";
    public static final String WITHDRAWAL = "Withdrawal";
    public static int agentID =1;

    private JButton startAgentButton, dismissButton;
    private JLabel agentLabel, amountLabel, operationsLabel;
    private JTextField agentField, amountField, operationsField;
    private String id;
    private String name;
    private double balance;
    private double exchangeRate;

    public DepositAgentView(Model model, Controller controller, String id, String name, double balance, double exchangeRate) {
        super(model, controller);
        AmountHandler handler = new AmountHandler();
        DismissHandler dismissHandler = new DismissHandler(this);
        DepositHandler depositHandler = new DepositHandler();

        this.id = id;
        this.name = name;
        this.balance = balance;
        this.setSize(500, 250);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel thePanel = new JPanel();
        thePanel.setLayout(new GridBagLayout());

        GridBagConstraints gridConstraints = new GridBagConstraints();

        gridConstraints.gridx = 1;
        gridConstraints.gridy = 1;
        gridConstraints.gridwidth = 1;
        gridConstraints.gridheight = 1;
        gridConstraints.weightx = 100;
        gridConstraints.weighty = 100;
        gridConstraints.insets = new Insets(5,5,5,5);
        gridConstraints.anchor = GridBagConstraints.EAST;
        gridConstraints.fill = GridBagConstraints.BOTH;

        this.setTitle("Start Deposit Agent for account: " + id);
        agentLabel = new JLabel("Agent ID: ");
        agentField = new JTextField(Integer.toString(agentID++), 0);
        agentField.setEnabled(false);
        amountLabel = new JLabel("Amount in USD: ");
        amountField = new JTextField("", 0);
        operationsLabel = new JLabel("Operations per second: ");
        operationsField = new JTextField("", 0);

        Box setBox  = Box.createVerticalBox();
        Box setBox2 = Box.createHorizontalBox();
        Box setBox3 = Box.createHorizontalBox();
        Box setBox4 = Box.createHorizontalBox();

        setBox.add(Box.createVerticalStrut(10));
        setBox2.add(agentLabel, gridConstraints);
        setBox2.add(agentField, gridConstraints);
        setBox.add(setBox2, gridConstraints);
        setBox.add(Box.createVerticalStrut(10));
        setBox3.add(amountLabel, gridConstraints);
        setBox3.add(amountField, gridConstraints);
        setBox.add(setBox3, gridConstraints);
        setBox.add(Box.createVerticalStrut(10));
        setBox4.add(operationsLabel, gridConstraints);
        setBox4.add(operationsField, gridConstraints);
        setBox.add(setBox4, gridConstraints);
        setBox.add(Box.createVerticalStrut(10));
        gridConstraints.gridwidth = 4;
        thePanel.add(setBox, gridConstraints);

        Box setBox5 = Box.createHorizontalBox();
        startAgentButton = new JButton("Start agent");
        dismissButton = new JButton("Dismiss");

        setBox5.add(startAgentButton);
        startAgentButton.addActionListener(depositHandler);
        setBox5.add(Box.createHorizontalStrut(10));
        setBox5.add(dismissButton);
        dismissButton.addActionListener(dismissHandler);
        addComp(thePanel, setBox5, 0, 2, 2, 1, GridBagConstraints.SOUTH, GridBagConstraints.NONE);

        this.add(thePanel);
        this.setVisible(true);
        this.setResizable(false);
    }

    private void addComp(JPanel thePanel, JComponent comp, int xPos, int yPos, int compWidth, int compHeight, int anchor,
                                int fill){
        GridBagConstraints gridConstraints = new GridBagConstraints();

        gridConstraints.gridx = xPos;
        gridConstraints.gridy = yPos;
        gridConstraints.gridwidth = compWidth;
        gridConstraints.gridheight = compHeight;
        gridConstraints.weightx = 100;
        gridConstraints.weighty = 100;
        gridConstraints.insets = new Insets(5,5,5,5);
        gridConstraints.anchor = anchor;
        gridConstraints.fill = fill;

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

        amountField.setText(msg);
        amountField.setText("0.0");
    }

    /**
     * Display error message.
     *
     * @param errorMessage the error message
     */
// Open a popup that contains the error message passed
    private void displayErrorMessage(String errorMessage){
        JOptionPane.showMessageDialog(this, errorMessage);
    }

    /**
     * The type Invalid number exception.
     */
    private class InvalidNumberException extends Exception {
        /**
         * Instantiates a new Invalid number exception.
         *
         * @param message the message
         */
        private InvalidNumberException(String message){
            super(message);
        }
    }

    //Inner classes for Event Handling
    private class AmountHandler implements ActionListener {
        @Override
        // Event handling is handled locally
        public void actionPerformed(ActionEvent e) {

            try {
                double amount = Double.parseDouble(amountField.getText());
                if (amount < 0)
                    throw new InvalidNumberException("Amount must not be negative");
                ((AccountController) getController()).operation(e.getActionCommand(), id, amount, exchangeRate);
            } catch (NumberFormatException nfe) {
            } catch (InvalidNumberException ex) {
                displayErrorMessage(ex.getMessage());
            }
        }
    }

    private class DepositHandler implements ActionListener {
        // Event handling is handled locally
        public void actionPerformed(ActionEvent e) {
            try {
                if (e.getActionCommand().equalsIgnoreCase("Start Agent")) {
                    double amount = Double.parseDouble(amountField.getText());
                    DepositView dp = new DepositView(getModel(), getController(), id, name, balance, exchangeRate, amount,
                            operationsField.getText());
                    (getController()).setDepositView(dp);
                    (getController()).getDepositAgentView().setVisible(true);
                    dp.callStartDepositAgentHandler();
                }
            } catch (NullPointerException npe) {
                npe.printStackTrace();
            }
        }
    }

    //Inner classes for Event Handling
    private class DismissHandler implements ActionListener {
        private DepositAgentView av;

        /**
         * Instantiates a new Dismiss handler.
         *
         * @param av the av
         */
        DismissHandler(DepositAgentView av) {
            this.av = av;
        }

        @Override
        // Event handling is handled locally
        public void actionPerformed(ActionEvent e) {
             av.dispatchEvent(new WindowEvent(av, WindowEvent.WINDOW_CLOSING));
        }
    }
}


