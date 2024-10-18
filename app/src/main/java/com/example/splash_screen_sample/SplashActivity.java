package com.example.splash_screen_sample;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Intent iHome = new Intent(SplashActivity.this, MainActivity.class);

        // this method used to asynchronized process.
        // the postDelayed() is a method used to delayed a thread(process)
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(iHome);// this is used to start the intent activity
                finish(); // and this is used to finish the activity from the stacks(Stack Activity)
            }
        },3000);
    }
}