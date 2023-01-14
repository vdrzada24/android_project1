package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import io.realm.Realm;

public class SosNumber extends AppCompatActivity {
    LottieAnimationView lottieAnimationView;
    Button b1;
    EditText e1;
    ImageButton ib;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sos_number);
        lottieAnimationView=(LottieAnimationView) findViewById(R.id.register);
        b1=(Button) findViewById(R.id.button3);
        ib=(ImageButton)findViewById(R.id.back2);
        e1=(EditText) findViewById(R.id.edittext5);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=e1.getText().toString();
                if(s.isEmpty() || s=="null"){
                    e1.setError("number required");
                    return;
                }
                SmsManager smsManager=SmsManager.getDefault();
                smsManager.sendTextMessage(s,null,"emergency",null,null);
                Toast.makeText(SosNumber.this, "message sent", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(SosNumber.this,First.class);
                startActivity(i);
                finish();



            }





        });

        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(SosNumber.this,First.class);
                startActivity(j);
                finish();
            }
        });


    }
}