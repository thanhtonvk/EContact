package com.utehy.econtact.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.utehy.econtact.R;

public class ManHinhChinhActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangchu);

        ImageButton imgbt_HoSo = (ImageButton) findViewById(R.id.imgbt_hoso);
        ImageButton imgbt_HocTap = (ImageButton) findViewById(R.id.imgbt_hoctap);
        ImageButton imgbt_ThongBao = (ImageButton) findViewById(R.id.imgbt_thongbao);
        ImageButton imgbt_LienHe = (ImageButton) findViewById(R.id.imgbt_lienhe);

        //Set sự kiện onClick
        imgbt_HoSo.setOnClickListener(this);
        imgbt_HocTap.setOnClickListener(this);
        imgbt_ThongBao.setOnClickListener(this);
        imgbt_LienHe.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.imgbt_hoso:
                i = new Intent(this, HoSoActivity.class);
                Toast.makeText(getApplicationContext(),"Hồ Sơ học tập",Toast.LENGTH_LONG).show();
                startActivity(i);
                break;
            case R.id.imgbt_hoctap:
                i = new Intent(this, QuaTrinhActivity.class);
                Toast.makeText(getApplicationContext(),"Điểm quá trình",Toast.LENGTH_LONG).show();
                startActivity(i);
                break;
            case R.id.imgbt_thongbao:
                i = new Intent(this, ThongBaoActivity.class);
                Toast.makeText(getApplicationContext(),"Các thông báo",Toast.LENGTH_LONG).show();
                startActivity(i);
                break;
            case R.id.imgbt_lienhe:
                i = new Intent(this, LienHeActivity.class);
                Toast.makeText(getApplicationContext(),"Thông tin liên hệ",Toast.LENGTH_LONG).show();
                startActivity(i);
                break;
        }
    }
}
