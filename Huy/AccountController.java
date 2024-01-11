package com.quanlisinhvien;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class AccountController extends MainController {
    @FXML
    private Label ThongBao;
    @FXML
    private ImageView ShowOldPassImage,HideOldPassImage,ShowNewPassImage,HideNewPassImage;
    @FXML
    private Button ChangeAccInfoWindow,HideAndShowOldPass,HideAndShowNewPass,BackButton;
    @FXML 
    private Label accountName,role;
    @FXML 
    private TextField accountNameField,ShowOldPassField,ShowNewPassField;
    @FXML 
    private PasswordField HideOldPassField,HideNewPassField;
    @FXML
    private ChoiceBox<String> Menu;
    @FXML
    private Button NutDiemThi,ChangeAccInfo;
    private String[] item = {"Đăng xuất","Thoát"};
    private String newAccountName,newPassword,oldPassword,OldPassInfo="hide",NewPassInfo="hide";
    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        try {
            accountNameField.setText(LoginController.acc);
            if(LoginController.role.equals("Student")){
                accountNameField.setEditable(false);;
            }
        } catch (Exception e) {}
        try {
            accountName.setText(LoginController.acc);
            if(LoginController.role.equals("Student")){
                role.setText("Sinh viên");
            } else role.setText("Admin");
            Menu.getItems().addAll(item);
            Menu.setOnAction(arg01 -> {
                try {
                    Menu(arg01);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
        }
    }
    public void ChangeAccInfo() throws Exception{
        if(OldPassInfo.equals("hide")){
            oldPassword = HideOldPassField.getText();
        } else oldPassword = ShowOldPassField.getText();
        if(NewPassInfo.equals("hide")){
            newPassword = HideNewPassField.getText();
        } else newPassword = ShowNewPassField.getText();
        if(accountNameField.getText().equals("")||newPassword.equals("")||oldPassword.equals("")){
            ThongBao.setText("Mật khẩu hoặc tài khoản không được để trống!");
            return;
        }
        if(oldPassword.equals(LoginController.pass)){
            Class.forName("org.sqlite.JDBC");
            Connection cnt = DriverManager.getConnection(Main.URL);
            Statement stt = cnt.createStatement();
            newAccountName = accountNameField.getText();
            String sql = "UPDATE Account SET accountName = "+newAccountName+", password = "+newPassword+" WHERE id = "+LoginController.id+";";
            stt.executeUpdate(sql);
            LoginController.acc = newAccountName;
            LoginController.pass = newPassword;
            ThongBao("Tài khoản và mật khẩu đã được cập nhập");
        } else ThongBao.setText("Mật khẩu cũ không đúng!");
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
    public void ChangeAccInfoButton(ActionEvent e) throws Exception{
        Stage Main = (Stage) NutDiemThi.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("ChangeAccInfo.fxml"));
        Scene scene = new Scene(root,600,400);
        Main.setScene(scene);
    }
    private void ThongBao(String message) throws Exception {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Thông báo");
        alert.setHeaderText(null);
        alert.setContentText(message);
        // set logo
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        Image logo = new Image(getClass().getResourceAsStream("logo.png"));
        stage.getIcons().add(logo); 
        // chinh font chu
        alert.getDialogPane().getStylesheets().add(getClass().getResource("Main.css").toExternalForm());
        alert.showAndWait();
        Back();
    }
    public void ShowAndHideOldPass(ActionEvent e) throws Exception{
        if(OldPassInfo.equals("hide")){
            ShowOldPassField.setDisable(false);
            ShowOldPassField.setText(HideOldPassField.getText());
            ShowOldPassField.setOpacity(1);
            ShowOldPassImage.setOpacity(0);
            HideOldPassImage.setOpacity(1);
            OldPassInfo = "show";
        }
        else if (OldPassInfo.equals("show")){
            ShowOldPassField.setDisable(true);
            HideOldPassField.setText(ShowOldPassField.getText());
            ShowOldPassField.setOpacity(0);
            HideOldPassImage.setOpacity(0);
            ShowOldPassImage.setOpacity(1);
            OldPassInfo = "hide";
        }
    }
    public void ShowAndHideNewPass(ActionEvent e) throws Exception{
        if(NewPassInfo.equals("hide")){
            ShowNewPassField.setDisable(false);
            ShowNewPassField.setText(HideNewPassField.getText());
            ShowNewPassField.setOpacity(1);
            ShowNewPassImage.setOpacity(0);
            HideNewPassImage.setOpacity(1);
            NewPassInfo = "show";
        }
        else if (NewPassInfo.equals("show")){
            ShowNewPassField.setDisable(true);
            HideNewPassField.setText(ShowNewPassField.getText());
            ShowNewPassField.setOpacity(0);
            HideNewPassImage.setOpacity(0);
            ShowNewPassImage.setOpacity(1);
            NewPassInfo = "hide";
        }
    }
    public void BackButton(ActionEvent e) throws Exception{
        Back();
    }
    public void Back() throws Exception{
        Stage Main = (Stage) BackButton.getScene().getWindow();
        Main.close();
        Stage Stage = new Stage();
        Account App = new Account();
        App.start(Stage);
    }
}