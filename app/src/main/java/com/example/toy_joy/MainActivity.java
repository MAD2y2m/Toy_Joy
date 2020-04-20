package com.example.toy_joy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    //time variable
    private  static  int SPLASH_SCREEN = 5000;

    //variable
    Animation topAnim,bottomAnim;
    ImageView image;  //logo
    TextView logo,slogan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //calling animation function
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

       //assinge valuve
        ImageView image = (ImageView)findViewById(R.id.ImageView);
        image.setImageResource(R.drawable.t_j);
        logo = findViewById(R.id.textView);
        slogan = findViewById(R.id.textView2);



        image.setAnimation(topAnim);
        logo.setAnimation(bottomAnim);
        slogan.setAnimation(bottomAnim);

        //timing
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent =new Intent(MainActivity.this,login.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }
}
