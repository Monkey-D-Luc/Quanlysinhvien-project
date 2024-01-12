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
import java.sql.*;
import java.util.Objects;
import java.util.ResourceBundle;

public class DiemThiController extends MainController {
    private final String[] sceneNames = {
            "Điểm cá nhân",
            "Danh sách điểm"
    };

    protected static String selection = "Điểm cá nhân";

    @FXML
    protected ChoiceBox<String> selectSceneChoiceBox;
    @FXML
    private TextField msvText;
    @FXML
    private TextField hoTenText;
    @FXML
    private Label tbcHocTapLabel;
    @FXML
    private Label xepLoaiLabel;
    @FXML
    private TableView<DiemCaNhan> ketQuaHocTapTable;
    @FXML
    private TableColumn<DiemCaNhan, Integer> sttColumn;
    @FXML
    private TableColumn<DiemCaNhan, String> maHocPhanColumn;
    @FXML
    private TableColumn<DiemCaNhan, String> tenHocPhanColumn;
    @FXML
    private TableColumn<DiemCaNhan, Integer> soTinChiColumn;
    @FXML
    private TableColumn<DiemCaNhan, Float> diemThanhPhanColumn;
    @FXML
    private TableColumn<DiemCaNhan, Float> diemThiColumn;
    @FXML
    private TableColumn<DiemCaNhan, Float> tbchpColumn;
    @FXML
    private TableColumn<DiemCaNhan, Integer> diemSoColumn;
    @FXML
    private TableColumn<DiemCaNhan, String> diemChuColumn;
    @FXML
    private Label messageLabel;



    @Override
    public void DiemThi(ActionEvent e) throws Exception {
        System.out.println("Trang hien tai la Diem Thi");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        super.initialize(arg0, arg1);
        selectSceneChoiceBox.setItems(FXCollections.observableArrayList(sceneNames));
        SelectScene();
        selectSceneChoiceBox.setTooltip(new Tooltip("Select"));
        selectSceneChoiceBox.setOnAction(event -> {
            selection = selectSceneChoiceBox.getValue();
            try {
                LoadScene(event);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        });
        if (Objects.equals(selection, "Điểm cá nhân")){
            messageLabel.setText("");
            sttColumn.setCellValueFactory(new PropertyValueFactory<DiemCaNhan, Integer>("stt"));
            maHocPhanColumn.setCellValueFactory(new PropertyValueFactory<DiemCaNhan, String>("maHocPhan"));
            tenHocPhanColumn.setCellValueFactory(new PropertyValueFactory<DiemCaNhan, String>("tenHocPhan"));
            soTinChiColumn.setCellValueFactory(new PropertyValueFactory<DiemCaNhan, Integer>("soTinChi"));
            diemThanhPhanColumn.setCellValueFactory(new PropertyValueFactory<DiemCaNhan, Float>("diemThanhPhan"));
            diemThiColumn.setCellValueFactory(new PropertyValueFactory<DiemCaNhan, Float>("diemThi"));
            tbchpColumn.setCellValueFactory(new PropertyValueFactory<DiemCaNhan, Float>("tbchp"));
            diemSoColumn.setCellValueFactory(new PropertyValueFactory<DiemCaNhan, Integer>("diemSo"));
            diemChuColumn.setCellValueFactory(new PropertyValueFactory<DiemCaNhan, String>("diemChu"));
        }

    }

    protected void SelectScene() {
        selection = "Điểm cá nhân";
        selectSceneChoiceBox.setValue(selection);
    }

    public void LoadScene(ActionEvent event) throws IOException {
        Scene scene = ((Node) event.getSource()).getScene();
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

    public void FindStudent(ActionEvent event) throws SQLException {
        String msv = msvText.getText();
        String ten = hoTenText.getText();
        Connection connection = DriverManager.getConnection(Main.DB_URL);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(String.format("SELECT DIEM_THI.ma_hoc_phan, ten_hoc_phan, so_tin_chi, diem_thanh_phan, diem_thi "
                                                                    +"FROM DIEM_THI JOIN SINH_VIEN ON DIEM_THI.msv = SINH_VIEN.msv JOIN HOC_PHAN ON DIEM_THI.ma_hoc_phan = HOC_PHAN.ma_hoc_phan "
                                                                    +"WHERE DIEM_THI.msv = '%s' AND SINH_VIEN.ten = '%s'", msv, ten));
        ObservableList<DiemCaNhan> diemList = null;
        float tbcHocTap = 0;
        int stt = 1;
        while (resultSet.next()){
            String maHocPhan = resultSet.getString("ma_hoc_phan");
            String hocPhan = resultSet.getString("ten_hoc_phan");
            int soTinChi = resultSet.getInt("so_tin_chi");
            float diemThanhPhan = resultSet.getFloat("diem_thanh_phan");
            float diemThi = resultSet.getFloat("diem_thi");
            float tbchp = (diemThanhPhan + diemThi)/ 2;
            String diemChu = CalculateLetterGrades(tbchp);
            int diemSo = TranslateLetterToNumberGrades(diemChu);

            if (diemList != null){
                diemList.add(new DiemCaNhan(stt, maHocPhan, hocPhan, soTinChi, diemThanhPhan, diemThi, tbchp, diemSo, diemChu));
            }
            else{
                diemList = FXCollections.observableArrayList(new DiemCaNhan(stt, maHocPhan, hocPhan, soTinChi, diemThanhPhan, diemThi, tbchp, diemSo, diemChu));
            }
            tbcHocTap += diemSo;
            stt++;
        }
        if (diemList == null){
            messageLabel.setText("Không tìm thấy thông tin");
            tbcHocTapLabel.setText("TBC Học tập: ");
            xepLoaiLabel.setText("Xếp loại: ");
            connection.close();
            statement.close();
            resultSet.close();
            return;
        }
        tbcHocTap /= (stt - 1);
        String xepLoai = Classify(tbcHocTap);

        tbcHocTapLabel.setText("TBC Học tập: " + tbcHocTap);
        xepLoaiLabel.setText("Xếp loại: " + xepLoai);
        messageLabel.setText("");
        ketQuaHocTapTable.setItems(diemList);
        connection.close();
        statement.close();
        resultSet.close();
    }

    public String CalculateLetterGrades(float tbchp){
        if (tbchp >= 8.5){
            return  "A";
        }
        else if(tbchp >= 7.0){
            return  "B";
        }
        else if(tbchp >= 5.5){
            return  "C";
        }
        else if(tbchp >= 4.0){
            return  "D";
        }
        else{
            return  "F";
        }
    }

    public int TranslateLetterToNumberGrades(String letter){
        switch (letter) {
            case "A" : return 4;
            case "B" : return 3;
            case "C" : return 2;
            case "D" : return 1;
            case "F" : return 0;
        }
        return 0;
    }

    public String Classify(float tbcHocTap){
        if (tbcHocTap >= 3.6) {
            return  "Xuất sắc";
        }
        else if(tbcHocTap >= 3.2){
            return "Giỏi";
        }
        else if(tbcHocTap >= 2.5){
            return "Khá";
        }
        else if(tbcHocTap >= 2.0){
            return "Trung bình";
        }
        else if(tbcHocTap >= 1.0){
            return "Yếu";
        }
        else{
            return "Kém";
        }
    }
}






