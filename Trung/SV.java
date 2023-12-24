package com.example.demo;

public class SV {
    private String hoTen;
    private String msv;
    private float diemThanhPhan;
    private float diemThi;
    private float tbchp;

    public SV(String hoTen, String msv, float diemThanhPhan, float diemThi) {
        this.hoTen = hoTen;
        this.msv = msv;
        this.diemThanhPhan = diemThanhPhan;
        this.diemThi = diemThi;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getMsv() {
        return msv;
    }

    public void setMsv(String msv) {
        this.msv = msv;
    }

    public float getDiemThanhPhan() {
        return diemThanhPhan;
    }

    public void setDiemThanhPhan(float diemThanhPhan) {
        this.diemThanhPhan = diemThanhPhan;
    }

    public float getDiemThi() {
        return diemThi;
    }

    public void setDiemThi(float diemThi) {
        this.diemThi = diemThi;
    }

    public float getTbchp() {
        return tbchp;
    }

    public void setTbchp() {
        this.tbchp = tbchp;
    }


    public SV() {
    }
}