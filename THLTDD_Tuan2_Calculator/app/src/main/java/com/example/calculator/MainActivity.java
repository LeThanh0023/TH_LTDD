package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;
    private String input = "";
    private String operator = "";
    private double firstNumber = 0;
    private boolean isDecimalAdded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tvResult);


        findViewById(R.id.btn0).setOnClickListener(v -> appendNumber("0"));
        findViewById(R.id.btn1).setOnClickListener(v -> appendNumber("1"));
        findViewById(R.id.btn2).setOnClickListener(v -> appendNumber("2"));
        findViewById(R.id.btn3).setOnClickListener(v -> appendNumber("3"));
        findViewById(R.id.btn4).setOnClickListener(v -> appendNumber("4"));
        findViewById(R.id.btn5).setOnClickListener(v -> appendNumber("5"));
        findViewById(R.id.btn6).setOnClickListener(v -> appendNumber("6"));
        findViewById(R.id.btn7).setOnClickListener(v -> appendNumber("7"));
        findViewById(R.id.btn8).setOnClickListener(v -> appendNumber("8"));
        findViewById(R.id.btn9).setOnClickListener(v -> appendNumber("9"));

        findViewById(R.id.btnDot).setOnClickListener(v -> appendDecimal());

        findViewById(R.id.btnAdd).setOnClickListener(v -> setOperator("+"));
        findViewById(R.id.btnSubtract).setOnClickListener(v -> setOperator("-"));
        findViewById(R.id.btnMultiply).setOnClickListener(v -> setOperator("*"));
        findViewById(R.id.btnDivide).setOnClickListener(v -> setOperator("/"));
        findViewById(R.id.btnPercent).setOnClickListener(v -> setOperator("%"));

        findViewById(R.id.btnPercent).setOnClickListener(v -> calculate());
        findViewById(R.id.btnDel).setOnClickListener(v -> clear());
    }

    private void appendNumber(String number) {
        input += number;
        tvResult.setText(input);
    }

    private void appendDecimal() {
        if (!isDecimalAdded) {
            if (input.isEmpty()) {
                input = "0.";
            } else {
                input += ".";
            }
            isDecimalAdded = true;
            tvResult.setText(input);
        }
    }

    private void setOperator(String op) {
        if (!input.isEmpty()) {
            firstNumber = Double.parseDouble(input);
            operator = op;
            input = "";
            isDecimalAdded = false;
        }
    }

    private void calculate() {
        if (!input.isEmpty() && !operator.isEmpty()) {
            double secondNumber = Double.parseDouble(input);
            double result = 0;

            switch (operator) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "*":
                    result = firstNumber * secondNumber;
                    break;
                case "/":
                    result = firstNumber / secondNumber;
                    break;
                case "%":
                    result = firstNumber % secondNumber;
                    break;
            }

            tvResult.setText(String.valueOf(result));
            input = "";
            operator = "";
            isDecimalAdded = false;
        }
    }

    private void clear() {
        input = "";
        operator = "";
        firstNumber = 0;
        isDecimalAdded = false;
        tvResult.setText("0");
    }
}
