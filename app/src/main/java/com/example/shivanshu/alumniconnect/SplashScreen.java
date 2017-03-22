package com.example.shivanshu.alumniconnect;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Dimension;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.WindowManager;

import static com.example.shivanshu.alumniconnect.ProfileActivity.context;

public class SplashScreen extends AppCompatActivity {
    Intent intent;
    private int heading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Handler handler=new Handler();
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        VaryScreenSize.width = size.x;
        VaryScreenSize.height= size.y;
        heading = R.dimen.heading;

        intent=new Intent(this,LoginActivity.class);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
                finish();
            }
        },500);
    }
}
