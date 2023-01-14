package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class First extends AppCompatActivity {
    Button b1,b2,b3;
    LottieAnimationView lottieAnimationView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        b1=(Button) findViewById(R.id.button1);
        b2=(Button) findViewById(R.id.button4);
        b3=(Button)findViewById(R.id.button5);
        lottieAnimationView=(LottieAnimationView) findViewById(R.id.lottie);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(First.this,Page_1.class);
                startActivity(i);
                finish();
            }



        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(First.this,SosNumber.class);
                startActivity(j);
                finish();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k=new Intent(First.this,Bill.class);
                startActivity(k);
                finish();
            }
        });


    }



}