package java_lessons.lesson23_swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextFields {
    // declare widgets
    JLabel label;
    JTextField textField;

    public TextFields() {
        label = new JLabel("");
        textField = new JTextField(20); // pass number of chars wide
        JFrame frame = new JFrame("Using TextFields");
        // provide a window management system for multiple widgets
        frame.setLayout(new FlowLayout());
        frame.setSize(500, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // wire the interface to handle events by adding an action listener
        // when an action is performed capture the action and take the
        // text out of the textfield and put it in the label
        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                label.setText(textField.getText());
            }
        });
        // flow layout works by flowing widgets onto the
        // frame in the order that they are added
        frame.add(label);
        frame.add(textField);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TextFields();
            }
        });
    }
}
