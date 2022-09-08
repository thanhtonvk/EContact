package com.utehy.econtact.Models;

import java.util.List;

public class ResponseDiemHocPhan {
    private String MessageCode;
    private List<DiemHocPhan> data;
    private String ExtraInfo;

    public String getMessageCode() {
        return MessageCode;
    }

    public void setMessageCode(String messageCode) {
        MessageCode = messageCode;
    }

    public List<DiemHocPhan> getData() {
        return data;
    }

    public void setData(List<DiemHocPhan> data) {
        this.data = data;
    }

    public String getExtraInfo() {
        return ExtraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        ExtraInfo = extraInfo;
    }

    public ResponseDiemHocPhan(String messageCode, List<DiemHocPhan> data, String extraInfo) {
        MessageCode = messageCode;
        this.data = data;
        ExtraInfo = extraInfo;
    }

    public ResponseDiemHocPhan() {
    }

}
