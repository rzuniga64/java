package creational.abstract_factory.ship.enemyshipbuilding;

import creational.abstract_factory.ship.enemyship.EnemyShip;

/**
 *  This class acts as an ordering mechanism for creating EnemyShips that have a weapon, engine & name.
 */
public abstract class EnemyShipBuilding {


    /**
     *  The specific parts used for engine & weapon depend upon the String that is passed to this method
     *  @param typeOfShip
     *  @return EnemyShip
     */
    protected abstract EnemyShip makeEnemyShip(String typeOfShip);


    /**
     *  When called a new EnemyShip is made. The specific parts are based on the String entered. After the ship is made
     *  we execute multiple methods in the EnemyShip Object
     */
    public EnemyShip orderTheShip(String typeOfShip) {

        EnemyShip theEnemyShip = makeEnemyShip(typeOfShip);

        theEnemyShip.makeShip();
        theEnemyShip.displayEnemyShip();
        theEnemyShip.followHeroShip();
        theEnemyShip.enemyShipShoots();

        return theEnemyShip;
    }
}
