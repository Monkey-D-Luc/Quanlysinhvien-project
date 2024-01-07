package com.example.demo;

public class TTSV {
    private String msv;
    private String ten;
    private String lop;
    private String khoa;
    private String khoaHoc;

    private String hocphi;

    private String conthieu;
    private String danop;

    public TTSV(String msv, String ten, String lop, String khoa, String khoa_hoc ) {
        this.msv = msv;
        this.ten = ten;
        this.lop = lop;
        this.khoa = khoa;
        this.khoaHoc = khoa_hoc;
//        this.hocphi= hoc_phi;
//        this.danop= da_nop;
//        this.conthieu=con_thieu;
    }
    public TTSV (String msv,String ten, String hoc_phi,String da_nop,String con_thieu ,String nam){
        this.msv =msv;
        this.ten=ten;
        this.hocphi= hoc_phi;
        this.danop= da_nop;
        this.conthieu=con_thieu;
    }
    public String getMsv() {
        return msv;
    }

    public void setMsv(String msv) {
        this.msv = msv;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public String getKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(String khoaHoc) {
        this.khoaHoc = khoaHoc;
    }

    public String getHocphi() {
        return hocphi;
    }

    public void setHocphi(String hocphi) {
        this.hocphi = hocphi;
    }

    public String getConthieu() {
        return conthieu;
    }

    public void setConthieu(String conthieu) {
        this.conthieu = conthieu;
    }

    public String getDanop() {
        return danop;
    }

    public void setDanop(String danop) {
        this.danop = danop;
    }
}
