package structural.flyweight;

import java.util.HashMap;
import java.awt.Color;

/**
 * This creational.factory only creates a new rectangle if it uses a color not previously used.
 * Otherwise its going to use a stored object that has already been created.
 * The HashMap uses the color as the key for every rectangle it will make up to 8 total.
 *
 * Intrinsic State: Color
 * Extrinsic State: X & Y Values
 */
class RectFactory {

    // Store the rectangles in a hash map with a key Color.
    private static final HashMap<Color, MyRect> rectsByColor = new HashMap<>();

    /**
     *  Checks if a rectangle with a specific color has been made. If not it makes a new one, otherwise it returns one
     *  that has already been made.
     *  @param color the color
     *  @return the rect
     */
    static MyRect getRect(Color color) {

        MyRect rect = rectsByColor.get(color);

        if(rect == null) {
            rect = new MyRect(color);
            // Add new rectangle to HashMap
            rectsByColor.put(color, rect);
        }
        return rect;
    }
}