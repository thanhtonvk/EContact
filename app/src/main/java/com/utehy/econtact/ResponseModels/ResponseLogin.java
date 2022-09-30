package com.utehy.econtact.ResponseModels;

public class ResponseLogin {
    private String access_token, user_id, username, full_name, avatar, expires_in, print_name_e, prin_name_l, date_of_birth, email, lang, expires;
    public static ResponseLogin USER_INFO;
    public ResponseLogin(String access_token, String user_id, String username, String full_name, String avatar, String expires_in, String print_name_e, String prin_name_l, String date_of_birth, String email, String lang, String expires) {
        this.access_token = access_token;
        this.user_id = user_id;
        this.username = username;
        this.full_name = full_name;
        this.avatar = avatar;
        this.expires_in = expires_in;
        this.print_name_e = print_name_e;
        this.prin_name_l = prin_name_l;
        this.date_of_birth = date_of_birth;
        this.email = email;
        this.lang = lang;
        this.expires = expires;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

    public String getPrint_name_e() {
        return print_name_e;
    }

    public void setPrint_name_e(String print_name_e) {
        this.print_name_e = print_name_e;
    }

    public String getPrin_name_l() {
        return prin_name_l;
    }

    public void setPrin_name_l(String prin_name_l) {
        this.prin_name_l = prin_name_l;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getExpires() {
        return expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }
}
