package com.example.giaodien;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class Trangchu extends AppCompatActivity {

    private RecyclerView rcv_tc;
    private DSchucnang_Adapter dSchucnang_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangchu);

        rcv_tc=findViewById(R.id.rcv_trangchu);
        dSchucnang_adapter= new DSchucnang_Adapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rcv_tc.setLayoutManager(linearLayoutManager);

        dSchucnang_adapter.setData();
    }
}