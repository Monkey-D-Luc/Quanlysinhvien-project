package com.quanlisinhvien;

import java.sql.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class SinhVien extends Application {
    protected static String msv,ten,lop,khoa,khoa_hoc,ngay_sinh,gioi_tinh,CMND; 
    @Override
    public void start(Stage SinhVien) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("SinhVien.fxml"));;
        Scene scene = new Scene(root,1280,720);
        if (LoginController.role.equals("Student")){
            Class.forName("org.sqlite.JDBC");
            Connection cnt = DriverManager.getConnection(Main.URL);
            Statement stt = cnt.createStatement();
            ResultSet rs = stt.executeQuery("select * from Sinh_Vien WHERE msv = "+LoginController.acc+";");
            while(rs.next()){
                msv = rs.getString("msv");
                ten = rs.getString("ten");
                gioi_tinh = rs.getString("gioi_tinh");
                lop = rs.getString("lop");
                khoa = rs.getString("khoa");
                khoa_hoc = rs.getString("khoa_hoc");
                ngay_sinh = rs.getString("ngay_sinh");
                CMND = rs.getString("CMND");
                System.out.println(ten);

            }
            root = FXMLLoader.load(getClass().getResource("SinhVien_Student.fxml"));
            scene = new Scene(root,1280,720);
        }
        SinhVien.setResizable(false);
        Image logo = new Image(getClass().getResourceAsStream("logo.png"));
        SinhVien.getIcons().add(logo);
        SinhVien.setScene(scene);
        SinhVien.setTitle("SinhVien");
        SinhVien.show();
    }
    
}
