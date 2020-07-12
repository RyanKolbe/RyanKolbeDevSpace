package com.ryankolbe.ryankolbedevspace;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MenuScreen extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_screen);

        String message = getIntent().getStringExtra("EXTRA");
        TextView tvMenuIntro = findViewById(R.id.menu_screen_intro);
        Button btnMenuHome = findViewById(R.id.btnMenuHome);
        Button btnMenuAbout = findViewById(R.id.btnMenuAbout);
        Button btnMenuCalculator = findViewById(R.id.btnMenuCalculator);
        Button btnMenuProfile = findViewById(R.id.btnMenuProfile);

        tvMenuIntro.setText(String.format("Dear %s \n Welcome to my code space", message));
        btnMenuHome.setOnClickListener(this);
        btnMenuAbout.setOnClickListener(this);
        btnMenuCalculator.setOnClickListener(this);
        btnMenuProfile.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnMenuHome:
                menuIntent(MainActivity.class);
                break;
            case R.id.btnMenuAbout:
                menuIntent(AboutMe.class);
                break;
            case R.id.btnMenuCalculator:
                menuIntent(Calculator.class);
                break;
            case R.id.btnMenuProfile:
                menuIntent(Profile.class);
                break;
            default:
                break;
        }
    }

    public void menuIntent(Class<?> context) {
        Intent intent = new Intent(MenuScreen.this, context);
        startActivity(intent);
    }
}