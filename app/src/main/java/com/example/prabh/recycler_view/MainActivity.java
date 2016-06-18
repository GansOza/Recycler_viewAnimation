package com.example.prabh.recycler_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MyCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        adapter = new MyCustomAdapter(this, Data.getData());
        recyclerView.setAdapter(adapter); // ----link recy view and adapter----//
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // apperence//
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id)
        {
            case R.id.linearViewHorizontal:
                LinearLayoutManager LLM = new LinearLayoutManager(this);
                LLM.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerView.setLayoutManager(LLM);
                break;

            case R.id.gridView:
                GridLayoutManager GLM = new GridLayoutManager(this,2);
                recyclerView.setLayoutManager(GLM);
                break;

            case R.id.staggeredViewHorizontal:
                StaggeredGridLayoutManager SVH = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL);//(int spancount,int orienttion)
                recyclerView.setLayoutManager(SVH);
                break;

            case R.id.staggeredViewVertical:
                StaggeredGridLayoutManager SVV = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(SVV);
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}
