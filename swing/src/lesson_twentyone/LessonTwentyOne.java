package lesson_twentyone;   // Swing allows you to create Graphical User Interfaces

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;

import java.awt.event.*;

/*
 *  About event handlers for Window, Mouse and Keyboard
 */
public class LessonTwentyOne extends JFrame{
    private JButton button1;
    private JTextField textField1;
    private JTextArea textArea1;
    private int buttonClicked;

    public static void main(String[] args){
        new LessonTwentyOne();
    }

    private LessonTwentyOne(){

        this.setSize(400, 400);                     // Define the size of the frame
        // Toolkit is the super class for the Abstract Window Toolkit. It allows us to ask questions of the OS
        Toolkit tk = Toolkit.getDefaultToolkit();
        // A Dimension can hold the width and height of a component getScreenSize returns the size of the screen
        Dimension dim = tk.getScreenSize();

        // dim.width returns the width of the screen
        // this.getWidth returns the width of the frame you are making

        // Find upper left hand corner of my window
        int xPos = (dim.width / 2) - (this.getWidth() / 2);
        int yPos = (dim.height / 2) - (this.getHeight() / 2);

        this.setLocation(xPos, yPos);                       // You could also define the x, y position of the frame

        // Define how the frame exits (Click the Close Button). Without this Java will eventually close the app
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My First Frame");                    // Define the title for the frame
        JPanel thePanel = new JPanel();                     // The JPanel contains all of the components for your frame

        // How to add a button
        button1 = new JButton("Click Here");                // Create a button with Click Here on it
        ListenForButton lForButton = new ListenForButton(); // Create an instance of ListenForEvents to handle events
        // Tell Java that you want to be alerted when an event occurs on the button
        button1.addActionListener(lForButton);
        thePanel.add(button1);

        // How to add a text field
        textField1 = new JTextField("Type Here", 15);
        ListenForKeys lForKeys = new ListenForKeys();
        textField1.addKeyListener(lForKeys);
        thePanel.add(textField1);

        // How to add a text area
        textArea1 = new JTextArea(15, 20);
        textArea1.setText("Tracking Events\n");             // Set the default text for the text area
        textArea1.setLineWrap(true);                        // If text doesn't fit on a line, jump to the next
        textArea1.setWrapStyleWord(true);                   // Makes sure that words stay intact if a line wrap occurs

        // Adds scroll bars to the text area. Other options: VERTICAL_SCROLLBAR_ALWAYS, VERTICAL_SCROLLBAR_NEVER
        JScrollPane scrollbar1 = new JScrollPane(textArea1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                                    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        thePanel.add(scrollbar1);
        this.add(thePanel);

        ListenForWindow lForWindow = new ListenForWindow();
        this.addWindowListener(lForWindow);
        this.setVisible(true);

        // Track the mouse if it is inside of the panel
        ListenForMouse lForMouse = new ListenForMouse();
        thePanel.addMouseListener(lForMouse);
    }

    // Implements ActionListener so it can react to events on components

    private class ListenForButton implements ActionListener{
        // This method is called when an event occurs
        public void actionPerformed(ActionEvent e){

            // Check if the source of the event was the button
            if(e.getSource() == button1){
                buttonClicked++;
                textArea1.append("Button clicked " + buttonClicked + " times\n" ); // Change the text for the label
                // e.getSource().toString() returns information on the button and the event that occurred
            }
        }
    }

    // By using KeyListener you can track keys on the keyboard
    private class ListenForKeys implements KeyListener{

        // Handle the key typed event from the text field.
        public void keyTyped(KeyEvent e) {
            textArea1.append("Key Hit: " + e.getKeyChar() + "\n");
        }

        // Handle the key-pressed event from the text field.
        public void keyPressed(KeyEvent e) {
        }

        // Handle the key-released event from the text field.
        public void keyReleased(KeyEvent e) {
        }
    }

    private class ListenForMouse implements MouseListener{
        // Called when a mouse button is clicked
        public void mouseClicked(MouseEvent e) {

            textArea1.append("Mouse Panel Pos: " + e.getX() + " " + e.getY() + "\n");
            textArea1.append("Mouse Screen Pos: " + e.getXOnScreen() + " " + e.getYOnScreen() + "\n");
            textArea1.append("Mouse Button: " + e.getButton()  + "\n");
            textArea1.append("Mouse Clicks: " + e.getClickCount()  + "\n");
        }

        // Called when the mouse enters the component assigned the MouseListener
        public void mouseEntered(MouseEvent arg0) {
        }

        // Called when the mouse leaves the component assigned the MouseListener
        public void mouseExited(MouseEvent arg0) {
        }

        // Mouse button pressed
        public void mousePressed(MouseEvent arg0) {
        }

        // Mouse button released
        public void mouseReleased(MouseEvent arg0) {
        }
    }

    private class ListenForWindow implements WindowListener{

        // Called when window is the active window
        public void windowActivated(WindowEvent e) {
            textArea1.append("Window Activated\n");
        }

        // Called when window is closed using dispose this.dispose(); can be used to close a window
        public void windowClosed(WindowEvent arg0) {
        }

        // Called when the window is closed from the menu
        public void windowClosing(WindowEvent arg0) {
        }

        // Called when a window is no longer the active window
        public void windowDeactivated(WindowEvent e) {
            textArea1.append("Window Activated\n");
        }

        // Called when the window goes from minimized to a normal state
        public void windowDeiconified(WindowEvent arg0) {
            textArea1.append("Window in Normal State\n");
        }

        // Called when the window goes from normal to a minimized state
        public void windowIconified(WindowEvent arg0) {
            textArea1.append("Window Minimized\n");
        }

        // Called when the window is first created
        public void windowOpened(WindowEvent arg0) {
            textArea1.append("Window Created\n");
        }
    }
}