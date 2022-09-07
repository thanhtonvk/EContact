package com.utehy.econtact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;


import com.utehy.econtact.Activity.LoginActivity;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangchu);
        startActivity(new Intent(getApplication(), LoginActivity.class));
        finish();
    }
}
