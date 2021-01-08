package com.example.schoolapp.fragment;

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
import com.example.schoolapp.activities.AddSection;
import com.example.schoolapp.activities.MainPage;
import com.example.schoolapp.activities.SectionD;
import com.example.schoolapp.adapter.SectionAdp;
import com.example.schoolapp.modal.Section;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import javax.xml.namespace.QName;


public class Fragment2 extends Fragment {

    FirebaseDatabase database = FirebaseDatabase.getInstance("https://schooldb-5db58-default-rtdb.firebaseio.com/");
    DatabaseReference dbRef = database.getReference();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);

        ImageView addsection = view.findViewById(R.id.addsection);
        ImageView gotostudent = view.findViewById(R.id.gotostudent);
        ArrayList<Section> sectionList = new ArrayList<>();

        RecyclerView sectionL = (RecyclerView) view.findViewById(R.id.rv_section);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.layout2);

        sectionL.setHasFixedSize(true);
        RecyclerView.LayoutManager lm = new LinearLayoutManager((MainPage) getActivity());
        sectionL.setLayoutManager(lm);

        SectionAdp sa = new SectionAdp(sectionList, (MainPage) getActivity(), linearLayout);
        sectionL.setAdapter(sa);

        Query allSections = dbRef.child("Section").orderByValue();
        allSections.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                sectionList.clear();
                for(DataSnapshot section : snapshot.getChildren()){
                    Section n = section.getValue(Section.class);
                    sectionList.add(n);

                }sa.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(),error.getMessage(), Toast.LENGTH_SHORT).show();;
            }
        });

        addsection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(getActivity(), AddSection.class);
                startActivity(a);
            }
        });

        /*gotostudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), SectionD.class);
                startActivity(i);
            }
        });

         */



    return view;
    }

}

