package builder;

// The concrete builder class that assembles the parts
// of the finished Robot object

class TheRobotBuilder implements RobotBuilder {

    private Robot robot;

    TheRobotBuilder() { this.robot = new Robot(); }

    public void buildRobotHead()  { robot.setRobotHead("Tin Head"); }
    public void buildRobotTorso() { robot.setRobotTorso("Tin Torso"); }
    public void buildRobotArms()  { robot.setRobotArms("Blowtorch Arms"); }
    public void buildRobotLegs()  { robot.setRobotLegs("Rollar Skates"); }
    public Robot getRobot() { return this.robot; }
}
