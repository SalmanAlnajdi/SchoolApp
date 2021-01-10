package com.example.schoolapp.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.schoolapp.R;
import com.example.schoolapp.modal.News;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class NewsAdp extends RecyclerView.Adapter {

    FirebaseDatabase database = FirebaseDatabase.getInstance("https://schooldb-5db58-default-rtdb.firebaseio.com/");
    DatabaseReference dbRef = database.getReference();

    ArrayList<News> nArray;
    Context context;
    LinearLayout linearLayout;

    public NewsAdp(ArrayList<News> nArray, Context context, LinearLayout linearLayout) {
        this.nArray = nArray;
        this.context = context;
        this.linearLayout = linearLayout;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_list_item, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ((ViewHolder) holder).title.setText(nArray.get(position).getTitle());
        ((ViewHolder) holder).news.setText(nArray.get(position).getNews());


        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        final Query tot = dbRef.child("News").orderByChild("title").equalTo(nArray.get(position).getTitle());


        /*((ViewHolder) holder).tot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setTitle("Delete");
                builder.setMessage("Are you sure!!!");
                builder.setCancelable(false).setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        tot.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                for (DataSnapshot news : snapshot.getChildren()) {
                                    news.getRef().removeValue();
                                    notifyDataSetChanged();
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });


                        Snackbar.make(linearLayout, "NEWs has been deleted", Snackbar.LENGTH_LONG).setAction("Undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {


                                notifyDataSetChanged();
                            }
                        }).show();

                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, "Not Deleted", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

                //  Snackbar.make(((ViewHolder) holder).linearLayout,"news has been deleted",Snackbar.LENGTH_LONG).show();
            }
        });
*/

    }

    @Override
    public int getItemCount() {
        return nArray.size();
    }


    private class ViewHolder extends RecyclerView.ViewHolder {

        public View view;
        public TextView title;
        public TextView news;
        public ImageView tot;
        public LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;

            title = itemView.findViewById(R.id.title);
            news = itemView.findViewById(R.id.news);
           // tot = itemView.findViewById(R.id.delete);
            linearLayout = itemView.findViewById(R.id.linearlayout);
        }
    }
}
