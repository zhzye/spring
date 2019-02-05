package com.zhzye.entity;

import java.util.Date;

public class Novel {
    private String title;
    private String url;
    private Date created_at;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "Novel{" +
                "title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", created_at=" + created_at +
                '}';
    }
}
