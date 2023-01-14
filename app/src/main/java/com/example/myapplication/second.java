package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;

import io.realm.Realm;

public class second extends AppCompatActivity {
    EditText e1,e2;
    ImageButton ib,ib1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        e1=(EditText) findViewById(R.id.edittext1);
        e2=(EditText) findViewById(R.id.edittext2);
        ib=(ImageButton) findViewById(R.id.imagebutton);
        ib1=(ImageButton)findViewById(R.id.imagebutton3);

        Realm.init((getApplicationContext()));
        Realm realm=Realm.getDefaultInstance();

        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(second.this,MainActivity.class);
                startActivity(j);
                finish();
            }
        });

        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title=e1.getText().toString();
                String content=e2.getText().toString();
                if(title.isEmpty()|| title=="null"){
                    e1.setError("title not added");
                    return;
                }

                realm.beginTransaction();
                Note note= realm.createObject(Note.class);
                note.setContent(content);
                note.setTitle(title);
                realm.commitTransaction();
                Toast.makeText(second.this, "Wishes added", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(second.this,MainActivity.class);
                startActivity(i);
                finish();

            }
        });


    }

}