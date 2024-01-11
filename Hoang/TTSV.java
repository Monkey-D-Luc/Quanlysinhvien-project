package com.example.demo;

public class TTSV {
    private String stt;
    private String msv;
    private String ten;
    private String lop;
    private String khoa;
    private String khoaHoc;

    public TTSV(String stt,String msv, String ten, String lop, String khoa, String khoa_hoc) {
        this.stt=stt;
        this.msv = msv;
        this.ten = ten;
        this.lop = lop;
        this.khoa = khoa;
        this.khoaHoc = khoa_hoc;
    }
    public String getStt() {
        return stt;
    }

    public void setStt(String stt) {
        this.stt = stt;
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
}
