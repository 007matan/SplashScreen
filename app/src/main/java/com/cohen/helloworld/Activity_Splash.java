package com.cohen.helloworld;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import com.google.android.material.progressindicator.LinearProgressIndicator;

public class Activity_Splash extends AppCompatActivity {

    private AppCompatImageView splash_IMG_logo;
    private LinearProgressIndicator splash_PRG_download;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_splash);

        splash_IMG_logo = findViewById(R.id.splash_IMG_logo);

        startAnimation(splash_IMG_logo);
    }

    private void startAnimation(View view) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        view.setY(-height / 2);

        view.setScaleX(0.0f);
        view.setScaleY(0.0f);
        view.setAlpha(0.0f);

        view.animate()
                .scaleY(1.0f)
                .scaleX(1.0f)
                .alpha(1.0f)
                .translationY(0)
                .setDuration(4000)
                //.setInterpolator(new LinearOutSlowInInterpolator())
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        startApp();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
    }

    //To Log In
    private void startApp() {
        startActivity(new Intent(this, LoadingActivity.class));
        finish();
    }
}
