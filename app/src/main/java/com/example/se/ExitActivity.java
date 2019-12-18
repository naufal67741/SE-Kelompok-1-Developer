package com.example.se;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ExitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exit);

        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
                System.exit(0);
            }
        },2000);
    }
}
