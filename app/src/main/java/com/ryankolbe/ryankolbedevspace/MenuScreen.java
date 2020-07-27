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
        Button btnMenuHome = findViewById(R.id.btn_menu_home);
        Button btnMenuAbout = findViewById(R.id.btn_menu_about);
        Button btnMenuCalculator = findViewById(R.id.btn_menu_calculator);
        Button btnMenuProfile = findViewById(R.id.btn_menu_profile);

        tvMenuIntro.setText(String.format("Dear %s \n Welcome to my code space", message));
        btnMenuHome.setOnClickListener(this);
        btnMenuAbout.setOnClickListener(this);
        btnMenuCalculator.setOnClickListener(this);
        btnMenuProfile.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_menu_home:
                menuIntent(MainActivity.class);
                break;
            case R.id.btn_menu_about:
                menuIntent(AboutMe.class);
                break;
            case R.id.btn_menu_calculator:
                menuIntent(Calculator.class);
                break;
            case R.id.btn_menu_profile:
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