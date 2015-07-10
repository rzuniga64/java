package advanced_java.ch12_applets;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

// <applet code = "TempConverterApplet" width=300 height=200></applet>

public class TempConverterApplet extends Applet {
    JLabel tempLabel, outLabel;
    JTextField textField;
    JButton button;
    String[] temps;
    JList list;
    int tempIndex;

    static double convert(int temp, String scale) {
        if (scale.equals("Celsius"))
            return (temp - 32.0) * (5.0 / 9.0);
        else
            return temp * (9.0 /5.0) + 32.0;
    }

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
