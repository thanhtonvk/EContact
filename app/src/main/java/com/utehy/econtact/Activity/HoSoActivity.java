package com.utehy.econtact.Activity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.utehy.econtact.R;
import com.utehy.econtact.Tools.Common;

import java.util.Map;

public class HoSoActivity extends AppCompatActivity {
    ImageButton btn_back;
    ImageView avatar;
    TextView tv_hoso_hoten, tv_hoso_lop, tv_hoso_masinhvien, tv_hoso_gvcn, tv_hoso_chuyen_nganh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoso_sinhvien);
        anhxa();
        onClick();
        loadData();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.status_bar_color, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.status_bar_color));
        }
    }

    private void anhxa() {
        btn_back = findViewById(R.id.btn_tro_ve);
        avatar = findViewById(R.id.img_avatar);
        tv_hoso_hoten = findViewById(R.id.tv_ho_ten);
        tv_hoso_lop = findViewById(R.id.tv_lop);
        tv_hoso_masinhvien = findViewById(R.id.tv_ma_sv);
        tv_hoso_gvcn = findViewById(R.id.tv_gvcn);
        tv_hoso_chuyen_nganh = findViewById(R.id.tv_chuyen_nganh);

    }

    private void onClick() {
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void loadData() {
        Log.e("TAG", "loadData: " + Common.LOGIN_USER.get("facility"));
        Map<String, String> facility = new Gson().fromJson(Common.LOGIN_USER.get("facility").toString(), Map.class);
        tv_hoso_chuyen_nganh.setText(facility.get("facility_name_l").toString());
        tv_hoso_masinhvien.setText(Common.STUDENT_BY_FAMILY.get("student_rcd"));
        tv_hoso_gvcn.setText(Common.STUDENT_BY_FAMILY.get("form_teacher"));
        tv_hoso_lop.setText(Common.STUDENT_BY_FAMILY.get("class_id"));
        tv_hoso_hoten.setText(Common.STUDENT_BY_FAMILY.get("student_name"));
    }
}
