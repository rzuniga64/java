package java_lessons.lesson23_swing;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

/**
 * The type Temp converter.
 */
public class TempConverter {
    private JLabel tempLabel, outLabel;
    private JTextField textField;
    private JButton button;
    private String[] temps;
    private JList list;
    private int tempIndex;

    private static double convert(int temp, String scale) {
        if (scale.equals("Celsius")) {
            return (temp - 32.0) * (5.0 / 9.0);
        }
        else {
            return temp * (9.0 / 5.0) + 32.0;
        }
    }

    private TempConverter() {

        tempLabel = new JLabel("Temperature: ");
        outLabel = new JLabel("");
        textField = new JTextField(5);
        button = new JButton("Convert");
        temps = new String[]{"Celsius", "Fahrenheit"};
        list = new JList(temps);

        JFrame frame = new JFrame("Temperature Converter:");
        frame.setLayout(new GridLayout(3,2));
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent le) {
                tempIndex = list.getSelectedIndex();
            }
        });

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                int temp = Integer.parseInt(textField.getText());
                String scale = temps[tempIndex];
                outLabel.setText(Double.toString(convert(temp, scale)));
            }
        });

        frame.add(tempLabel);
        frame.add(textField);
        frame.add(list);
        frame.add(button);
        frame.add(outLabel);
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
                new TempConverter();
            }
        });
    }
}
