package com.example.danhsachsinhvien;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listViewStudents;
    private DatabaseHelper dbHelper;
    private StudentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewStudents = findViewById(R.id.listViewStudents);
        dbHelper = new DatabaseHelper(this);

        List<Student> studentList = dbHelper.getAllStudents();
        adapter = new StudentAdapter(this, studentList);
        listViewStudents.setAdapter(adapter);

        listViewStudents.setOnItemClickListener((parent, view, position, id) -> {
            Student selectedStudent = (Student) parent.getItemAtPosition(position);
            Intent intent = new Intent(MainActivity.this, StudentDetailActivity.class);
            intent.putExtra("student_id", selectedStudent.getId());
            startActivity(intent);
        });
    }
}