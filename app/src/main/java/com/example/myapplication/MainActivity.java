package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.Query;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton b1;
    RecyclerView recyclerView;
    ImageButton ib,ib1;
    Noteadap noteadap;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (FloatingActionButton) findViewById(R.id.add);
        recyclerView = findViewById(R.id.recylerview);
        ib = (ImageButton) findViewById(R.id.imagebutton2);
        ib1=(ImageButton)findViewById(R.id.imagebutton4);

        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(MainActivity.this,First.class);
                startActivity(j);
                finish();
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, second.class);
                startActivity(i);
                finish();
            }
        });

        Realm.init(getApplicationContext());
        Realm realm=Realm.getDefaultInstance();

        RealmResults<Note> notelist=realm.where(Note.class).findAll();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Noteadap adapter=new Noteadap(getApplicationContext(),notelist);
        recyclerView.setAdapter(adapter);

        notelist.addChangeListener(new RealmChangeListener<RealmResults<Note>>() {
            @Override
            public void onChange(RealmResults<Note> notes) {
                adapter.notifyDataSetChanged();

            }
        });


    }


}