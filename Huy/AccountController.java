package com.quanlisinhvien;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AccountController extends MainController {
    @FXML 
    private TextField accountName;
    @FXML 
    private TextField password;
    @FXML
    private ChoiceBox<String> Menu;
    @FXML
    private Button NutDiemThi;
    private String[] item = {"Thoát"};
    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        System.out.println(LoginController.acc);
        System.out.println(LoginController.pass);
        accountName.setText(LoginController.acc);
        password.setText(LoginController.pass);
        Menu.getItems().addAll(item);
        Menu.setOnAction(arg01 -> {
            try {
                Menu(arg01);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }
    public void Menu(ActionEvent e) throws Exception{
        String choice = Menu.getValue();
        if(choice=="Thoát"){
            Stage Main = (Stage) NutDiemThi.getScene().getWindow();
            Main.close();
        }
    }
}
