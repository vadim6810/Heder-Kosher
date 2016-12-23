package com.tr2016.hederkosher.utils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tr2016.hederkosher.R;

public class SignInActivity extends AppCompatActivity {
//    private Connection connection = new Connection();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_sign_in);
//        getToken();
    }


//    public String getToken(){
//        FirebaseUser mUser = FirebaseAuth.getInstance().getCurrentUser();
//        mUser.getToken(true)
//                .addOnCompleteListener(new OnCompleteListener<GetTokenResult>() {
//                    public void onComplete(@NonNull Task<GetTokenResult> task) {
//                        if (task.isSuccessful()) {
//                            String idToken = task.getResult().getToken();
//                            // Send token to your backend via HTTPS
//                            // ...
//                        } else {
//                            // Handle error -> task.getException();
//                        }
//                    }
//                });
//    }

}
