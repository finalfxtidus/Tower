package ProjectileClasses;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

/**
 * Created by final on 9/9/2017.
 */

public class Projectile {

    double xPos;
    double yPos;
    double xSpeed;
    double ySpeed;

    public Projectile(double angle, double velocity){
        calculateXYSpeed(angle, velocity);
    }

    public void calculateXYSpeed(double angle, double velocity){
        xSpeed = velocity * cos(angle);
        ySpeed = velocity * sin(angle);
    }

    public void updateMovement(double dTime){
        xPos = xPos + xSpeed * dTime;
        yPos = yPos + ySpeed * dTime;
    }

}
