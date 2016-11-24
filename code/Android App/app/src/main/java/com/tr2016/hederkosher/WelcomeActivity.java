package com.tr2016.hederkosher;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        String userFirstName = this.getResources().getResourceName(R.id.welcomeUser);
        String userFirstName = "Welcome ";
        TextView textWelcome = (TextView) findViewById(R.id.welcomeUser);
        try {
            userFirstName = userFirstName + getIntent().getExtras().getString("userFirstName");
        }catch (Exception e){
            try {
                userFirstName = userFirstName + getIntent().getExtras().getString("emailLogin");
            }catch (Exception r){
                userFirstName = userFirstName + "User";
            }
        }
        textWelcome.setText(userFirstName);


        Button buttonAbout = (Button) findViewById(R.id.action_about_yourself);
        if (buttonAbout!=null) {
            buttonAbout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    WelcomeActivity.this.startActivity(new Intent(WelcomeActivity.this, SettingsActivity.class));
                }
            });
        }

        Button buttonStarted = (Button) findViewById(R.id.action_started);
        if (buttonStarted!=null) {
            buttonStarted.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    WelcomeActivity.this.startActivity(new Intent(WelcomeActivity.this, StartActivity.class));
                }
            });
        }


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

}
