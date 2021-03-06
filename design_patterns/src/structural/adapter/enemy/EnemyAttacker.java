package structural.adapter.enemy;

/**
 *  This is the target interface. This is what the client expects to work with. It is the adapters job to make new
 *  classes compatible with this one.
 */
interface EnemyAttacker {

    void fireWeapon();
    void driveForward();
    void assignDriver(String driverName);
}