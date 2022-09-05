package com.utehy.econtact.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.utehy.econtact.R;

public class CauHoiBaoMat_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau_hoi_bao_mat);

        Button btn_xac_nhan = findViewById(R.id.btnXacNhanBM);

        btn_xac_nhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Ma_OTP_Activity.class);
                Toast.makeText(getApplicationContext(),"Lấy mã OTP" ,Toast.LENGTH_LONG).show();
                startActivity(i);
            }
        });
    }
}