package structural.flyweight;

import java.awt.*;

/**
 *  Class that draws a colored rectangle.
 */
class MyRect {

    private Color color = Color.black;
    private int x, y, x2, y2;

    /**
     * Instantiates a new colored rectangle.
     * @param color a color
     */
    MyRect(Color color) {

        this.color = color;
    }

    /**
     * Draw.
     * @param g      the g
     * @param upperX the upper x
     * @param upperY the upper y
     * @param lowerX the lower x
     * @param lowerY the lower y
     */
    void draw(Graphics g, int upperX, int upperY, int lowerX, int lowerY) {

        g.setColor(color);
        g.fillRect(upperX, upperY, lowerX, lowerY);
    }
}