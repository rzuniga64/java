package lesson_twentysix;               // Swing allows you to create Graphical User Interfaces

import javax.swing.*;
import javax.swing.SpinnerDateModel;    // Editor for JSpinner that allows easy incrementing of dates

import java.awt.event.*;
import java.awt.Dimension;              // Object that allows me to use height & width units

import java.util.Date;                  // Used to get todays date to use with Calendar
import java.util.Calendar;              // Calendar provides methods that make it easy to work with dates

/*
 *  About JSpinner component. Cycling through numbers and dates. Revisit the Dimension, Date and Calendar libraries.
 */
public class LessonTwentySix extends JFrame{

    private JButton button1;
    private JSpinner spinner1, spinner2, spinner3, spinner4;
    private String outputString = "";

    public static void main(String[] args){
        new LessonTwentySix();
    }

    public LessonTwentySix(){

        this.setSize(400,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Fifth Frame");
        JPanel thePanel = new JPanel();

        // Create a button
        button1 = new JButton("Get Answer");
        ListenForButton lForButton = new ListenForButton();
        button1.addActionListener(lForButton);
        thePanel.add(button1);

        // Create a basic 1-9 number spinner
        spinner1 = new JSpinner();
        thePanel.add(spinner1);

        // Create a spinner with initial number, starting number, max number, increment with each click
        spinner2 = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        thePanel.add(spinner2);

        // Create a spinner using default values
        String[] weekDays = {"Mon", "Tues", "Weds", "Thurs", "Fri"};
        spinner3 = new JSpinner(new SpinnerListModel(weekDays));

        // Set the size for the spinner so that everything fits
        Dimension d = spinner3.getPreferredSize();
        d.width = 80;
        spinner3.setPreferredSize(d);
        thePanel.add(spinner3);

        // Get todays date
        Date todaysDate = new Date();

        // Create a date spinner & set default to today, no minimum, or max
        // Increment the days on button presses
        // Can also increment YEAR, MONTH, or DAY_OF_MONTH
        spinner4 = new JSpinner(new SpinnerDateModel(todaysDate, null, null,
                Calendar.DAY_OF_MONTH));

        // DateEditor is an editor that handles displaying & editing the dates
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinner4, "dd/MM/yy");
        spinner4.setEditor(dateEditor);
        thePanel.add(spinner4);
		
		/* 
            You can add a change listener with Spinners as well
            ListenForSpinner lForSpinner = new ListenForSpinner();
            Tell Java that you want to be alerted when an event occurs on the spinner
            spinner4.addChangeListener(lForSpinner);
		*/

        this.add(thePanel);
        this.setVisible(true);
    }

    private class ListenForButton implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == button1){
                outputString += "Spinner 1 Value: " + spinner1.getValue() + "\n";
                outputString += "Spinner 2 Value: " + spinner2.getValue() + "\n";
                outputString += "Spinner 3 Value: " + spinner3.getValue() + "\n";
                outputString += "Spinner 4 Value: " + spinner4.getValue() + "\n";
                JOptionPane.showMessageDialog(LessonTwentySix.this, outputString, "Information", JOptionPane.INFORMATION_MESSAGE);
                outputString = "";
            }
        }
    }
}