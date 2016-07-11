package java_lessons.lesson31_graphics;

import java.applet.Applet;
import java.awt.*;

// <applet code="Colors" width="300" height="200"></applet>

/**
 * The type Colors.
 */
public class Colors extends Applet {
    public void paint(Graphics g) {

        Color color1 = new Color(178,34,34);
        g.setColor(color1);

        int x1 = 0;
        int y1 = 100;
        int x2 = 300;
        int y2 = 100;
        g.drawLine(x1,y1,x2,y2);

        g.setColor(Color.yellow);
        x1 = 30;
        y1 = 30;
        x2 = 60;
        y2 = 50;
        g.fillRect(x1,y1,x2,y2);

        g.setColor(Color.green);
        x1 = 80;
        y1 = 80;
        x2 = 100;
        y2 = 100;
        g.fillOval(x1,y1,x2,y2);

        x1 = 200;
        y1 = 60;
        x2 = 60;
        y2 = 60;
        g.drawArc(x1,y1,x2,y2,0,180);
    }
}

