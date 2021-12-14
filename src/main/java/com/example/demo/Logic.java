package com.example.demo;

import javafx.scene.control.TextField;
import java.util.ArrayList;

public class Logic{

    public Phone addClient(TextField num, TextField id, TextField fullName, TextField accNumber,
                           TextField cityTalkTime, TextField outOfCityTalkTime){
        Phone client = new Phone();
        client.setNum(Integer.parseInt(num.getText()));
        client.setId(Integer.parseInt(id.getText()));
        client.setFullName(fullName.getText().trim());
        client.setAccNumber(Integer.parseInt(accNumber.getText()));
        client.setCityTalkTime(Float.parseFloat(cityTalkTime.getText()));
        client.setOutOfCityTalkTime(Float.parseFloat(outOfCityTalkTime.getText()));
        return client;
    }

    public void clearClientInfo(TextField num, TextField id, TextField fullName, TextField accNumber,
                                 TextField cityTalkTime, TextField outOfCityTalkTime) {
        num.clear();
        id.clear();
        fullName.clear();
        accNumber.clear();
        cityTalkTime.clear();
        outOfCityTalkTime.clear();
    }

    public void clearEnterID(TextField enter_id) {
        enter_id.clear();
    }

    public ArrayList<Phone> infAboutCityCalls(ArrayList<Phone> clients, float value){
        ArrayList<Phone> temp = new ArrayList<Phone>();

        for (Phone client : clients){
            if (client.getCityTalkTime() > value){
                temp.add(client);
            }
        }
        return temp;
    }

    public ArrayList<Phone> outOfCityTalkTimeUsers(ArrayList<Phone> clients){
        ArrayList<Phone> temp = new ArrayList<Phone>();
        for (Phone client : clients){
            if (client.getOutOfCityTalkTime() > 0){
                temp.add(client);
            }
        }
        return temp;
    }

    public ArrayList<Phone> accNumberInRange(ArrayList<Phone> clients, int minValue, int maxValue){
        ArrayList<Phone> temp = new ArrayList<Phone>();

        for (Phone client : clients){
            if (client.getAccNumber() >= minValue && client.getAccNumber() <= maxValue){
                temp.add(client);
            }
        }
        return temp;
    }

}
