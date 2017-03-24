package creational.builder;

// The director / engineer class creates a Robot using the creational.builder interface that is defined (TheRobotBuilder)
class RobotEngineer {

    private RobotBuilder robotBuilder;

    // TheRobotBuilder specification is sent to the engineer
    RobotEngineer(RobotBuilder robotBuilder){

        this.robotBuilder = robotBuilder;
    }

    // Return the Robot made from the TheRobotBuilder spec
    Robot getRobot(){

        return this.robotBuilder.getRobot();
    }

    // Execute the methods specific to the RobotBuilder that implements RobotBuilder (TheRobotBuilder)
    void makeRobot() {

        this.robotBuilder.buildRobotHead();
        this.robotBuilder.buildRobotTorso();
        this.robotBuilder.buildRobotArms();
        this.robotBuilder.buildRobotLegs();
    }
}
