package com.utehy.econtact.Models;

import java.util.List;

public class ResponseDiemRenLuyem {
    private String MessageCode;
    private List<DiemRenLuyen> data;
    private String ExtraInfo;

    public String getMessageCode() {
        return MessageCode;
    }

    public void setMessageCode(String messageCode) {
        MessageCode = messageCode;
    }

    public List<DiemRenLuyen> getData() {
        return data;
    }

    public void setData(List<DiemRenLuyen> data) {
        this.data = data;
    }

    public String getExtraInfo() {
        return ExtraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        ExtraInfo = extraInfo;
    }

    public ResponseDiemRenLuyem(String messageCode, List<DiemRenLuyen> data, String extraInfo) {
        MessageCode = messageCode;
        this.data = data;
        ExtraInfo = extraInfo;
    }

    public ResponseDiemRenLuyem() {
    }
}
