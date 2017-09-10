package com.example.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private IdleTowerSet cIdleTowerSet = new IdleTowerSet();
    EditText editText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText3 = (EditText) findViewById(R.id.editText3);
        //editText3.setInputType(InputType.TYPE_NULL);
        editText3.setFocusable(false);

    }

    /** Called when the user taps the Send button */
    public void sendCommand(View view) {
        EditText editText = (EditText) findViewById(R.id.editText);
        String cmdText = editText.getText().toString();
        printLineToConsole(cmdText);
        proccessCommand(cmdText);
        editText.setText("");
    }

    private void proccessCommand(String cmdText) {
        int c = 0;
        String parameterString = "";
        ArrayList<String> parameterList = new ArrayList<>();
        String command = "";
        int cmdIndex = cmdText.indexOf(" ");
        if (cmdIndex == -1) {
            cmdIndex = cmdText.length();
        }

        if (cmdIndex != -1) {
            command = cmdText.substring(0, cmdIndex);
            Log.d("myTag", "Command " + command + " detected");

            if (command.length() < cmdText.length()) {
                parameterString = cmdText.substring(cmdIndex + 1);
                Log.d("myTag", "Remaining Text = " + parameterString);
            }


            if (!parameterString.isEmpty()) {
                c = 1;
            }
            while (c == 1) {
                int paramIndex = parameterString.indexOf(" ");
                if (paramIndex == -1) {
                    paramIndex = parameterString.length();
                }
                parameterList.add(parameterString.substring(0, paramIndex));
                if (parameterString.substring(0, paramIndex).length() < parameterString.length()) {
                    parameterString = parameterString.substring(paramIndex + 1);
                    Log.d("myTag", "Remaining Text = " + parameterString);
                }
                else {
                    c = 0;
                    Log.d("myTag", "Loop has been broken");
                }



            }
        }

        if (command.equals("idletowers")){
            printLineToConsole("idletowers command recognised");
            idletowersCommand(parameterList);

        }
        if (command.equals("addfbtower")){
            printLineToConsole("addfbtower command recognised");
            addfireballtower(parameterList);

        }
        if (command.equals("addsnipertower")){
            printLineToConsole("addsnipertower command recognised");
            addsnipertower(parameterList);

        }
        if (command.equals("addicetower")){
            printLineToConsole("addicetower command recognised");
            addicetower(parameterList);

        }
        if (command.equals("addlightningtower")){
            printLineToConsole("addlightningtower command recognised");
            addlightningtower(parameterList);

        }
    }

    private void addlightningtower(ArrayList<String> parameterList) {
        int towerSlot = 1;
        for (int i = 0; i <parameterList.size (); i++){
            if (parameterList.get(i).equals("!slot")) {
                if (parameterList.get(i + 1) != null);{
                    towerSlot = Integer.parseInt(parameterList.get(i + 1));
                }
            }
        }
        if (cIdleTowerSet.towerSlotArray.get(towerSlot-1).hasTower ==false){
            printLineToConsole(cIdleTowerSet.towerSlotArray.get(towerSlot - 1).setTower("Lightning Tower"));
        }
        else {
            printLineToConsole("Tower Slot is full");
        }
    }

    private void addicetower(ArrayList<String> parameterList) {
        int towerSlot = 1;
        for (int i = 0; i <parameterList.size (); i++){
            if (parameterList.get(i).equals("!slot")) {
                if (parameterList.get(i + 1) != null);{
                    towerSlot = Integer.parseInt(parameterList.get(i + 1));
                }
            }
        }
        if (cIdleTowerSet.towerSlotArray.get(towerSlot-1).hasTower ==false){
            printLineToConsole(cIdleTowerSet.towerSlotArray.get(towerSlot - 1).setTower("Ice Tower"));
        }
        else {
            printLineToConsole("Tower Slot is full");
        }
    }

    private void addsnipertower(ArrayList<String> parameterList) {
        int towerSlot = 1;
        for (int i = 0; i <parameterList.size (); i++){
            if (parameterList.get(i).equals("!slot")) {
                if (parameterList.get(i + 1) != null);{
                    towerSlot = Integer.parseInt(parameterList.get(i + 1));
                }
            }
        }
        if (cIdleTowerSet.towerSlotArray.get(towerSlot-1).hasTower ==false){
            printLineToConsole(cIdleTowerSet.towerSlotArray.get(towerSlot - 1).setTower("Sniper Tower"));
        }
        else {
            printLineToConsole("Tower Slot is full");
        }
    }

    private void addfireballtower(ArrayList<String> parameterList) {
        int towerSlot = 1;
        for (int i = 0; i < parameterList.size(); i++){
            Log.d ("myTag", "Loop Number: " + (i+1) );
            if (parameterList.get(i).equals("!slot")) {
                Log.d ("myTag", "!slot detected in parameted list" );

               if (parameterList.get(i + 1) != null);{
                    towerSlot = Integer.parseInt(parameterList.get(i + 1));
                    Log.d("myTag", "TowerSlot " + towerSlot + " selected");
               }



            }
        }
        if ( cIdleTowerSet.towerSlotArray.get(towerSlot-1).hasTower == false) {
            printLineToConsole(cIdleTowerSet.towerSlotArray.get(towerSlot - 1).setTower("Fireball Tower"));
        }
        else {
            printLineToConsole("Tower Slot is full");
        }

    }

    private void idletowersCommand(ArrayList<String> parameterList) {

        for (int i = 0; i < parameterList.size(); i++){
            if (parameterList.get(i) == "!entity") {

            }
        }

        printLineToConsole("List of Idle Towers\n");
        printLineToConsole(cIdleTowerSet.sendTowerListToConsole());
    }

    private void printLineToConsole(String message){
        editText3 = (EditText) findViewById(R.id.editText3);

        editText3.append(message + "\n");
        //editText3.setInputType(InputType.TYPE_NULL);

    }
}
