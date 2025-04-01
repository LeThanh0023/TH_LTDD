package com.example.thltdd_tuan1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edt_HoTen, edt_MSSV, edt_Lop, edt_SDT;
    RadioGroup rg_Nam, rg_ChuyenNganh;
    Button bt_Submit, bt_Clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ các thành phần giao diện
        edt_HoTen = findViewById(R.id.edt_HoTen);
        edt_MSSV = findViewById(R.id.edt_MSSV);
        edt_Lop = findViewById(R.id.edt_Lop);
        edt_SDT = findViewById(R.id.edt_SDT);
        rg_Nam = findViewById(R.id.rg_Nam);
        rg_ChuyenNganh = findViewById(R.id.rg_ChuyenNganh);
        bt_Submit = findViewById(R.id.bt_Submit);
        bt_Clear = findViewById(R.id.bt_Clear);

        // Xử lý nút gửi dữ liệu
        bt_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy dữ liệu từ các trường nhập liệu
                String hoTen = edt_HoTen.getText().toString();
                String mssv = edt_MSSV.getText().toString();
                String lop = edt_Lop.getText().toString();
                String sdt = edt_SDT.getText().toString();

                // Lấy dữ liệu từ RadioGroup (Năm thứ)
                int selectedNamThuId = rg_Nam.getCheckedRadioButtonId();
                RadioButton rbNamThu = findViewById(selectedNamThuId);
                String namThu = (rbNamThu != null) ? rbNamThu.getText().toString() : "Chưa chọn";

                // Lấy dữ liệu từ RadioGroup (Chuyên ngành)
                int selectedChuyenNganhId = rg_ChuyenNganh.getCheckedRadioButtonId();
                RadioButton rbChuyenNganh = findViewById(selectedChuyenNganhId);
                String chuyenNganh = (rbChuyenNganh != null) ? rbChuyenNganh.getText().toString() : "Chưa chọn";

                // Tạo Intent để gửi dữ liệu sang SecondActivity
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("hoTen", hoTen);
                intent.putExtra("mssv", mssv);
                intent.putExtra("lop", lop);
                intent.putExtra("sdt", sdt);
                intent.putExtra("namThu", namThu);
                intent.putExtra("chuyenNganh", chuyenNganh);

                // Chuyển sang SecondActivity
                startActivity(intent);
            }
        });
        bt_Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt_HoTen.setText("");
                edt_Lop.setText("");
                edt_MSSV.setText("");
                edt_SDT.setText("");

                rg_Nam.clearCheck();
                rg_ChuyenNganh.clearCheck();
            }
        });
    }
}
