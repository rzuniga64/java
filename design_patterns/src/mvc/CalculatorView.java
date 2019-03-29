package mvc;

import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * The type Calculator view. It performs no calculations, but instead passes information entered by the user to
 * whomever needs it.
 */

 class CalculatorView extends JFrame{

    private JTextField firstNumber  = new JTextField(10);
    private JLabel additionLabel = new JLabel("+");
    private JTextField secondNumber = new JTextField(10);
    private JButton calculateButton = new JButton("Calculate");
    private JTextField calcSolution = new JTextField(10);

    /**
     * Instantiates a new Calculator view.
     */
    CalculatorView(){

        // Sets up the view and adds the components
        JPanel calcPanel = new JPanel();

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(600, 200);

        calcPanel.add(firstNumber);
        calcPanel.add(additionLabel);
        calcPanel.add(secondNumber);
        calcPanel.add(calculateButton);
        calcPanel.add(calcSolution);

        this.add(calcPanel);
    }

    /**
     * Get first number int.
     *
     * @return the int
     */
    int getFirstNumber(){

        return Integer.parseInt(firstNumber.getText());
    }

    /**
     * Gets second number.
     *
     * @return the second number
     */
    int getSecondNumber() {

        return Integer.parseInt(secondNumber.getText());
    }

    /**
     * Set calc solution.
     *
     * @param solution the solution
     */
    void setCalcSolution(int solution){

        calcSolution.setText(Integer.toString(solution));
    }

    /**
     * Add calculate listener. If the calculateButton is clicked execute a method in the Controller named actionPerformed
     *
     * @param listenForCalcButton the listen for calc button
     */

    void addCalculateListener(ActionListener listenForCalcButton){

        calculateButton.addActionListener(listenForCalcButton);
    }

    /**
     * Display error message.
     *
     * @param errorMessage the error message
     */

    void displayErrorMessage(String errorMessage){

        // Open a popup that contains the error message passed
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}
