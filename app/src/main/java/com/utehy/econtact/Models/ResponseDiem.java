package com.utehy.econtact.Models;

import java.util.List;

public class ResponseDiem {
    private String totalItems;
    private int page;
    private int pageSize;
    private String messageCode;
    private List<DiemHocPhan> data;

    public String getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(String totalItems) {
        this.totalItems = totalItems;
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

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public List<DiemHocPhan> getData() {
        return data;
    }

    public void setData(List<DiemHocPhan> data) {
        this.data = data;
    }

    public ResponseDiem(String totalItems, int page, int pageSize, String messageCode, List<DiemHocPhan> data) {
        this.totalItems = totalItems;
        this.page = page;
        this.pageSize = pageSize;
        this.messageCode = messageCode;
        this.data = data;
    }
}
