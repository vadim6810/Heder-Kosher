package com.tr2016.hederkosher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ShareNBurnActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_nburn);
    }

    public void openWorkoutActivity(View view) {
        startActivity(new Intent(ShareNBurnActivity.this, WorkOutActivity.class));
    }

    public void openCoachActivity(View view) {
        startActivity(new Intent(ShareNBurnActivity.this, CoachActivity.class));
    }
}
