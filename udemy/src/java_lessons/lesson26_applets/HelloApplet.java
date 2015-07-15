package java_lessons.lesson26_applets;

import java.awt.*;
import java.applet.*;

/*
<applet code="HelloApplet" width=200 height=200></applet>
 */

public class HelloApplet extends Applet {
    public void paint(Graphics g) {
        g.drawString("Hello, world!", 40, 40);
    }
}
