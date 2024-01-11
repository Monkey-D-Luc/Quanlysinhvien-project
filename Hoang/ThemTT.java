package com.example.demo;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ThemTT {
    public void start(Stage SinhVien) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ThemTT.fxml"));
        Scene scene = new Scene(root);
        SinhVien.setResizable(false);
        Image logo = new Image(getClass().getResourceAsStream("logo.png"));
        SinhVien.getIcons().add(logo);
        SinhVien.setScene(scene);
        SinhVien.setTitle("Thêm thông tin");
        SinhVien.show();
    }
}
