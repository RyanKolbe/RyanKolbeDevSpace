package com.ryankolbe.ryankolbedevspace;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Calculator extends AppCompatActivity {
    EditText etHeight, etWidth, etLength;
    TextView tvResult;
    Button btnRunFormula, btnCalculatorBack;
    int length, width, height, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        etHeight = findViewById(R.id.et_height);
        etWidth = findViewById(R.id.et_width);
        etLength = findViewById(R.id.et_length);
        tvResult = findViewById(R.id.tv_calculation_result);
        btnCalculatorBack = findViewById(R.id.btn_calculator_back);
        btnRunFormula = findViewById(R.id.btn_run_formula);

        btnRunFormula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etHeight.getText().toString().isEmpty() ||
                        etLength.getText().toString().isEmpty() ||
                        etWidth.getText().toString().isEmpty()) {
                    if (etHeight.getText().toString().isEmpty()) {
                        etHeight.setError("Enter value");
                    }
                    if (etLength.getText().toString().isEmpty()) {
                        etLength.setError("Enter Value");
                    }
                    if (etWidth.getText().toString().isEmpty()) {
                        etWidth.setError("Enter Value");
                    }
                } else {
                    length = Integer.parseInt(etLength.getText().toString());
                    width = Integer.parseInt(etWidth.getText().toString());
                    height = Integer.parseInt(etHeight.getText().toString());
                    result = 2 * ((length * width) + (length * height) + (width * height));
                    tvResult.setText(String.valueOf(result));
                }
            }
        });

        btnCalculatorBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Calculator.this, MenuScreen.class);
                startActivity(intent);
            }
        });
    }
}