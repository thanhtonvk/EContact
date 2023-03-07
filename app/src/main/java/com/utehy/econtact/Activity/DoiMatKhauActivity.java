package com.utehy.econtact.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.utehy.econtact.R;

public class DoiMatKhauActivity extends AppCompatActivity {
    EditText edt_mat_khau_cu, edt_nhap_mat_khau_moi,edt_nhap_lai_mat_khau;
    Button btn_xac_nhan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doi_mat_khau);

        initView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.status_bar_color, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.status_bar_color));
        }

    }

    private void initView() {
        edt_mat_khau_cu = findViewById(R.id.edt_mat_khau_cu);
        edt_nhap_mat_khau_moi= findViewById(R.id.edt_nhap_mat_khau_moi);
        edt_nhap_lai_mat_khau =findViewById(R.id.edt_nhap_lai_mat_khau);
        btn_xac_nhan= findViewById(R.id.btn_xac_nhan);
    }

}