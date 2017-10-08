package com.example;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;

public class JS {
    private String nonceStr = "";
    private String url = "";
    private String timeStamp = "";
    private String ticket = "";
    private String signature = "";
    private int nonceStrLength = 16;

    public JS(String url) throws IOException {
        nonceStr = createRandomString();
        this.url = url;
        timeStamp = String.valueOf((System.currentTimeMillis() / 1000));
        ticket = Base.getJsapiTicket();
        String str = "jsapi_ticket=" + ticket + "&noncestr=" + nonceStr + "&timestamp=" + timeStamp + "&url=" + url;
        signature = DigestUtils.sha1Hex(str.getBytes("utf-8"));
    }


    private String createRandomString() {
        String key = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int keyLenght = key.length() - 1;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i=0; i<nonceStrLength; i++) {
            stringBuffer.append( key.charAt( (int) Math.round(Math.random() * keyLenght) ) );
        }
        return stringBuffer.toString();
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getAppId() {
        return Base.APPID;
    }
}
