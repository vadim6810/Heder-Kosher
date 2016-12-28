package com.tr2016.hederkosher;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tr2016.hederkosher.utils.Connection;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btn = (Button) findViewById(R.id.buttonSignIn);
        if (btn != null) {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getResponse();
                }
            });
        }
    }

    private void getResponse() {
        Map<String, Object> parametersBody = new HashMap<>();
        Map<String, Object> parametersHeader = new HashMap<>();
        Map<String, Object> mapRes = new Connection().request("http://10.0.2.2:8080/persons", parametersBody, parametersHeader);
//        if (mapRes == null)
//            return;
//        else if (!(Boolean) mapRes.get("requestStatus")) {
//            Toast.makeText(LoginActivity.this, (String) mapRes.get("requestMessage"), Toast.LENGTH_LONG).show();
//        } else {
//            Toast.makeText(LoginActivity.this, (String) mapRes.get("responceString"), Toast.LENGTH_LONG).show();
        LoginActivity.this.startActivity(new Intent(LoginActivity.this, StartActivity.class));
//        }
    }

    public void openRegisterActivity(View view) {
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
    }

    public void forgotPassword(View view) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        final EditText input = new EditText(this);
        final TextView tv = new TextView(this);

        tv.setTextSize(20);
        tv.setText("Enter your email:");

        alert.setCustomTitle(tv);
        alert.setView(input);
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String value = input.getText().toString().trim();
                Toast.makeText(getApplicationContext(), value,
                        Toast.LENGTH_SHORT).show();
            }
        });

        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                dialog.cancel();
            }
        });
        alert.show();
    }
}
