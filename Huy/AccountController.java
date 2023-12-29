package com.quanlisinhvien;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AccountController extends MainController {
    @FXML
    private Button ChangeAccInfo;
    @FXML 
    private TextField accountName;
    @FXML 
    private TextField password;
    @FXML
    private ChoiceBox<String> Menu;
    @FXML
    private Button NutDiemThi;
    private String[] item = {"Đăng xuất","Thoát"};
    private String newAccountName,newPassword;
    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        System.out.println(LoginController.acc);
        System.out.println(LoginController.pass);
        System.out.println(LoginController.role);
        accountName.setText(LoginController.acc);
        password.setText(LoginController.pass);
        if(LoginController.role.equals("Student")){
            accountName.setEditable(false);
            System.out.println("test");
        }
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
    public void ChangeAccInfo() throws Exception{
        Class.forName("org.sqlite.JDBC");
        Connection cnt = DriverManager.getConnection(Main.URL);
        Statement stt = cnt.createStatement();
        newAccountName = accountName.getText();
        newPassword = password.getText();
        String sql = "UPDATE Account SET accountName = "+newAccountName+", password = "+newPassword+" WHERE id = "+LoginController.id+";";
        stt.executeUpdate(sql);
    }
    public void Menu(ActionEvent e) throws Exception{
        String choice = Menu.getValue();
        if(choice=="Thoát"){
            Stage Main = (Stage) NutDiemThi.getScene().getWindow();
            Main.close();
        }
        else if(choice=="Đăng xuất"){
            Stage Main = (Stage) NutDiemThi.getScene().getWindow();
            Main.close();
            Stage Stage = new Stage();
            Login App = new Login();
            App.start(Stage);
        }
    }
}