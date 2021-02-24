package com.emerat.sesootwebapp.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

import com.emerat.sesootwebapp.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash_page);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                MainActivity.start(SplashActivity.this);

                SplashActivity.this.finish();
            }
        },2000);
    }
}