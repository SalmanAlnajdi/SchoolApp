package com.example.schoolapp.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.schoolapp.R;
import com.example.schoolapp.activities.AddNews;
import com.example.schoolapp.activities.MainPage;
import com.example.schoolapp.adapter.SectionAdp;
import com.example.schoolapp.modal.News;
import com.example.schoolapp.adapter.NewsAdp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.security.cert.PolicyNode;
import java.util.ArrayList;


public class Fragment3 extends Fragment {

    FirebaseDatabase database = FirebaseDatabase.getInstance("https://schooldb-5db58-default-rtdb.firebaseio.com/");
    DatabaseReference dbRef = database.getReference();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_3, container, false);




        ImageView add = view.findViewById(R.id.addnews);

        ArrayList<News> newsList = new ArrayList<>();


       /* News n1 = new News("fire","blaaa blaaa blaa");
        News n2 = new News("fire","blaaa blaaa blaa");
        News n3 = new News("fire","blaaa blaaa blaa");

        newsList.add(n1);
        newsList.add(n2);
        newsList.add(n3);*/


        RecyclerView newsL = (RecyclerView) view.findViewById(R.id.rv_news);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linearlayout);

        newsL.setHasFixedSize(true);                            //
        RecyclerView.LayoutManager lm = new LinearLayoutManager((MainPage) getActivity());
        newsL.setLayoutManager(lm);

        NewsAdp na = new NewsAdp(newsList, (MainPage) getActivity(), linearLayout);
        newsL.setAdapter(na);

        Query allNews = dbRef.child("News");
        allNews.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                newsList.clear();
                for(DataSnapshot news : snapshot.getChildren()){
                    News n = news.getValue(News.class);
                    newsList.add(n);

                }na.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(),error.getMessage(), Toast.LENGTH_SHORT).show();;
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(getActivity(), AddNews.class);
                startActivity(a);
            }
        });





        return view;
        }

    }
