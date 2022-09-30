package com.utehy.econtact.Models;

import com.google.gson.annotations.SerializedName;

public class Data{
    @SerializedName("academy_year")
    private String academy_year;
    @SerializedName("semester")
    private String semester;
    @SerializedName("student_rcd")
    private String student_rcd;
    @SerializedName("page")
    private int page;
    @SerializedName("pageSize")
    private int pageSize;

    public String getAcademy_year() {
        return academy_year;
    }

    public void setAcademy_year(String academy_year) {
        this.academy_year = academy_year;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getStudent_rcd() {
        return student_rcd;
    }

    public void setStudent_rcd(String student_rcd) {
        this.student_rcd = student_rcd;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Data(String academy_year, String semester, String student_rcd, int page, int pageSize) {
        this.academy_year = academy_year;
        this.semester = semester;
        this.student_rcd = student_rcd;
        this.page = page;
        this.pageSize = pageSize;
    }
}
