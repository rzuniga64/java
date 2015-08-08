package builder;

// The director / engineer class creates a Robot using the
// builder interface that is defined (TheRobotBuilder)

public class RobotEngineer {

    private RobotBuilder robotBuilder;

    // TheRobotBuilder specification is sent to the engineer
    public RobotEngineer(RobotBuilder robotBuilder){

        this.robotBuilder = robotBuilder;
    }

    // Return the Robot made from the TheRobotBuilder spec
    public Robot getRobot(){

        return this.robotBuilder.getRobot();
    }

    // Execute the methods specific to the RobotBuilder
    // that implements RobotBuilder (TheRobotBuilder)
    public void makeRobot() {

        this.robotBuilder.buildRobotHead();
        this.robotBuilder.buildRobotTorso();
        this.robotBuilder.buildRobotArms();
        this.robotBuilder.buildRobotLegs();
    }
}
