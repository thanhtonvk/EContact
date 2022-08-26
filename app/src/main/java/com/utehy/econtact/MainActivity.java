package com.utehy.econtact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.utehy.econtact.Activity.LoginActivity;
import com.utehy.econtact.Activity.ManHinhChinhActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(new Intent(getApplication(), LoginActivity.class));
        finish();
    }
}
