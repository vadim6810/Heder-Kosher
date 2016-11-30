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

public class AboutActivity extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        btn = (Button) findViewById(R.id.buttonAbout);
        if (btn != null) {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getResponce();
                }
            });
        }
    }
    private void getResponce(){
        Map<String,Object> parametersBody = new HashMap<>();
        Map<String,Object> parametersHeader = new HashMap<>();

//        parametersHeader.put("Content-Type","application/json");
//        parametersHeader.put("method","POST");
//
//        parametersBody.put("fistName",((EditText) findViewById(R.id.editTextFirstName)).getText());
//        parametersBody.put("secondName",((EditText) findViewById(R.id.editTextSecondName)).getText());
//        parametersBody.put("lastName",((EditText) findViewById(R.id.editTextLastName)).getText());
//
//        parametersBody.put("passportNo","passportNo");
//        parametersBody.put("birthday","1990-03-28");
//        parametersBody.put("sex", "true");
//        parametersBody.put("height",170.2);
//        parametersBody.put("weight",65.5);



        Map<String,Object> mapRes = new Connection().request("http://10.0.2.2:8080/rooms",parametersBody,parametersHeader);

        if (mapRes==null) return;
        else if (!(Boolean) mapRes.get("requestStatus")){
            Toast.makeText(AboutActivity.this,(String) mapRes.get("requestMessage"),Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(AboutActivity.this, (String) mapRes.get("responceString"), Toast.LENGTH_LONG).show();
            AboutActivity.this.startActivity(new Intent(AboutActivity.this, WorkActivity.class));
        }

    }
}
