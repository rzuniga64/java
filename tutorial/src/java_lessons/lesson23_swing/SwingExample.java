package java_lessons.lesson23_swing;

import javax.swing.*;

// we'll look at the frame and label classes in this example
public class SwingExample {
    private SwingExample() {
        JFrame frame = new JFrame("Hello, World! Application");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel("Hello, World!");
        // ad the label to the frame
        frame.add(label);
        frame.setVisible(true);
    }

    // When developing GUIs they need to run in a seperate thread
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
           public void run() {
               new SwingExample();
           }
        });
    }
}
