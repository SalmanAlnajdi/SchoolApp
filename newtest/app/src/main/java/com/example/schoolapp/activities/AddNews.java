package com.example.schoolapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.schoolapp.R;
import com.example.schoolapp.fragment.Fragment3;
import com.example.schoolapp.modal.News;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddNews extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance("https://schooldb-5db58-default-rtdb.firebaseio.com/");
    DatabaseReference dbRef = database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_news);

        EditText title = findViewById(R.id.newstitle);
        EditText news = findViewById(R.id.ednews);
        Button addnews = findViewById(R.id.addnews);

        addnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                News n = new News(title.getText().toString(),news.getText().toString());
                dbRef.child("News").push().setValue(n);
                Intent i = new Intent(AddNews.this, Fragment3.class);
                startActivity(i);
            }
        });


    }
}