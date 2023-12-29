package com.quanlisinhvien;


import java.sql.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LoginController {
    protected static String acc,pass,role; 
    protected static int id;
    @FXML
    private Label ThongBao;
    @FXML
    private TextField accountName;
    @FXML
    private PasswordField password;
    @FXML
    private Button NutDangNhap;
    @FXML
    public void DangNhap(ActionEvent e) throws Exception{
        Class.forName("org.sqlite.JDBC");
        Connection cnt = DriverManager.getConnection(Main.URL);
        Statement stt = cnt.createStatement();
        acc = accountName.getText();
        pass = password.getText();
        System.out.println(acc);
        System.out.println(pass);
        ResultSet rs = stt.executeQuery("select * from Account");
        while (rs.next()) {
            if(acc.equals(rs.getString(2))&&pass.equals(rs.getString(3))){
                id = rs.getInt(1);
                role = rs.getString(4);
                System.out.println("Dang nhap thanh cong");
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
}