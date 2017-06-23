package com.miramicodigo.pokekotlin;

import android.app.Activity;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.miramicodigo.pokekotlin.adapter.MyAdapter;
import com.miramicodigo.pokekotlin.model.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Pokemon> list;
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activity = this;
        recyclerView= (RecyclerView) findViewById(R.id.rvPokeKotlin);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);

        populateList();

        adapter = new MyAdapter(activity, list);
        recyclerView.setAdapter(adapter);
    }

    public void populateList() {
        list = new ArrayList<Pokemon>();
        Resources resources = getResources();
        String[] arrayName = resources.getStringArray(R.array.name);
        String[] arrayCP = resources.getStringArray(R.array.cp);
        TypedArray arrayImgs = resources.obtainTypedArray(R.array.photo);
        for(int i=0; i < arrayName.length; i++) {
            Pokemon poke = new Pokemon(
                    arrayName[i],
                    Integer.parseInt(arrayCP[i]),
                    arrayImgs.getResourceId(i, -1)
            );
            list.add(poke);
        }
    }
}
