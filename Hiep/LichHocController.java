package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;


import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class LichHocController extends MainController {

    @FXML
    private TextField id_text;

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
    private TableColumn<lichhocsv, Integer> id;

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

    int index = -1;
    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {
        Hienthilich();
        Tracuulich();
        Laydulieulich();
    }

    public void Hienthilich() {
        id.setCellValueFactory(new PropertyValueFactory<lichhocsv, Integer>("id"));
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

        try {
            Connection connection = DriverManager.getConnection(Main.URL);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Lich_Hoc");
            ObservableList<lichhocsv> lichhocList = null;
            while (resultSet.next()) {
                Integer id = Integer.parseInt(resultSet.getString(1));
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
                if (lichhocList != null)
                    lichhocList.add(new lichhocsv(id, ten_hoc_phan, so_tin_chi, ten_lop_tin_chi, thoi_gian, thu, tiet, phong, thanh_vien, ma_sinh_vien, giao_vien));
                else {
                    lichhocList = FXCollections.observableArrayList(new lichhocsv(id, ten_hoc_phan, so_tin_chi, ten_lop_tin_chi, thoi_gian, thu, tiet, phong, thanh_vien, ma_sinh_vien, giao_vien));
                }
            }
            hienthilich.setItems(lichhocList);
        } catch (Exception e) {

        }
    }

    @FXML
    void Tracuulich() {
        try {
            Connection connection = DriverManager.getConnection(Main.URL);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Lich_Hoc");
            ObservableList<lichhocsv> lichhocList = null;
            while (resultSet.next()) {
                Integer id = Integer.parseInt(resultSet.getString(1));
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
                if (lichhocList != null)
                    lichhocList.add(new lichhocsv(id, ten_hoc_phan, so_tin_chi, ten_lop_tin_chi, thoi_gian, thu, tiet, phong, thanh_vien, ma_sinh_vien, giao_vien));
                else {
                    lichhocList = FXCollections.observableArrayList(new lichhocsv(id, ten_hoc_phan, so_tin_chi, ten_lop_tin_chi, thoi_gian, thu, tiet, phong, thanh_vien, ma_sinh_vien, giao_vien));
                }
            }
            id.setCellValueFactory(new PropertyValueFactory<lichhocsv, Integer>("id"));
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

                    if(String.valueOf(lichhocsv.getId()).toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;
                    }else if(lichhocsv.getTen_hoc_phan().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;
                    } else if (lichhocsv.getSo_tin_chi().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;
                    } else if (lichhocsv.getTen_lop_tin_chi().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;
                    } else if (lichhocsv.getThoi_gian().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;
                    } else if (lichhocsv.getThu().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;
                    } else if (lichhocsv.getTiet().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;
                    } else if (lichhocsv.getPhong().toLowerCase().indexOf(searchKeyword) > -1) {
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
        String sql = "INSERT INTO Lich_Hoc(ten_hoc_phan,so_tin_chi,ten_lop_tin_chi,thoi_gian,thu,tiet,phong,thanh_vien,ma_sinh_vien,giao_vien) VALUES (?,?,?,?,?,?,?,?,?,?)";

        try {
            Connection connection = DriverManager.getConnection(Main.URL);
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

            Hienthilich();
            Tracuulich();
        } catch (Exception e) {

        }
        Clear();
    }

    public void XoaLichhoc(ActionEvent event){
        String sql = "DELETE FROM Lich_Hoc WHERE id = ?";
        try {
            Connection connection = DriverManager.getConnection(Main.URL);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id_text.getText());
            preparedStatement.execute();

            Hienthilich();
            Tracuulich();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Clear();
    }

    public void Laydulieulich() {
        hienthilich.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                index = hienthilich.getSelectionModel().getSelectedIndex();

                if (index <= -1){

                    return;
                }

                id_text.setText(id.getCellData(index).toString());
                ten_hoc_phan_text.setText(ten_hoc_phan.getCellData(index).toString());
                so_tin_chi_text.setText(so_tin_chi.getCellData(index).toString());
                ten_lop_tin_chi_text.setText(ten_hoc_phan.getCellData(index).toString());
                thoi_gian_text.setText(thoi_gian.getCellData(index).toString());
                thu_text.setText(thu.getCellData(index).toString());
                tiet_text.setText(tiet.getCellData(index).toString());
                phong_text.setText(phong.getCellData(index).toString());
                thanh_vien_text.setText(thanh_vien.getCellData(index).toString());
                ma_sinh_vien_text.setText(ma_sinh_vien.getCellData(index).toString());
                giao_vien_text.setText(giao_vien.getCellData(index).toString());
            }
        });
    }

    public void Sualich(ActionEvent event) {
        String sql1 = "DELETE FROM Lich_Hoc WHERE id = ?";
        try {
            Connection connection = DriverManager.getConnection(Main.URL);
            PreparedStatement preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.setString(1, id_text.getText());
            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String sql2 = "INSERT INTO Lich_Hoc(ten_hoc_phan,so_tin_chi,ten_lop_tin_chi,thoi_gian,thu,tiet,phong,thanh_vien,ma_sinh_vien,giao_vien) VALUES (?,?,?,?,?,?,?,?,?,?)";

        try {
            Connection connection = DriverManager.getConnection(Main.URL);
            PreparedStatement preparedStatement = connection.prepareStatement(sql2);

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

        Hienthilich();
        Tracuulich();
        Clear();
    }

    public void Clear() {
        id_text.clear();
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
}