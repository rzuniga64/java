package java_lessons.lesson25_applets;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

// <applet code = "TempConverterApplet" width=300 height=200></applet>

/**
 * The type Temp converter applet.
 */
public class TempConverterApplet extends Applet {

    private JLabel tempLabel, outLabel;
    private JTextField textField;
    private JButton button;
    private String[] temps;
    private JList list;
    private int tempIndex;

    /**
     * Convert double.
     *
     * @param temp  the temperature
     * @param scale the scale in Celsius or Fahrenheit
     * @return temperature converted to Celsius or Fahrenheit
     */
    static double convert(int temp, String scale) {
        if (scale.equals("Celsius"))
            return (temp - 32.0) * (5.0 / 9.0);
        else
            return temp * (9.0 /5.0) + 32.0;
    }

    /**
     * Init
     */
    public void init() {
        tempLabel = new JLabel("Temperature: ");
        outLabel = new JLabel("");
        textField = new JTextField(5);
        button = new JButton("Convert");
        temps = new String[] {"Celsius", "Fahrenheight"};
        list = new JList(temps);
        setLayout(new GridLayout(3,2));

        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                tempIndex = list.getSelectedIndex();    // retrieve the temperature from the textfield
            }
        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int temp = Integer.parseInt(textField.getText());
                String scale = temps[tempIndex];        // get the scale from the index
                outLabel.setText(Double.toString(convert(temp, scale))); // place the converted temperature in its label
            }
        });
        // add widgets to applet
        add(tempLabel);
        add(textField);
        add(list);
        add(button);
        add(outLabel);
        setVisible(true);
    }
}
