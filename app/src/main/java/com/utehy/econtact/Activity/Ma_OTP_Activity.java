package com.utehy.econtact.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.utehy.econtact.R;

public class Ma_OTP_Activity extends AppCompatActivity {

    private EditText edtOTP;
    private Button btnSendOTP;
    private TextView tvSendOTPAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma_otp);

        Button btn_send_OTP_code = findViewById(R.id.btn_send_OTP_code);

        btn_send_OTP_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), QuenmatkhauActivity.class);
                Toast.makeText(getApplicationContext(),"Nhập mật khẩu mới",Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
        });
        setTitleToolbar();

        Anhxa();
        btnSendOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strOTP = edtOTP.getText().toString().trim();
                onClickSendOTPCode(strOTP);
            }
        });
        tvSendOTPAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClicktvSendOTPAgain();
            }
        });
    }
    private  void setTitleToolbar(){
        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle("Enter_OTP");
        }
    }

    private void Anhxa(){
        edtOTP = findViewById(R.id.edt_OTP);
        btnSendOTP = findViewById(R.id.btn_send_OTP_code);
        tvSendOTPAgain = findViewById(R.id.tv_send_OTP_again);
    }

    private void onClickSendOTPCode(String strOTP) {

    }

    private void onClicktvSendOTPAgain(){

    }
}