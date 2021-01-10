package com.example.schoolapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.schoolapp.R;
import com.example.schoolapp.adapter.FragmentAdp;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondarySwitchDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.nio.file.attribute.AclEntry;

public class MainPage extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance("https://schooldb-5db58-default-rtdb.firebaseio.com/");
    DatabaseReference dbRef = database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        ViewPager vp = findViewById(R.id.vp);
        TabLayout tab = findViewById(R.id.tab);
        Toolbar toolbar = findViewById(R.id.toolbar);

       PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("Home").withIcon(R.drawable.ic_baseline_home_24);
       PrimaryDrawerItem item2 = new PrimaryDrawerItem().withIdentifier(2).withName("School Principal ").withIcon(R.drawable.ic_baseline_phone_24);
       PrimaryDrawerItem item3 = new PrimaryDrawerItem().withIdentifier(3).withName("School ِِِِAssistant Principal").withIcon(R.drawable.ic_baseline_phone_24);
       PrimaryDrawerItem item4 = new PrimaryDrawerItem().withIdentifier(4).withName("School Control ").withIcon(R.drawable.ic_baseline_phone_24);
       PrimaryDrawerItem item5 = new PrimaryDrawerItem().withIdentifier(5).withName("School library ").withIcon(R.drawable.ic_baseline_phone_24);
       PrimaryDrawerItem item6 = new PrimaryDrawerItem().withIdentifier(6).withName("School Clinic ").withIcon(R.drawable.ic_baseline_phone_24);
       PrimaryDrawerItem item7 = new PrimaryDrawerItem().withIdentifier(7).withName("Technical Support ").withIcon(R.drawable.ic_baseline_phone_24);


        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .addDrawerItems(item1, new DividerDrawerItem(), item2, item3, item4, item5, item6, item7)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        if (drawerItem.getIdentifier() == 2) {
                            Intent callIntent = new Intent(Intent.ACTION_DIAL);
                            callIntent.setData(Uri.parse("tel:"+1888333));
                            startActivity(callIntent);

                        } else if (drawerItem.getIdentifier() == 3) {
                            Intent callIntent = new Intent(Intent.ACTION_DIAL);
                            callIntent.setData(Uri.parse("tel:" + 1888666));
                            startActivity(callIntent);

                        } else if (drawerItem.getIdentifier() == 4) {
                            Intent callIntent = new Intent(Intent.ACTION_DIAL);
                            callIntent.setData(Uri.parse("tel:" + 1800800));
                            startActivity(callIntent);
                        } else if (drawerItem.getIdentifier() == 5) {
                            Intent callIntent = new Intent(Intent.ACTION_DIAL);
                            callIntent.setData(Uri.parse("tel:" + 1888000));
                            startActivity(callIntent);
                        } else if (drawerItem.getIdentifier() == 6) {
                            Intent callIntent = new Intent(Intent.ACTION_DIAL);
                            callIntent.setData(Uri.parse("tel:" + 1511111));
                            startActivity(callIntent);
                        } else if (drawerItem.getIdentifier() == 7) {
                            Intent callIntent = new Intent(Intent.ACTION_DIAL);
                            callIntent.setData(Uri.parse("tel:" + 1808777));
                            startActivity(callIntent);
                        }
                        return false;
                    }
                }).build();

        tab.setupWithViewPager(vp);


        FragmentAdp adapter = new FragmentAdp(getSupportFragmentManager());
        vp.setAdapter(adapter);

        tab.getTabAt(0).setIcon(R.drawable.ic_baseline_home_24);
        tab.getTabAt(1).setIcon(R.drawable.ic_baseline_class_24);
        tab.getTabAt(2).setIcon(R.drawable.ic_baseline_fiber_new_24);

    }


}