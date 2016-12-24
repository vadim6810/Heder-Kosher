package com.tr2016.hederkosher;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.tr2016.hederkosher.utils.Task;
import com.tr2016.hederkosher.utils.TaskAdapter;

import java.util.ArrayList;

public class WorkOutActivity extends AppCompatActivity {
    ListView tasksListView;
    //    GridView gvCol;
//    GridView gvTasks;
//    Object[] cNames = new Object[]{"excerise","sets","reapet","weight",""};
//    ArrayAdapter<Object> cAdapter;
    ArrayList<Task> tasksList;
//    ArrayAdapter<Object> tAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_out);

        int idProgram = 0;
        setTableTasks(idProgram);
//        setTableTasks(idProgram);
    }


    public void setTableTasks(int idProgram) {
        getTableTasks(idProgram);
//        createTableLayout();

        TaskAdapter adapter = new TaskAdapter(this, R.layout.layout_task_item_row, tasksList);
        tasksListView = (ListView) findViewById(R.id.tasksListView);

        View header = (View)getLayoutInflater().inflate(R.layout.layout_task_header_row, null);
        tasksListView.addHeaderView(header);
        tasksListView.setAdapter(adapter);


//        adjustGridView();


//        cAdapter = new ArrayAdapter<>(this, R.layout.item, R.id.tvText, cNames);
//        gvCol= (GridView) findViewById(R.id.gv_colls);

//        tAdapter = new ArrayAdapter<Object>(this, R.layout.item, R.id.tvText, tTasks);
//        gridView = (GridView) findViewById(R.id.grid_tasks);
//        gridView.setAdapter(adapter);
//        adjustGridView();

//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View v,
//                                    int position, long id) {
//                Toast.makeText(getApplicationContext(),
//                        ((TextView) v).getText(), Toast.LENGTH_SHORT).show();
//            }
//        });
    }

//    private void adjustGridView() {
//        tasksListView.setNumColumns(5);
//        tasksListView.setVerticalSpacing(2);
//    }

    public void getTableTasks(int idProgram) {
        tasksList = new ArrayList<>();
        tasksList.add(new Task("squat", "4", "10", "10", "E"));
        tasksList.add(new Task("biesep", "4", "10", "10", "E"));
        tasksList.add(new Task("squat", "4", "10", "10", "E"));
        tasksList.add(new Task("squat", "4", "10", "10", "E"));
        tasksList.add(new Task("biesep", "4", "10", "10", "E"));
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
        tableRow.addView(createTextView(task.getTimer()));
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
