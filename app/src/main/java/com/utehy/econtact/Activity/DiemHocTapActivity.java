package com.utehy.econtact.Activity;

import android.os.Build;
import android.os.Bundle;
import android.util.ArrayMap;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.utehy.econtact.Adapter.DiemAdapter;
import com.utehy.econtact.Api.ApiService;
import com.utehy.econtact.Models.NamHoc;
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

public class DiemHocTapActivity extends AppCompatActivity {


    RecyclerView rcvDiem;
    List<Map<String, Object>> diems;
    DiemAdapter diemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diem_hoc_tap);
        back();
        initView();
        loadDiem();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.status_bar_color, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.status_bar_color));
        }
    }

    private void initView() {
        diems = new ArrayList<>();
        rcvDiem = findViewById(R.id.rcv_diem);
        diemAdapter = new DiemAdapter(this, diems);
        rcvDiem.setAdapter(diemAdapter);

    }

    private void loadDiem() {
        String maHS = Common.STUDENT_BY_FAMILY.get("student_rcd");
        Map<String, Object> jsonParams = new ArrayMap<>();
        Map<String, String> method = new HashMap<>();
        method.put("Method", "POST");
        jsonParams.put("Method", method);
        jsonParams.put("Url", "/api/subject-score/search");
        jsonParams.put("Module", "TEACHER");
        String data = String.format("{\"academy_year\":\"%s\",\"semester\":\"%s\",\"student_rcd\":\"%s\",\"page\":1,\"pageSize\":0}", NamHoc.NAM_HOC.getNamHoc(),NamHoc.NAM_HOC.getKiHoc(),maHS);
        jsonParams.put("Data", data);
        jsonParams.put("ContentType", "application/json");
        jsonParams.put("AcceptType", "application/json");

        Log.e("TAG", "loadDiem: " + jsonParams.toString());
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), (new JSONObject(jsonParams)).toString());
        ApiService.api.executeAdapter(body).enqueue(new Callback<Map<String, Object>>() {
            @Override
            public void onResponse(Call<Map<String, Object>> call, Response<Map<String, Object>> response) {
                if (response.isSuccessful()) {

                    diems = (List<Map<String, Object>>) response.body().get("data");
                    diemAdapter = new DiemAdapter(DiemHocTapActivity.this, diems);
                    rcvDiem.setAdapter(diemAdapter);
                } else {
                    Log.e("TAG", "onResponse: " + response.body());
                }
            }

            @Override
            public void onFailure(Call<Map<String, Object>> call, Throwable t) {
                Log.e("TAG", "onFailure: " + t.getMessage());
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