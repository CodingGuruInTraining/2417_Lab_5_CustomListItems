package com.example.hl4350hb.customlistitemsapp;

import java.util.Date;

public class ToDoItem {
    String text;
    Date created;

    public ToDoItem(String text) {
        this.text = text;
        this.created = new Date();
    }

    public Date getCreated() {
        return created;
    }

    public String getText() {
        return text;
    }
}