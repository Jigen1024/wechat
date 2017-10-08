package com.example.bean;

import com.google.gson.annotations.SerializedName;

public class RicoBean {

    @SerializedName("code")
    private long code;

    @SerializedName("text")
    private String text;

    @SerializedName("url")
    private String url;

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
