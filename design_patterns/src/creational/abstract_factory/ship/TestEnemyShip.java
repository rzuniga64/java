package creational.abstract_factory.ship;

import creational.abstract_factory.ship.enemyship.EnemyShip;
import creational.abstract_factory.ship.enemyshipbuilding.EnemyShipBuilding;
import creational.abstract_factory.ship.enemyshipbuilding.UFOEnemyShipBuilding;

public class TestEnemyShip {

    public static void main(String[] args) {
        // EnemyShipBuilding handles orders for new EnemyShips. You send it a code using the orderTheShip method &
        // it sends the order to the right creational.factory for creation

        EnemyShipBuilding MakeUFOs = new UFOEnemyShipBuilding();

        EnemyShip theGrunt = MakeUFOs.orderTheShip("UFO");
        System.out.println(theGrunt + "\n");

        EnemyShip theBoss = MakeUFOs.orderTheShip("UFO BOSS");
        System.out.println(theBoss + "\n");
    }
}
