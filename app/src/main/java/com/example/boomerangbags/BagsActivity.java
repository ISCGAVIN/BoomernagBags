package com.example.boomerangbags;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class BagsActivity extends AppCompatActivity {

    String strA[], strB[];
    int pictures[] = {R.drawable.bag1,R.drawable.bag2, R.drawable.bag3, R.drawable.bag3,
    R.drawable.bag4, R.drawable.bag5, R.drawable.bag6, R.drawable.bag7, R.drawable.bag8,
    R.drawable.bag9, R.drawable.bag10};
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bags);

        recyclerView = findViewById(R.id.BagView);

        strA = getResources().getStringArray(R.array.BagID);
        strB = getResources().getStringArray(R.array.description);

        BagAdapter bagAdapter = new BagAdapter(this, strA, strB,pictures);
        recyclerView.setAdapter(bagAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager((this)));
    }
}