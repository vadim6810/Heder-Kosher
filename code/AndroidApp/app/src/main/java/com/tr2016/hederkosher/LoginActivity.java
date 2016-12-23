package com.tr2016.hederkosher;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
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
                    getResponce();
                }
            });
        }
    }

    private void getResponce() {
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
}
