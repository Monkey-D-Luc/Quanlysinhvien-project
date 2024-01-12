package com.example.demo;

import javafx.scene.control.Alert;

public class DiemSV{
    protected int stt;
    private String ten;
    private String msv;
    protected float diemThanhPhan;
    protected float diemThi;
    protected float tbchp;

    public DiemSV(int stt, String ten, String msv, float diemThanhPhan, float diemThi, float tbchp) {
        this.stt = stt;
        this.ten = ten;
        this.msv = msv;
        this.diemThanhPhan = diemThanhPhan;
        this.diemThi = diemThi;
        this.tbchp = tbchp;
    }

    public DiemSV(int stt, String ten, String msv) {
        this.stt = stt;
        this.ten = ten;
        this.msv = msv;
    }

    public DiemSV() {
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
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

    public boolean setDiemThanhPhan(float diemThanhPhan) {
        if (diemThanhPhan > 10 || diemThanhPhan < 0){
            showFailedAlert();
            return false;
        }
        this.diemThanhPhan = diemThanhPhan;
        this.tbchp = (this.diemThi + this.diemThanhPhan) / 2;
        showSuccessAlert();
        return true;
    }

    public float getDiemThi() {
        return diemThi;
    }

    public boolean setDiemThi(float diemThi) {
        if (diemThi > 10 || diemThi < 0){
            showFailedAlert();
            return false;
        }
        this.diemThi = diemThi;
        this.tbchp = (this.diemThi + this.diemThanhPhan) / 2;
        showSuccessAlert();
        return true;
    }

    public float getTbchp() {
        return tbchp;
    }

    public void setTbchp(float tbchp) {
        this.tbchp = tbchp;
    }

    private void showSuccessAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Thông báo");
        alert.setHeaderText(null);
        alert.setContentText("Chỉnh sửa thành công!");
        alert.showAndWait();
    }

    private void showFailedAlert() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Thông báo");
        alert.setHeaderText(null);
        alert.setContentText("Điểm không hợp lệ! Yêu cầu nhập điểm từ trong khoảng 0 - 10");
        alert.showAndWait();
    }
}
