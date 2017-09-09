package com.example.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
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

            if (command.length() > cmdText.length()) {
                parameterString = cmdText.substring(cmdIndex + 1);
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
                if (parameterString.isEmpty()) {
                    c = 0;
                }
                if (!parameterString.isEmpty()) {
                    parameterString = parameterString.substring(paramIndex + 1);
                }


            }
        }

        if (command.equals("idletowers")){
            printLineToConsole("idletowers command recognised");
            idletowersCommand(parameterList);

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
