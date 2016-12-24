package com.tr2016.hederkosher;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

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

    public void getTableTasks(int idProgram) {
        tasksList = new ArrayList<>();
        tasksList.add(new Task("squat", "4", "10", "10", "E"));
        tasksList.add(new Task("biesep", "4", "10", "10", "E"));
        tasksList.add(new Task("squat", "4", "10", "10", "E"));
        tasksList.add(new Task("squat", "4", "10", "10", "E"));
        tasksList.add(new Task("biesep", "4", "10", "10", "E"));
    }

    public void setTableTasks(int idProgram) {
        getTableTasks(idProgram);

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

}
