package com.quanlisinhvien;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class DiemThi extends Application {

    @Override
    public void start(Stage SinhVien) throws Exception {
        SinhVien.setWidth(1280);
        SinhVien.setHeight(720);
        SinhVien.setResizable(false);
        Image logo = new Image(getClass().getResourceAsStream("logo.png"));
        SinhVien.getIcons().add(logo);
        SinhVien.setTitle("DiemThi");
        SinhVien.show();
    }
    
}
