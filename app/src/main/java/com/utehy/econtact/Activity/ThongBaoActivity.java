package com.utehy.econtact.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.utehy.econtact.Adapter.ThongbaoAdapter;
import com.utehy.econtact.Models.Thongbao;
import com.utehy.econtact.R;

import java.util.ArrayList;
import java.util.List;

public class ThongBaoActivity extends AppCompatActivity {

    private RecyclerView rcv_it_thongbao;
    private ThongbaoAdapter thongbaoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongbao);

        rcv_it_thongbao = findViewById(R.id.rcv_thongbao);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcv_it_thongbao.setLayoutManager(linearLayoutManager);

        // thongbaoAdapter = new ThongbaoAdapter(getListThongbao());
//        rcv_it_thongbao.setAdapter(thongbaoAdapter);
    }

    private List<Thongbao> getListThongbao() {
        List<Thongbao> list = new ArrayList<>();
        list.add(new Thongbao(R.drawable.anh_ic_logo_khoa_cntt, "thông báo 1", "con bạn học ngu vl"));
        list.add(new Thongbao(R.drawable.anh_ic_logo_khoa_cntt, "thông báo 2", "con bạn học ngu vl"));
        list.add(new Thongbao(R.drawable.anh_ic_logo_khoa_cntt, "thông báo 3", "con bạn học ngu vl"));

        return list;
    }
}
