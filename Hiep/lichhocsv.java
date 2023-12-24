package com.quanlisinhvien;

public class lichhocsv{
    private String tenhocphan;
    private Integer sotinchi;
    private String tenloptinchi;
    private String thanhvien;
    private String masinhvien;
    private String giaovien;

    public lichhocsv(String tenhocphan, Integer sotinchi, String tenloptinchi, String thanhvien, String masinhvien, String giaovien) {
        this.tenhocphan = tenhocphan;
        this.sotinchi = sotinchi;
        this.tenloptinchi = tenloptinchi;
        this.thanhvien = thanhvien;
        this.masinhvien = masinhvien;
        this.giaovien = giaovien;
    }

    public lichhocsv() {
    }

    public String getGiaovien() {
        return giaovien;
    }

    public void setGiaovien(String giaovien) {
        this.giaovien = giaovien;
    }

    public String getThanhvien() {
        return thanhvien;
    }

    public void setThanhvien(String thanhvien) {
        this.thanhvien = thanhvien;
    }

    public String getMasinhvien() {
        return masinhvien;
    }

    public void setMasinhvien(String masinhvien) {
        this.masinhvien = masinhvien;
    }

    public String getTenhocphan() {
        return tenhocphan;
    }

    public void setTenhocphan(String tenhocphan) {
        this.tenhocphan = tenhocphan;
    }

    public int getSotinchi() {
        return sotinchi;
    }

    public void setSotinchi(int sotinchi) {
        this.sotinchi = sotinchi;
    }

    public String getTenloptinchi() {
        return tenloptinchi;
    }

    public void setTenloptinchi(String tenloptinchi) {
        this.tenloptinchi = tenloptinchi;
    }
}

