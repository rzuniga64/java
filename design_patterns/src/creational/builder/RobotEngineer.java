package creational.builder;

/**
 *  The director/engineer class creates a Robot using the TheRobotBuilder interface that is defined.
 */
 class RobotEngineer {

    private RobotBuilder robotBuilder;

    /**
     *  TheRobotBuilder specification is sent to the engineer.
     *  @param robotBuilder robotbuilder
     */
     RobotEngineer(final RobotBuilder robotBuilder) {

        this.robotBuilder = robotBuilder;
    }

    /**
     * Return the Robot made from the TheRobotBuilder spec.
     * @return a Robot
     */
     Robot getRobot() {

        return this.robotBuilder.getRobot();
    }

    /**
     *  Execute the methods specific to the RobotBuilder that implements
     *  RobotBuilder (TheRobotBuilder).
     */
     void makeRobot() {

        this.robotBuilder.buildRobotHead();
        this.robotBuilder.buildRobotTorso();
        this.robotBuilder.buildRobotArms();
        this.robotBuilder.buildRobotLegs();
    }
}
