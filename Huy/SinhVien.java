package com.quanlisinhvien;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class SinhVien extends Application {

    @Override
    public void start(Stage SinhVien) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("SinhVien.fxml"));
        Scene scene = new Scene(root,1280,720);
        SinhVien.setResizable(false);
        Image logo = new Image(getClass().getResourceAsStream("logo.png"));
        SinhVien.getIcons().add(logo);
        SinhVien.setScene(scene);
        SinhVien.setTitle("SinhVien");
        SinhVien.show();
    }
    
}
