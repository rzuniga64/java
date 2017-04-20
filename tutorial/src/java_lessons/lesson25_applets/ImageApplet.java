package java_lessons.lesson25_applets;

import java.awt.*;
import java.applet.*;

// <applet code = "ImageApplet" width=400 height=350></applet>

/**
 * The type Image applet.
 */
public class ImageApplet extends Applet{
    private Image anImage;

    /**
     * Init
     */
    public void init() {
        anImage = Toolkit.getDefaultToolkit().getImage("java\\lesson25_applets\\Java.jpg");
    }

    /**
     * Paint
     * @param g  the Graphics
     */
    public void paint(Graphics g) {
        g.drawImage(anImage, 50, 25, this);
        showStatus("image loaded");
    }
}
