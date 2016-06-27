

import java.util.ArrayList;

class Cluster {

    private ArrayList<Point> points;
    private Point centroid;
    private int id;

    //Creates a new Cluster
    Cluster(int id) {
        this.id = id;
        this.points = new ArrayList();
        this.centroid = null;
    }

    ArrayList<Point> getPoints() {
        return points;
    }
    void addPoint(Point point) {
        points.add(point);
    }
    public void setPoints(ArrayList<Point> points) { this.points = points; }

    Point getCentroid() {
        return centroid;
    }
    void setCentroid(Point centroid) {
        this.centroid = centroid;
    }

    int getId() {
        return id;
    }
    void clear() {
        points.clear();
    }
}

