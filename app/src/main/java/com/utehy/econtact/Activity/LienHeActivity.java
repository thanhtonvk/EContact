package com.utehy.econtact.Activity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.utehy.econtact.R;

public class LienHeActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lienhe);

        //ánh xạ
        TextView tv_lienhe_ws1 = findViewById(R.id.tv_lienhe_cs1_ws);
        TextView tv_lienhe_ws2 = findViewById(R.id.tv_lienhe_cs2_ws);
        TextView tv_lienhe_ws3 = findViewById(R.id.tv_lienhe_cs3_ws);

        //
        tv_lienhe_ws1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.utehy.edu.vn/"));
                startActivity(i);
            }
        });

        tv_lienhe_ws2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.utehy.edu.vn/"));
                startActivity(i);
            }
        });

        tv_lienhe_ws3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.utehy.edu.vn/"));
                startActivity(i);
            }
        });
    }
}
