package com.example.myfirstapp;

/**
 * Created by final on 9/9/2017.
 */

class TowerSlot {



    private String towerName = "No Tower";
    boolean hasTower = false;


    public String getTowerName(){

        return towerName;
    }

    public String setTower(String towerName) {
        this.towerName = towerName;
        this.hasTower = true;

        return "A " + towerName + " Tower has been added";
    }
}
