package com.quanlisinhvien;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainController {

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
}
