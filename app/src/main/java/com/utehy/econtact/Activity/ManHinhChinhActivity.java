package com.utehy.econtact.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.utehy.econtact.R;

public class ManHinhChinhActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton imgbt_HoSo, imgbt_HocTap, imgbt_ThongBao, imgbt_LienHe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangchu);
        anhxa();

        imgbt_HoSo.setOnClickListener(this);
        imgbt_HocTap.setOnClickListener(this);
        imgbt_ThongBao.setOnClickListener(this);
        imgbt_LienHe.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.imgbt_hoctap:
                i = new Intent(this, HoSoActivity.class);
                startActivity(i);
                break;
            case R.id.imgbt_hoso:
                i = new Intent(this, QuaTrinhActivity.class);
                startActivity(i);
                break;
            case R.id.imgbt_thongbao:
                i = new Intent(this, ThongBaoActivity.class);
                startActivity(i);
                break;
            case R.id.imgbt_lienhe:
                i = new Intent(this, LienHeActivity.class);
                startActivity(i);
                break;
        }
    }

    private void anhxa() {
        imgbt_HoSo.findViewById(R.id.imgbt_hoso);
        imgbt_HocTap.findViewById(R.id.imgbt_hoctap);
        imgbt_ThongBao.findViewById(R.id.imgbt_thongbao);
        imgbt_LienHe.findViewById(R.id.imgbt_lienhe);
    }
}
