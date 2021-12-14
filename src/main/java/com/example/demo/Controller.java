package com.example.demo;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Controller {

    @FXML private ResourceBundle resources;
    @FXML private URL location;

    @FXML private Button add_customer;
    @FXML private Button exit;
    @FXML private Button remove;

    @FXML private GridPane full_list;
    @FXML private GridPane sorted_list;

    @FXML private TextField number;
    @FXML private TextField id;
    @FXML private TextField full_name;
    @FXML private TextField acc_number;
    @FXML private TextField time_of_city_calls;
    @FXML private TextField time_out_of_city_calls;
    @FXML private TextField set_limit;
    @FXML private TextField lower_limit;
    @FXML private TextField higher_limit;
    @FXML private TextField enter_id;

    @FXML private CheckBox checkBox_1;
    @FXML private CheckBox checkBox_2;
    @FXML private CheckBox checkBox_3;

    private final WriteObject writeObject = new WriteObject();
    private final ReadObject readObject = new ReadObject();
    private ArrayList<Phone> phone = new ArrayList<Phone>();
    private Phone client = new Phone();
    private final Show show = new Show();
    private final Logic logic = new Logic();
    @FXML
    void initialize() {
        add_customer.setOnAction(event -> {
            if (number.getText() != "" && id.getText() != "" && full_name.getText() != ""
                    && acc_number.getText() != "" && time_of_city_calls.getText() != ""
                    && time_out_of_city_calls.getText() != "") {

                client = logic.addClient(Integer.parseInt(number.getText()), Integer.parseInt(id.getText()),
                        full_name.getText().trim(), Integer.parseInt(acc_number.getText()),
                        Float.parseFloat(time_of_city_calls.getText()), Float.parseFloat(time_out_of_city_calls.getText()));
                phone.add(client);
                writeObject.writeObject(phone, "lab_6.bin");
                readObject.readObject(phone, "lab_6.bin");
                show.showClients(client, full_list);
                show.clearClientInfo(number, id, full_name, acc_number, time_of_city_calls, time_out_of_city_calls);

            } else {
                add_customer.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("error.fxml"));

                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();
            }
            if (checkBox_1.isSelected()) {
                show.showSortedClients(logic.infAboutCityCalls(phone, Float.parseFloat(set_limit.getText())),
                        sorted_list);
            } else if (checkBox_2.isSelected()) {
                show.showSortedClients(logic.outOfCityTalkTimeUsers(phone), sorted_list);
            } else if (checkBox_3.isSelected()) {
                show.showSortedClients(logic.accNumberInRange(phone, Integer.parseInt(lower_limit.getText()),
                                Integer.parseInt(higher_limit.getText())),
                                        sorted_list);
            }
        });

        checkBox_1.setOnAction(event -> {
            if (checkBox_1.isSelected()) {
                if (set_limit.getText() != "") {
                    show.showSortedClients(logic.infAboutCityCalls(phone, Float.parseFloat(set_limit.getText())),
                            sorted_list);
                }
            }
            else {
                sorted_list.getChildren().clear();
            }
        });

        checkBox_2.setOnAction(event -> {
           if (checkBox_2.isSelected()) {
               show.showSortedClients(logic.outOfCityTalkTimeUsers(phone), sorted_list);
           }
           else {
               sorted_list.getChildren().clear();
           }
        });


        checkBox_3.setOnAction(event -> {
            if(checkBox_3.isSelected()) {
                if (lower_limit.getText() != "" && higher_limit.getText() != "") {
                    show.showSortedClients(logic.accNumberInRange(phone, Integer.parseInt(lower_limit.getText()),
                                    Integer.parseInt(higher_limit.getText())),
                                            sorted_list);
                }
            }
            else {
                sorted_list.getChildren().clear();
            }
        });

        remove.setOnAction(event -> {
            ArrayList<Phone> temp = new ArrayList<Phone>();
            if (enter_id.getText() != "") {

                for (Phone client : phone) {
                    if (Integer.parseInt(enter_id.getText()) != client.getId()) {
                        temp.add(client);
                    }
                    phone = temp;
                }
                show.clearEnterID(enter_id);
                show.showSortedClients(phone, full_list);
                if (checkBox_1.isSelected()) {
                    show.showSortedClients(logic.infAboutCityCalls(phone, Float.parseFloat(set_limit.getText())),
                            sorted_list);
                } else if (checkBox_2.isSelected()) {
                    show.showSortedClients(logic.outOfCityTalkTimeUsers(phone), sorted_list);
                } else if (checkBox_3.isSelected()) {
                    show.showSortedClients(logic.accNumberInRange(phone, Integer.parseInt(lower_limit.getText()),
                                    Integer.parseInt(higher_limit.getText())),
                                            sorted_list);
                }
            } else {
                add_customer.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("error.fxml"));

                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();
            }

        });
    }

    @FXML
    public void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }

}
