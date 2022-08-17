package com.example.giaodien;

import java.util.List;

public class DSchucnang {
    private String tenChucnang;
    private List<Chucnang> chucnangs;

    public DSchucnang(String tenChucnang, List<Chucnang> chucnangs) {
        this.tenChucnang = tenChucnang;
        this.chucnangs = chucnangs;
    }

    public String getTenChucnang() {
        return tenChucnang;
    }

    public void setTenChucnang(String tenChucnang) {
        this.tenChucnang = tenChucnang;
    }

    public List<Chucnang> getChucnangs() {
        return chucnangs;
    }

    public void setChucnangs(List<Chucnang> chucnangs) {
        this.chucnangs = chucnangs;
    }
}
