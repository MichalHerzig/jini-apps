package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    NumbersAdapter adapter;

    List<Num> numbersList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));

        NumbersViewModel model = ViewModelProviders.of(this).get(NumbersViewModel.class);

        model.getNumbers().observe(this, new Observer<ArrayList<Num>>() {
            @Override
            public void onChanged(@Nullable ArrayList<Num> numList) {
                adapter = new NumbersAdapter(MainActivity.this, numList);
                recyclerView.setAdapter(adapter);
            }
        });
    }
}