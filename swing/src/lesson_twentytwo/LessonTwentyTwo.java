package lesson_twentytwo;                       // Swing allows you to create Graphical User Interfaces

import javax.swing.*;
import javax.swing.border.*;                    // Allows me to edit borders on panels

import java.awt.event.*;
import javax.swing.event.ChangeEvent;           // New event listener that monitors changing values for components
import javax.swing.event.ChangeListener;

import java.text.NumberFormat;                  // Allows me to format the numbers

/*
 *  About a new GUI listener called the ChangeListener.
 *  About check boxes, radio buttons, groups, borders and sliders.
 */
public class LessonTwentyTwo extends JFrame{
    private JButton button1;
    private JLabel label1, label2, label3;
    private JTextField textField1, textField2;
    private JCheckBox dollarSign, commaSeparator;
    private JRadioButton addNums, subtractNums, multNums, divideNums;
    private JSlider howManyTimes;

    private double number1, number2, totalCalc;

    public static void main(String[] args){
        new LessonTwentyTwo();
    }

    public LessonTwentyTwo(){

        this.setSize(400, 400);                 // Define the size of the frame
        this.setLocationRelativeTo(null);       // Opens the frame in the middle of the screen
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // Define how the frame exits (Click the Close Button)
        this.setTitle("My Third Frame");        // Define the title for the frame
        JPanel thePanel = new JPanel();         // The JPanel contains all of the components for your frame

        button1 = new JButton("Calculate");     // Create a button with Click Here on it
        ListenForButton lForButton = new ListenForButton(); // Create an instance of ListenForEvents to handle events
        // Tell Java that you want to be alerted when an event occurs on the button
        button1.addActionListener(lForButton);
        thePanel.add(button1);

        label1 = new JLabel("Number 1");        // How to add a label
        thePanel.add(label1);

        textField1 = new JTextField("", 5);     // How to add a text field
        thePanel.add(textField1);

        label2 = new JLabel("Number 2");        // How to add a label
        thePanel.add(label2);

        textField2 = new JTextField("", 5);     // How to add a text field
        thePanel.add(textField2);

        dollarSign = new JCheckBox("Dollars");  // How to add checkboxes
        commaSeparator = new JCheckBox("Commas");
        thePanel.add(dollarSign);
        thePanel.add(commaSeparator, true);     // By putting true in here it is selected by default

        addNums = new JRadioButton("Add");      // Creates radio buttons with default labels
        subtractNums = new JRadioButton("Subtract");
        multNums = new JRadioButton("Multiply");
        divideNums = new JRadioButton("Divide");

        // Creates a group that will contain radio buttons. You do this so that when 1 is selected the others
        // are deselected
        ButtonGroup operation = new ButtonGroup();

        // Add radio buttons to the group
        operation.add(addNums);
        operation.add(subtractNums);
        operation.add(multNums);
        operation.add(divideNums);

        // Create a new panel to hold radio buttons
        JPanel operPanel = new JPanel();

        // Surround radio button panel with a border. You can define different types of borders createEtchedBorder,
        // createLineBorder, createTitledBorder createLoweredBevelBorder, createRaisedBevelBorder
        Border operBorder = BorderFactory.createTitledBorder("Operation");

        operPanel.setBorder(operBorder);        // Set the border for the panel

        // Add the radio buttons to the panel
        operPanel.add(addNums);
        operPanel.add(subtractNums);
        operPanel.add(multNums);
        operPanel.add(divideNums);

        addNums.setSelected(true);              // Selects the add radio button by default
        thePanel.add(operPanel);                // Add the panel to the main panel. You don't add the group

        label3 = new JLabel("Perform How Many Times?"); // How to create a slider
        thePanel.add(label3);

        // Creates a slider with a min value of 0 thru 99 and an initial value of 1
        howManyTimes = new JSlider(0, 99, 1);
        howManyTimes.setMinorTickSpacing(1);    // Defines the minimum space between ticks
        howManyTimes.setMajorTickSpacing(10);   // Defines the minimum space between major ticks
        howManyTimes.setPaintTicks(true);       // Says to draw the ticks on the slider
        howManyTimes.setPaintLabels(true);      // Says to draw the tick labels on the slider

        // Create an instance of ListenForEvents to handle events
        ListenForSlider lForSlider = new ListenForSlider();

        // Tell Java that you want to be alerted when an event occurs on the slider
        howManyTimes.addChangeListener(lForSlider);
        thePanel.add(howManyTimes);
        this.add(thePanel);

        this.setVisible(true);
        textField1.requestFocus();              // Gives focus to the textfield
    }

    private class ListenForButton implements ActionListener{

        // This method is called when an event occurs
        public void actionPerformed(ActionEvent e){
            // Check if the source of the event was the button
            if(e.getSource() == button1){
                // getText returns a String so you have to parse it into a double in this situation
                try{
                    number1 = Double.parseDouble(textField1.getText());
                    number2 = Double.parseDouble(textField2.getText());
                }

                catch(NumberFormatException excep){

                    // JOptionPane displays a popup on the screen
                    // (parentComponent, message, title, error icon)
                    // Error Icons: WARNING_MESSAGE, QUESTION_MESSAGE, PLAIN_MESSAGE
                    JOptionPane.showMessageDialog(LessonTwentyTwo.this, "Please Enter the Right Info", "Error",
                                                    JOptionPane.ERROR_MESSAGE);
                    System.exit(0); // Closes the Java app
                }

                if(addNums.isSelected()) { totalCalc = addNumbers(number1, number2, howManyTimes.getValue());

                } else if(subtractNums.isSelected()) { totalCalc = subtractNumbers(number1, number2,
                                                        howManyTimes.getValue());

                } else if(multNums.isSelected()) { totalCalc = multiplyNumbers(number1, number2,
                                                        howManyTimes.getValue());

                } else { totalCalc = divideNumbers(number1, number2, howManyTimes.getValue()); }

                // If the dollar is selected in the checkbox print the number as currency
                if(dollarSign.isSelected()) {
                    // Defines that you want to format a number with $ and commas
                    NumberFormat numFormat = NumberFormat.getCurrencyInstance();
                    JOptionPane.showMessageDialog(LessonTwentyTwo.this, numFormat.format(totalCalc), "Solution",
                                                    JOptionPane.INFORMATION_MESSAGE);
                }

                // If the comma is selected in the checkbox print the number with commas
                else if(commaSeparator.isSelected()) {
                    // Defines that you want to format a number with commas
                    NumberFormat numFormat = NumberFormat.getNumberInstance();
                    JOptionPane.showMessageDialog(LessonTwentyTwo.this, numFormat.format(totalCalc), "Solution",
                                                    JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(LessonTwentyTwo.this, totalCalc, "Solution",
                                                    JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }

    // Implements ActionListener so it can react to events on components
    private class ListenForSlider implements ChangeListener{
        @Override
        public void stateChanged(ChangeEvent e) {
            // Check if the source of the event was the button
            if(e.getSource() == howManyTimes){
                label3.setText("Perform How Many Times? " + howManyTimes.getValue() );
            }
        }
    }

    private static double addNumbers(double number1, double number2, int howMany){
        double total = 0;
        int i = 1;

        while(i <= howMany){
            total = total + (number1 + number2);
            i++;
        }

        return total;
    }

    private static double subtractNumbers(double number1, double number2, int howMany){
        double total = 0;
        int i = 1;

        while(i <= howMany){
            total = total + (number1 - number2);
            i++;
        }

        return total;
    }

    private static double multiplyNumbers(double number1, double number2, int howMany){
        double total = 0;
        int i = 1;

        while(i <= howMany){
            total = total + (number1 * number2);
            i++;
        }

        return total;
    }

    private static double divideNumbers(double number1, double number2, int howMany){
        double total = 0;
        int i = 1;

        while(i <= howMany){
            total = total + (number1 / number2);
            i++;
        }

        return total;
    }
}