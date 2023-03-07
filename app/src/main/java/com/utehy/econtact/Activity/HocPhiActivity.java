package com.utehy.econtact.Activity;

import android.os.Build;
import android.os.Bundle;
import android.util.ArrayMap;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.utehy.econtact.Adapter.HocPhiAdapter;
import com.utehy.econtact.Api.ApiService;
import com.utehy.econtact.R;
import com.utehy.econtact.Tools.Common;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HocPhiActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoc_phi);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.status_bar_color, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.status_bar_color));
        }
        ImageButton btnTroVe;
        btnTroVe = findViewById(R.id.btn_tro_ve);
        btnTroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        rcvHocPhi = findViewById(R.id.rcv_hoc_phi);
        loadHocPhi();
    }

    List<Map<String, Object>> listHocPhi;
    HocPhiAdapter hocPhiAdapter;
    RecyclerView rcvHocPhi;

    private void loadHocPhi() {
        String maHS = Common.STUDENT_BY_FAMILY.get("student_rcd").toString();
        Map<String, Object> jsonParams = new ArrayMap<>();
        Map<String, String> method = new HashMap<>();
        method.put("Method", "POST");
        jsonParams.put("Method", method);
        jsonParams.put("Url", "/api/tuition-fee/search");
        jsonParams.put("Module", "TEACHER");

        String data = String.format("\"{\\\"academy_year\\\":\\\"\\\",\\\"semester\\\":\\\"\\\",\\\"class_id\\\":\\\"\\\",\\\"student_rcd\\\":\\\"%s\\\",\\\"is_paid\\\":null,\\\"page\\\":1,\\\"pageSize\\\":0}\"",maHS);
        jsonParams.put("Data", data);
        jsonParams.put("ContentType", "application/json");
        jsonParams.put("AcceptType", "application/json");

        Log.e("TAG", "loadDiem: " + jsonParams.toString());
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), (new JSONObject(jsonParams)).toString());
        ApiService.api.executeAdapter(body).enqueue(new Callback<Map<String, Object>>() {
            @Override
            public void onResponse(Call<Map<String, Object>> call, Response<Map<String, Object>> response) {
                if (response.isSuccessful()) {
                    Log.e("Hocphi", "onResponse: "+response.body() );
                    listHocPhi = (List<Map<String, Object>>) response.body().get("data");
                    hocPhiAdapter = new HocPhiAdapter(listHocPhi, HocPhiActivity.this);
                    rcvHocPhi.setAdapter(hocPhiAdapter);
                } else {
                    Log.e("TAG", "onResponse: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<Map<String, Object>> call, Throwable t) {
                Log.e("TAG", "onFailure: " + t.getMessage());
            }
        });


    }
}