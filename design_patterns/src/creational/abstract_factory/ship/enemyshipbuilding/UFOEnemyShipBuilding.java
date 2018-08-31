package creational.abstract_factory.ship.enemyshipbuilding;

import creational.abstract_factory.ship.enemyship.EnemyShip;
import creational.abstract_factory.ship.enemyship.UFOEnemyShip;
import creational.abstract_factory.ship.enemyship.UFOBossEnemyShip;
import creational.abstract_factory.ship.enemyshipfactory.EnemyShipFactory;
import creational.abstract_factory.ship.enemyshipfactory.UFOBossEnemyShipFactory;
import creational.abstract_factory.ship.enemyshipfactory.UFOEnemyShipFactory;

/**
 *  This is the only class that needs to change, if you want to determine which enemy ships you want to provide as an
 *  option to build
 */
public class UFOEnemyShipBuilding extends EnemyShipBuilding {

    /**
     *  If UFO was sent grab use the creational.factory that knows what types of weapons and engines a regular UFO needs.
     *  The EnemyShip object is returned & given a name.
     *  @param typeOfShip
     *  @return EnemyShip
     */
     public EnemyShip makeEnemyShip(String typeOfShip) {

        EnemyShip theEnemyShip = null;

        if(typeOfShip.equals("UFO")){
            EnemyShipFactory shipPartsFactory = new UFOEnemyShipFactory();
            theEnemyShip = new UFOEnemyShip(shipPartsFactory);
            theEnemyShip.setName("UFO Grunt Ship");

        } else if(typeOfShip.equals("UFO BOSS")){
                EnemyShipFactory shipPartsFactory = new UFOBossEnemyShipFactory();
                theEnemyShip = new UFOBossEnemyShip(shipPartsFactory);
                theEnemyShip.setName("UFO Boss Ship");
        }

        return theEnemyShip;
    }
}