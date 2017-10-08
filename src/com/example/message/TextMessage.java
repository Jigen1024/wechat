package com.example.message;

public class TextMessage extends MessageAdapter {

    public TextMessage(String toUserName, String fromUserName, String content) {
        xml = "<xml>"
                + "<ToUserName><![CDATA[" + toUserName + "]]></ToUserName>"
                + "<FromUserName><![CDATA[" + fromUserName + "]]></FromUserName>"
                + "<CreateTime>" + (System.currentTimeMillis()/1000) + "</CreateTime>"
                + "<MsgType><![CDATA[text]]></MsgType>"
                + "<Content><![CDATA[" + content + "]]></Content>"
                + "</xml>";
    }
}
