package com.example.message;

public class MessageAdapter implements IMessage {

    String xml = "success";

    public MessageAdapter(String xml) {
        this.xml = xml;
    }

    public MessageAdapter() {

    }

    @Override
    public String create() {
        return this.xml;
    }
}
