package com.utehy.econtact.Models;

public class Thongbao {
    private int Id;
    private String Tenthongbao;
    private String Noidung;

    public Thongbao(int id, String tenthongbao, String noidung) {
        Id = id;
        Tenthongbao = tenthongbao;
        Noidung = noidung;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTenthongbao() {
        return Tenthongbao;
    }

    public void setTenthongbao(String tenthongbao) {
        Tenthongbao = tenthongbao;
    }

    public String getNoidung() {
        return Noidung;
    }

    public void setNoidung(String noidung) {
        Noidung = noidung;
    }
}
