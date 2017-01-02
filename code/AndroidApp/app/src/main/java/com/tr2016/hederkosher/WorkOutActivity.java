package com.tr2016.hederkosher;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.tr2016.hederkosher.utils.Message;
import com.tr2016.hederkosher.utils.MessageAdapter;
import com.tr2016.hederkosher.utils.Task;
import com.tr2016.hederkosher.utils.TaskAdapter;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class WorkOutActivity extends AppCompatActivity {
    private static final int MILLIS_PER_SECOND = 1000;
//    private static final int SECONDS_TO_COUNTDOWN = 30;

    private ListView tasksListView;
    private ArrayList<Task> tasksList;
    private ListView messagesListView;
    private ArrayList<Message> messagesList;

    private TaskAdapter taskAdapter;
    private MessageAdapter messageAdapter;

    private TextView countdownDisplay;
    private CountDownTimer timer;
    private Button startButton;
    private ProgressBar progressBarProgram;
    private Task currentTask;

    private int indexTaskInProgress = 0;
    private int indexTaskInSubProgress = 1;
    private long currentMsProgress = 0;
    private View cView;
 //   private TextView textTimer;
    private ProgressBar progressTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_out);

        final int idProgram = 0;
        setTables(idProgram);

        progressBarProgram = (ProgressBar) findViewById(R.id.progressBarTasks);
//        progressBarProgram.setVisibility(View.INVISIBLE);

        startButton = (Button) findViewById(R.id.button_done_task);
        startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                setProcess(idProgram);
            }
        });
    }

    public void setProcess(int idProgram) {
        if (tasksList == null || tasksList.size() == 0) return;
        countdownDisplay = (TextView) findViewById(R.id.textView);
        ProgressBar progressBarTasks = (ProgressBar) findViewById(R.id.progressBarTasks);
        try {
            String status = startButton.getText().toString();
//                Toast.makeText(WorkOutActivity.this, String.valueOf(currentTask.getTimerProcess()), Toast.LENGTH_LONG).show();

            if (status.toUpperCase().contains("START")) {
                indexTaskInProgress = 0;
                indexTaskInSubProgress = 1;
                currentTask = tasksList.get(indexTaskInProgress);

                int pb_max = 0;
                int iTask = 0;
                for (Task task : tasksList) {
                    task.setTimerProcess(task.getTimer());
                    task.setPauseProcess(task.getPause());
                    pb_max += (task.getTimer() + task.getPause());

                    cView = tasksListView.getChildAt(++iTask);
                    progressTask = (ProgressBar) cView.findViewById(R.id.timer);
//                    progressTask.setMax(task.getTimer());
                    progressTask.setProgress(0);
                }
                progressBarTasks.setProgress(0);
                progressBarTasks.setMax(pb_max);
//                Toast.makeText(WorkOutActivity.this, String.valueOf(pb_max), Toast.LENGTH_LONG).show();
                startButton.setText("PAUSE");
                showTimer();
            } else if (status.toUpperCase().contains("PAUSE")) {
                startButton.setText("NEXT");
                timer.cancel();
                if (indexTaskInSubProgress == 2)
                    currentTask.setPauseProcess((int) currentMsProgress);
                else
                    currentTask.setTimerProcess((int) currentMsProgress);
            } else if (status.toUpperCase().contains("NEXT")) {
                startButton.setText("PAUSE");
                showTimer();
            } else if (status.toUpperCase().contains("FINISH")) {
                startButton.setText("START");
            }
        } catch (NumberFormatException e) {
            // method ignores invalid (non-integer) input and waits
            // for something it can use
        }

    }

    private void showTimer() {
        if (timer != null) {
            timer.cancel();
        }

        if (indexTaskInSubProgress == 2)
            currentMsProgress = currentTask.getPauseProcess();
        else
            currentMsProgress = currentTask.getTimerProcess();

        cView = tasksListView.getChildAt(indexTaskInProgress + 1);
//        if (indexTaskInSubProgress == 1) {
//            progressTask = (ProgressBar) cView.findViewById(R.id.timer);
//           // textTimer = (TextView) cView.findViewById(R.id.textTimer);
//        }

        timer = new CountDownTimer(currentMsProgress * MILLIS_PER_SECOND, MILLIS_PER_SECOND) {
            @Override
            public void onTick(long millisUntilFinished) {
                iterationAll(millisUntilFinished / MILLIS_PER_SECOND);

                if (indexTaskInSubProgress == 1) {
                    cView.setBackgroundColor(Color.parseColor("#6CA6CD"));
                    progressTask = (ProgressBar) cView.findViewById(R.id.timer);
                    progressTask.incrementProgressBy(1);
                }
//                textTimer.setText(String.valueOf(progressTask.getProgress()));
            }

            @Override
            public void onFinish() {
                iterationAll(currentMsProgress+1);

                if (indexTaskInSubProgress == 2 && indexTaskInProgress == tasksList.size() - 1) {
                    countdownDisplay.setText("Finish!");
                    startButton.setText("Start");
                    cView.setBackgroundColor(Color.TRANSPARENT);
                } else if (indexTaskInSubProgress == 2) {
                    cView.setBackgroundColor(Color.TRANSPARENT);
                    currentTask.setPauseProcess(0);
                    currentTask = tasksList.get(++indexTaskInProgress);
                    indexTaskInSubProgress = 1;
                    showTimer();
                } else {
                    progressTask = (ProgressBar) cView.findViewById(R.id.timer);
                    progressTask.incrementProgressBy(1);

                    currentTask.setTimerProcess(0);

                    currentMsProgress = currentTask.getPauseProcess();
                    indexTaskInSubProgress = 2;
 //               Toast.makeText(WorkOutActivity.this, String.valueOf(progressTask.getProgress()), Toast.LENGTH_SHORT).show();
                    showTimer();
                }
            }

            private void iterationAll(long currentMs){
                currentMsProgress = currentMs;
                countdownDisplay.setText("№" + (indexTaskInProgress + 1) + ","
                        + ((indexTaskInSubProgress == 2) ? " pause: " : " process: ")+ currentMsProgress
                        +"/"+((indexTaskInSubProgress == 2) ? currentTask.getPause() : currentTask.getTimer()));
                progressBarProgram.incrementProgressBy(1);
            }


        }.start();

    }


    public void setTables(int idProgram) {
        getTableTasks(idProgram);
        getTableMessages(idProgram);
//        createTableLayout();
        View header;

        taskAdapter = new TaskAdapter(this, R.layout.layout_task_item_row, tasksList);
        tasksListView = (ListView) findViewById(R.id.tasksListView);
        header = (View) getLayoutInflater().inflate(R.layout.layout_task_header_row, null);
        tasksListView.addHeaderView(header);
        tasksListView.setAdapter(taskAdapter);

        messageAdapter = new MessageAdapter(this, R.layout.layout_message_item_row, messagesList);
        messagesListView = (ListView) findViewById(R.id.messagesListView);
        header = (View) getLayoutInflater().inflate(R.layout.layout_message_header_row, null);
        messagesListView.addHeaderView(header);
        messagesListView.setAdapter(messageAdapter);

        tasksListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(WorkOutActivity.this, "itemClick: position = " + position + ", id = "
                        + id, Toast.LENGTH_LONG).show();
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
        Random rnd = new Random();
//        tasksList.add(new Task("squat", "4", "10", "10", R.drawable.stopwatch, R.drawable.clock));
        tasksList.add(new Task("biesep", "4", "10", "10", rnd.nextInt(30), 5));
        tasksList.add(new Task("squat", "4", "10", "10", rnd.nextInt(30), 5));
        tasksList.add(new Task("squat", "4", "10", "10", rnd.nextInt(30), 5));
//        tasksList.add(new Task("squat", "4", "10", "10", rnd.nextInt(30),5));
//        tasksList.add(new Task("squat", "4", "10", "10", rnd.nextInt(30),5));
//        tasksList.add(new Task("squat", "4", "10", "10", rnd.nextInt(30),5));
//        tasksList.add(new Task("squat", "4", "10", "10", rnd.nextInt(30),5));
//        tasksList.add(new Task("squat", "4", "10", "10", rnd.nextInt(30),5));
//        tasksList.add(new Task("squat", "4", "10", "10", rnd.nextInt(30),5));
//        tasksList.add(new Task("squat", "4", "10", "10", rnd.nextInt(30),5));
//        tasksList.add(new Task("squat", "4", "10", "10", rnd.nextInt(30),5));
//        tasksList.add(new Task("squat", "4", "10", "10", rnd.nextInt(30),5));
//        tasksList.add(new Task("squat", "4", "10", "10", rnd.nextInt(30),5));
//        tasksList.add(new Task("squat", "4", "10", "10", rnd.nextInt(30),5));
    }

    public void getTableMessages(int idProgram) {
        messagesList = new ArrayList<>();
        messagesList.add(new Message(new Date(), "squatsadmnasdnsa,dsa"));
        messagesList.add(new Message(new Date(), "squatsadmnasdnsa,dsa"));
        messagesList.add(new Message(new Date(), "squatsadmnasdnsa,dsa"));
        messagesList.add(new Message(new Date(), "squatsadmnasdnsa,dsa"));
        messagesList.add(new Message(new Date(), "squatsadmnasdnsa,dsa"));
        messagesList.add(new Message(new Date(), "squatsadmnasdnsa,dsa"));
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

    private TableRow createTableRow(Task task) {
        TableRow tableRow = new TableRow(this);

//        tableRow.setBackgroundColor(0xffcccccc);
//        android:orientation="horizontal"
//        android:layout_width="fill_parent"
//        android:layout_height="fill_parent">

        tableRow.addView(createTextView(task.getName()));
        tableRow.addView(createTextView(task.getSet()));
        tableRow.addView(createTextView(task.getRepeat()));
        tableRow.addView(createTextView(task.getWeight()));
//        tableRow.addView(createTextView(task.getTimer()));
        return tableRow;
    }

    private TextView createTextView(String obj) {
        TextView textView = new TextView(this);
        textView.setText(obj);
//        textView.setGravity(View.gra.TEXT_ALIGNMENT_GRAVITY);
        textView.setTextSize(12);
        textView.setTextColor(Color.rgb(200, 0, 0));
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
        return textView;
    }


}
