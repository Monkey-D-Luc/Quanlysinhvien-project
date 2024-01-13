package com.example.demo;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.w3c.dom.events.MouseEvent;

import java.net.URL;
import java.sql.*;
import java.util.Arrays;
import java.util.ResourceBundle;

public class LichHocController extends MainController {

    @FXML
    private TextField ten_hoc_phan_text;

    @FXML
    private TextField so_tin_chi_text;

    @FXML
    private TextField ten_lop_tin_chi_text;

    @FXML
    private TextField thoi_gian_text;

    @FXML
    private TextField thu_text;

    @FXML
    private TextField tiet_text;

    @FXML
    private TextField phong_text;

    @FXML
    private TextField thanh_vien_text;

    @FXML
    private TextField ma_sinh_vien_text;

    @FXML
    private TextField giao_vien_text;

    @FXML
    private TextField thanhtracuu;

    @FXML
    private TableView<lichhocsv> hienthilich;

    @FXML
    private TableColumn<lichhocsv, String> ten_hoc_phan;

    @FXML
    private TableColumn<lichhocsv, String> so_tin_chi;

    @FXML
    private TableColumn<lichhocsv, String> ten_lop_tin_chi;

    @FXML
    private TableColumn<lichhocsv,String> thoi_gian;

    @FXML
    private TableColumn<lichhocsv,String> thu;

    @FXML
    private TableColumn<lichhocsv,String> tiet;

    @FXML
    private TableColumn<lichhocsv,String> phong;

    @FXML
    private TableColumn<lichhocsv, String> thanh_vien;

    @FXML
    private TableColumn<lichhocsv, String> ma_sinh_vien;

    @FXML
    private TableColumn<lichhocsv, String> giao_vien;

    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {
        super.initialize(location, resourceBundle);
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/TunHip/Documents/demo (1)/src/main/resources/com/example/demo/data.db");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Lich_Hoc");
            ObservableList<lichhocsv> lichhocList = null;
            while (resultSet.next()) {
                String ten_hoc_phan = resultSet.getString(2);
                String so_tin_chi = resultSet.getString(3);
                String ten_lop_tin_chi = resultSet.getString(4);
                String thoi_gian = resultSet.getString(5);
                String thu = resultSet.getString(6);
                String tiet = resultSet.getString(7);
                String phong = resultSet.getString(8);
                String thanh_vien = resultSet.getString(9);
                String ma_sinh_vien = resultSet.getString(10);
                String giao_vien = resultSet.getString(11);
                if (lichhocList != null) {
                    lichhocList.add(new lichhocsv(ten_hoc_phan, so_tin_chi, ten_lop_tin_chi, thoi_gian, thu, tiet, phong, thanh_vien, ma_sinh_vien, giao_vien));
                } else {
                    lichhocList = FXCollections.observableArrayList(new lichhocsv(ten_hoc_phan, so_tin_chi, ten_lop_tin_chi, thoi_gian, thu, tiet, phong, thanh_vien, ma_sinh_vien, giao_vien));
                }
            }
            ten_hoc_phan.setCellValueFactory(new PropertyValueFactory<lichhocsv, String>("ten_hoc_phan"));
            so_tin_chi.setCellValueFactory(new PropertyValueFactory<lichhocsv, String>("so_tin_chi"));
            ten_lop_tin_chi.setCellValueFactory(new PropertyValueFactory<lichhocsv, String>("ten_lop_tin_chi"));
            thoi_gian.setCellValueFactory(new PropertyValueFactory<lichhocsv, String>("thoi_gian"));
            thu.setCellValueFactory(new PropertyValueFactory<lichhocsv, String>("thu"));
            tiet.setCellValueFactory(new PropertyValueFactory<lichhocsv, String>("tiet"));
            phong.setCellValueFactory(new PropertyValueFactory<lichhocsv, String>("phong"));
            thanh_vien.setCellValueFactory(new PropertyValueFactory<lichhocsv, String>("thanh_vien"));
            ma_sinh_vien.setCellValueFactory(new PropertyValueFactory<lichhocsv, String>("ma_sinh_vien"));
            giao_vien.setCellValueFactory(new PropertyValueFactory<lichhocsv, String>("giao_vien"));

            hienthilich.setItems(lichhocList);

            FilteredList<lichhocsv> filteredData = new FilteredList<>(lichhocList, b -> true);

            thanhtracuu.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredData.setPredicate(lichhocsv -> {
                    if(newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                        return true;
                    }

                    String searchKeyword = newValue.toLowerCase();

                    if(lichhocsv.getTen_hoc_phan().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;
                    } else if (lichhocsv.getSo_tin_chi().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;
                    } else if (lichhocsv.getTen_lop_tin_chi().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;
                    } else if (lichhocsv.getThanh_vien().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;
                    } else if (lichhocsv.getMa_sinh_vien().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;
                    } else if (lichhocsv.getGiao_vien().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;
                    } else {
                        return false;
                    }
                });
            });

            SortedList<lichhocsv> sortedData = new SortedList<>(filteredData);
            sortedData.comparatorProperty().bind(hienthilich.comparatorProperty());
            hienthilich.setItems(sortedData);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void ThemLichhoc(ActionEvent event) {
        lichhocsv newlichhocsv = new lichhocsv(ten_hoc_phan_text.getText(), so_tin_chi_text.getText(), ten_lop_tin_chi_text.getText(), thoi_gian_text.getText(), thu_text.getText(), tiet_text.getText(), phong_text.getText(), thanh_vien_text.getText(), ma_sinh_vien_text.getText(), giao_vien_text.getText());
        hienthilich.getItems().add(newlichhocsv);

        String sql = "INSERT INTO Lich_Hoc(ten_hoc_phan,so_tin_chi,ten_lop_tin_chi,thoi_gian,thu,tiet,phong,thanh_vien,ma_sinh_vien,giao_vien) VALUES (?,?,?,?,?,?,?,?,?,?)";

        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/TunHip/Documents/demo (1)/src/main/resources/com/example/demo/data.db");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, ten_hoc_phan_text.getText());
            preparedStatement.setString(2, so_tin_chi_text.getText());
            preparedStatement.setString(3, ten_lop_tin_chi_text.getText());
            preparedStatement.setString(4, thoi_gian_text.getText());
            preparedStatement.setString(5, thu_text.getText());
            preparedStatement.setString(6, tiet_text.getText());
            preparedStatement.setString(7, phong_text.getText());
            preparedStatement.setString(8, thanh_vien_text.getText());
            preparedStatement.setString(9, ma_sinh_vien_text.getText());
            preparedStatement.setString(10, giao_vien_text.getText());
            preparedStatement.executeUpdate();
        } catch (Exception e) {

        }
        ten_hoc_phan_text.clear();
        so_tin_chi_text.clear();
        ten_lop_tin_chi_text.clear();
        thoi_gian_text.clear();
        thu_text.clear();
        tiet_text.clear();
        phong_text.clear();
        thanh_vien_text.clear();
        ma_sinh_vien_text.clear();
        giao_vien_text.clear();
    }

    public void XoaLichhoc(ActionEvent event){
        TableView.TableViewSelectionModel<lichhocsv> selectionModel = hienthilich.getSelectionModel();
        ObservableList<Integer> lichhoc = selectionModel.getSelectedIndices();
        Integer[] selectedIndices = new Integer[lichhoc.size()];
        selectedIndices = lichhoc.toArray(selectedIndices);

        Arrays.sort(selectedIndices);

        for(int i = selectedIndices.length -1; i >= 0; i--){
            selectionModel.clearSelection(selectedIndices[i].intValue());
            hienthilich.getItems().remove(selectedIndices[i].intValue());
        }

        String sql = "DELETE FROM Lich_Hoc WHERE id = ?";

        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/TunHip/Documents/demo (1)/src/main/resources/com/example/demo/data.db");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ten_hoc_phan_text.getText());
            preparedStatement.executeUpdate();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }



//    public void SuaLichhoc() {
//        ten_hoc_phan.setCellFactory(TextFieldTableCell.<lichhocsv>forTableColumn());
//        ten_hoc_phan.setOnEditCommit(event -> {
//            lichhocsv lichhocsv = event.getTableView().getItems().get(event.getTablePosition().getRow());
//            lichhocsv.setten_hoc_phan(event.getNewValue());
//            System.out.println(lichhocsv.getten_hoc_phan() + " - Gia tri da duoc doi thanh " + event.getNewValue() + " tai dong " + (event.getTablePosition().getRow() + 1));
//        });
//
//        so_tin_chi.setCellFactory(TextFieldTableCell.<lichhocsv>forTableColumn());
//        so_tin_chi.setOnEditCommit(event -> {
//            lichhocsv lichhocsv = event.getTableView().getItems().get(event.getTablePosition().getRow());
//            lichhocsv.setso_tin_chi(event.getNewValue());
//            System.out.println(lichhocsv.getso_tin_chi() + " - Gia tri da duoc doi thanh " + event.getNewValue() + " tai dong " + (event.getTablePosition().getRow() + 1));
//        });
//
//        ten_lop_tin_chi.setCellFactory(TextFieldTableCell.<lichhocsv>forTableColumn());
//        ten_lop_tin_chi.setOnEditCommit(event -> {
//            lichhocsv lichhocsv = event.getTableView().getItems().get(event.getTablePosition().getRow());
//            lichhocsv.setten_lop_tin_chi(event.getNewValue());
//            System.out.println(lichhocsv.getten_lop_tin_chi() + " - Gia tri da duoc doi thanh " + event.getNewValue() + " tai dong " + (event.getTablePosition().getRow() + 1));
//        });
//
//        thanh_vien.setCellFactory(TextFieldTableCell.<lichhocsv>forTableColumn());
//        thanh_vien.setOnEditCommit(event -> {
//            lichhocsv lichhocsv = event.getTableView().getItems().get(event.getTablePosition().getRow());
//            lichhocsv.setthanh_vien(event.getNewValue());
//            System.out.println(lichhocsv.getthanh_vien() + " - Gia tri da duoc doi thanh " + event.getNewValue() + " tai dong " + (event.getTablePosition().getRow() + 1));
//        });
//
//        ma_sinh_vien.setCellFactory(TextFieldTableCell.<lichhocsv>forTableColumn());
//        ma_sinh_vien.setOnEditCommit(event -> {
//            lichhocsv lichhocsv = event.getTableView().getItems().get(event.getTablePosition().getRow());
//            lichhocsv.setma_sinh_vien(event.getNewValue());
//            System.out.println(lichhocsv.getma_sinh_vien() + " '- Gia tri da duoc doi thanh " + event.getNewValue() + " tai dong " + (event.getTablePosition().getRow() + 1));
//        });
//
//        giao_vien.setCellFactory(TextFieldTableCell.<lichhocsv>forTableColumn());
//        giao_vien.setOnEditCommit(event -> {
//            lichhocsv lichhocsv = event.getTableView().getItems().get(event.getTablePosition().getRow());
//            lichhocsv.setgiao_vien(event.getNewValue());
//            System.out.println(lichhocsv.getgiao_vien() + " - Gia tri da duoc doi thanh " + event.getNewValue() + " tai dong " + (event.getTablePosition().getRow() + 1));
//        });
//    }

}