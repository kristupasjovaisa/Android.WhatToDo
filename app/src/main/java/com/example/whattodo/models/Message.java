package com.example.whattodo.models;

public class Message {
    private Long id;
    private User user;
    private String text;

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getText() {
        return text;
    }

    public Message(Long id, User user, String text) {
        this.id = id;
        this.user = user;
        this.text = text;
    }



    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", user=" + user +
                ", text='" + text + '\'' +
                '}';
    }
}