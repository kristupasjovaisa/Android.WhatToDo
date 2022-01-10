package com.example.whattodo;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.whattodo.models.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.user_layout, container, false);
        TextView idTextView = rootView.findViewById(R.id.textViewId);

        TextView nameTextView = rootView.findViewById(R.id.textViewNameId);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http:192.168.1.131:8080/").addConverterFactory(GsonConverterFactory.create()).build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<User> call = jsonPlaceHolderApi.getUser(UserManager.shared.userId + "");
        Log.d("LOGAS","useris pries " );

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.d("LOGAS","responsas " + response);
                if (!response.isSuccessful()) {
                    System.out.println("Is Successful response");
                    return;
                }
                User user = response.body();
                Log.d("LOGAS","useris po" + user.getId());
                idTextView.setText(user.getId().toString());
                nameTextView.setText(user.getName());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d("LOGAS","eroras " + t.getMessage());
            }
        });
        return rootView;
    }

}
