package com.example.whattodo.models;

import java.util.ArrayList;
import java.util.List;

public class Chat {

    private Long id;
    private List<User> users = new ArrayList<>();

    public Chat(Long id, List<User> users) {
        this.id = id;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public List<User> getUsers() {
        return users;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
                ", users=" + users +
                '}';
    }
}
