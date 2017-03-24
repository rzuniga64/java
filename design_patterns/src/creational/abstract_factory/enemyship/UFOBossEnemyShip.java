package creational.abstract_factory.enemyship;

import creational.abstract_factory.enemyshipfactory.EnemyShipFactory;

public class UFOBossEnemyShip extends EnemyShip{

    // We define the type of ship we want to create by stating we want to use the creational.factory that makes enemy ships
    private EnemyShipFactory shipFactory;

    // The enemy ship required parts list is sent to this method. They behavorial.state that the enemy ship must have a weapon and
    // engine assigned. That object also states the specific parts needed to make a Boss UFO versus a Regular UFO
    public UFOBossEnemyShip(EnemyShipFactory shipFactory){

        this.shipFactory = shipFactory;
    }

    // EnemyShipBuilding calls this method to build a specific UFOBossEnemyShip
    public void makeShip() {

        System.out.println("Making enemy ship " + getName());

        // The specific weapon & engine needed were passed in shipFactory. We are assigning those specific part objects
        // to the UFOBossEnemyShip here
        weapon = shipFactory.addESGun();
        engine = shipFactory.addESEngine();
    }
}