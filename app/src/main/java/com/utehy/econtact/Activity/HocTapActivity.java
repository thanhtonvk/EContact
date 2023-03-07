package com.utehy.econtact.Activity;

import android.os.Build;
import android.os.Bundle;
import android.util.ArrayMap;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.utehy.econtact.Adapter.NamHocAdapter;
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

public class HocTapActivity extends AppCompatActivity {

    RecyclerView rcvNamHoc;
    List<NamHoc> namHocList;
    NamHocAdapter namHocAdapter;
    ImageButton btnTroVe;
    TextView txtTieuDe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoc_tap);
        initView();
        loadNamHoc();
        back();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.status_bar_color, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.status_bar_color));
        }

    }

    private void initView() {
        namHocList = new ArrayList<>();
        namHocAdapter = new NamHocAdapter(namHocList, this);
        rcvNamHoc = findViewById(R.id.rcv_nam_hoc);
        rcvNamHoc.setAdapter(namHocAdapter);
        txtTieuDe = findViewById(R.id.txt_tieu_de);


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

    private void loadNamHoc() {
        String maLop = Common.STUDENT_BY_FAMILY.get("class_id").toString();
        Map<String, Object> jsonParams = new ArrayMap<>();
        Map<String, String> method = new HashMap<>();
        method.put("Method", "GET");
        jsonParams.put("Method", method);
        jsonParams.put("Url", "/api/subject-score/get-academy-year-dropdown?class_id=" + maLop);
        jsonParams.put("Module", "TEACHER");
        jsonParams.put("ContentType", "application/json");
        jsonParams.put("AcceptType", "application/json");
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), (new JSONObject(jsonParams)).toString());
        ApiService.api.executeAdapter(body).enqueue(new Callback<Map<String, Object>>() {
            @Override
            public void onResponse(Call<Map<String, Object>> call, Response<Map<String, Object>> response) {
                Log.e("TAG", "onResponse: " + response);
                if (response.isSuccessful()) {
                    Map<String, Object> result = response.body();
                    List<Map<String, String>> data = (List<Map<String, String>>) result.get("data");
                    for (Map<String, String> stringMap : data
                    ) {
                        namHocList.add(new NamHoc(stringMap.get("value"), "1"));
                        namHocAdapter.notifyDataSetChanged();
                    }

                }
            }

            @Override
            public void onFailure(Call<Map<String, Object>> call, Throwable t) {
                Log.e("TAG", "onFailure: " + t.getMessage());
            }
        });
    }
}