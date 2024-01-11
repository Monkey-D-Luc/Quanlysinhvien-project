package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SVC2 extends MainController{
    @FXML
    private ChoiceBox<String> khoaChoiceBox;
    @FXML
    private ChoiceBox<String> khoaHocChoiceBox;
    @FXML
    private ChoiceBox<String> lopChoiceBox;
    @FXML
    private Button hienThiButton;
    @FXML
    private Button themttButton;
    @FXML
    private TableView<TTSV> table;
    @FXML
    private  TableColumn<TTSV, String> STTColumn;
    @FXML
    private TableColumn<TTSV, String> msvColumn;
    @FXML
    private TableColumn<TTSV, String> tenColumn;
    @FXML
    private TableColumn<TTSV, String> lopColumn;
    @FXML
    private TableColumn<TTSV, String> khoaColumn;
    @FXML
    private TableColumn<TTSV, String> khoaHocColumn;
    private final String DB_URL = "jdbc:sqlite:C:\\Users\\ADMIN\\Downloads\\demo\\data";
    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
                super.initialize(arg0, arg1);
            try {
                Connection connection = DriverManager.getConnection(DB_URL);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM SINH_VIEN");

                ArrayList<String> khoaOptions = new ArrayList<>();
                ArrayList<String> khoaHocOptions = new ArrayList<>();
                ArrayList<String> lopOptions = new ArrayList<>();
                while (resultSet.next()) {
                    String khoa = resultSet.getString("khoa");
                    if (!khoaOptions.contains(khoa)) {
                        khoaOptions.add(khoa);
                    }
                    String khoaHoc = resultSet.getString("khoa_hoc");
                    if (!khoaHocOptions.contains(khoaHoc)) {
                        khoaHocOptions.add(khoaHoc);
                    }
                    String lop = resultSet.getString("lop");
                    if (!lopOptions.contains(lop)) {
                        lopOptions.add(lop);
                    }
                }
                khoaChoiceBox.setItems(FXCollections.observableArrayList(khoaOptions));
                khoaHocChoiceBox.setItems(FXCollections.observableArrayList(khoaHocOptions));
                lopChoiceBox.setItems(FXCollections.observableArrayList(lopOptions));
                connection.close();
                statement.close();
                resultSet.close();


            }catch (SQLException e) {
                throw new RuntimeException(e);
            }


    }
    @FXML
    public void ThemTT(ActionEvent event) throws Exception {
        Stage AA = new Stage();
        ThemTT App = new ThemTT();
        App.start(AA);
    }
    @FXML
    public void HienThiTT(ActionEvent event) throws SQLException {
        String khoa = khoaChoiceBox.getValue();
        String khoaHoc = khoaHocChoiceBox.getValue();
        String lop = lopChoiceBox.getValue();

        Connection connection = DriverManager.getConnection(DB_URL);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM SINH_VIEN WHERE khoa = '" + khoa + "' AND khoa_hoc = '" + khoaHoc + "' AND lop = '" + lop + "'" );
        int socot=resultSet.getMetaData().getColumnCount();
        ObservableList<TTSV> ttsvList = null;
        int count=1;
        while (resultSet.next()){
            String msv1 = resultSet.getString("msv");
            String ten1 = resultSet.getString("ten");
            String lop1 = resultSet.getString("lop");
            String khoa1 = resultSet.getString("khoa");
            String khoaHoc1= resultSet.getString("khoa_hoc");
            String c=Integer.toString(count);
            if (ttsvList != null){
                ttsvList.add( new TTSV(c,msv1, ten1, lop1, khoa1, khoaHoc1));
            }
            else{
                ttsvList = FXCollections.observableArrayList(new TTSV(c,msv1, ten1, lop1, khoa1, khoaHoc1));
            }
            count++;
        }
        STTColumn.setCellValueFactory(new PropertyValueFactory<TTSV, String>("stt"));
        msvColumn.setCellValueFactory(new PropertyValueFactory<TTSV, String>("msv"));
        tenColumn.setCellValueFactory(new PropertyValueFactory<TTSV, String>("ten"));
        lopColumn.setCellValueFactory(new PropertyValueFactory<TTSV, String>("lop"));
        khoaColumn.setCellValueFactory(new PropertyValueFactory<TTSV, String>("khoa"));
        khoaHocColumn.setCellValueFactory(new PropertyValueFactory<TTSV, String>("khoaHoc"));
        table.setItems(ttsvList);
    }
}


