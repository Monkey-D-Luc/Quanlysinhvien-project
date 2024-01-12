package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.FloatStringConverter;

import java.net.URL;
import java.sql.*;
import java.util.Arrays;
import java.util.ResourceBundle;

public class DiemThi2Controller extends DiemThiController{

    @FXML
    private TextField hocPhanText;
    @FXML
    private TextField maHocPhanText;
    @FXML
    private TextField lopText;
    @FXML
    private TableView<DiemSV> dsDiemTable;
    @FXML
    private TableColumn<DiemSV, Integer> sttColumn;
    @FXML
    private TableColumn<DiemSV, String> hoTenColumn;
    @FXML
    private TableColumn<DiemSV, String> msvColumn;
    @FXML
    private TableColumn<DiemSV, Float> diemThanhPhanColumn;
    @FXML
    private TableColumn<DiemSV, Float> diemThiColumn;
    @FXML
    private TableColumn<DiemSV, Float> tbchpColumn;
    @FXML
    private Label messageLabel;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        super.initialize(arg0, arg1);
        //selection = "Danh sách điểm";
        sttColumn.setCellValueFactory(new PropertyValueFactory<DiemSV, Integer>("stt"));
        hoTenColumn.setCellValueFactory(new PropertyValueFactory<DiemSV, String>("ten"));
        msvColumn.setCellValueFactory(new PropertyValueFactory<DiemSV, String>("msv"));
        diemThanhPhanColumn.setCellValueFactory(new PropertyValueFactory<DiemSV, Float>("diemThanhPhan"));
        diemThiColumn.setCellValueFactory(new PropertyValueFactory<DiemSV, Float>("diemThi"));
        tbchpColumn.setCellValueFactory(new PropertyValueFactory<DiemSV, Float>("tbchp"));

        diemThanhPhanColumn.setEditable(true);
        diemThiColumn.setEditable(true);
        diemThanhPhanColumn.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
        diemThiColumn.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
        diemThanhPhanColumn.setOnEditCommit(event -> {
            DiemSV rowData = event.getRowValue();
            float newValue = event.getNewValue();
            boolean isEditedSuccessfully = rowData.setDiemThanhPhan(newValue);
            if (!isEditedSuccessfully){
                dsDiemTable.refresh();
                return;
            }
            String msv = rowData.getMsv();
            String maHocPhan = maHocPhanText.getText();
            try {
                Connection connection = DriverManager.getConnection(Main.DB_URL);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(String.format("SELECT COUNT(*) FROM DIEM_THI WHERE msv = '%s' AND ma_hoc_phan = '%s'", msv, maHocPhan));
                if (resultSet.next()) {
                    int rowCount = resultSet.getInt(1);
                    if (rowCount > 0){
                        statement.executeUpdate(String.format("UPDATE DIEM_THI SET diem_thanh_phan = '%s' WHERE msv = '%s' AND ma_hoc_phan = '%s'", newValue, msv, maHocPhan));
                    }
                    else {
                        statement.executeUpdate(String.format("INSERT INTO DIEM_THI VALUES('%s', '%s', '%s', %f, %f)", msv, maHocPhan, "1/2023-2024", rowData.getDiemThanhPhan(), rowData.getDiemThi()));
                    }
                }
                connection.close();
                statement.close();
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            dsDiemTable.refresh();
        });
        diemThiColumn.setOnEditCommit(event -> {
            DiemSV rowData = event.getRowValue();
            float newValue = event.getNewValue();
            boolean isEditedSuccessfully = rowData.setDiemThi(newValue);
            if (!isEditedSuccessfully){
                dsDiemTable.refresh();
                return;
            }
            String msv = rowData.getMsv();
            String maHocPhan = maHocPhanText.getText();
            try {
                Connection connection = DriverManager.getConnection(Main.DB_URL);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(String.format("SELECT COUNT(*) FROM DIEM_THI WHERE msv = '%s' AND ma_hoc_phan = '%s'", msv, maHocPhan));
                if (resultSet.next()) {
                    int rowCount = resultSet.getInt(1);
                    if (rowCount > 0){
                        statement.executeUpdate(String.format("UPDATE DIEM_THI SET diem_thi = '%s' WHERE msv = '%s' AND ma_hoc_phan = '%s'", newValue, msv, maHocPhan));
                    }
                    else {
                        statement.executeUpdate(String.format("INSERT INTO DIEM_THI VALUES('%s', '%s', '%s', %f, %f)", msv, maHocPhan, "1/2023-2024", rowData.getDiemThanhPhan(), rowData.getDiemThi()));
                    }
                }
                connection.close();
                statement.close();
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            dsDiemTable.refresh();
        });

        System.out.println(selection);
        selectSceneChoiceBox.setValue(selection);
        System.out.println(selectSceneChoiceBox.getValue());
        messageLabel.setText(" ");
    }

    @Override
    protected void SelectScene() {
        selection = "Danh sách điểm";
        selectSceneChoiceBox.setValue(selection);
    }

    public void FindClass(ActionEvent event) throws SQLException {
        String tenHocPhan = hocPhanText.getText();
        String maHocPhan = maHocPhanText.getText();
        String tenLop = lopText.getText();

        Connection connection = DriverManager.getConnection(Main.DB_URL);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(String.format("SELECT DIEM_THI.msv, diem_thanh_phan, diem_thi, ten FROM DIEM_THI JOIN SINH_VIEN ON DIEM_THI.msv = SINH_VIEN.msv JOIN HOC_PHAN ON DIEM_THI.ma_hoc_phan = HOC_PHAN.ma_hoc_phan WHERE ten_hoc_phan = '%s' AND DIEM_THI.ma_hoc_phan = '%s' AND SINH_VIEN.lop = '%s';", tenHocPhan, maHocPhan, tenLop));
        ObservableList<DiemSV> diemList = null;
        int stt = 1;
        while (resultSet.next()){
            String msv = resultSet.getString("msv");
            String ten = resultSet.getString("ten");
            float diemThanhPhan = resultSet.getFloat("diem_thanh_phan");
            float diemThi = resultSet.getFloat("diem_thi");
            float tbchp = (diemThanhPhan + diemThi) / 2;
            if (diemList != null){
                diemList.add(new DiemSV(stt, ten, msv, diemThanhPhan, diemThi, tbchp));
            }
            else{
                diemList = FXCollections.observableArrayList(new DiemSV(stt, ten, msv, diemThanhPhan, diemThi, tbchp));
            }
            stt++;
        }

        resultSet = statement.executeQuery(String.format("SELECT msv, ten FROM SINH_VIEN WHERE lop = '%s' AND msv NOT IN (SELECT msv FROM DIEM_THI WHERE ma_hoc_phan = '%s' ) AND khoa IN (SELECT khoa FROM HOC_PHAN WHERE ma_hoc_phan = '%s')",  tenLop, maHocPhan, maHocPhan));
        while (resultSet.next()){
            String msv = resultSet.getString("msv");
            String ten = resultSet.getString("ten");
            if (diemList != null){
                diemList.add(new DiemSV(stt, ten, msv));
            }
            else{
                diemList = FXCollections.observableArrayList(new DiemSV(stt, ten, msv));
            }
            stt++;
        }

        if (diemList == null){
            messageLabel.setText("Không tìm thấy môn học hoặc lớp");
            connection.close();
            statement.close();
            resultSet.close();
            return;
        }


        messageLabel.setText("");
        dsDiemTable.setItems(diemList);
        connection.close();
        statement.close();
        resultSet.close();
    }
}




