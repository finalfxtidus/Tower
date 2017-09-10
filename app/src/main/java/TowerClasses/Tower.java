package TowerClasses;

/**
 * Created by final on 9/9/2017.
 */

public class Tower {

    public double turretRange;
    public double turretAngle;
    public double projectileVelocity;
    public int damage = 0;
    public double attackSpeed;
    int xPos;
    int yPos;
    double splash = 0;
    String towerType = "No Tower";

    public void setProjectileVelocity(double projectileVelocity) {
        this.projectileVelocity = projectileVelocity;
    }

    public double getTurretAngle() {
        return turretAngle;
    }

    public double getProjectileVelocity() {
        return projectileVelocity;
    }

    public int getDamage() {
        return damage;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public double getSplash() {
        return splash;
    }

    public String getTowerType() {
        return towerType;
    }



    //TODO Method that rotates tower to a specific targer, based on targeting type (first, last, tough, weak)

}
