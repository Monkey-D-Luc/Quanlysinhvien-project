package com.quanlisinhvien;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Account extends Application {
   
    @Override
    public void start(Stage Account) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Account.fxml"));
        Scene scene = new Scene(root,1280,720);
        Account.setResizable(false);
        Image logo = new Image(getClass().getResourceAsStream("logo.png"));
        Account.getIcons().add(logo);
        Account.setScene(scene);
        Account.setTitle("Account");
        Account.show();
    }
}
