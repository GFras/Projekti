package com.example.textingapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.textingapp.R;

public class LaunchActivity extends AppCompatActivity {

    //Hooki

    ImageView icon;
    TextView text;

    //Animacije
    Animation iconanAnimation,textanAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);    //Ni top bara
        setContentView(R.layout.activity_launch);


        iconanAnimation= AnimationUtils.loadAnimation(this,R.anim.iconanimation);
        textanAnimation= AnimationUtils.loadAnimation(this,R.anim.textanimation);


        //Hooki

        icon = findViewById(R.id.iconid);
        //text = findViewById(R.id.textid);

        icon.setAnimation(iconanAnimation);
        //text.setAnimation(textanAnimation);


        Runnable r = new Runnable() {
            @Override
            public void run() {
                // if you are redirecting from a fragment then use getActivity() as the context.
                startActivity(new Intent(LaunchActivity.this, SignInActivity.class));
                // To close the CurrentActitity, r.g. SpalshActivity
                finish();
            }
        };

        Handler delay = new Handler();
        // The Runnable will be executed after the given delay time
        delay.postDelayed(r, 2500); // will be delayed for 1.5 seconds
    }
}