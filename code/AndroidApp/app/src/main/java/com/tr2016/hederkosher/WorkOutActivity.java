package com.tr2016.hederkosher;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.tr2016.hederkosher.utils.Message;
import com.tr2016.hederkosher.utils.MessageAdapter;
import com.tr2016.hederkosher.utils.Task;
import com.tr2016.hederkosher.utils.TaskAdapter;

import java.util.ArrayList;
import java.util.Date;

public class WorkOutActivity extends AppCompatActivity {
    ListView tasksListView;
    ArrayList<Task> tasksList;

    ListView messagesListView;
    ArrayList<Message> messagesList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_out);

        int idProgram = 0;
        setTables(idProgram);
//        setTableTasks(idProgram);
    }


    public void setTables(int idProgram) {
        getTableTasks(idProgram);
        getTableMessages(idProgram);
//        createTableLayout();
        View header;

        TaskAdapter taskAdapter = new TaskAdapter(this, R.layout.layout_task_item_row, tasksList);
        tasksListView = (ListView) findViewById(R.id.tasksListView);
        header = (View)getLayoutInflater().inflate(R.layout.layout_task_header_row, null);
        tasksListView.addHeaderView(header);
        tasksListView.setAdapter(taskAdapter);

        MessageAdapter messageAdapter = new MessageAdapter(this, R.layout.layout_message_item_row, messagesList);
        messagesListView = (ListView) findViewById(R.id.messagesListView);
        header = (View)getLayoutInflater().inflate(R.layout.layout_message_header_row, null);
        messagesListView.addHeaderView(header);
        messagesListView.setAdapter(messageAdapter);

        tasksListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

//                Log.d(LOG_TAG, "itemClick: position = " + position + ", id = "
//                        + id);
            }
        });
        tasksListView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
//                Log.d(LOG_TAG, "itemSelect: position = " + position + ", id = "
//                        + id);
            }

            public void onNothingSelected(AdapterView<?> parent) {
//                Log.d(LOG_TAG, "itemSelect: nothing");
            }
        });
    }

    public void getTableTasks(int idProgram) {
        tasksList = new ArrayList<>();
        tasksList.add(new Task("squat", "4", "10", "10", R.drawable.stopwatch));
        tasksList.add(new Task("biesep", "4", "10", "10", R.drawable.stopwatch));
        tasksList.add(new Task("squat", "4", "10", "10", R.drawable.stopwatch));
        tasksList.add(new Task("squat", "4", "10", "10",  R.drawable.stopwatch));
        tasksList.add(new Task("squat", "4", "10", "10",  R.drawable.stopwatch));
        tasksList.add(new Task("squat", "4", "10", "10",  R.drawable.stopwatch));
        tasksList.add(new Task("squat", "4", "10", "10",  R.drawable.stopwatch));
        tasksList.add(new Task("squat", "4", "10", "10",  R.drawable.stopwatch));
        tasksList.add(new Task("squat", "4", "10", "10",  R.drawable.stopwatch));
        tasksList.add(new Task("squat", "4", "10", "10",  R.drawable.stopwatch));
        tasksList.add(new Task("squat", "4", "10", "10",  R.drawable.stopwatch));
        tasksList.add(new Task("squat", "4", "10", "10",  R.drawable.stopwatch));
        tasksList.add(new Task("squat", "4", "10", "10",  R.drawable.stopwatch));
        tasksList.add(new Task("squat", "4", "10", "10",  R.drawable.stopwatch));
        tasksList.add(new Task("squat", "4", "10", "10",  R.drawable.stopwatch));
    }

    public void getTableMessages(int idProgram) {
        messagesList = new ArrayList<>();
        messagesList.add(new Message(new Date(),"squatsadmnasdnsa,dsa"));
        messagesList.add(new Message(new Date(),"squatsadmnasdnsa,dsa"));
        messagesList.add(new Message(new Date(),"squatsadmnasdnsa,dsa"));
        messagesList.add(new Message(new Date(),"squatsadmnasdnsa,dsa"));
        messagesList.add(new Message(new Date(),"squatsadmnasdnsa,dsa"));
        messagesList.add(new Message(new Date(),"squatsadmnasdnsa,dsa"));
    }

    public void createTableLayout() {

        TableLayout tableLayout = new TableLayout(this);
        tableLayout.setLayoutParams(new TableLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        tableLayout.setStretchAllColumns(true);

        for (Task task : tasksList) {
            tableLayout.addView(createTableRow(task));

        }
        setContentView(tableLayout);
    }
    private TableRow createTableRow(Task task){
        TableRow tableRow = new TableRow(this);

//        tableRow.setBackgroundColor(0xffcccccc);
//        android:orientation="horizontal"
//        android:layout_width="fill_parent"
//        android:layout_height="fill_parent">

        tableRow.addView(createTextView(task.getTask()));
        tableRow.addView(createTextView(task.getSet()));
        tableRow.addView(createTextView(task.getRepeat()));
        tableRow.addView(createTextView(task.getWeight()));
//        tableRow.addView(createTextView(task.getTimer()));
        return  tableRow;
    }
    private TextView createTextView(String obj){
        TextView textView = new TextView(this);
        textView.setText(obj);
//        textView.setGravity(View.gra.TEXT_ALIGNMENT_GRAVITY);
        textView.setTextSize(12);
        textView.setTextColor(Color.rgb(200,0,0));
//        ContextCompat.getColor(context, R.color.your_color);
//
//        android:gravity="center_vertical"
//        android:layout_alignParentTop="true"
//        android:layout_alignParentBottom="true"
//        android:textSize="12dp"
//        android:textColor=
//        android:padding="10dp"
//        android:layout_marginTop="5dp"
//        android:layout_marginBottom="5dp" />
//
        return  textView;
    }








}
