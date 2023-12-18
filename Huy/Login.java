package com.quanlisinhvien;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class Login extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage DangNhap) throws Exception {
        DangNhap.setWidth(1280);
        DangNhap.setHeight(720);
        DangNhap.setResizable(false);
        DangNhap.setTitle("Đăng nhập");

        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root,Color.LIGHTPINK);

        Image logo = new Image(getClass().getResourceAsStream("logo.png"));
        DangNhap.getIcons().add(logo);
 
        DangNhap.setScene(scene);
        DangNhap.show();
    }

}