package java_lessons.lesson10_inheritance;

public class Circle extends Shape {
    private int radius;
    
    Circle(int xcoor, int ycoor, int r) {
        super(xcoor, ycoor);
        setRadius(r);
    }
    
    public int getRadius() { return radius; }
    public void setRadius(int r) { radius = r; }
}
