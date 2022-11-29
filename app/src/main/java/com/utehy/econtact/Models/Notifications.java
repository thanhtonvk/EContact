package com.utehy.econtact.Models;

public class Notifications {
    public String created_date_time, class_id, notification_title, notification_content, notification_range;

    public Notifications() {

    }

    public String getCreated_date_time() {
        return created_date_time;
    }

    public void setCreated_date_time(String created_date_time) {
        this.created_date_time = created_date_time;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public String getNotification_title() {
        return notification_title;
    }

    public void setNotification_title(String notification_title) {
        this.notification_title = notification_title;
    }

    public String getNotification_content() {
        return notification_content;
    }

    public void setNotification_content(String notification_content) {
        this.notification_content = notification_content;
    }

    public String getNotification_range() {
        return notification_range;
    }

    public void setNotification_range(String notification_range) {
        this.notification_range = notification_range;
    }

    public Notifications(String created_date_time, String class_id, String notification_title, String notification_content, String notification_range) {
        this.created_date_time = created_date_time;
        this.class_id = class_id;
        this.notification_title = notification_title;
        this.notification_content = notification_content;
        this.notification_range = notification_range;
    }
}
