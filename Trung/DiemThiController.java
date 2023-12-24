package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class DiemThiController extends MainController{

    protected MonHoc pttkhttt;//data
    protected MonHoc java;//data
    protected MonHoc[] dsMonHoc;
    private final String[] sceneNames = {
            "Điểm cá nhân",
            "Danh sách điểm"
    };

    protected static String selection = "Điểm cá nhân";

    @FXML
    protected ChoiceBox<String> selectSceneChoiceBox;


    @Override
    public void DiemThi(ActionEvent e) throws Exception {
        System.out.println("Trang hien tai la Diem Thi");
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        super.initialize(arg0, arg1);
        InitData();
        //selection = "Điểm cá nhân";
        //selectSceneChoiceBox.getItems().addAll(sceneNames);
        selectSceneChoiceBox.setItems(FXCollections.observableArrayList(sceneNames));
        SelectScene();
        selectSceneChoiceBox.setTooltip(new Tooltip("Select"));
        selectSceneChoiceBox.setOnAction(event -> {
            selection = selectSceneChoiceBox.getValue();
            try{
                LoadScene(event);
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        });

    }

    protected void SelectScene(){
        selection = "Điểm cá nhân";
        selectSceneChoiceBox.setValue(selection);
    }

    public void LoadScene(ActionEvent event) throws IOException {
        Scene scene = ((Node)event.getSource()).getScene();
        String value = selectSceneChoiceBox.getValue();
        //Parent root = null;
        switch (value) {
            case "Điểm cá nhân" -> {
                Parent root = FXMLLoader.load(getClass().getResource("DiemThi.fxml"));
                scene.setRoot(root);
            }
            case "Danh sách điểm" -> {
                Parent root2 = FXMLLoader.load(getClass().getResource("DiemThi2.fxml"));
                scene.setRoot(root2);
            }
        }
    }

    //data
    private void InitData(){
        pttkhttt = new MonHoc("pttkhttt", "01", 2);
        java = new MonHoc("Công nghệ java", "02", 2);
        Lop CN1 = new Lop("CN1");
        Lop CN2 = new Lop("CN2");

        CN1.dssv = FXCollections.observableArrayList(
                new SV("T", "2155010269", 10, 10),
                new SV("H", "2155010270", 9, 9),
                new SV("H", "2155010271", 8, 8)
        );
        CN2.dssv = FXCollections.observableArrayList(
                new SV("S", "2155010272", 10, 10),
                new SV("H", "2155010273", 9, 9),
                new SV("H", "2155010274", 8, 8)
        );
        pttkhttt.dsLop[0] = CN1;
        pttkhttt.dsLop[1] = CN2;

        Lop CN3 = new Lop("CN3");
        Lop CN4 = new Lop("CN4");

        CN3.dssv = FXCollections.observableArrayList(
                new SV("A", "2155010275", 10, 10),
                new SV("B", "2155010276", 9, 9),
                new SV("C", "2155010277", 8, 8)
        );
        CN4.dssv = FXCollections.observableArrayList(
                new SV("F", "2155010278", 10, 10),
                new SV("P", "2155010279", 9, 9),
                new SV("T", "2155010280", 8, 8),
                new SV("F", "2155010278", 10, 10),
                new SV("P", "2155010279", 9, 9),
                new SV("T", "2155010280", 8, 8),
                new SV("F", "2155010278", 10, 10),
                new SV("P", "2155010279", 9, 9),
                new SV("T", "2155010280", 8, 8),
                new SV("F", "2155010278", 10, 10),
                new SV("P", "2155010279", 9, 9),
                new SV("T", "2155010280", 8, 8),
                new SV("F", "2155010278", 10, 10),
                new SV("P", "2155010279", 9, 9),
                new SV("T", "2155010280", 8, 8),
                new SV("F", "2155010278", 10, 10),
                new SV("P", "2155010279", 9, 9),
                new SV("T", "2155010280", 8, 8)
        );
        java.dsLop[0] = CN3;
        java.dsLop[1] = CN4;

        dsMonHoc = new MonHoc[] {pttkhttt, java};
    }

}

class Lop{
    public String tenLop;
    public ObservableList<SV> dssv;

    public Lop(String tenLop) {
        this.tenLop = tenLop;
    }
}

class MonHoc{
    public String ten;
    public String ma;
    public int soLop;
    public Lop[] dsLop;

    public MonHoc(String ten, String ma, int soLop) {
        this.ten = ten;
        this.ma = ma;
        this.soLop = soLop;
        dsLop = new Lop[soLop];
    }
}





