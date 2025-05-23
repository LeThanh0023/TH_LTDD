package com.example.danhsachsinhvien;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StudentDetailActivity extends AppCompatActivity {
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);

        dbHelper = new DatabaseHelper(this);

        int studentId = getIntent().getIntExtra("student_id", -1);
        Student student = dbHelper.getStudentById(studentId);

        if (student != null) {
            ImageView imageDetailAvatar = findViewById(R.id.imageDetailAvatar);
            TextView textDetailName = findViewById(R.id.textDetailName);
            TextView textDetailMSSV = findViewById(R.id.textDetailMSSV);
            TextView textDetailPhone = findViewById(R.id.textDetailPhone);
            TextView textDetailHometown = findViewById(R.id.textDetailHometown);
            TextView textDetailBirthYear = findViewById(R.id.textDetailBirthYear);

            textDetailName.setText(getString(R.string.student_name) + ": " + student.getName());
            textDetailMSSV.setText(getString(R.string.student_id) + ": " + student.getMssv());
            textDetailPhone.setText(getString(R.string.student_phone) + ": " + student.getPhone());
            textDetailHometown.setText(getString(R.string.student_hometown) + ": " + student.getHometown());
            textDetailBirthYear.setText(getString(R.string.student_birth_year) + ": " + student.getBirthYear());

            int resId = getResources().getIdentifier(student.getAvatar(), "drawable", getPackageName());
            if (resId != 0) {
                imageDetailAvatar.setImageResource(resId);
            } else {
                imageDetailAvatar.setImageResource(R.drawable.null_avatar);
            }
        }
    }
}