package com.tr2016.hederkosher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WorkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);
    }

    public void onMyWorkoutClick(View view) {
        Intent intent = new Intent(WorkActivity.this, ShareNBurnActivity.class);
        startActivity(intent);
    }
}
