package com.utehy.econtact.Activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.utehy.econtact.Adapter.HocKiAdapter;
import com.utehy.econtact.Models.NamHoc;
import com.utehy.econtact.R;

import java.util.ArrayList;
import java.util.List;

public class HocKiActivity extends AppCompatActivity {

    RecyclerView rcvNamHoc;
    List<NamHoc> namHocList;
    HocKiAdapter namHocAdapter;
    ImageButton btnTroVe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoc_ki);
        initView();
        loadNamHoc();
        back();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.status_bar_color, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.status_bar_color));
        }

    }

    private void initView() {
        namHocList = new ArrayList<>();
        namHocAdapter = new HocKiAdapter(namHocList, this);
        rcvNamHoc = findViewById(R.id.rcv_nam_hoc);
        rcvNamHoc.setAdapter(namHocAdapter);

    }

    private void back() {
        btnTroVe = findViewById(R.id.btn_tro_ve);
        btnTroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void loadNamHoc() {
        NamHoc namHoc= new NamHoc(NamHoc.NAM_HOC.getNamHoc(),"1");
        namHocList.add(namHoc);
        namHoc= new NamHoc(NamHoc.NAM_HOC.getNamHoc(),"2");
        namHocList.add(namHoc);
        namHocAdapter = new HocKiAdapter(namHocList, this);
        rcvNamHoc.setAdapter(namHocAdapter);
    }
}