package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class DiemThi2Controller extends DiemThiController{

    @FXML
    private TextField hocPhanText;
    @FXML
    private TextField maHocPhanText;
    @FXML
    private TextField lopText;
    @FXML
    private TableView dsDiemTable;
    @FXML
    private TableColumn<Integer[], Integer> sttColumn;
    @FXML
    private TableColumn<SV, String> hoTenColumn;
    @FXML
    private TableColumn<SV, String> msvColumn;
    @FXML
    private TableColumn<SV, Float> diemThanhPhanColumn;
    @FXML
    private TableColumn<SV, Float> diemThiColumn;
    @FXML
    private Label messageLabel;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        super.initialize(arg0, arg1);
        //selection = "Danh sách điểm";
        hoTenColumn.setCellValueFactory(new PropertyValueFactory<SV, String>("hoTen"));
        msvColumn.setCellValueFactory(new PropertyValueFactory<SV, String>("msv"));
        diemThanhPhanColumn.setCellValueFactory(new PropertyValueFactory<SV, Float>("diemThanhPhan"));
        diemThiColumn.setCellValueFactory(new PropertyValueFactory<SV, Float>("diemThi"));
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

    public void FindClass(ActionEvent event){
        String tenHocPhan = hocPhanText.getText();
        String maHocPhan = maHocPhanText.getText();
        String tenLop = lopText.getText();

        for (MonHoc monHoc : dsMonHoc){
            if (Objects.equals(monHoc.ten, tenHocPhan) && Objects.equals(monHoc.ma, maHocPhan)){
                for (Lop lop : monHoc.dsLop){
                    if (Objects.equals(lop.tenLop, tenLop)){
                        System.out.println("Tim thay lop: " + tenLop + ", mon: " + tenHocPhan);
                        dsDiemTable.setItems(lop.dssv);
                        return;
                    }
                }
                System.out.println("khong tim thay lop");
                messageLabel.setText("Không tìm thấy lớp");
                return;
            }
        }
        //khong tim thay mon hoc
        System.out.print("khong tim thay mon hoc");
        messageLabel.setText("Không tìm thấy môn học");
    }
}


