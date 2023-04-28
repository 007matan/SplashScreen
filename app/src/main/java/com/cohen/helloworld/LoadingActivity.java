package com.cohen.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.android.material.progressindicator.LinearProgressIndicator;

public class LoadingActivity extends AppCompatActivity {

    private AppCompatImageView loading_IMG_logo;
    private LinearProgressIndicator loading_PRG_download;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        loading_IMG_logo = findViewById(R.id.loading_IMG_logo);
        loading_PRG_download = findViewById(R.id.loading_PRG_download);

        startLoading();
    }

    //This code is for design puposes only
    private void startLoading() {
        loading_PRG_download.setProgress(0);
        loading_PRG_download.setMax(10);
        final Handler handler = new Handler();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(()->{
                    loading_PRG_download.setProgress(4);
                }, 1000);

                handler.postDelayed(()->{
                    loading_PRG_download.setProgress(10);
                    finish();
                }, 2000);

                handler.postDelayed(()->{
                    Intent intent = new Intent(LoadingActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }, 2000);
            }
        });


    }
}