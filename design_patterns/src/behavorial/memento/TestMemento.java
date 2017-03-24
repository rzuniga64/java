package behavorial.memento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * The type Test behavorial.memento.
 */
public class TestMemento extends JFrame{

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        new TestMemento();
    }

    private JButton saveBut, undoBut, redoBut;
    private JTextArea theArticle = new JTextArea(40,60);

    /**
     *  Create a caretaker that contains the ArrayList with all the articles in it.
     *  It can add and retrieve articles from the ArrayList
     */
    private Caretaker caretaker = new Caretaker();

    /**
     *  The originator sets the value for the article, creates a new behavorial.memento with a new article, and gets the article
     *  stored in the current behavorial.memento
     */
    private Originator originator = new Originator();

    private int saveFiles = 0, currentArticle = 0;

    private TestMemento(){

        // Set basic information for the panel that will hold all the GUI elements
        this.setSize(750,780);
        this.setTitle("Memento Design Pattern");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("Article"));
        panel1.add(theArticle);

        ButtonListener saveListener = new ButtonListener();
        ButtonListener undoListener = new ButtonListener();
        ButtonListener redoListener = new ButtonListener();

        saveBut = new JButton("Save");
        saveBut.addActionListener(saveListener);

        undoBut = new JButton("Undo");
        undoBut.addActionListener(undoListener);

        redoBut = new JButton("Redo");
        redoBut.addActionListener(redoListener);

        panel1.add(saveBut);
        panel1.add(undoBut);
        panel1.add(redoBut);

        this.add(panel1);
        this.setVisible(true);
    }

    private class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if(e.getSource() == saveBut){

                String textInTextArea = theArticle.getText();  // Get text in JTextArea
                originator.set(textInTextArea); // Set the value for the current behavorial.memento
                caretaker.addMemento( originator.storeInMemento() ); // Add new article to the ArrayList
                saveFiles++;
                currentArticle++;

                System.out.println("Save Files " + saveFiles);
                undoBut.setEnabled(true); // Make undo clickable
            } else

            if(e.getSource() == undoBut){
                if(currentArticle >= 1){
                    currentArticle--; // Decrement to the current article displayed

                    // Get the older article saved and display it in JTextArea
                    String textBoxString = originator.restoreFromMemento( caretaker.getMemento(currentArticle) );

                    theArticle.setText(textBoxString);
                    redoBut.setEnabled(true); // Make Redo clickable
                } else {
                    undoBut.setEnabled(false); // Don't allow user to click Undo
                }
            } else

            if(e.getSource() == redoBut){
                if((saveFiles - 1) > currentArticle){
                    currentArticle++;   // Increment to the current article displayed

                    // Get the newer article saved and display it in JTextArea
                    String textBoxString = originator.restoreFromMemento( caretaker.getMemento(currentArticle) );
                    theArticle.setText(textBoxString);
                    undoBut.setEnabled(true); // Make undo clickable
                } else {
                    redoBut.setEnabled(false); // Don't allow user to click Redo
                }
            }
        }
    }
}