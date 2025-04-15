package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Forgot extends AppCompatActivity {
    EditText etPhonePass;
    final String PHONE_PASS = "1111";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgotpass);

        etPhonePass = findViewById(R.id.etPhonePass);
        Button btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(v -> {
            String input = etPhonePass.getText().toString();
            if (input.equals(PHONE_PASS)) {
                startActivity(new Intent(this, ViewAccounts.class));
            } else {
                Toast.makeText(this, "Sai mật khẩu, vui lòng nhập lại!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
