package com.example.demo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TaiChinhController extends MainController implements Initializable {
    @FXML
    private Button noptien;
    @FXML
    private ChoiceBox<String> mykhoa;
    @FXML
    private ChoiceBox<String> mynam;
    @FXML
    private ChoiceBox<String> mylop;
    @FXML
    private ChoiceBox<String>myhoc_ky;
    @FXML
    private TableColumn<TTSV, String> msv;
    @FXML
    private TableColumn<TTSV, String> da_nop;
    @FXML
    private TableColumn<TTSV, String> ten;
    @FXML
    private TableColumn<TTSV, String> con_thieu;
    @FXML
    private TableColumn<TTSV, String> hoc_phi;
    @FXML
    private TableView<TTSV> table;

//    private String[] Khoa={"Công nghệ thông tin","Nội thất","Xây dựng"};
//    private String [] Nam= {"2021","2022","2023"};
//    private String [] HocKy={"1","2"};
//    private String[] CNClasses = {"CN1", "CN2"};
//    private String[] NTClasses = {"NT1", "NT2"};
//    private String[] XDClasses = {"XD1", "XD2"};


//    public void initialize (URL arg0, ResourceBundle arg1){
//        mykhoa.getItems().addAll(Khoa);
//        mynam.getItems().addAll(Nam);
//        myhoc_ky.getItems().addAll(HocKy);
//        mykhoa.setOnAction(event -> {
//            String selectedKhoa = mykhoa.getValue();
//            switch (selectedKhoa) {
//                case "Công nghệ thông tin":
//                    mylop.getItems().setAll(CNClasses);
//                    break;
//                case "Nội thất":
//                    mylop.getItems().setAll(NTClasses);
//                    break;
//                case "Xây dựng":
//                    mylop.getItems().setAll(XDClasses);
//                    break;
//                default:
//                    break;
//            }
//            mylop.setVisible(mylop.getItems().size()>0);
//        });
@Override
public void initialize(URL arg0, ResourceBundle arg1) {
    super.initialize(arg0, arg1);
    try {
        Connection connection = DriverManager.getConnection(Main.URL);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM SINH_VIEN");

        ArrayList<String> khoaOptions = new ArrayList<>();
        ArrayList<String> HockyOptions = new ArrayList<>();
        ArrayList<String> lopOptions = new ArrayList<>();
        ArrayList<String> namOptions = new ArrayList<>();

        while (resultSet.next()){
            String khoa = resultSet.getString("khoa");
            if (!khoaOptions.contains(khoa)){
                khoaOptions.add(khoa);
            }
            String khoaHoc = resultSet.getString("hoc_ky");
            if (!HockyOptions.contains(khoaHoc)){
                HockyOptions.add(khoaHoc);
            }

            String lop = resultSet.getString("lop");
            if (!lopOptions.contains(lop)){
                lopOptions.add(lop);
            }
            String nam = resultSet.getString("nam");
            if (!namOptions.contains(nam)){
                namOptions.add(nam);
            }
        }
        mykhoa.setItems(FXCollections.observableArrayList(khoaOptions));
        myhoc_ky.setItems(FXCollections.observableArrayList(HockyOptions));
        mylop.setItems(FXCollections.observableArrayList(lopOptions));
        mynam.setItems(FXCollections.observableArrayList(namOptions));

        connection.close();

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

}


    @Override
    public void TaiChinh(ActionEvent e) throws Exception {
        System.out.println("Trang hien tai la Tai Chinh");
    }

    @FXML
    public void NopTien (ActionEvent e) throws Exception{
        System.out.println("Vao trang nop tien");
        Stage Stage = new Stage();
        NopTien App = new NopTien();
        App.start(Stage);
    }
    public void HienThiTT(ActionEvent event) throws SQLException {
        String khoa = mykhoa.getValue();
        String lop = mylop.getValue();
        String nam = mynam.getValue();
        String hocky = myhoc_ky.getValue();

        Connection connection = DriverManager.getConnection(Main.URL);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM SINH_VIEN WHERE khoa = '" + khoa + "'AND lop = '" +lop +"'AND nam = '" +nam+"'AND hoc_ky = '" +hocky+"'" );
        ObservableList<TTSV> ttsvList = null;
        while (resultSet.next()){
            String msv = resultSet.getString("msv");
            String ten = resultSet.getString("ten");
            String hoc_phi = String.valueOf(resultSet.getInt("hocphi"));
            String con_thieu = String.valueOf(resultSet.getInt("conthieu"));
            String da_nop = String.valueOf(resultSet.getInt("danop"));
            if (ttsvList != null){
                ttsvList.add( new TTSV(msv, ten, hoc_phi,da_nop,con_thieu,nam));
            }
            else{
                ttsvList = FXCollections.observableArrayList(new TTSV(msv, ten, hoc_phi,da_nop,con_thieu,nam));
            }
        }
        msv.setCellValueFactory(new PropertyValueFactory<TTSV, String>("msv"));
        ten.setCellValueFactory(new PropertyValueFactory<TTSV, String>("ten"));
        hoc_phi.setCellValueFactory(new PropertyValueFactory<TTSV, String>("hocphi"));
        con_thieu.setCellValueFactory(new PropertyValueFactory<TTSV, String>("conthieu"));
        da_nop.setCellValueFactory(new PropertyValueFactory<TTSV, String>("danop"));
        table.setItems(ttsvList);
    }
}
