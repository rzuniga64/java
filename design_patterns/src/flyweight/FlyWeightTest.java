package flyweight;

/**
 *  The Flyweight design pattern is used when you need to create a large number of similar objects.
 *  To reduce memory this pattern shares Objects that are the same rather than creating new ones.
 *  Intrinsic State: Color
 *  Extrinsic State: Size
 */

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * The type Fly weight test.
 */
public class FlyWeightTest extends JFrame{

    private static final long serialVersionUID = 1L;

    private JButton startDrawingButton;
    private int windowWidth = 1500;
    private int windowHeight = 800;

    // A new rectangle is created only if a new color is needed
    private Color[] shapeColor = {Color.orange, Color.red, Color.yellow,
            Color.blue, Color.pink, Color.cyan, Color.magenta,
            Color.black, Color.gray};

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args){

        new FlyWeightTest();
    }

    private  FlyWeightTest(){

        // Create the frame, position it and handle closing it
        this.setSize(windowWidth,windowHeight);
        this.setLocationRelativeTo(null);   // set to center of screen
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Flyweight Test");

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        final JPanel  drawingPanel  = new JPanel();
        startDrawingButton = new JButton("Create Rectangles");
        contentPane.add(drawingPanel,  BorderLayout.CENTER);
        contentPane.add(startDrawingButton, BorderLayout.SOUTH);

        startDrawingButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {

                Graphics g = drawingPanel.getGraphics();
                long startTime = System.currentTimeMillis();

                for(int i=0; i < 100000; ++i) {

                    // 1st try
                    //g.setColor(getRandColor());
                    //g.fillRect(getRandX(), getRandY(), getRandX(), getRandY());

                    // 2nd try
                    //MyRect rect = new MyRect(getRandColor());
                    //rect.draw(g, getRandX(), getRandY(), getRandX(), getRandY());

                    // Uses rectangles stored in the HashMap to speed up the program
                    MyRect rect = RectFactory.getRect(getRandColor());
                    rect.draw(g, getRandX(), getRandY(), getRandX(), getRandY());
                }
                long endTime = System.currentTimeMillis();
                System.out.println("That took " + (endTime - startTime) + " milliseconds");
            }
        });

        this.add(contentPane);
        this.setVisible(true);
    }

    // Picks random x & y coordinates
    private int getRandX(){
        return (int)(Math.random()*windowWidth);
    }

    private int getRandY(){
        return (int)(Math.random()*windowHeight);
    }

    // Picks a random Color from the 9 available
    private Color getRandColor(){

        Random randomGenerator = new Random();
        int randInt = randomGenerator.nextInt(9);

        return shapeColor[randInt];
    }
}