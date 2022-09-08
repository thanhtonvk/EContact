package com.utehy.econtact.Activity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.utehy.econtact.R;

public class HoSoActivity extends AppCompatActivity {
    ImageButton img_trolai;
    ImageView img_anhhoso;
    TextView tv1,tv2,tv3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoso_sinhvien);
    }
}
