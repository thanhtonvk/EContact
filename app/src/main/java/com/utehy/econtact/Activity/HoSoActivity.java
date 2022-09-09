package com.utehy.econtact.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.utehy.econtact.R;

public class HoSoActivity extends AppCompatActivity {
    ImageButton img_trolai;
    ImageView anhhoso;
    TextView tv_hoso_hoten,tv_hoso_ngaysinh, tv_hoso_diachi,tv_hoso_lop, tv_hoso_masinhvien, tv_hoso_gvcn,tv_hoso_gioitinh,tv_hoso_hanhkiem,tv_hoso_hocluc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoso_sinhvien);
        anhxa();

    }
    private void anhxa(){
        img_trolai = findViewById(R.id.img_trolai);
        anhhoso = findViewById(R.id.anhhoso);
        tv_hoso_hoten = findViewById(R.id.tv_hoso_hoten);
        tv_hoso_ngaysinh = findViewById(R.id.tv_hoso_ngaysinh);
        tv_hoso_diachi = findViewById(R.id.tv_hoso_diachi);
        tv_hoso_lop = findViewById(R.id.tv_hoso_lop);
        tv_hoso_masinhvien = findViewById(R.id.tv_hoso_masinhvien);
        tv_hoso_gvcn = findViewById(R.id.tv_hoso_gvcn);
        tv_hoso_gioitinh = findViewById(R.id.tv_hoso_gioitinh);
        tv_hoso_hanhkiem = findViewById(R.id.tv_hoso_hanhkiem);
        tv_hoso_hocluc = findViewById(R.id.tv_hoso_hocluc);
    }
    private void setClick(){
        tv_hoso_hoten.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {


            }
        });
    }
}
