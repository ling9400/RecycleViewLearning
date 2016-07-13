package com.example.swk_4.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<String> datas;
    private MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        recyclerView = (RecyclerView) super.findViewById(R.id.id_recyclerview);
//        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
//        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 4));
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.HORIZONTAL));
        recyclerView.setAdapter(new MyAdapter());
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
    }

    private void initData() {
        datas = new ArrayList<>();
        for (int i = 'A'; i < 'z'; i++)
        {
            datas.add("" + (char) i);
        }
    }


    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(MainActivity.this).inflate(R.layout.item_home
            ,viewGroup,false));
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            viewHolder.textView.setText(datas.get(i));
        }


        @Override
        public int getItemCount() {
            return datas.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder{
            TextView textView;

            public ViewHolder(View view){
                super(view);
                textView = (TextView)view.findViewById(R.id.id_num);
            }
        }
    }
}
