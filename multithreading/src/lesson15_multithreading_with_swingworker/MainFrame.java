package lesson15_multithreading_with_swingworker;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.*;

/*
    The user interface should be updated from the main thread not from threads
    you create.  For that reason the SwingWorker class is introduced.
 */
public class MainFrame extends JFrame {
    private JLabel countLabel1 = new JLabel("0");
    private JLabel statusLabel = new JLabel("Task not completed.");
    private JButton startButton = new JButton("Start");

    public MainFrame(String title) {
        super(title);

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.NONE;

        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 1;
        gc.weighty = 1;
        add(countLabel1, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        gc.weightx = 1;
        gc.weighty = 1;
        add(statusLabel, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        gc.weightx = 1;
        gc.weighty = 1;
        add(startButton, gc);

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                start();
            }
        });

        setSize(200, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void start() {
        /**
         *  SwingWorker is an abstract,thread class. Implement the abstract
         *  method of the class with an anonymous class type syntax.
         *  Kind of a public void run() method in Thread class.
         *  You can't stop it and if you want to run it again you need a
         *  new SwingWorker.  This runs in its own background thread but
         *  there is no way to get any information back out of it. To do
         *  this use the first template parameter.  It must be a class not
         *  a primitive type.
         */

        SwingWorker<Boolean, Integer> worker = new SwingWorker<Boolean, Integer>() {

            // run some code in its own thread without getting a return
            // value from it or update the gui. Cannot update GUI from
            // this method.
            protected Boolean doInBackground() throws Exception {
                for (int i = 0; i < 30; i++) {
                    Thread.sleep(100);
                    System.out.println("Hello: " + i);
                    publish(i);
                }
                return true;
            }

            /**
             *  Not guaranteed to be called everytime you do publish().
             *  It might save up a bunch of integers which is why the paramer
             *  is a list of Integers and give them to you all at once in
             *  chunks.  In prcess() method you can safely update your GUI
             *  interface.
             * @param chunks
             */
            protected void process(List<Integer> chunks) {
                Integer value = chunks.get(chunks.size()-1);

                countLabel1.setText("Current value: " + value);
            }

            /**
             *  Called when thread finishes. In done() method you can
             *  safely update your GUI interface.  To get a return value
             *  use the get() method. get() returns a boolean here because
             *  that is what is specified in the first template parameter.
             */
            protected void done() {
                try {
                    Boolean status = get();
                    statusLabel.setText("Completed with status: " + status);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        };
        worker.execute();
    }
}
