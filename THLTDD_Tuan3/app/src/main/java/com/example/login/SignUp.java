package com.example.login;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {
    EditText etEmail, etPassword, etConfirmPassword;
    AccountManager accountManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etAgainPassword);
        Button btnCreate = findViewById(R.id.btnCreate);
        accountManager = new AccountManager(this);

        btnCreate.setOnClickListener(v -> {
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();
            String confirmPassword = etConfirmPassword.getText().toString().trim();

            // ✅ Kiểm tra rỗng
            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(confirmPassword)) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
                return;
            }

            // ✅ Kiểm tra mật khẩu khớp
            if (!password.equals(confirmPassword)) {
                Toast.makeText(this, "Mật khẩu không khớp, vui lòng nhập lại!", Toast.LENGTH_SHORT).show();
                return;
            }

            // ✅ Kiểm tra trùng email
            if (accountManager.isAccountExists(email)) {
                Toast.makeText(this, "Email đã được đăng ký!", Toast.LENGTH_SHORT).show();
            } else {
                accountManager.saveAccount(email, password);
                Toast.makeText(this, "Tạo tài khoản thành công!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });


    }
}
