package com.example.schoolapp.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.schoolapp.R;
import com.example.schoolapp.activities.SectionD;
import com.example.schoolapp.fragment.Fragment2;
import com.example.schoolapp.modal.Section;
import com.example.schoolapp.modal.Student;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static com.google.android.material.internal.ContextUtils.getActivity;

public class SectionAdp extends RecyclerView.Adapter {
    FirebaseDatabase database = FirebaseDatabase.getInstance("https://schooldb-5db58-default-rtdb.firebaseio.com/");
    DatabaseReference dbRef = database.getReference();

    ArrayList<Section> sArray;
    Context context;
    LinearLayout linearLayout;

    public SectionAdp(ArrayList<Section> sArray, Context context, LinearLayout linearLayout) {
        this.sArray = sArray;
        this.context = context;
        this.linearLayout = linearLayout;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.section_list, parent, false);
        SectionAdp.ViewHolder vh = new SectionAdp.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


        ((ViewHolder)holder).name.setText(sArray.get(position).getName());
        ((ViewHolder)holder).view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, SectionD.class);
                context.startActivity(i);
            }
        });
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        //final Query deletsec = dbRef.child("Section").orderByChild("id").equalTo(sArray.get(position).getId());





    }

    @Override
    public int getItemCount() {
        return sArray.size();
    }


    private class ViewHolder extends RecyclerView.ViewHolder {

        public View view;
        public TextView name;
        public LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            name = itemView.findViewById(R.id.secName);
            linearLayout = itemView.findViewById(R.id.layout2);
        }
    }
}
