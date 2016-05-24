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
public class DepositView extends JFrameView {
    public static final String DEPOSIT = "Deposit";
    public static final String WITHDRAWAL = "Withdrawal";
    public static int agentID =1;
    public static int ops = 0;

    private JButton stopAgentButton, dismissButton;
    private JLabel amountLabel, operationsLabel, stateLabel, amountTransferredLabel, operationsCompletedLabel;
    private JTextField amountField, operationsField,stateField, amountTransferredField, operationsCompletedField;
    private String id;
    private String name;
    private double balance;
    private double exchangeRate;
    private double amount;
    private String operations;
    private Integer temp;


    public DepositView(Model model, Controller controller, String id, String name, double balance, double exchangeRate,
                       double amount, String operations) {
        super(model, controller);
        AmountHandler handler = new AmountHandler();
        DismissHandler dismissHandler = new DismissHandler(this);
        StartDepositAgentHandler startDepositAgentHandler = new StartDepositAgentHandler();
        StopDepositAgentHandler stopDepositAgentHandler = new StopDepositAgentHandler();

        this.id = id;
        this.name = name;
        this.balance = balance;
        this.amount = amount;
        this.operations = operations;
        this.setSize(500, 400);
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

        this.setTitle("Deposit Agent for account: " + id);
        amountLabel = new JLabel("Amount in $: ");
        amountField = new JTextField(Double.toString(amount), 0);
        amountField.setEnabled(false);

        operationsLabel = new JLabel("Operations per second: ");
        operationsField = new JTextField(operations, 0);
        operationsField.setEnabled(false);
        stateLabel = new JLabel("State: ");
        stateField = new JTextField("Running", 0);
        stateField.setEnabled(false);
        amountTransferredLabel = new JLabel("Amount in $ transferred: ");
        amountTransferredField = new JTextField(Double.toString(amount), 0);
        amountTransferredField.setEnabled(false);
        operationsCompletedLabel = new JLabel("Operations completed: ");
        operationsCompletedField = new JTextField(operations, 0);
        operationsCompletedField.setEnabled(false);
        temp = Integer.parseInt(operationsCompletedField.getText());;

        Box setBox  = Box.createVerticalBox();
        Box setBox2 = Box.createHorizontalBox();
        Box setBox3 = Box.createHorizontalBox();
        Box setBox4 = Box.createHorizontalBox();
        Box setBox5 = Box.createHorizontalBox();
        Box setBox6 = Box.createHorizontalBox();
        Box setBox7 = Box.createHorizontalBox();

        setBox.add(Box.createVerticalStrut(10));
        setBox2.add(amountLabel, gridConstraints);
        setBox2.add(amountField, gridConstraints);
        setBox.add(setBox2, gridConstraints);
        setBox.add(Box.createVerticalStrut(10));
        setBox3.add(operationsLabel, gridConstraints);
        setBox3.add(operationsField, gridConstraints);
        setBox.add(setBox3, gridConstraints);
        setBox.add(Box.createVerticalStrut(10));
        setBox4.add(stateLabel, gridConstraints);
        setBox4.add(stateField, gridConstraints);
        setBox.add(setBox4, gridConstraints);
        setBox.add(Box.createVerticalStrut(10));
        setBox5.add(amountTransferredLabel, gridConstraints);
        setBox5.add(amountTransferredField, gridConstraints);
        setBox.add(setBox5, gridConstraints);
        setBox.add(Box.createVerticalStrut(10));
        setBox6.add(operationsCompletedLabel, gridConstraints);
        setBox6.add(operationsCompletedField, gridConstraints);
        setBox.add(setBox6, gridConstraints);
        setBox.add(Box.createVerticalStrut(10));
        gridConstraints.gridwidth = 4;
        thePanel.add(setBox, gridConstraints);

        setBox7 = Box.createHorizontalBox();
        stopAgentButton = new JButton("Stop agent");
        dismissButton = new JButton("Dismiss");

        setBox7.add(stopAgentButton);
        stopAgentButton.addActionListener(stopDepositAgentHandler);
        setBox7.add(Box.createHorizontalStrut(10));
        setBox7.add(dismissButton);
        dismissButton.addActionListener(dismissHandler);
        addComp(thePanel, setBox7, 0, 2, 2, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);

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

    public void callStartDepositAgentHandler() {
        StartDepositAgentHandler startDepositAgentHandler = new StartDepositAgentHandler();
        startDepositAgentHandler.startHandler();
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
                displayErrorMessage("You need to enter an amount");
            } catch (InvalidNumberException ex) {
                displayErrorMessage(ex.getMessage());
            }
        }
    }

    //Inner classes for Event Handling
    public class StartDepositAgentHandler {

        public void startHandler() {
            /**
             *  SwingWorker is an abstract,thread class. Implement the abstract
             *  method of the class with an anonymous class type syntax.
             *  Kind of a public void run() method in Thread class.
             *  You can't stop it and if you want to run it again you need a
             *  new SwingWorker.  This runs in its own background thread but
             *  there is no way to get any information back out of it. To do
             *  this use the first template parameter.  It must be a class not
             *  a primitive type.
             */

            SwingWorker<Void, Double> worker = new SwingWorker<Void, Double>() {

                // run some code in its own thread without getting a return
                // value from it or update the gui. Cannot update GUI from
                // this method.
                public Void doInBackground() throws Exception {
                    double amount = Double.parseDouble(amountField.getText());
                    double value = balance + amount;
                    while (true) {
                        Thread.sleep(Long.parseLong(operationsField.getText()) * 1000);
                        value += amount;
                        publish(value);
                    }
                }

                /**
                 *  Not guaranteed to be called everytime you do publish().
                 *  It might save up a bunch of integers which is why the paramer
                 *  is a list of Integers and give them to you all at once in
                 *  chunks.  In prcess() method you can safely update your GUI
                 *  interface.
                 * @param chunks
                 */
                protected void process(java.util.List<Double> chunks){
                    Double value = chunks.get(chunks.size()-1);
                    ops = ops + temp;

                    DecimalFormat df = new DecimalFormat("#.##");
                    amountField.setText(df.format(value));
                    amountTransferredField.setText(df.format(value-balance));
                    operationsCompletedField.setText(Integer.toString(ops));
                }
            };
            worker.execute();
        }
    }

    //Inner classes for Event Handling
    private class StopDepositAgentHandler implements ActionListener {
        @Override
        // Event handling is handled locally
        public void actionPerformed(ActionEvent e) {
            /**
             *  SwingWorker is an abstract,thread class. Implement the abstract
             *  method of the class with an anonymous class type syntax.
             *  Kind of a public void run() method in Thread class.
             *  You can't stop it and if you want to run it again you need a
             *  new SwingWorker.  This runs in its own background thread but
             *  there is no way to get any information back out of it. To do
             *  this use the first template parameter.  It must be a class not
             *  a primitive type.
             */

            SwingWorker<Void, Double> worker = new SwingWorker<Void, Double>() {

                // run some code in its own thread without getting a return
                // value from it or update the gui. Cannot update GUI from
                // this method.
                public Void doInBackground() throws Exception {
                    double amount = Double.parseDouble(amountField.getText());
                    double value = balance + amount;
                    while (true) {
                        Thread.sleep(Long.parseLong(operationsField.getText()) * 1000);
                        value += amount;
                        publish(value);
                    }
                }

                /**
                 *  Not guaranteed to be called everytime you do publish().
                 *  It might save up a bunch of integers which is why the paramer
                 *  is a list of Integers and give them to you all at once in
                 *  chunks.  In prcess() method you can safely update your GUI
                 *  interface.
                 * @param chunks
                 */
                protected void process(java.util.List<Double> chunks){
                    Double value = chunks.get(chunks.size()-1);

                    DecimalFormat df = new DecimalFormat("#.##");
                    amountField.setText(df.format(value));
                }
            };
            worker.execute();
        }
    }

    //Inner classes for Event Handling
    private class DismissHandler implements ActionListener {
        private DepositView av;

        /**
         * Instantiates a new Dismiss handler.
         *
         * @param av the av
         */
        DismissHandler(DepositView av) {
            this.av = av;
        }

        @Override
        // Event handling is handled locally
        public void actionPerformed(ActionEvent e) {
             av.dispatchEvent(new WindowEvent(av, WindowEvent.WINDOW_CLOSING));
        }
    }
}


