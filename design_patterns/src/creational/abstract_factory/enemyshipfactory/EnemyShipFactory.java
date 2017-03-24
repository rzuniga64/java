package creational.abstract_factory.enemyshipfactory;

import creational.abstract_factory.engine.ESEngine;
import creational.abstract_factory.weapon.ESWeapon;

// With an Abstract Factory Pattern you won't just build ships, but also all of the components for the ships
// Here is where you define the parts that are required if an object wants to be an enemy ship
public interface EnemyShipFactory{

    ESWeapon addESGun();
    ESEngine addESEngine();
}