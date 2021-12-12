package com.example.demo;

import java.io.*;
import java.util.ArrayList;

public class WriteObject {

    public void serialization(ArrayList<Phone> clients, String filename) {
            try {
                FileOutputStream fos = new FileOutputStream(filename);
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                oos.writeObject(clients);

                oos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

    }

}
