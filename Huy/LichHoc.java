package com.quanlisinhvien;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class LichHoc extends Application {

    @Override
    public void start(Stage LichHoc) throws Exception {
        LichHoc.setWidth(1280);
        LichHoc.setHeight(720);
        LichHoc.setResizable(false);
        Image logo = new Image(getClass().getResourceAsStream("logo.png"));
        LichHoc.getIcons().add(logo);
        LichHoc.setTitle("LichHoc");
        LichHoc.show();
    }
    
}
