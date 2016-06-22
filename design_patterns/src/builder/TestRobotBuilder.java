package builder;

class TestRobotBuilder {

    public static void main(String[] args){

        // Get a specification to build a Robot
        RobotBuilder oldStyleRobot = new TheRobotBuilder();

        // Pass the RobotBuilder specification to the engineer so he can build it
        RobotEngineer robotEngineer = new RobotEngineer(oldStyleRobot);

        // The engineer makes the Robot using the specifications of the RobotBuilder class
        robotEngineer.makeRobot();

        // The engineer returns the right robot based off of the specification sent to it
        Robot firstRobot = robotEngineer.getRobot();

        System.out.println("Robot Built");
        System.out.println(firstRobot.toString());
    }
}
