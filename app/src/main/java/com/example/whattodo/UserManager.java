package com.example.whattodo;

public class UserManager {

    public static UserManager shared = new UserManager();

   public long userId = 1;

    private UserManager() {
    }
}
