package com.example.listviewstudent;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
public class StudentAdapter extends ArrayAdapter<Student> {
    private Context context;
    private int resource;
    private List<Student> students;

    public StudentAdapter(Context context, int resource, List<Student> students) {
        super(context, resource, students);
        this.context = context;
        this.resource = resource;
        this.students = students;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(resource, parent, false);
        }

        ImageView imgAvatar = convertView.findViewById(R.id.imgAvatar);
        TextView tvName = convertView.findViewById(R.id.tvName);
        TextView tvMssv = convertView.findViewById(R.id.tvMssv);

        Student student = students.get(position);
        tvName.setText(student.getName());
        tvMssv.setText(student.getMssv());

        Bitmap bitmap = BitmapFactory.decodeByteArray(student.getAvatar(), 0, student.getAvatar().length);
        imgAvatar.setImageBitmap(bitmap);

        return convertView;
    }
}
