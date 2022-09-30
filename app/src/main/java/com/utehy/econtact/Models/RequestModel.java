package com.utehy.econtact.Models;

public class RequestModel {
    private Method Method;
    private String Url, Module;
    private Object Data;
    private String ContentType;
    private String AcceptType;

    public RequestModel(com.utehy.econtact.Models.Method method, String url, String module, Object data) {
        Method = method;
        Url = url;
        Module = module;
        Data = data;
        ContentType = "application/json";
        AcceptType = "application/json";
    }

    public RequestModel() {
        ContentType = "application/json";
        AcceptType = "application/json";
    }

    public com.utehy.econtact.Models.Method getMethod() {
        return Method;
    }

    public void setMethod(com.utehy.econtact.Models.Method method) {
        Method = method;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getModule() {
        return Module;
    }

    public void setModule(String module) {
        Module = module;
    }

    public Object getData() {
        return Data;
    }

    public void setData(Object data) {
        Data = data;
    }

    public String getContentType() {
        return ContentType;
    }

    public void setContentType(String contentType) {
        ContentType = contentType;
    }

    public String getAcceptType() {
        return AcceptType;
    }

    public void setAcceptType(String acceptType) {
        AcceptType = acceptType;
    }
}
