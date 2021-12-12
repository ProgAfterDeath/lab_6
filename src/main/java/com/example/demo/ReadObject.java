package com.example.demo;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.io.*;
import java.util.ArrayList;

public class ReadObject {

    public String deserialization(ArrayList<Phone> clients, String filename){
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);

            for (Phone client : clients = (ArrayList<Phone>) ois.readObject())
            ois.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return filename;
    }
}
