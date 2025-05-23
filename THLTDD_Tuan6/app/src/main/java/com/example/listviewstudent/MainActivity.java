package com.example.listviewstudent;

import android.app.AlertDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    StudentAdapter adapter;
    List<Student> studentList;
    DBHelper dbHelper;

    private long lastClickTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        dbHelper = new DBHelper(this);

        if (dbHelper.getAllStudents().isEmpty()) {
            byte[] sampleAvatar = imageToByte(BitmapFactory.decodeResource(getResources(), R.drawable.sample_avatar));
            dbHelper.insertStudent(new Student(0, "Nguyễn Văn A", "B1900001", sampleAvatar));
        }

        studentList = dbHelper.getAllStudents();
        adapter = new StudentAdapter(this, R.layout.item_student, studentList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastClickTime < 400) {
                showDetail(studentList.get(position));
            }
            lastClickTime = currentTime;
        });
    }

    private byte[] imageToByte(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }

    private void showDetail(Student student) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Chi tiết sinh viên");
        builder.setMessage("Họ tên: " + student.getName() + "\nMSSV: " + student.getMssv());
        builder.setPositiveButton("OK", null);
        builder.show();
    }
}
