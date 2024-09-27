package com.example.qa;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

@SuppressLint("CustomSplashScreen")
public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ImageView i  = findViewById(R.id.splash_logo);

        Intent splash = new Intent(SplashScreen.this, Register.class);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation alpha = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                i.startAnimation(alpha);
                startActivity(splash);
                finish();
            }
        },4000);
    }
}