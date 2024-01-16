package com.example.demo;

public class lichhocsv{
    private Integer id;
    private String ten_hoc_phan;
    private String so_tin_chi;
    private String ten_lop_tin_chi;
    private String thoi_gian;
    private String thu;
    private String tiet;
    private String phong;
    private String thanh_vien;
    private String ma_sinh_vien;
    private String giao_vien;

    public lichhocsv(Integer id, String ten_hoc_phan, String so_tin_chi, String ten_lop_tin_chi, String thoi_gian, String thu, String tiet, String phong, String thanh_vien, String ma_sinh_vien, String giao_vien) {
        this.id = id;
        this.ten_hoc_phan = ten_hoc_phan;
        this.so_tin_chi = so_tin_chi;
        this.ten_lop_tin_chi = ten_lop_tin_chi;
        this.thoi_gian = thoi_gian;
        this.thu = thu;
        this.tiet = tiet;
        this.phong = phong;
        this.thanh_vien = thanh_vien;
        this.ma_sinh_vien = ma_sinh_vien;
        this.giao_vien = giao_vien;
    }

    public lichhocsv() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public String getTen_hoc_phan() {
        return ten_hoc_phan;
    }

    public void setTen_hoc_phan(String ten_hoc_phan) {
        this.ten_hoc_phan = ten_hoc_phan;
    }

    public String getSo_tin_chi() {
        return so_tin_chi;
    }

    public void setSo_tin_chi(String so_tin_chi) {
        this.so_tin_chi = so_tin_chi;
    }

    public String getTen_lop_tin_chi() {
        return ten_lop_tin_chi;
    }

    public void setTen_lop_tin_chi(String ten_lop_tin_chi) {
        this.ten_lop_tin_chi = ten_lop_tin_chi;
    }

    public String getThoi_gian() {
        return thoi_gian;
    }

    public void setThoi_gian(String thoi_gian) {
        this.thoi_gian = thoi_gian;
    }

    public String getThu() {
        return thu;
    }

    public void setThu(String thu) {
        this.thu = thu;
    }
    public String getTiet() {
        return tiet;
    }

    public void setTiet(String tiet) {
        this.tiet = tiet;
    }
    public String getPhong() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }

    public String getThanh_vien() {
        return thanh_vien;
    }

    public void setThanh_vien(String thanh_vien) {
        this.thanh_vien = thanh_vien;
    }

    public String getMa_sinh_vien() {
        return ma_sinh_vien;
    }

    public void setMa_sinh_vien(String ma_sinh_vien) {
        this.ma_sinh_vien = ma_sinh_vien;
    }

    public String getGiao_vien() {
        return giao_vien;
    }

    public void setGiao_vien(String giao_vien) {
        this.giao_vien = giao_vien;
    }
}

