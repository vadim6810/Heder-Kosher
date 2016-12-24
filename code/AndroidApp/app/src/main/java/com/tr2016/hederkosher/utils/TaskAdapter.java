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

public class TaskAdapter extends ArrayAdapter<Task> {

    Context context;
    int layoutResourceId;
    ArrayList<Task> data = null;

    public TaskAdapter(Context context, int resource, List<Task> objects) {
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
            holder.task = (TextView) row.findViewById(R.id.task);
            holder.set = (TextView) row.findViewById(R.id.set);
            holder.repeat = (TextView) row.findViewById(R.id.repeat);
            holder.weight = (TextView) row.findViewById(R.id.weight);
            holder.timer = (TextView) row.findViewById(R.id.timer);

            row.setTag(holder);
        }
        else
        {
            holder = (TaskHolder) row.getTag();
        }

        Task task = data.get(position);
        holder.task.setText(task.getTask());
        holder.set.setText(task.getSet());
        holder.repeat.setText(task.getRepeat());
        holder.weight.setText(task.getWeight());
        holder.timer.setText(task.getTimer());
        return row;
    }

    private class TaskHolder {
        public TextView task;
        public TextView set;
        public TextView repeat;
        public TextView weight;
        public TextView timer;

    }
}