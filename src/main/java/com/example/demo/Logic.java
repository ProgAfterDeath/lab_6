package com.example.demo;

import javafx.scene.control.TextField;
import java.util.ArrayList;

public class Logic{

    public Phone addClient(int number, int id, String fullName, int accNumber,
                           float cityTalkTime, float outOfCityTalkTime){
        Phone client = new Phone();
        client.setNum(number);
        client.setId(id);
        client.setFullName(fullName);
        client.setAccNumber(accNumber);
        client.setCityTalkTime(cityTalkTime);
        client.setOutOfCityTalkTime(outOfCityTalkTime);
        return client;
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
