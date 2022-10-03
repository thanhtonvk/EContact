package com.utehy.econtact.Activity;

import android.os.Build;
import android.os.Bundle;
import android.util.ArrayMap;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.utehy.econtact.Adapter.DiemRenLuyenAdapter;
import com.utehy.econtact.Api.ApiService;
import com.utehy.econtact.R;
import com.utehy.econtact.Tools.Common;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DiemRenLuyenActivity extends AppCompatActivity {


    RecyclerView rcvDiemRL;
    List<Map<String, Object>> diemRLList;
    DiemRenLuyenAdapter diemRenLuyenAdapter;
    ImageButton btnTroVe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diem_ren_luyen);
        initView();
        back();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.status_bar_color, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.status_bar_color));
        }
        loadDiemRL();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.status_bar_color, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.status_bar_color));
        }

    }

    private void initView() {
        diemRLList = new ArrayList<>();
        diemRenLuyenAdapter = new DiemRenLuyenAdapter(this, diemRLList);
        rcvDiemRL = findViewById(R.id.rcv_diem_rl);
        rcvDiemRL.setAdapter(diemRenLuyenAdapter);

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

    private void loadDiemRL() {
        String maHS = Common.STUDENT_BY_FAMILY.get("student_rcd").toString();
        Map<String, Object> jsonParams = new ArrayMap<>();


        Map<String, String> method = new HashMap<>();


        method.put("Method", "POST");
        jsonParams.put("Method", method);
        jsonParams.put("Url", "/api/point-training/search");
        jsonParams.put("Module", "TEACHER");
        String data = String.format("{\"page\":0,\"pageSize\":0,\"student_rcd\":\"%s\",\"academy_year\":\"\",\"semester\":\"\"}", maHS);
        jsonParams.put("Data", data);
        jsonParams.put("ContentType", "application/json");
        jsonParams.put("AcceptType", "application/json");

        Log.e("TAG", "loadDiem: " + jsonParams.toString());
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), (new JSONObject(jsonParams)).toString());
        ApiService.api.executeAdapter(body).enqueue(new Callback<Map<String, Object>>() {
            @Override
            public void onResponse(Call<Map<String, Object>> call, Response<Map<String, Object>> response) {
                if (response.isSuccessful()) {
                    diemRLList = (List<Map<String, Object>>) response.body().get("data");
                    diemRenLuyenAdapter = new DiemRenLuyenAdapter(DiemRenLuyenActivity.this, diemRLList);
                    rcvDiemRL.setAdapter(diemRenLuyenAdapter);
                } else {
                    Toast.makeText(getApplicationContext(), "Lỗi lấy dữ liệu", Toast.LENGTH_LONG).show();
                }
                Log.e("TAG", "onFailure: " + response.body());
            }

            @Override
            public void onFailure(Call<Map<String, Object>> call, Throwable t) {
                Log.e("TAG", "onFailure: " + t.getMessage());
            }
        });
    }
}