package com.example.findthespot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity {

    private ViewPager screenPager;
    IntroViewPageAdaptor introViewPageAdaptor ;
    TabLayout tabIndicator;
    Button btnGetStarted;
    int position = 0;
    Animation btnAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        // ini views
        tabIndicator = findViewById(R.id.tab_indicator);
        btnGetStarted = findViewById(R.id.btnGetStarted);
        btnAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.button_animation);

        // list
        final List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem("Scroll", "Baca Informasi tempat wisata yang kami sediakan!", R.drawable.scroll));
        mList.add(new ScreenItem("Find", "Temukan tempat wisata yang kamu inginkan.", R.drawable.location));
        mList.add(new ScreenItem("Go!", "Pergi dengan tenang, selamat dan bahagia:)", R.drawable.go));


        // setup
        screenPager = findViewById(R.id.screen_viewpager);
        introViewPageAdaptor = new IntroViewPageAdaptor(this, mList);
        screenPager.setAdapter(introViewPageAdaptor);

        //setup table layout
        tabIndicator.setupWithViewPager(screenPager);

        tabIndicator.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == mList.size() - 1) {
                    loadLastScreen();
                }


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //get started listener
        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //open main activity
                Intent intro = new Intent(IntroActivity.this, ButtomActivity.class);
                startActivity(intro);

                finish();
            }
        }); }

    //menampilkan tombol get started
    private void loadLastScreen() {
        btnGetStarted.setVisibility(View.VISIBLE);
        tabIndicator.setVisibility(View.INVISIBLE);
        btnGetStarted.setAnimation(btnAnim);
    }


}


