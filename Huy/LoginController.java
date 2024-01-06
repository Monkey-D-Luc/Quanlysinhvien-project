package com.quanlisinhvien;

import java.sql.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class LoginController {
    protected static String acc,pass,role,passInfo="hide"; 
    protected static int id;
    @FXML
    private Label ThongBao;
    @FXML
    private TextField accountName;
    @FXML
    private TextField ShowPassField;
    @FXML
    private PasswordField password;
    @FXML
    private Button NutDangNhap;
    @FXML
    private Button ShowAndHidePassButton;
    @FXML
    private ImageView ShowPassImage;
    @FXML
    private ImageView HidePassImage;
    @FXML
    public void DangNhap(ActionEvent e) throws Exception{
        Class.forName("org.sqlite.JDBC");
        Connection cnt = DriverManager.getConnection(Main.URL);
        Statement stt = cnt.createStatement();
        acc = accountName.getText();
        if(passInfo.equals("hide")){
            pass = password.getText();
        } else pass = ShowPassField.getText();
        if(accountName.getText().equals("")||pass.equals("")){
            ThongBao.setText("Mật khẩu hoặc tài khoản\nkhông được để trống!");
            System.out.println(acc);
            return;
        }
        ResultSet rs = stt.executeQuery("select * from Account");
        while (rs.next()) {
            if(acc.equals(rs.getString(2))&&pass.equals(rs.getString(3))){
                id = rs.getInt(1);
                role = rs.getString(4);
                Stage DangNhap = (Stage) NutDangNhap.getScene().getWindow();
                DangNhap.close();
                Stage mainStage = new Stage();
                Main mainApp = new Main();
                mainApp.start(mainStage);
                cnt.close();
                return;
            }
        }
        ThongBao.setText("Mật khẩu hoặc tài khoản\nkhông đúng!");
    }
    public void ShowAndHidePass(ActionEvent e) throws Exception{
        if(passInfo.equals("hide")){
            System.out.println("Show pass");
            ShowPassField.setDisable(false);
            pass = password.getText();
            ShowPassField.setText(pass);
            ShowPassField.setOpacity(1);
            ShowPassImage.setOpacity(0);
            HidePassImage.setOpacity(1);
            passInfo = "show";
        }
        else if (passInfo.equals("show")){
            System.out.println("Hide pass");
            ShowPassField.setDisable(true);
            pass = ShowPassField.getText();
            password.setText(pass);
            ShowPassField.setOpacity(0);
            HidePassImage.setOpacity(0);
            ShowPassImage.setOpacity(1);
            passInfo = "hide";
        }
    }
}