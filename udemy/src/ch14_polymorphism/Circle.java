package ch14_polymorphism;

public class Circle extends Shape {
    private int radius;
    
    Circle(int xcoor, int ycoor, int r) {
        super(xcoor, ycoor);
        setRadius(r);
    }
    
    public int getRadius() { return radius; }
    public void setRadius(int r) { radius = r; }
    @Override
    public void draw() {
        System.out.println("Drawing a circle at x: " + getX() + ", y: " + getY() +
                            " with radius of: " + getRadius());
    }
}
