package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class NoptienController extends MainController {
    @FXML
    private Button noptien;
    @FXML
    private TextField my_masv;
    @FXML
    private TextField my_noptien;
    @FXML
    private Label Error;
    public void initialize(URL arg0, ResourceBundle arg1) {
        try {
            Connection connection = DriverManager.getConnection(Main.URL);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM SINH_VIEN");


            ArrayList<String> masvOptions = new ArrayList<>();
            ArrayList<String> danopOptions = new ArrayList<>();
            ArrayList<String> conthieuOptions = new ArrayList<>();

            while (resultSet.next()) {
                String msv = resultSet.getString("msv");
                if (!masvOptions.contains(msv)) {
                    masvOptions.add(msv);
                }
                String danop = resultSet.getString("danop");
                if (!danopOptions.contains(danop)) {
                    danopOptions.add(danop);
                }
                String conthieu = resultSet.getString("conthieu");
                if (!conthieuOptions.contains(conthieu)) {
                    conthieuOptions.add(conthieu);
                }
            }
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void NopTien (ActionEvent event) throws SQLException {
        String Masv = my_masv.getText();
        String Noptien = my_noptien.getText();

        Connection connection = DriverManager.getConnection(Main.URL);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM SINH_VIEN WHERE msv = '" + Masv +"'" );
        if (resultSet.next()) {
            try {
                int nopTienValue = Integer.parseInt(Noptien);
                String updateQuery = "UPDATE SINH_VIEN SET danop = danop + " + nopTienValue + ", conthieu = CAST(hocphi AS INTEGER) - (danop+ " + nopTienValue + ") WHERE msv = '" + Masv + "'";
                statement.executeUpdate(updateQuery);
                Error.setText("Nộp tiền thành công");
            } catch (NumberFormatException e) {
                Error.setText("Số tiền không hợp lệ");
            }
        } else {
            Error.setText("Thông tin nhập không hợp lệ");
        }
    }
}