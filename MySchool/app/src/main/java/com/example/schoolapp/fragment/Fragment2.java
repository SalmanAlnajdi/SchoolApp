package com.example.schoolapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.schoolapp.R;
import com.example.schoolapp.activities.MainPage;
import com.example.schoolapp.adapter.FristAdp;
import com.example.schoolapp.modal.ChildItem;
import com.example.schoolapp.modal.ParentItem;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;


public class Fragment2 extends Fragment {

    FirebaseDatabase database = FirebaseDatabase.getInstance("https://schooldb-5db58-default-rtdb.firebaseio.com/");
    DatabaseReference dbRef = database.getReference();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);


       // ArrayList<Section> sectionList = new ArrayList<>();



        RecyclerView ParentRecyclerViewItem = (RecyclerView) view.findViewById(R.id.rv_section);
        LinearLayoutManager layoutManager = new LinearLayoutManager((MainPage)getActivity());
        FristAdp parentItemAdapter = new FristAdp(ParentItemList());
        ParentRecyclerViewItem.setAdapter(parentItemAdapter);
        ParentRecyclerViewItem.setLayoutManager(layoutManager);



    return view;
    }

    private List<ParentItem> ParentItemList()
    {
        List<ParentItem> itemList = new ArrayList<>();

        ParentItem item = new ParentItem("10th Grade - Sectoin 1", ChildItemList());
        itemList.add(item);
        ParentItem item1 = new ParentItem("10th Grade - Sectoin 2", ChildItemList());
        itemList.add(item1);
        ParentItem item2 = new ParentItem("10th Grade - Sectoin 3", ChildItemList());
        itemList.add(item2);
        ParentItem item3 = new ParentItem("11th Grade - Section 1", ChildItemList());
        itemList.add(item3);
        ParentItem item4 = new ParentItem("11th Grade - Section 2", ChildItemList());
        itemList.add(item4);
        ParentItem item5 = new ParentItem("12th Grade - Section 1", ChildItemList());
        itemList.add(item5);
        ParentItem item6 = new ParentItem("12th Grade - Section 2", ChildItemList());
        itemList.add(item6);

        return itemList;
    }

    // Method to pass the arguments
    // for the elements
    // of child RecyclerView
    private List<ChildItem> ChildItemList()
    {
        List<ChildItem> ChildItemList = new ArrayList<>();

        ChildItemList.add(new ChildItem("Student 1"));
        ChildItemList.add(new ChildItem("Student 2"));
        ChildItemList.add(new ChildItem("Student 3"));
        ChildItemList.add(new ChildItem("Student 4"));
        ChildItemList.add(new ChildItem("Student 5"));
        ChildItemList.add(new ChildItem("Student 6"));
        ChildItemList.add(new ChildItem("Student 7"));
        ChildItemList.add(new ChildItem("Student 8"));

        return ChildItemList;
    }
}

