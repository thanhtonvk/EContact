package com.utehy.econtact.Models;

import java.util.List;

public class ResponseMessage {
    private String MessageCode;
    private List<Object> data;
    private String ExtraInfo;

    public String getMessageCode() {
        return MessageCode;
    }

    public void setMessageCode(String messageCode) {
        MessageCode = messageCode;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }

    public String getExtraInfo() {
        return ExtraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        ExtraInfo = extraInfo;
    }

    public ResponseMessage(String messageCode, List<Object> data, String extraInfo) {
        MessageCode = messageCode;
        this.data = data;
        ExtraInfo = extraInfo;
    }

    public ResponseMessage() {
    }
}
