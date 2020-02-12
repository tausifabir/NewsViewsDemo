package com.example.newsviewsdemo.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.newsviewsdemo.MainActivity;
import com.example.newsviewsdemo.R;

public class SplashThridAcitivity extends AppCompatActivity {

    private TextView helloTV;
    private TextView nameTV;
    private int progressUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_thrid_acitivity);
        Intent intent = getIntent();
        helloTV = findViewById(R.id.hello);
        nameTV = findViewById(R.id.name);


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

        Intent intent = new Intent(SplashThridAcitivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
