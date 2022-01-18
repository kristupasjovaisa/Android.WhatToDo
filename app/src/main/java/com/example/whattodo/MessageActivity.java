package com.example.whattodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.whattodo.models.Chat;
import com.example.whattodo.models.Message;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        Long chatId = getIntent().getLongExtra("chatId", 0);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http:192.168.1.131:8080/").addConverterFactory(GsonConverterFactory.create()).build();
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<Message>> call = jsonPlaceHolderApi.getMessages(chatId + "");

        call.enqueue(new Callback<List<Message>>() {
            @Override
            public void onResponse(Call<List<Message>> call, Response<List<Message>> response) {
                if (!response.isSuccessful()) {
                    System.out.println("Is Successful response");
                    return;
                }
                List<Message> messages = response.body();

                MessageListAdapter adapter = new MessageListAdapter(getApplicationContext(), R.layout.message_adapter_view_layout, messages);

                View view = getWindow().getDecorView().getRootView();
                ListView listView = (ListView) view.findViewById(R.id.messageList);

                listView = (ListView) view.findViewById(R.id.messageList);
                listView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<Message>> call, Throwable t) {

            }
        });
    }
}