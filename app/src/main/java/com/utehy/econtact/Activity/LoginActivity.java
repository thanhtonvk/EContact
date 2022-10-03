package com.utehy.econtact.Activity;

import static com.utehy.econtact.Api.ApiService.api;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.utehy.econtact.R;
import com.utehy.econtact.Tools.Common;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText edtTaiKhoan;
    TextInputEditText edtMatKhau;
    Button btnDangNhap, btnQuenMatKhau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        onClick();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.status_bar_color, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.status_bar_color));
        }
    }

    private void initView() {
        edtTaiKhoan = findViewById(R.id.edt_ma_sv);
        edtMatKhau = findViewById(R.id.edt_mat_khau);
        btnDangNhap = findViewById(R.id.btn_dang_nhap);
        btnQuenMatKhau = findViewById(R.id.btn_quen_mat_khau);
    }

    private void onClick() {
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("Đang đăng nhập");
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String maSV = edtTaiKhoan.getText().toString();
                String matKhau = edtMatKhau.getText().toString();
                if (maSV.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Tài khoản không được để trống", Toast.LENGTH_LONG).show();
                }
                if (maSV.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Mật khẩu không được để trống", Toast.LENGTH_LONG).show();
                }
                if (!maSV.isEmpty() && !matKhau.isEmpty()) {
                    dialog.show();
                    Map<String, String> body = new HashMap();
                    body.put("facility_id", Common.FACILITY_ID);
                    body.put("userName", maSV);
                    body.put("password", Common.toMD5(maSV));
                    body.put("grant_type", "password");

                    api.login(body).enqueue(new Callback<Map<String, Object>>() {
                        @Override
                        public void onResponse(Call<Map<String, Object>> call, Response<Map<String, Object>> response) {
                            if (response.isSuccessful()) {
                                Common.LOGIN_USER = response.body();
                                Common.TOKEN = (String) Common.LOGIN_USER.get("access_token");
                                Log.e("TAG", "token: " + Common.TOKEN);
                                startActivity(new Intent(getApplicationContext(), ManHinhChinhActivity.class));
                                dialog.dismiss();
                            } else {
                                Toast.makeText(getApplicationContext(), "Tài khoản hoặc mật khẩu không chính xác", Toast.LENGTH_LONG).show();
                                dialog.dismiss();
                            }
                        }

                        @Override
                        public void onFailure(Call<Map<String, Object>> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Lỗi kết nối", Toast.LENGTH_LONG).show();
                            Log.e("TAG", t.getMessage());
                            dialog.dismiss();
                        }
                    });


                }
            }
        });
        findViewById(R.id.btn_quen_mat_khau).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String maSV = edtTaiKhoan.getText().toString();
                if (maSV.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Tài khoản không được để trống", Toast.LENGTH_LONG).show();
                } else {
                    startActivity(new Intent(getApplicationContext(), Ma_OTP_Activity.class));
                }

            }
        });

    }
}