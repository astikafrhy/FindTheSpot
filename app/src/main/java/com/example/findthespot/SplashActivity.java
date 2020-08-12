package com.example.findthespot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.findthespot.MainActivity;
import com.example.findthespot.R;

public class SplashActivity extends AppCompatActivity {

    ImageView imgLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //agar fullscreen
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);

        imgLogo = (ImageView) findViewById(R.id.splash_icon);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.fadeout);

        imgLogo.startAnimation(animation);

        //Run Splash Activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent splsh = new Intent(SplashActivity.this, IntroActivity .class);
                startActivity(splsh);

                finish();
            }
        },3000);
    }
}
