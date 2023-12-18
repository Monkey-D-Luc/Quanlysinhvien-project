package com.quanlisinhvien;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LoginController {
    @FXML
    private Button NutDangNhap;
    @FXML
    public void DangNhap(ActionEvent e) throws Exception{
        System.out.println("Dang nhap thanh cong");
        Stage DangNhap = (Stage) NutDangNhap.getScene().getWindow();
        DangNhap.close();
        Stage mainStage = new Stage();
        Main mainApp = new Main();
        mainApp.start(mainStage);
    }
}
