package com.example.demo;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class Show {

    public void showClients(Phone client, GridPane grid)
    {
          Label label = new Label(client.toString());
          label.setWrapText(true);
          grid.add(label,0,client.getNum());
    }

    public void clearClientInfo(TextField number, TextField id, TextField fullName, TextField accNumber,
                                TextField cityTalkTime, TextField outOfCityTalkTime) {
        number.clear();
        id.clear();
        fullName.clear();
        accNumber.clear();
        cityTalkTime.clear();
        outOfCityTalkTime.clear();
    }

    public void clearEnterID(TextField enter_id) {
        enter_id.clear();
    }

    public void showSortedClients(ArrayList<Phone> clients, GridPane grid)
    {
        grid.getChildren().clear();
        int counter = 0;
        for(Phone client : clients)
        {
            Label label = new Label(client.toString());
            grid.add(label,0,counter);
            counter++;
        }
    }
}
