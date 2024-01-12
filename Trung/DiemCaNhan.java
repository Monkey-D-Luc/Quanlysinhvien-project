package com.example.demo;

public class DiemCaNhan extends DiemSV{
    private String maHocPhan;
    private String tenHocPhan;
    private int soTinChi;
    private int diemSo;
    private String diemChu;

    public DiemCaNhan(int stt, String maHocPhan, String tenHocPhan, int soTinChi, float diemThanhPhan, float diemThi, float tbchp, int diemSo, String diemChu) {
        this.maHocPhan = maHocPhan;
        this.tenHocPhan = tenHocPhan;
        this.soTinChi = soTinChi;
        this.stt = stt;
        this.diemThanhPhan = diemThanhPhan;
        this.diemThi = diemThi;
        this.tbchp = tbchp;
        this.diemSo = diemSo;
        this.diemChu = diemChu;
    }

    public String getMaHocPhan() {
        return maHocPhan;
    }

    public void setMaHocPhan(String maHocPhan) {
        this.maHocPhan = maHocPhan;
    }

    public String getTenHocPhan() {
        return tenHocPhan;
    }

    public void setTenHocPhan(String tenHocPhan) {
        this.tenHocPhan = tenHocPhan;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }

    public int getDiemSo() {
        return diemSo;
    }

    public void setDiemSo(int diemSo) {
        this.diemSo = diemSo;
    }

    public String getDiemChu() {
        return diemChu;
    }

    public void setDiemChu(String diemChu) {
        this.diemChu = diemChu;
    }
}
