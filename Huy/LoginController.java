package com.quanlisinhvien;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LoginController {
    protected static String acc; 
    protected static String pass; 
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
        acc = accountName.getText();
        pass = password.getText();
        System.out.println(acc);
        System.out.println(pass);
        if(acc.equals("1")&&pass.equals("1")){
            System.out.println("Dang nhap thanh cong");
            Stage DangNhap = (Stage) NutDangNhap.getScene().getWindow();
            DangNhap.close();
            Stage mainStage = new Stage();
            Main mainApp = new Main();
            mainApp.start(mainStage);
        }
        else ThongBao.setText("Mật khẩu hoặc tài khoản\nkhông đúng!");
    }
}
