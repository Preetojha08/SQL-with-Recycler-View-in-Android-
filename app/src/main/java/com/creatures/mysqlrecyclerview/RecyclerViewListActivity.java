package com.creatures.mysqlrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerViewListActivity extends AppCompatActivity {

    RecyclerView recyclerView_e_details;
    ArrayList<model_new> data_holder;
    boolean flag=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_list);

        recyclerView_e_details=(RecyclerView)findViewById(R.id.recycler_view_event_details);
        recyclerView_e_details.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        Cursor rv_cursor = new DatabaseManager(this).readalldata();
       data_holder = new ArrayList<>();

        while(rv_cursor.moveToNext())
        {
            model_new obj=new model_new(rv_cursor.getString(1),rv_cursor.getString(2));
            data_holder.add(obj);
        }

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(data_holder);
        recyclerView_e_details.setAdapter(recyclerViewAdapter);


    }

}