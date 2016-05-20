package lesson_twentyfour;                       // Swing allows you to create Graphical User Interfaces

import javax.swing.*;

import java.awt.event.*;

/*
 *  I implement the Swing event listeners. I then cover how to format numbers in Java so that they have commas or are
 *  displayed as currency. JOptionPane, a useful popup window in Java is introduced.
 */
public class LessonTwentyFour extends JFrame{

    private JComboBox favoriteShows;
    private JButton button1;
    private String infoOnComponent = "";

    public static void main(String[] args){
        new LessonTwentyFour();
    }

    public LessonTwentyFour(){
        this.setSize(400,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Fourth Frame");
        JPanel thePanel = new JPanel();

        // Create an array that will be added to the combo box
        String[] shows = {"Breaking Bad", "Life on Mars", "Doctor Who"};

        // Create a combo box and add the array of shows
        favoriteShows = new JComboBox(shows);

        // Add an item to the combo box
        favoriteShows.addItem("Pushing Daisies");
        thePanel.add(favoriteShows);

        // Create a button
        button1 = new JButton("Get Answer");
        ListenForButton lForButton = new ListenForButton();
        button1.addActionListener(lForButton);
        thePanel.add(button1);
        this.add(thePanel);

        this.setVisible(true);

        // Add an item to a combo box at index 1
        favoriteShows.insertItemAt("Dexter", 1);

        // Only show 3 items at a time
        favoriteShows.setMaximumRowCount(3);

        // Remove the item named Dexter
        //favoriteShows.removeItem("Dexter");

        // Remove the item at index 1
        //favoriteShows.removeItemAt(1);

        // Remove all items
        // favoriteShows.removeAllItems();
    }

    private class ListenForButton implements ActionListener{
        public void actionPerformed(ActionEvent e){

            if(e.getSource() == button1){
                favoriteShows.setEditable(true);

                // Get item at index 0
                infoOnComponent = "Item at 0: " + favoriteShows.getItemAt(0) + "\n";

                // Get the number of items in the combo box
                infoOnComponent += "Num of Shows: " + favoriteShows.getItemCount() + "\n";

                // Get the index for the selected item
                infoOnComponent += "Selected ID: " + favoriteShows.getSelectedIndex() + "\n";

                // Get the value for the selected item
                infoOnComponent += "Selected Show: " + favoriteShows.getSelectedItem() + "\n";

                // Find out if the values in the combo box are editable
                infoOnComponent += "Combo Box Editable: " + favoriteShows.isEditable() + "\n";

                JOptionPane.showMessageDialog(LessonTwentyFour.this, infoOnComponent, "Information", JOptionPane.INFORMATION_MESSAGE);
                infoOnComponent = "";
            }
        }
    }
}