package creational.builder;

/**
 *  This is the interface that will be returned from the creational.builder.
 */
interface RobotPlan {

    String getRobotHead();
    void setRobotHead(String head);
    String getRobotTorso();
    void setRobotTorso(String torso);
    String getRobotArms();
    void setRobotArms(String arms);
    String getRobotLegs();
    void setRobotLegs(String legs);
}
