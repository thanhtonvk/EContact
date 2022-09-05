package com.utehy.econtact.Models;

public class TaiKhoan {
    private String ID;
    private String TenTK;
    private String MatKhau;

    public TaiKhoan() {
    }

    public TaiKhoan(String ID, String tenTK, String matKhau) {
        this.ID = ID;
        TenTK = tenTK;
        MatKhau = matKhau;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTenTK() {
        return TenTK;
    }

    public void setTenTK(String tenTK) {
        TenTK = tenTK;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String matKhau) {
        MatKhau = matKhau;
    }
}
