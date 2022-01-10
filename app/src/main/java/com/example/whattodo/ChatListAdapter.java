package com.example.whattodo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.whattodo.models.Chat;
import com.example.whattodo.models.User;

import java.util.List;
import java.util.stream.Collectors;

public class ChatListAdapter extends ArrayAdapter<Chat> {

    private static final String TAG = "ChatListAdapter";
    private Context mContext;
    int mResource;

    public ChatListAdapter(@NonNull Context context, int resource, @NonNull List<Chat> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Chat chat = getItem(position);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView textViewUser = (TextView) convertView.findViewById(R.id.userTextView);

//        for (User user : chat.getUsers()) {
//            if (!user.getId().equals(UserManager.shared.userId)) {
//                userToDisplay = user;
//            }
//        }

        User userToDisplay = chat.getUsers().stream().filter(user -> !user.getId().equals(UserManager.shared.userId)).findFirst().get();

        textViewUser.setText((userToDisplay.getName()));
        return convertView;
    }


}
