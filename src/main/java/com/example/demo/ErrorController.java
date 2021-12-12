package com.example.demo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ErrorController {

    @FXML private ResourceBundle resources;

    @FXML private URL location;
    @FXML private ImageView img;
    @FXML private Button ok;

    @FXML
    void initialize() {
        ok.setOnAction(event ->{
            Stage stage1 = (Stage) ok.getScene().getWindow();
            stage1.close();
            Main new_main = new Main();
            try {
                Stage stage = new Stage();
                new_main.start(stage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
