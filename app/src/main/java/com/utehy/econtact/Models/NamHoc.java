package com.utehy.econtact.Models;

public class NamHoc {
    private String namHoc;
    private String kiHoc;
    public static NamHoc NAM_HOC;

    public String getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(String namHoc) {
        this.namHoc = namHoc;
    }

    public String getKiHoc() {
        return kiHoc;
    }

    public void setKiHoc(String kiHoc) {
        this.kiHoc = kiHoc;
    }

    public NamHoc(String namHoc, String kiHoc) {
        this.namHoc = namHoc;
        this.kiHoc = kiHoc;
    }
}
