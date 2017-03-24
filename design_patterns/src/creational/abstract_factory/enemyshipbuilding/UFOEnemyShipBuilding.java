package creational.abstract_factory.enemyshipbuilding;

// This is the only class that needs to change, if you want to determine which enemy ships you want to provide as an
// option to build

import creational.abstract_factory.enemyship.EnemyShip;
import creational.abstract_factory.enemyship.UFOEnemyShip;
import creational.abstract_factory.enemyship.UFOBossEnemyShip;
import creational.abstract_factory.enemyshipfactory.EnemyShipFactory;
import creational.abstract_factory.enemyshipfactory.UFOBossEnemyShipFactory;
import creational.abstract_factory.enemyshipfactory.UFOEnemyShipFactory;

public class UFOEnemyShipBuilding extends EnemyShipBuilding {

     public EnemyShip makeEnemyShip(String typeOfShip) {
        EnemyShip theEnemyShip = null;

        // If UFO was sent grab use the creational.factory that knows what types of weapons and engines a regular UFO needs.
         // The EnemyShip object is returned & given a name
        if(typeOfShip.equals("UFO")){
            EnemyShipFactory shipPartsFactory = new UFOEnemyShipFactory();
            theEnemyShip = new UFOEnemyShip(shipPartsFactory);
            theEnemyShip.setName("UFO Grunt Ship");
        } else
            // If UFO BOSS was sent grab use the creational.factory that knows what types of weapons and engines a Boss UFO needs.
            // The EnemyShip object is returned & given a name
            if(typeOfShip.equals("UFO BOSS")){
                EnemyShipFactory shipPartsFactory = new UFOBossEnemyShipFactory();
                theEnemyShip = new UFOBossEnemyShip(shipPartsFactory);
                theEnemyShip.setName("UFO Boss Ship");
            }

        return theEnemyShip;
    }
}