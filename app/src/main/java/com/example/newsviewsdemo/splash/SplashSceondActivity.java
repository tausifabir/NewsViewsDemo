package com.example.newsviewsdemo.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.newsviewsdemo.MainActivity;
import com.example.newsviewsdemo.R;

public class SplashSceondActivity extends AppCompatActivity {

    private TextView showText;
    private int progressUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        /*requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);*/

        Intent intent = getIntent();
        setContentView(R.layout.activity_splash_sceond);
        showText = findViewById(R.id.showTV);





        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                startApp();
            }


        });

        thread.start();
    }


    public void doWork(){

        for(progressUp=20;progressUp <= 100;progressUp=progressUp+20){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    public void startApp(){

        Intent intent = new Intent(SplashSceondActivity.this, SplashThridAcitivity.class);
        startActivity(intent);
        finish();
    }
}
