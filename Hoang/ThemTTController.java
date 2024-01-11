package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.*;

public class ThemTTController {
    @FXML
    private TextField msv;
    @FXML
    private TextField ten;
    @FXML
    private TextField lop;
    @FXML
    private TextField khoa;
    @FXML
    private TextField khoahoc;
    private final String DB_URL = "jdbc:sqlite:C:\\Users\\ADMIN\\Downloads\\demo\\data";

    @FXML
    public void clickLuu(ActionEvent e) throws Exception {
        String textmsv =msv.getText();
        String textten = ten.getText();
        String textlop = lop.getText();
        String textkhoa = khoa.getText();
        String textkhoahoc = khoahoc.getText();
        Connection connection = DriverManager.getConnection(DB_URL);
        Statement statement = connection.createStatement();
        String query = "INSERT INTO SINH_VIEN (msv, ten, lop, khoa, khoa_hoc, ngay_sinh, gioi_tinh) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, textmsv);
            preparedStatement.setString(2, textten);
            preparedStatement.setString(3, textlop);
            preparedStatement.setString(4, textkhoa);
            preparedStatement.setString(5, textkhoahoc);
            preparedStatement.setString(6, "a");  // Assuming ngay_sinh is a string placeholder
            preparedStatement.setString(7, "b");  // Assuming gioi_tinh is a string placeholder

            preparedStatement.executeUpdate();
        } catch (SQLException ee){
            // Handle the exception appropriately
        }

    }

}
