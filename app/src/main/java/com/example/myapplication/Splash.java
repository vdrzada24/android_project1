package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.airbnb.lottie.LottieAnimationView;

public class Splash extends AppCompatActivity {
    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        lottieAnimationView=(LottieAnimationView) findViewById(R.id.lottie4);

        lottieAnimationView.animate().translationX(2000).setDuration(2000).setStartDelay(1500);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(Splash.this,First.class);
                startActivity(i);
                finish();

            }
        },3000);
    }
}