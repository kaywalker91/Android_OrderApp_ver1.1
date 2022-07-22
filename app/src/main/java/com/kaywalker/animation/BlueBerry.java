package com.kaywalker.animation;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BlueBerry extends AppCompatActivity {

    private ImageButton btnAdd, btnMinus;
    private TextView tv_count,tv_bbPrice;
    private int count = 0, bbprice = 7000;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blueberry);

        tv_count = findViewById(R.id.tv_ctn);
        tv_count.setText(count+"");
        tv_bbPrice = findViewById(R.id.tv_bbPrice);
        tv_bbPrice.setText(count*bbprice+"");
        btnAdd = findViewById(R.id.btn_plus);
        btnMinus = findViewById(R.id.btn_minus);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                tv_count.setText(count+"");
                tv_bbPrice.setText(count*bbprice+""+"원");
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count--;
                tv_count.setText(count+"");
                tv_bbPrice.setText(count*bbprice+""+"원");
            }
        });
    }
}
