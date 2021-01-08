package com.example.schoolapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.schoolapp.R;
import com.example.schoolapp.adapter.NewsAdp;
import com.example.schoolapp.adapter.StudentAdp;
import com.example.schoolapp.modal.News;
import com.example.schoolapp.modal.Student;

import java.util.ArrayList;

public class SectionD extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_d);

        ImageView addstd = findViewById(R.id.addstd);
        ArrayList<Student> studentList = new ArrayList<>();

        RecyclerView studentL = findViewById(R.id.rv_news);
        LinearLayout linearLayout = findViewById(R.id.layout1);

        studentL.setHasFixedSize(true);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(SectionD.this);
        studentL.setLayoutManager(lm);

        StudentAdp sd = new StudentAdp(studentList,SectionD.this, linearLayout);
        studentL.setAdapter(sd);
        addstd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s = new Intent(SectionD.this,AddStudent.class);
                startActivity(s);
            }
        });
    }
}