package com.quanlisinhvien;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.*;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseConnect {
    Connection conn = null;
    public static Connection ConnectDB(){
        try{
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:lichhoc.db");
            JOptionPane.showMessageDialog(null, "Ket noi CSDL");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public static ObservableList<lichhocsv> getDatalichhoc() {
        Connection conn = ConnectDB();
        ObservableList<lichhocsv> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from users");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                list.add(new lichhocsv(rs.getString("tenhocphan"), Integer.parseInt(rs.getString("sotinchi")), rs.getString("tenloptinchi"), rs.getString("thanhvien"), rs.getString("masinhvien"), rs.getString("giaovien")));

            }
        }catch (Exception e) {
        }

        return list;
    }
}
