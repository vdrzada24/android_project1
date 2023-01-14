package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class Bill extends AppCompatActivity {
    TextView t1,t2,t3,t4;
    EditText e1,e2;
    Button b1;
    LottieAnimationView lottieAnimationView;
    ImageButton ib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
        t1=(TextView) findViewById(R.id.textview5);
        t2=(TextView) findViewById(R.id.textview6);
        t3=(TextView) findViewById(R.id.textview7);
        t4=(TextView) findViewById(R.id.textview8);
        e1=(EditText)findViewById(R.id.edittext4);
        e2=(EditText)findViewById(R.id.edittext5);
        b1=(Button)findViewById(R.id.button6);
        ib=(ImageButton)findViewById(R.id.back);
        lottieAnimationView=(LottieAnimationView)findViewById(R.id.lottie3);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                Integer i1=Integer.parseInt(s1);
                Integer i2=Integer.parseInt(s2);
                Integer i3=i1/i2;
                String s3=Integer.toString(i3);
                t4.setText(s3);

            }
        });
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Bill.this,First.class);
                startActivity(i);
                finish();
            }
        });

    }
}