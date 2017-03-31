package structural.bridge.shapes;

/**
 *  Shape interface.
 *  Abstraction.
 */
public interface Shape {

    /** Draw method. */
    void draw();

    /**
     * Resize by percentage method.
     * @param pct percentage.
     */
    void resizeByPercentage(double pct);
}
