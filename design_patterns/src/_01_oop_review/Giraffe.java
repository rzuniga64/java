package _01_oop_review;

public class Giraffe extends Creature{

    private String name;

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return name;
    }

    @Override
    public void setName(String newName) {
        name = newName;
    }

    @Override
    public double getHeight() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setHeight(double newHeight) {
        // TODO Auto-generated method stub
    }

    @Override
    public double getWeight() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setWeight(double newWeight) {
        // TODO Auto-generated method stub
    }

    @Override
    public String getFavFood() {
        // TODO Auto-generated method stub
        return favFood;
    }

    @Override
    public void setFavFood(String newFood) {
        name = newFood;
    }

    @Override
    public double getSpeed() {
        // TODO Auto-generated method stub
        return speed;
    }

    @Override
    public void setSpeed(double newSpeed) {
        speed = newSpeed;
    }

    @Override
    public String getSound() {
        // TODO Auto-generated method stub
        return sound;
    }

    @Override
    public void setSound(String newSound) {
        sound = newSound;
    }
}
