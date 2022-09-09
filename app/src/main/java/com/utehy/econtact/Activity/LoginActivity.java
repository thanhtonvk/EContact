package com.utehy.econtact.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.utehy.econtact.MainActivity;
import com.utehy.econtact.R;

public class LoginActivity extends AppCompatActivity {

    EditText edt_tai_khoan,edt_mat_khau;
    TextView tv_quen_mat_khau;
    Button btn_dang_nhap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        anhxa();

        btn_dang_nhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ManHinhChinhActivity.class);
                startActivity(i);
            }
        });

        tv_quen_mat_khau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), CauHoiBaoMat_Activity.class);
                startActivity(i);
            }
        });
    }

    private void anhxa() {
        edt_tai_khoan = findViewById(R.id.edt_tai_khoan);
        edt_mat_khau = findViewById(R.id.edt_mat_khau);
        tv_quen_mat_khau = findViewById(R.id.tv_quen_mat_khau);
        btn_dang_nhap = findViewById(R.id.btn_dang_nhap);
    }
}