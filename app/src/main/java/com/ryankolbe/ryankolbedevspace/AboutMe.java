package com.ryankolbe.ryankolbedevspace;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AboutMe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

        Button btnProfileBack = findViewById(R.id.btn_about_me_back);
        btnProfileBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AboutMe.this, MenuScreen.class);
                startActivity(intent);
            }
        });

        TextView tvProfileText = findViewById(R.id.tv_scrollview);
        String tvContent = "I am Ryan Kolbe. \n\nI like to code because of the challenge" +
                " involved. I have skills such as problem solving and I am a team worker." +
                " I am a manager in my current profession. \n\nIn the future I hope to become a" +
                " professional programmer and/or data scientist in support of my professional" +
                " aspirations and in view of my technical skills. \n\nI enjoy watching Japanese" +
                " anime and unique series via streaming media such as Netflix and ShowMax.";
        tvProfileText.setText(tvContent);
        tvProfileText.setMovementMethod(new ScrollingMovementMethod());
    }
}