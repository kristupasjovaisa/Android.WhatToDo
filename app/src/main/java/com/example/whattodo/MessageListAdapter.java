package com.example.whattodo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.whattodo.models.Chat;
import com.example.whattodo.models.Message;
import com.example.whattodo.models.User;

import java.util.List;

public class MessageListAdapter extends ArrayAdapter<Message> {

    private static final String TAG = "MessageListAdapter";
    private Context mContext;
    int mResource;

    public MessageListAdapter(@NonNull Context context, int resource, @NonNull List<Message> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Message message = getItem(position);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView textView = (TextView) convertView.findViewById(R.id.messageTextView);

        textView.setText(message.getText());
        return textView;
    }


}
