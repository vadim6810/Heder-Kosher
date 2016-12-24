package com.tr2016.hederkosher.utils;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.tr2016.hederkosher.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 23/12/16.
 */

public class MessageAdapter extends ArrayAdapter<Message> {

    Context context;
    int layoutResourceId;
    ArrayList<Message> data = null;

    public MessageAdapter(Context context, int resource, List<Message> objects) {
        super(context, resource, objects);
        this.layoutResourceId = resource;
        this.context = context;
        this.data = (ArrayList) objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        TaskHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new TaskHolder();
            holder.date = (TextView) row.findViewById(R.id.date);
            holder.text = (TextView) row.findViewById(R.id.text);

            row.setTag(holder);
        }
        else
        {
            holder = (TaskHolder) row.getTag();
        }

        Message message = data.get(position);
        holder.date.setText(message.getDateToString());
        holder.text.setText(message.getText());
        return row;
    }

    private class TaskHolder {
        public TextView date;
        public TextView text;
    }
}