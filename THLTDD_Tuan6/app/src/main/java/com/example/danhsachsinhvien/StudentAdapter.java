package com.example.danhsachsinhvien;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class StudentAdapter extends ArrayAdapter<Student> {
    private Context context;
    private List<Student> students;

    public StudentAdapter(Context context, List<Student> students) {
        super(context, 0, students);
        this.context = context;
        this.students = students;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_student, parent, false);
        }

        Student student = students.get(position);

        ImageView imageAvatar = view.findViewById(R.id.imageAvatar);
        TextView textName = view.findViewById(R.id.textName);
        TextView textMSSV = view.findViewById(R.id.textMSSV);

        textName.setText(student.getName());
        textMSSV.setText(student.getMssv());

        int resId = context.getResources().getIdentifier(student.getAvatar(), "drawable", context.getPackageName());
        if (resId != 0) {
            imageAvatar.setImageResource(resId);
        } else {
            imageAvatar.setImageResource(R.drawable.null_avatar);
        }

        return view;
    }
}