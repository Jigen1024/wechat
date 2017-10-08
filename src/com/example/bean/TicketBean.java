package com.example.bean;

import com.google.gson.annotations.SerializedName;

public class TicketBean {

    @SerializedName("errcode")
    private int errcode;

    @SerializedName("errmsg")
    private String errmsg;

    @SerializedName("ticket")
    private String tiket;

    @SerializedName("expires_in")
    private long expires_in;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getTiket() {
        return tiket;
    }

    public void setTiket(String tiket) {
        this.tiket = tiket;
    }

    public long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(long expires_in) {
        this.expires_in = expires_in;
    }

    @Override
    public String toString() {
        return "{\"errcode\":" + errcode + ",\"errmsg\":\"" + errmsg + "\",\"ticket\":\"" + tiket + "\",\"expires_in\":" + expires_in + "}";
    }
}
