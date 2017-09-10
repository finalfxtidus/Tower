package com.example.myfirstapp;

import java.util.ArrayList;

/**
 * Created by final on 9/9/2017.
 */

public class IdleTowerSet {
    ArrayList<TowerSlot> towerSlotArray = new ArrayList<TowerSlot>();


    public IdleTowerSet(){
        addTowerSlot();
        addTowerSlot();
        addTowerSlot();
    }

    public String sendTowerListToConsole( ){
        String towerListS = "";

        for (int i = 0; i < towerSlotArray.size(); i++){
            towerListS = towerListS.concat("Tower Number:" + (i + 1) + " Name:" + towerSlotArray.get(i).getTowerType() + "\n");
        }

        return towerListS;
    }

    public void addTowerSlot(){
        towerSlotArray.add(new TowerSlot());
    }

}
