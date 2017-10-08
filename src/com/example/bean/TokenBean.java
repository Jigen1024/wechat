package com.example.bean;

import com.google.gson.annotations.SerializedName;

public class TokenBean {

    @SerializedName("access_token")
    private String access_token;

    @SerializedName("expires_in")
    private long expires_in;

    public TokenBean() {

    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(long expires_in) {
        this.expires_in = expires_in;
    }

    @Override
    public String toString() {
        return "{\"access_token\":\"" + access_token + "\",\"expires_in\":" + expires_in + "}";
    }
}
