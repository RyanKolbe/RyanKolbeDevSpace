package com.ryankolbe.ryankolbedevspace;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText et_visitor_name;
    Button bt_launch_next;
    String message = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_visitor_name = findViewById(R.id.et_visitor_name);
        bt_launch_next = findViewById(R.id.bt_launch_next);

        bt_launch_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et_visitor_name.getText().toString().isEmpty()) {
                    et_visitor_name.setError("Please enter a value");
                } else {
                    Intent intent = new Intent(MainActivity.this, MenuScreen.class);
                    message = et_visitor_name.getText().toString();
                    intent.putExtra("EXTRA", message);
                    startActivity(intent);
                }
            }
        });
    }
}