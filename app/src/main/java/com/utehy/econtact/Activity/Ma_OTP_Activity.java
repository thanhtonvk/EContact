package com.utehy.econtact.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.utehy.econtact.R;

public class Ma_OTP_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma_otp);

        Button btn_gui_OTP = findViewById(R.id.btn_gui_OTP);

        btn_gui_OTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), QuenmatkhauActivity.class);
                Toast.makeText(getApplicationContext(),"Nhập mật khẩu mới",Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
        });
    }
}