package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class DiemThi extends Application {
    @Override
    public void start(Stage diemThi) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("DiemThi.fxml"));
        //Parent root2 = FXMLLoader.load(getClass().getResource("DiemThi2.fxml"));
        Scene scene = new Scene(root,1280,720);
        scene.getStylesheets().add(getClass().getResource("Main.css").toExternalForm());
        scene.getStylesheets().add(getClass().getResource("DiemThi.css").toExternalForm());

        diemThi.setResizable(false);
        Image logo = new Image(getClass().getResourceAsStream("logo.png"));
        diemThi.setScene(scene);
        diemThi.getIcons().add(logo);
        diemThi.setTitle("DiemThi");
        diemThi.show();
    }
}
