package com.utehy.econtact.Models;

public class TinTuc {
    private String id;
    private String tieuDe, noiDung, hinhAnh, ngay;

    public TinTuc(String id, String tieuDe, String noiDung, String hinhAnh, String ngay) {
        this.id = id;
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
        this.hinhAnh = hinhAnh;
        this.ngay = ngay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }
}
