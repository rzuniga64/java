package java_lessons.lesson23_swing;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type Buttons.
 */
public class Buttons {
    // declare widgets
    private JLabel label;
    private JTextField textField;
    private JButton button;

    /**
     * Instantiates a new Buttons.
     */
    public Buttons() {

        label = new JLabel("");
        textField = new JTextField(10); // pass number of chars wide
        button = new JButton("Put OutputFormatting in label");
        JFrame frame = new JFrame("Using TextFields");

        // provide a window management system for multiple widgets
        frame.setLayout(new FlowLayout());
        frame.setSize(200, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Wire the interface to handle events by adding an action listener when an action is performed capture the
        // action and take the text out of the textfield and put it in the label
        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                label.setText(textField.getText());
            }
        });

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                label.setText(textField.getText());
            }
        });

        // flow layout works by flowing widgets onto the frame in the order that they are added
        frame.add(label);
        frame.add(button);
        frame.add(textField);
        frame.setVisible(true);
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Buttons();
            }
        });
    }
}
