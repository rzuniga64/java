package java_lessons.lesson10_inheritance;

public class Shape {
    private int x;
    private int y;
    
    Shape(int xcoor, int ycoor) {
        x = xcoor;
        y = ycoor;
    }
    
    public int getX() { return x; }
    public int getY() { return y; }
    public void setX( int xcoor) { x = xcoor; }
    public void setY( int ycoor) { y = ycoor; }
    public void set( int xcoor, int ycoor) {
        setX(xcoor);
        setY(ycoor);
    }
    
    public void move(int x1, int y1) {
        set(getX() + x1, getY() + y1);
    }
}
