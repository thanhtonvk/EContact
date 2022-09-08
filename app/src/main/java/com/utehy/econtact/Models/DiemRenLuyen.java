package com.utehy.econtact.Models;

public class DiemRenLuyen {
    private long RowNumber;
    private String point_training_id;
    private String academy_year;
    private int semester;
    private int point;
    private String student_rcd;
    private String student_name;
    private String class_id;

    public long getRowNumber() {
        return RowNumber;
    }

    public void setRowNumber(long rowNumber) {
        RowNumber = rowNumber;
    }

    public String getPoint_training_id() {
        return point_training_id;
    }

    public void setPoint_training_id(String point_training_id) {
        this.point_training_id = point_training_id;
    }

    public String getAcademy_year() {
        return academy_year;
    }

    public void setAcademy_year(String academy_year) {
        this.academy_year = academy_year;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getStudent_rcd() {
        return student_rcd;
    }

    public void setStudent_rcd(String student_rcd) {
        this.student_rcd = student_rcd;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public DiemRenLuyen(long rowNumber, String point_training_id, String academy_year, int semester, int point, String student_rcd, String student_name, String class_id) {
        RowNumber = rowNumber;
        this.point_training_id = point_training_id;
        this.academy_year = academy_year;
        this.semester = semester;
        this.point = point;
        this.student_rcd = student_rcd;
        this.student_name = student_name;
        this.class_id = class_id;
    }

    public DiemRenLuyen() {
    }
}
