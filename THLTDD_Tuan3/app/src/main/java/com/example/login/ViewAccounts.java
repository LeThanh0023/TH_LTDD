package com.example.login;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Map;

public class ViewAccounts extends AppCompatActivity {
    TextView tvAccounts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewaccounts);

        tvAccounts = findViewById(R.id.tvAccounts);
        AccountManager accountManager = new AccountManager(this);

        Map<String, ?> allAccounts = accountManager.getAllAccounts();
        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, ?> entry : allAccounts.entrySet()) {
            if (!entry.getKey().equals("lastEmail") && !entry.getKey().equals("lastPassword")) {
                result.append("Email: ").append(entry.getKey()).append("\n")
                        .append("Password: ").append(entry.getValue().toString()).append("\n\n");
            }
        }

        tvAccounts.setText(result.length() > 0 ? result.toString() : "Không có tài khoản nào.");
    }
}