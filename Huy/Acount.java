package com.quanlisinhvien;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Acount extends Application {

    @Override
    public void start(Stage Acount) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Acount.fxml"));
        Scene scene = new Scene(root,1280,720);
        Acount.setResizable(false);
        Image logo = new Image(getClass().getResourceAsStream("logo.png"));
        Acount.getIcons().add(logo);
        Acount.setScene(scene);
        Acount.setTitle("Acount");
        Acount.show();
    }
    
}
