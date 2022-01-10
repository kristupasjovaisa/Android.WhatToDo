package com.example.whattodo.models;

public class Message {
    private Long id;
    private User user;
    private String text;

    public Message(Long id, User user, String text) {
        this.id = id;
        this.user = user;
        this.text = text;
    }
}