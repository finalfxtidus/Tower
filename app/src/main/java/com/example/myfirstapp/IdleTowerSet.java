package com.example.myfirstapp;

import java.util.ArrayList;

/**
 * Created by final on 9/9/2017.
 */

public class IdleTowerSet {
    ArrayList<TowerSlot> towerSlotArray = new ArrayList<TowerSlot>();

    public IdleTowerSet(){
        towerSlotArray.add(new TowerSlot());
        towerSlotArray.add(new TowerSlot());
        towerSlotArray.add(new TowerSlot());
    }

    public String sendTowerListToConsole( ){
        String towerListS = "";

        for (int i = 0; i < towerSlotArray.size(); i++){
            towerListS = towerListS.concat("Tower Number:" + (i + 1) + " Name:" + towerSlotArray.get(i).getTowerName() + "\n");
        }

        return towerListS;
    }

}
