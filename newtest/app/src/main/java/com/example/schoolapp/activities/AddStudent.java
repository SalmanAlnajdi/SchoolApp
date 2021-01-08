package com.example.schoolapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.schoolapp.R;
import com.example.schoolapp.fragment.Fragment2;
import com.example.schoolapp.fragment.Fragment3;
import com.example.schoolapp.modal.News;
import com.example.schoolapp.modal.Student;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddStudent extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance("https://schooldb-5db58-default-rtdb.firebaseio.com/");
    DatabaseReference dbRef = (DatabaseReference) database.getReference().child("Section");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        EditText name = findViewById(R.id.studentName);
        EditText age = findViewById(R.id.studentAge);
        EditText note = findViewById(R.id.studentNote);
        CheckBox scase = findViewById(R.id.checkBox);
        Button addstudent = findViewById(R.id.addstudent);

        addstudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student s = new Student(name.getText().toString(),age.getText().toString(), scase.isChecked(),note.getText().toString());
                dbRef.child("Student").push().setValue(s);
                Intent i = new Intent(AddStudent.this, SectionD.class);
                startActivity(i);
            }
        });
    }
}