package builder;

class TestRobotBuilder {

    public static void main(String[] args){

        // Get a RobotBuilder of type TheRobotBuilder
        RobotBuilder oldStyleRobot = new TheRobotBuilder();

        // Pass the TheRobotBuilder specification to the engineer
        RobotEngineer robotEngineer = new RobotEngineer(oldStyleRobot);

        // Tell the engineer to make the Robot using the specifications of the TheRobotBuilder class
        robotEngineer.makeRobot();

        // The engineer returns the right robot based off of the spec sent to it on line 11
        Robot firstRobot = robotEngineer.getRobot();

        System.out.println("Robot Built");
        System.out.println(firstRobot.toString());
    }
}
