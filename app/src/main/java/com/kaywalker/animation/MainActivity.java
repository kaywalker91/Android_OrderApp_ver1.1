package com.kaywalker.animation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView image_logo;
    Button btn_booking,btn_address;

    ViewPager2 viewPager;

    int[] images = {R.drawable.blueberry, R.drawable.mint, R.drawable.raspberries, R.drawable.watermelon};

    ItemAdapter itemAdapter;

    boolean orientationState = true;

    TextView textOrientation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image_logo = findViewById(R.id.image_logo);
        btn_booking = findViewById(R.id.btn_booking);
        btn_address = findViewById(R.id.btn_address);

        image_logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , SubActivity.class);
                startActivity(intent); // 액티비티 이동
            }
        });

        btn_booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , BookingActivity.class);
                startActivity(intent); // 액티비티 이동
            }
        });

        btn_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , AddressActivity.class);
                startActivity(intent); // 액티비티 이동
            }
        });

        viewPager =findViewById(R.id.viewPager);

        itemAdapter = new ItemAdapter(images);

        textOrientation = findViewById(R.id.textOrientation);

        viewPager.setAdapter(itemAdapter);
    }

    private void makeMsg() {
        Toast toast =Toast.makeText(this,"메세지입니다. ", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP|Gravity.TOP, 50, 500);
        toast.show();
    }

    public void changeorientation(View view) {
        if(orientationState){
            viewPager.setOrientation(viewPager.ORIENTATION_VERTICAL);
            orientationState = false;
            textOrientation.setText("세로방향");
        }else{
            viewPager.setOrientation(viewPager.ORIENTATION_HORIZONTAL);
            orientationState = true;
            textOrientation.setText("가로방향");
        }
    }
}