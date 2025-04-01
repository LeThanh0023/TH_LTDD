package com.example.thltdd_tuan1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView tv_HoTen, tv_MSSV, tv_Lop, tv_SDT, tv_Nam, tv_ChuyenNganh;
    Button bt_Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Ánh xạ các thành phần giao diện
        tv_HoTen = findViewById(R.id.tv_HoTen);
        tv_MSSV = findViewById(R.id.tv_MSSV);
        tv_Lop = findViewById(R.id.tv_Lop);
        tv_SDT = findViewById(R.id.tv_SDT);
        tv_Nam = findViewById(R.id.tv_Nam);
        tv_ChuyenNganh = findViewById(R.id.tv_ChuyenNganh);
        bt_Back = findViewById(R.id.bt_Back);

        // Nhận dữ liệu từ Intent
        Intent intent = getIntent();
        String hoTen = intent.getStringExtra("hoTen");
        String mssv = intent.getStringExtra("mssv");
        String lop = intent.getStringExtra("lop");
        String sdt = intent.getStringExtra("sdt");
        String namThu = intent.getStringExtra("namThu");
        String chuyenNganh = intent.getStringExtra("chuyenNganh");

        // Hiển thị dữ liệu lên giao diện
        tv_HoTen.setText("HỌ VÀ TÊN: " + hoTen);
        tv_MSSV.setText("MSSV: " + mssv);
        tv_Lop.setText("LỚP: " + lop);
        tv_SDT.setText("SĐT: " + sdt);
        tv_Nam.setText("SINH VIÊN NĂM THỨ: " + namThu);
        tv_ChuyenNganh.setText("CHUYÊN NGÀNH: " + chuyenNganh);

        // Xử lý nút trở về
        bt_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Quay lại MainActivity
                finish();
            }
        });
    }
}
