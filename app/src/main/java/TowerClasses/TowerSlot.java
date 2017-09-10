package TowerClasses;

import TowerClasses.Tower;

/**
 * Created by final on 9/9/2017.
 */

public class TowerSlot {




    public boolean hasTower = false;
    Tower currentTower;

    public TowerSlot(){
        currentTower = new Tower();
    }

    public String getTowerType(){

        return currentTower.getTowerType();
    }

    public String setTower(Tower t) {
        this.currentTower = t;
        this.hasTower = true;

        return "A " + currentTower.getTowerType() + " has been added";
    }
}
