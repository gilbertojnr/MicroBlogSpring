package com.theironyard;

/**
 * Created by gilbertakpan on 12/20/16.
 */
public class Message {
    String text;
    int id;

    public Message() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Message(String text, int id) {
        this.text = text;
        this.id = id;
    }
}


