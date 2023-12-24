package com.quanlisinhvien;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class MainController implements Initializable {

    @FXML
    private Button NutMain;
    @FXML
    private Button NutSV;
    @FXML
    private Button NutDiemThi;
    @FXML
    private Button NutLichHoc;
    @FXML
    private Button NutTaiChinh;
    @FXML
    private ChoiceBox<String> Menu;

    private String[] item = {"Tài khoản","Đăng xuất","Thoát"};

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
    public void SinhVien(ActionEvent e) throws Exception{
        System.out.println("Vao trang sinh vien");
        Stage Main = (Stage) NutSV.getScene().getWindow();
        Main.close();
        Stage Stage = new Stage();
        SinhVien App = new SinhVien();
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
        Stage Main = (Stage) NutDiemThi.getScene().getWindow();
        Main.close();
        Stage Stage = new Stage();
        LichHoc App = new LichHoc();
        App.start(Stage);
    }
    @FXML
    public void TaiChinh(ActionEvent e) throws Exception{
        System.out.println("Vao trang sinh vien");
        Stage Main = (Stage) NutDiemThi.getScene().getWindow();
        Main.close();
        Stage Stage = new Stage();
        TaiChinh App = new TaiChinh();
        App.start(Stage);
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        Menu.getItems().addAll(item);
        Menu.setOnAction(arg01 -> {
            try {
                Menu(arg01);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }
    public void Menu(ActionEvent e) throws Exception{
        String choice = Menu.getValue();
        if(choice=="Thoát"){
            Stage Main = (Stage) NutDiemThi.getScene().getWindow();
            Main.close();
        }
        else if(choice=="Tài khoản"){
            Stage Main = (Stage) NutDiemThi.getScene().getWindow();
            Main.close();
            Stage Stage = new Stage();
            Account App = new Account();
            App.start(Stage);
        }
        else if(choice=="Đăng xuất"){
            Stage Main = (Stage) NutDiemThi.getScene().getWindow();
            Main.close();
            Stage Stage = new Stage();
            Login App = new Login();
            App.start(Stage);
        }
    }
}
