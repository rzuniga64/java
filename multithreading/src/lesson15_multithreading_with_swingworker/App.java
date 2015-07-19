package lesson15_multithreading_with_swingworker;

import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainFrame("SwingWorker Demo");
            }
        });
    }
}
