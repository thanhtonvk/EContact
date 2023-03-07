package com.utehy.econtact.Activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.utehy.econtact.R;

public class CatDatActivity extends AppCompatActivity {
    Button btn_doi_mk,btn_dang_xuat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        setContentView(R.layout.activity_cat_dat);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.status_bar_color, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.status_bar_color));
        }
        back();


    }
    private void initView(){
        btn_doi_mk = findViewById(R.id.btn_doi_mk);
        btn_dang_xuat = findViewById(R.id.btn_dang_xuat);
    }
    private void onClick(){
        btn_doi_mk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),DoiMatKhauActivity.class));
            }
        });
        btn_dang_xuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),DangXuatActivity.class));
            }
        });
    }

    ImageButton btnTroVe;

    private void back() {
        btnTroVe = findViewById(R.id.btn_tro_ve);
        btnTroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}