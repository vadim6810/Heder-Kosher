package com.tr2016.hederkosher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        btn = (Button) findViewById(R.id.buttonStart);
        if (btn!=null) {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    StartActivity.this.startActivity(new Intent(StartActivity.this, WorkActivity.class));

                }
            });
        }
        btn = (Button) findViewById(R.id.buttonAbout);
        if (btn!=null) {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    StartActivity.this.startActivity(new Intent(StartActivity.this, AboutActivity.class));

                }
            });
        }


    }
}
