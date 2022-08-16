package com.utehy.econtact;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // tinh dien tich hcn
    public void mangphu(int i){
        for (int j = i+1; j < 50; j++) {

        }
    }
    public void mang(){
        for (int i = 0; i < 5; i++) {
              mangphu(i);
        }
    }
}