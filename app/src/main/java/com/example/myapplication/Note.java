package com.example.myapplication;


import io.realm.RealmObject;

public class Note extends RealmObject {
    String title,content;
    public Note(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }




}
