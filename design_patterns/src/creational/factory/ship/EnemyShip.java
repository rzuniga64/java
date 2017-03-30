package creational.factory.ship;

public abstract class EnemyShip {

    private String name;
    private double amtDamage;

    public String getName() { return name; }
    public void setName(String newName) { name = newName; }

    private double getDamage() { return amtDamage; }
    void setDamage(double newDamage) { amtDamage = newDamage; }

    void followHeroShip(){
        System.out.println(getName() + " is following the hero");
    }

    void displayEnemyShip(){
        System.out.println(getName() + " is on the screen");
    }

    void enemyShipShoots() {
        System.out.println(getName() + " attacks and does " + getDamage() + " damage to hero");
    }
}
