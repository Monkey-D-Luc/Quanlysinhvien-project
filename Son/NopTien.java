package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.stage.Stage;



public class NopTien extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage NopTien) throws Exception {
        NopTien.setResizable(false);
        NopTien.setTitle("Nộp tiền ");

        Parent root = FXMLLoader.load(getClass().getResource("noptien.fxml"));
        Scene scene = new Scene(root);

        Image logo = new Image(getClass().getResourceAsStream("logo.png"));
        NopTien.getIcons().add(logo);

        NopTien.setScene(scene);
        NopTien.show();
    }

}
