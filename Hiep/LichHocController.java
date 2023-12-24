package com.quanlisinhvien;

import com.mysql.cj.conf.IntegerProperty;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class LichHocController implements Initializable {

    @FXML
    private Button NutMain;
    @FXML
    private Button NutDiemThi;
    @FXML
    private Button NutLichHoc;
    @FXML
    private Button NutTaiChinh;

    @FXML
    private TextField tenhocphantext;

    @FXML
    private TextField sotinchitext;

    @FXML
    private TextField tenloptinchitext;

    @FXML
    private TextField thanhvientext;

    @FXML
    private TextField masinhvientext;

    @FXML
    private TextField giaovientext;
    @FXML
    public void TrangChu(ActionEvent e) throws Exception{
        System.out.println("Vao trang chu");
        Stage Main = (Stage) NutMain.getScene().getWindow();
        Main.close();
        Stage Stage = new Stage();
        Main App = new Main();
        App.start(Stage);
    }
    @FXML
    public void DiemThi(ActionEvent e) throws Exception{
        System.out.println("Vao trang sinh vien");
        Stage Main = (Stage) NutDiemThi.getScene().getWindow();
        Main.close();
        Stage Stage = new Stage();
        DiemThi App = new DiemThi();
        App.start(Stage);
    }
    @FXML
    public void LichHoc(ActionEvent e) throws Exception{
        System.out.println("Vao trang sinh vien");
        Stage Main = (Stage) NutLichHoc.getScene().getWindow();
        Main.close();
        Stage Stage = new Stage();
        LichHoc App = new LichHoc();
        App.start(Stage);
    }
    @FXML
    public void TaiChinh(ActionEvent e) throws Exception{
        System.out.println("Vao trang sinh vien");
        Stage Main = (Stage) NutTaiChinh.getScene().getWindow();
        Main.close();
        Stage Stage = new Stage();
        TaiChinh App = new TaiChinh();
        App.start(Stage);
    }


    @FXML
    private TableView<lichhocsv> hienthilich;

    @FXML
    private TableColumn<lichhocsv, String> tenhocphan;

    @FXML
    private TableColumn<lichhocsv, Integer> sotinchi;

    @FXML
    private TableColumn<lichhocsv, String> tenloptinchi;

    @FXML
    private TableColumn<lichhocsv, String> thanhvien;

    @FXML
    private TableColumn<lichhocsv, String> masinhvien;

    @FXML
    private TableColumn<lichhocsv, String> giaovien;

    private ObservableList<lichhocsv> lichhocList;

    int index = -1;
    Connection conn = null;
    ResultSet rs = null;

    PreparedStatement pst = null;

    @Override
    public void initialize(URL location, ResourceBundle resourceBundle){

        tenhocphan.setCellValueFactory(new PropertyValueFactory<lichhocsv, String>("tenhocphan"));
        sotinchi.setCellValueFactory(new PropertyValueFactory<lichhocsv, Integer>("sotinchi"));
        tenloptinchi.setCellValueFactory(new PropertyValueFactory<lichhocsv, String>("tenloptinchi"));
        thanhvien.setCellValueFactory(new PropertyValueFactory<lichhocsv, String>("thanhvien"));
        masinhvien.setCellValueFactory(new PropertyValueFactory<lichhocsv, String>("masinhvien"));
        giaovien.setCellValueFactory(new PropertyValueFactory<lichhocsv, String>("giaovien"));

        lichhocList = DatabaseConnect.getDatalichhoc();
        hienthilich.setItems(lichhocList);

    }
}
