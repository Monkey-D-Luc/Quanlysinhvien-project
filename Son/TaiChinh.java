package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TaiChinh extends Application {
    @Override
    public void start(Stage taiChinh) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("hocphi.fxml"));
        Scene scene = new Scene(root,1280,720);
        scene.getStylesheets().add(getClass().getResource("Main.css").toExternalForm());
        if (LoginController.role.equals("Student")){
            root = FXMLLoader.load(getClass().getResource("hocphi_student.fxml"));
            scene = new Scene(root,1280,720);
        }
        taiChinh.setResizable(false);
        Image logo = new Image(getClass().getResourceAsStream("logo.png"));
        taiChinh.setScene(scene);
        taiChinh.getIcons().add(logo);
        taiChinh.setTitle("Tài Chính");
        taiChinh.show();
    }



    public static void main(String[] args) {
        launch();
    }
}
