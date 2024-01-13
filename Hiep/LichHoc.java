package com.example.demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class LichHoc extends Application {

    @Override
    public void start(Stage LichHoc) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("LichHoc.fxml"));
        Scene scene = new Scene(root, 1280, 720);
        scene.getStylesheets().add(getClass().getResource("Main.css").toExternalForm());
        LichHoc.setResizable(false);
        Image logo = new Image(getClass().getResourceAsStream("logo.png"));
        LichHoc.getIcons().add(logo);
        LichHoc.setScene(scene);
        LichHoc.setTitle("Lịch học sinh viên");
        LichHoc.show();
    }
}
