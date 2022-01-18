package com.example.whattodo;

import com.example.whattodo.models.Chat;
import com.example.whattodo.models.Message;
import com.example.whattodo.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JsonPlaceHolderApi {

    @GET("users/{id}")
    Call<User> getUser(@Path("id") String id);

    @GET("users/{id}/chats")
    Call<List<Chat>> getChats(@Path("id") String id);

    @GET("chats/{id}/messages")
    Call<List<Message>> getMessages(@Path("id") String id);
}
