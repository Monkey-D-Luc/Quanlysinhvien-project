package com.example.demo;

import javafx.beans.property.ReadOnlyObjectWrapper;
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
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SinhVienController extends MainController{
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
    private TableColumn<TTSV,Integer> sttColumn;
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
    @Override
    public void SinhVien(ActionEvent e) throws Exception {

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        super.initialize(arg0, arg1);
        try {
            Connection connection = DriverManager.getConnection(Main.URL);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM SINH_VIEN");
            ArrayList<String> khoaOptions = new ArrayList<>();
            ArrayList<String> khoaHocOptions = new ArrayList<>();
            ArrayList<String> lopOptions = new ArrayList<>();
            while (resultSet.next()){
                String khoa = resultSet.getString("khoa");
                if (!khoaOptions.contains(khoa)){
                    khoaOptions.add(khoa);
                }
                String khoaHoc = resultSet.getString("khoa_hoc");
                if (!khoaHocOptions.contains(khoaHoc)){
                    khoaHocOptions.add(khoaHoc);
                }
                String lop = resultSet.getString("lop");
                if (!lopOptions.contains(lop)){
                    lopOptions.add(lop);
                }
            }
            khoaChoiceBox.setItems(FXCollections.observableArrayList(khoaOptions));
            khoaHocChoiceBox.setItems(FXCollections.observableArrayList(khoaHocOptions));
            lopChoiceBox.setItems(FXCollections.observableArrayList(lopOptions));

            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void HienThiTT(ActionEvent event) throws SQLException {
        String khoa = khoaChoiceBox.getValue();
        String khoaHoc = khoaHocChoiceBox.getValue();
        String lop = lopChoiceBox.getValue();
        Connection connection = DriverManager.getConnection(Main.URL);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM SINH_VIEN WHERE khoa = '" + khoa + "' AND khoa_hoc = '" + khoaHoc + "' AND lop = '" + lop + "'" );
        ObservableList<TTSV> ttsvList = null;
        int stt=0;
        while (resultSet.next()){
            String msv = resultSet.getString("msv");
            String ten = resultSet.getString("ten");
            stt++;
            System.out.print(stt);
            if (ttsvList != null){
                ttsvList.add( new TTSV(stt,msv, ten, lop, khoa, khoaHoc));
            }
            else{
                ttsvList = FXCollections.observableArrayList(new TTSV(stt,msv, ten, lop, khoa, khoaHoc));
            }
        }
        sttColumn.setCellValueFactory(new PropertyValueFactory<>("stt"));
        msvColumn.setCellValueFactory(new PropertyValueFactory<>("msv"));
        tenColumn.setCellValueFactory(new PropertyValueFactory<>("ten"));
        lopColumn.setCellValueFactory(new PropertyValueFactory<>("lop"));
        khoaColumn.setCellValueFactory(new PropertyValueFactory<>("khoa"));
        khoaHocColumn.setCellValueFactory(new PropertyValueFactory<>("khoaHoc"));

        table.setItems(ttsvList);
    }
    public void ThemTT(ActionEvent event) throws IOException {
        Stage SinhVien=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ThemTT.fxml"));
        Scene scene = new Scene(root);
        SinhVien.setResizable(false);
        Image logo = new Image(getClass().getResourceAsStream("logo.png"));
        SinhVien.getIcons().add(logo);
        SinhVien.setScene(scene);
        SinhVien.setTitle("Thêm thông tin");
        SinhVien.show();
    }
}
