package com.tr2016.hederkosher;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.buttonRegistration);
        if (btn!=null) {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   MainActivity.this.startActivity(new Intent(MainActivity.this, RegisterActivity.class));

                }
            });
        }
        btn = (Button) findViewById(R.id.buttonLogin);
        if (btn!=null) {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MainActivity.this.startActivity(new Intent(MainActivity.this, LoginActivity.class));

                }
            });
        }

        btn = (Button) findViewById(R.id.buttonTest);
        if (btn!=null) {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MainActivity.this.startActivity(new Intent(MainActivity.this, WorkOutActivity.class));
                }
            });
        }
    }
}
