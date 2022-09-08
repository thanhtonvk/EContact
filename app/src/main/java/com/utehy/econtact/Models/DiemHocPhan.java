package com.utehy.econtact.Models;

public class DiemHocPhan {
    private long RowNumber;
    private String subject_id;
    private String subject_name;
    private double score;
    private double score1;
    private double score2;
    private int number_credits;
    private String academy_year;
    private int semester;
    private String note;
    private String student_rcd;
    private String student_name;
    private String class_id;

    public long getRowNumber() {
        return RowNumber;
    }

    public void setRowNumber(long rowNumber) {
        RowNumber = rowNumber;
    }

    public String getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getScore1() {
        return score1;
    }

    public void setScore1(double score1) {
        this.score1 = score1;
    }

    public double getScore2() {
        return score2;
    }

    public void setScore2(double score2) {
        this.score2 = score2;
    }

    public int getNumber_credits() {
        return number_credits;
    }

    public void setNumber_credits(int number_credits) {
        this.number_credits = number_credits;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    public DiemHocPhan(long rowNumber, String subject_id, String subject_name, double score, double score1, double score2, int number_credits, String academy_year, int semester, String note, String student_rcd, String student_name, String class_id) {
        RowNumber = rowNumber;
        this.subject_id = subject_id;
        this.subject_name = subject_name;
        this.score = score;
        this.score1 = score1;
        this.score2 = score2;
        this.number_credits = number_credits;
        this.academy_year = academy_year;
        this.semester = semester;
        this.note = note;
        this.student_rcd = student_rcd;
        this.student_name = student_name;
        this.class_id = class_id;
    }

    public DiemHocPhan() {
    }

}
