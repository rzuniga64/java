package flyweight;

import java.awt.*;

/**
 * The type My rect.
 */
class MyRect {
    private Color color = Color.black;
    private int x, y, x2, y2;

    /**
     * Instantiates a new My rect.
     *
     * @param color the color
     */
    MyRect(Color color) {

        this.color = color;
    }

    /**
     * Draw.
     *
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

   /* Original forces creation of a rectangle every time
   public MyRect(Color color, int upperX, int upperY, int lowerX, int lowerY) {
      this.color = color;
      this.x = upperX;
      this.y = upperY;
      this.x2 = lowerX;
      this.y2 = lowerY;
   }

   public void draw(Graphics g) {
      g.setColor(color);
      g.fillRect(x, y, x2, y2);
   }
   */
}