package com.example.thltdd_tuan4_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class QuizInfoActivity extends AppCompatActivity {

    Button btnPlayNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizinfo);

        btnPlayNow = findViewById(R.id.btnPlayNow);

        btnPlayNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizInfoActivity.this, QuizActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
