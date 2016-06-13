import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class KMeans {
	private final static String input1 = "kmeans/src/input1.txt";
	private final static String input2 = "kmeans/src/input2.txt";
	private final static String input3 = "kmeans/src/input3.txt";
	private final static String input4 = "kmeans/src/input4.txt";
	
	//Number of Clusters. This metric should be related to the number of points
    private final static int NUM_CLUSTERS1 = 2;
    private final static int NUM_CLUSTERS2 = 2;
    private final static int NUM_CLUSTERS3 = 3;
    private final static int NUM_CLUSTERS4 = 4;
    
    //Number of Points
    private final static int NUM_POINTS = 15;
    
    //Min and Max X and Y
    private static final int MIN_COORDINATE = 0;
    private static final int MAX_COORDINATE = 10;

    private ArrayList<Point> points;
    private ArrayList<Cluster> clusters;
    private ArrayList<String> inputFiles;
    private ArrayList<Integer> numberOfClusters;
    
    private KMeans() {
        this.points = new ArrayList<Point>();
        this.clusters = new ArrayList<Cluster>();
        this.inputFiles = new ArrayList<String>();
        this.numberOfClusters = new ArrayList<Integer>();
        
        this.inputFiles.add(input1);
        this.inputFiles.add(input2);
        this.inputFiles.add(input3);
        this.inputFiles.add(input4);
        
        this.numberOfClusters.add(NUM_CLUSTERS1);
        this.numberOfClusters.add(NUM_CLUSTERS2);
        this.numberOfClusters.add(NUM_CLUSTERS3);
        this.numberOfClusters.add(NUM_CLUSTERS4);
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
  
        KMeans kmeans = new KMeans();
        ArrayList<String> inputFiles = kmeans.getInputFiles();
        ArrayList<Integer> getNumberClusters = kmeans.getNumberOfClusters();
        for (int i = 0; i < inputFiles.size(); i++) {
	        kmeans.init(inputFiles.get(i), getNumberClusters.get(i),i);
	        kmeans.calculate(getNumberClusters.get(i), i);
        }
    }

    public ArrayList<String> getInputFiles() {
    	return this.inputFiles;
    }
    
    public ArrayList<Integer> getNumberOfClusters() {
    	return this.numberOfClusters;
    }
    
    //Initializes the process
    public void init(String inputFile, int numberOfClusters, int index) throws FileNotFoundException, IOException {
        //Create Points
        points = Point.getPoints(inputFile);

        //Create Clusters
        //Set Random Centroids
        for (int i = 0; i < numberOfClusters; i++) {
            Cluster cluster = new Cluster(i);
            Point centroid = Point.createRandomPoint(MIN_COORDINATE,MAX_COORDINATE);
            cluster.setCentroid(centroid);
            clusters.add(cluster);
        }

        //Print Initial state
        plotClusters(numberOfClusters, index);
    }

    private void plotClusters(int numberOfClusters, int index) {
        for (int i = 0; i < numberOfClusters; i++) {
            Cluster c = clusters.get(i);
            plotCluster(c, index);
        }
    }
    
    private void plotCluster(Cluster c, int index) {
        System.out.println("[Cluster: " + c.getId() + "]");
        System.out.println("[Centroid: " + c.getCentroid() + "]");
        System.out.println("[Points: \n");
  
        try {
			FileWriter fw = new FileWriter("src/outfile" + Integer.toString(index+1) + ".txt", false);
	        PrintWriter pw  = new PrintWriter(fw);
	        for (Point p : points) {
	        	pw.write(p.toString() + "\t" + Integer.toString(c.getId()) + "\n");
	        	pw.flush();
	            System.out.println(p.toString() + "\t" + Integer.toString(c.getId()) );
	        }
	        System.out.println("]");
	        pw.close();
	    } catch (FileNotFoundException e) {
	        System.err.println("input file not found.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Can't access file");
			e.printStackTrace();
		}
    }

    //The process to calculate the K Means, with iterating method.
    private void calculate(int numberOfClusters, int index) {
        boolean finish = false;
        int iteration = 0;

        // Add in new data, one at a time, recalculating centroids with each new one.
        while(!finish) {
            //Clear cluster state
            clearClusters();

            ArrayList<Point> lastCentroids = getCentroids(numberOfClusters);

            //Assign points to the closer cluster
            assignCluster(numberOfClusters);

            //Calculate new centroids.
            calculateCentroids();

            iteration++;

            ArrayList<Point> currentCentroids = getCentroids(numberOfClusters);

            //Calculates total distance between new and old Centroids
            double distance = 0;
            for(int i = 0; i < lastCentroids.size(); i++) {
                distance += Point.distance(lastCentroids.get(i),currentCentroids.get(i));
            }
            System.out.println("#################");
            System.out.println("Iteration: " + iteration);
            System.out.println("Centroid distances: " + distance);
            plotClusters(numberOfClusters, index);

            if(distance == 0) {
                finish = true;
            }
        }
    }

    private void clearClusters() {
        for(Cluster cluster : clusters) {
            cluster.clear();
        }
    }

    private ArrayList<Point> getCentroids(int numberOfClusters) {
        ArrayList<Point> centroids = new ArrayList<>(numberOfClusters);
        for(Cluster cluster : clusters) {
            Point aux = cluster.getCentroid();
            Point point = new Point(aux.getX(),aux.getY());
            centroids.add(point);
        }
        return centroids;
    }

    private void assignCluster(int numberOfClusters) {
        double max = Double.MAX_VALUE;
        double min = max;
        int cluster = 0;
        double distance;

        for(Point point : points) {
            min = max;
            for(int i = 0; i < numberOfClusters; i++) {
                Cluster c = clusters.get(i);
                distance = Point.distance(point, c.getCentroid());
                if(distance < min){
                    min = distance;
                    cluster = i;
                }
            }
            point.setCluster(cluster);
            clusters.get(cluster).addPoint(point);
        }
    }
    
    private void calculateCentroids() {
        for(Cluster cluster : clusters) {
            double sumX = 0;
            double sumY = 0;
            ArrayList<Point> list = cluster.getPoints();
            int n_points = list.size();

            for(Point point : list) {
                sumX += point.getX();
                sumY += point.getY();
            }

            Point centroid = cluster.getCentroid();
            if(n_points > 0) {
                double newX = sumX / n_points;
                double newY = sumY / n_points;
                centroid.setX(newX);
                centroid.setY(newY);
            }
        }
    }
}