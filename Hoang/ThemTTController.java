package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import java.sql.PreparedStatement;
import java.sql.*;

public class ThemTTController {
    @FXML
    TextField khoa;
    @FXML
    TextField hoten;
    @FXML
    TextField ngaysinh;
    @FXML
    TextField lop;
    @FXML
    TextField msv;
    @FXML
    CheckBox CheckNam;
    @FXML
    CheckBox CheckNu;
    @FXML
    Button LuuButton;
    public void ClickLuu(ActionEvent event) throws SQLException {
        String hoten=this.hoten.getText();

        String ngaysinh=this.ngaysinh.getText();
        String lop=this.lop.getText();
        String msv=this.msv.getText();
        String khoa=this.khoa.getText();
        String gioitinh="";
        if(CheckNam.isSelected())
        {
            gioitinh="nam";
        } else if (CheckNu.isSelected()) {
            gioitinh="nữ";
        }
        Connection connection = DriverManager.getConnection(Main.URL);
        Statement statement = connection.createStatement();
        String query = "INSERT INTO SINH_VIEN (msv, ten, lop, khoa,khoa_hoc,  ngay_sinh, gioi_tinh,nam,hoc_ky,hocphi,danop,conthieu,CMND)" + "VALUES (?, ?, ?, ?,'', ?, ?,'','','','','','')";
        try(PreparedStatement pst= connection.prepareStatement(query)){
            pst.setString(1,msv);
            pst.setString(2,hoten);
            pst.setString(3,lop);
            pst.setString(4,khoa);
            pst.setString(5,ngaysinh);
            pst.setString(6,gioitinh);
            pst.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
        }





    }

}
