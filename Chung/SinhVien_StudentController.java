package com.quanlisinhvien;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SinhVien_StudentController extends MainController {
    @FXML 
    private TextField MSV;
    @FXML 
    private TextField Name;
    @FXML 
    private TextField Ngay_Sinh;
    @FXML 
    private TextField CMND;
    @FXML 
    private TextField Chuyen_Nganh;
    @FXML 
    private TextField Khoa_Hoc;
    @FXML 
    private TextField Lop;
    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        super.initialize(arg0, arg1);
        MSV.setText(LoginController.acc);
        Name.setText(SinhVien.ten);
        System.out.println(SinhVien.ten);
        Ngay_Sinh.setText(SinhVien.ngay_sinh);
        CMND.setText(SinhVien.CMND);
        Chuyen_Nganh.setText(SinhVien.khoa);
        Khoa_Hoc.setText(SinhVien.khoa_hoc);
        Lop.setText(SinhVien.lop);
    }
    public void ChangeInfo() throws Exception{
        Class.forName("org.sqlite.JDBC");
        Connection cnt = DriverManager.getConnection(Main.URL);
        Statement stt = cnt.createStatement();        
    }
}
