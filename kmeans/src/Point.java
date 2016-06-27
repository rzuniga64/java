import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

class Point {
    //Number of Points
    private final static int NUM_POINTS = 15;
	
    private double x = 0;
    private double y = 0;
    private int cluster_number = 0;

    Point(double x, double y)
    {
        this.setX(x);
        this.setY(y);
    }

    void setX(double x) {
        this.x = x;
    }
    double getX()  {
        return this.x;
    }
    void setY(double y) {
        this.y = y;
    }
    double getY() {
        return this.y;
    }
    void setCluster(int n) {
        this.cluster_number = n;
    }
    public int getCluster() {
        return this.cluster_number;
    }

    //Calculates the distance between two points.
    static double distance(Point p, Point centroid) {
        return Math.sqrt(Math.pow((centroid.getY() - p.getY()), 2) + Math.pow((centroid.getX() - p.getX()), 2));
    }

    //Creates random point
    static Point createRandomPoint(int min, int max) {
        Random r = new Random();
        double x = min + (max - min) * r.nextDouble();
        double y = min + (max - min) * r.nextDouble();
        return new Point(x,y);
    }
    
    static ArrayList<Point> getPoints(String inputFile) {
	    ArrayList<Point> points = new ArrayList<>(NUM_POINTS);
	    try {
	        FileReader fr = new FileReader(inputFile);
	        BufferedReader br  = new BufferedReader(fr);
	        String currentLine = br.readLine();
	        while (currentLine != null) {
	            //parse the data
	               String[] content = currentLine.split("\\t");
	               for (String s: content) {
	            	   Point p = new Point(Double.parseDouble(content[0]),Double.parseDouble(content[1]));
	            	   points.add(p);
	               }
	               currentLine = br.readLine();
	        }
	        br.close();
	    } catch (FileNotFoundException e) {
	        System.err.println("input file not found.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Can't access file");
			e.printStackTrace();
		}
		return points;
    }

    public String toString() {
        return x + "\t" + y;
    }
}