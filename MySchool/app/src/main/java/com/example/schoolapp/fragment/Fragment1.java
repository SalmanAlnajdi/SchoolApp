package com.example.schoolapp.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.schoolapp.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Fragment1 extends Fragment {

    FirebaseDatabase database = FirebaseDatabase.getInstance("https://schooldb-5db58-default-rtdb.firebaseio.com/");
    DatabaseReference dbRef = database.getReference();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);

        String url1 ="http://app.moe.edu.kw/TeacherInfo/";
        String url2 ="https://moe.edu.kw/teacher/Pages/Duties.aspx";
        String url3 ="https://moe.edu.kw/teacher/Pages/charter.aspx";
        String url4 ="https://eservices.moe.edu.kw/empt/";
        String url5 ="https://moe.edu.kw/teacher/teachers%20library/Vacations.pdf";
        String url6 ="http://www.q8sch.net/";

        Button urlme = view.findViewById(R.id.urlme);
        Button urlec = view.findViewById(R.id.urlec);
        Button urlrd = view.findViewById(R.id.urlrd);
        Button urltr = view.findViewById(R.id.urltr);
        Button urlvi = view.findViewById(R.id.urlvi);
        Button urlat = view.findViewById(R.id.urlat);

        urlat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url6));
                startActivity(i);
            }
        });

        urlvi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url5));
                startActivity(i);
            }
        });


        urltr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url4));
                startActivity(i);
            }
        });

        urlrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url3));
                startActivity(i);
            }
        });

        urlec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url2));
                startActivity(i);
            }
        });


        urlme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url1));
                startActivity(i);
            }
        });



        return view;
    }
}