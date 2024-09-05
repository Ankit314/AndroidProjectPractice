package com.example.recyclerview;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;


    ArrayList courseImg = new ArrayList<>(Arrays.asList(R.drawable.data_structure, R.drawable.c_plus_plus,
            R.drawable.c_hash, R.drawable.java_script,
            R.drawable.java, R.drawable.c,
            R.drawable.html, R.drawable.css,R.drawable.newcartoon,R.drawable.newcat,R.drawable.newdoll,R.drawable.muldoll,R.drawable.spider,R.drawable.dualdoll));
    ArrayList courseName = new ArrayList<>(Arrays.asList("Call", "Facebook", "Instagram", "Message", "Twiter",
            "Location", "Whatsapp", "YouTube","Cartoon","Cat","Doll","Multiple Doll","SpiderMan","Dual Doll"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);


        Adapter adapter = new Adapter(MainActivity.this, courseImg, courseName);


        recyclerView.setAdapter(adapter);
    }
}
