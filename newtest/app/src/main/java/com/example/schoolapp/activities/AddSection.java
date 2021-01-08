
package com.example.schoolapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.schoolapp.R;
import com.example.schoolapp.fragment.Fragment2;
import com.example.schoolapp.fragment.Fragment3;
import com.example.schoolapp.modal.News;
import com.example.schoolapp.modal.Section;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddSection extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance("https://schooldb-5db58-default-rtdb.firebaseio.com/");
    DatabaseReference dbRef = database.getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_section);

        EditText section = findViewById(R.id.edsection);
        Button addsec = findViewById(R.id.addsec);

        addsec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Section se = new Section(dbRef.getKey(),section.getText().toString());
                dbRef.child("Section").push().setValue(se);
                Intent i = new Intent(AddSection.this, Fragment2.class);
                startActivity(i);
            }

    });
}
}