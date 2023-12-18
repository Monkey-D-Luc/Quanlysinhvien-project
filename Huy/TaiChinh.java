package com.quanlisinhvien;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class TaiChinh extends Application {

    @Override
    public void start(Stage TaiChinh) throws Exception {
        TaiChinh.setWidth(1280);
        TaiChinh.setHeight(720);
        TaiChinh.setResizable(false);
        Image logo = new Image(getClass().getResourceAsStream("logo.png"));
        TaiChinh.getIcons().add(logo);
        TaiChinh.setTitle("TaiChinh");
        TaiChinh.show();
    }
    
}
