package com.tr2016.hederkosher;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.tr2016.hederkosher.exceptions.LocalizedException;
import com.tr2016.hederkosher.utils.Connection;
import com.tr2016.hederkosher.utils.ImageUtil;

import java.util.HashMap;
import java.util.Map;

public class RegistrationActivity extends AppCompatActivity {
    private ImageView mImageView;
    protected ImageUtil imageUtil;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        btn = (Button) findViewById(R.id.buttonRegistration);
        if (btn!=null) {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getResponce();
                }
            });
        }

        mImageView = (ImageView) findViewById(R.id.imageUserMini);
        if (mImageView!=null) {
            mImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loadImage();
                }
            });
        }

    }

//    private void imageUserSizeMaxi(){
//        Toast.makeText(RegistrationActivity.this,"MAXI",Toast.LENGTH_LONG).show();
//    }

    private void getResponce(){
        Map<String,Object> parametersBody = new HashMap<>();
        Map<String,Object> parametersHeader = new HashMap<>();

        parametersHeader.put("Content-Type","application/json");
        parametersHeader.put("method","POST");

        parametersBody.put("fistName",((EditText) findViewById(R.id.editTextFirstName)).getText());
        parametersBody.put("secondName",((EditText) findViewById(R.id.editTextSecondName)).getText());
        parametersBody.put("lastName",((EditText) findViewById(R.id.editTextLastName)).getText());

        parametersBody.put("passportNo","passportNo");
        parametersBody.put("birthday","1990-03-28");
        parametersBody.put("sex", "true");
        parametersBody.put("height",170.2);
        parametersBody.put("weight",65.5);

//        BIRTHDAY, FIRST_NAME, gym_ID, HEIGHT, LAST_NAME, PASSPORT_NO, SECOND_NAME, SEX, WEIGHT


        Map<String,Object> mapRes = new Connection().request("http://10.0.2.2:8080/persons",parametersBody,parametersHeader);
//        Toast.makeText(LoginActivity.this,(String) mapRes.get("responceString"),Toast.LENGTH_LONG).show();
//            "passportNo": "passp",
//                "birthday": "1990-03-28",
//                "sex": "true",
//                "height": 180.5,
//                "weight": 50.7

        if (mapRes==null) return;
        else if (!(Boolean) mapRes.get("requestStatus")){
            Toast.makeText(RegistrationActivity.this,(String) mapRes.get("requestMessage"),Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(RegistrationActivity.this, (String) mapRes.get("responceString"), Toast.LENGTH_LONG).show();
            RegistrationActivity.this.startActivity(new Intent(RegistrationActivity.this, StartActivity.class));
        }

    }

    private void loadImage() {
        try {
            imageUtil = new ImageUtil( getApplicationContext() );
            imageUtil.checkIsContentExists();
            imageUtil.getImageBitmap();//.selectRandomImage();

            setUpUI();
            setContent();

        } catch (LocalizedException e) {

            Toast.makeText( getApplicationContext(),
                    e.getString( getApplicationContext() ),
                    Toast.LENGTH_LONG)
                    .show();
        }
    }
    protected void setUpUI() {
        setContentView(R.layout.image_user_mini);

        mImageView = (ImageView) findViewById(R.id.imageView1);
    }

    protected void setContent() {
        // How-to initialize image view content, 3 ways
        // https://developer.android.com/reference/android/widget/ImageView.html
        // 1. from drawable
        // 2. from bitmap
        // 3. from specified Uri

//        mImageView.setImageResource(R.drawable.image_user_mini);
//
//// Fill image from picture stored on SD card
//        mImageView.setImageBitmap( imageUtil.getImageBitmap() );
        mImageView.setImageURI( imageUtil.getImageURI() );
    }




}
