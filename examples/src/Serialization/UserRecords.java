package Serialization;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class UserRecords {
	private static int userIdCounter = 0;
    private final Map<Integer, ZStudent> users;

    public UserRecords() {
        users = new HashMap<Integer, ZStudent>();
    }

    public Map<Integer, ZStudent> getUsers() {
        return users;
    }

    public static int getUserIdCounter() {
        return userIdCounter;
    }

    public static void setUserIdCounter(int userIdCounter) {
        UserRecords.userIdCounter = userIdCounter;
    }

    /**
     *
     * @param no
     * @param first
     * @param mid
     * @param last
     * @param ave 
     */
   
    public ZStudent addZStudent(int no, String first, String mid, String last, float ave) {
    
        int userId = userIdCounter++;
        ZStudent stud = new ZStudent(no, first, mid, last, ave);
        users.put(userId, stud);
        return stud;
    }
    
	 public ZStudent findUserByName(String name) {
	        for (int id : users.keySet()) {
	            ZStudent user = users.get(id);
	            if (user.getFirst().equals(name)) {
	                return user;
	            }
	        }

	        return null;
	    }

	 public static void main(String[] args) {
		 UserRecords usr = new UserRecords();
		    usr.addZStudent(50, "Ngu", "M", "Monday", 50.0F);
			usr.addZStudent(100, "Gray", "G", "Tuesday", 60.0F);
			usr.addZStudent(150, "Green", "G", "Wednesday", 70.0F);
			usr.addZStudent(200, "Purple", "P", "Thursday", 80.0F);
			usr.addZStudent(300, "Red", "R", "Friday", 90.0F);
			
			System.out.println("Enter the name of student you want to search");
			Scanner in = new Scanner(System.in);
	        String name = in.nextLine();
	        ZStudent ss = usr.findUserByName(name);
	        if (ss != null) {
	        System.out.println("Found " + ss.getFirst() + "!");
	        System.out.println(ss.toString());
	        }
	        else {
	        	System.out.println("User" + name + " not found");
	        }
	        
	 }
}
