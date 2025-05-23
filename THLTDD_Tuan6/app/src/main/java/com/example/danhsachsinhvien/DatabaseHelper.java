package com.example.danhsachsinhvien;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "StudentDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_STUDENTS = "students";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_MSSV = "mssv";
    private static final String KEY_PHONE = "phone";
    private static final String KEY_HOMETOWN = "hometown";
    private static final String KEY_BIRTH_YEAR = "birth_year";
    private static final String KEY_AVATAR = "avatar";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_STUDENTS_TABLE = "CREATE TABLE " + TABLE_STUDENTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_NAME + " TEXT,"
                + KEY_MSSV + " TEXT,"
                + KEY_PHONE + " TEXT,"
                + KEY_HOMETOWN + " TEXT,"
                + KEY_BIRTH_YEAR + " INTEGER,"
                + KEY_AVATAR + " TEXT" + ")";
        db.execSQL(CREATE_STUDENTS_TABLE);

        insertSampleData(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENTS);
        onCreate(db);
    }

    private void insertSampleData(SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, "Trần Văn A");
        values.put(KEY_MSSV, "21200111");
        values.put(KEY_PHONE, "0123456789");
        values.put(KEY_HOMETOWN, "Bình Định");
        values.put(KEY_BIRTH_YEAR, 2003);
        values.put(KEY_AVATAR, "a");
        db.insert(TABLE_STUDENTS, null, values);

        values.clear();
        values.put(KEY_NAME, "Lê Văn B");
        values.put(KEY_MSSV, "21200222");
        values.put(KEY_PHONE, "0987654321");
        values.put(KEY_HOMETOWN, "Tây Ninh");
        values.put(KEY_BIRTH_YEAR, 2005);
        values.put(KEY_AVATAR, "b");
        db.insert(TABLE_STUDENTS, null, values);

        values.clear();
        values.put(KEY_NAME, "Lê Thị C");
        values.put(KEY_MSSV, "21200333");
        values.put(KEY_PHONE, "0966666666");
        values.put(KEY_HOMETOWN, "Hà Nội");
        values.put(KEY_BIRTH_YEAR, 2002);
        values.put(KEY_AVATAR, "c");
        db.insert(TABLE_STUDENTS, null, values);

        values.clear();
        values.put(KEY_NAME, "Phan Văn D");
        values.put(KEY_MSSV, "21200444");
        values.put(KEY_PHONE, "0123456799");
        values.put(KEY_HOMETOWN, "TP.HCM");
        values.put(KEY_BIRTH_YEAR, 2003);
        values.put(KEY_AVATAR, "d");
        db.insert(TABLE_STUDENTS, null, values);

        values.clear();
        values.put(KEY_NAME, "Phạm Thị E");
        values.put(KEY_MSSV, "21200555");
        values.put(KEY_PHONE, "0909090909");
        values.put(KEY_HOMETOWN, "Tiền Giang");
        values.put(KEY_BIRTH_YEAR, 2003);
        values.put(KEY_AVATAR, "e");
        db.insert(TABLE_STUDENTS, null, values);

        values.clear();
        values.put(KEY_NAME, "Hồ Văn F");
        values.put(KEY_MSSV, "21200666");
        values.put(KEY_PHONE, "0902345556");
        values.put(KEY_HOMETOWN, "An Giang");
        values.put(KEY_BIRTH_YEAR, 2003);
        values.put(KEY_AVATAR, "f");
        db.insert(TABLE_STUDENTS, null, values);
    }

    public List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_STUDENTS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(KEY_ID));
                String name = cursor.getString(cursor.getColumnIndexOrThrow(KEY_NAME));
                String mssv = cursor.getString(cursor.getColumnIndexOrThrow(KEY_MSSV));
                String phone = cursor.getString(cursor.getColumnIndexOrThrow(KEY_PHONE));
                String hometown = cursor.getString(cursor.getColumnIndexOrThrow(KEY_HOMETOWN));
                int birthYear = cursor.getInt(cursor.getColumnIndexOrThrow(KEY_BIRTH_YEAR));
                String avatar = cursor.getString(cursor.getColumnIndexOrThrow(KEY_AVATAR));

                Student student = new Student(id, name, mssv, phone, hometown, birthYear, avatar);
                studentList.add(student);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return studentList;
    }

    public Student getStudentById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_STUDENTS, new String[]{KEY_ID, KEY_NAME, KEY_MSSV, KEY_PHONE, KEY_HOMETOWN, KEY_BIRTH_YEAR, KEY_AVATAR},
                KEY_ID + "=?", new String[]{String.valueOf(id)}, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            Student student = new Student(
                    cursor.getInt(cursor.getColumnIndexOrThrow(KEY_ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(KEY_NAME)),
                    cursor.getString(cursor.getColumnIndexOrThrow(KEY_MSSV)),
                    cursor.getString(cursor.getColumnIndexOrThrow(KEY_PHONE)),
                    cursor.getString(cursor.getColumnIndexOrThrow(KEY_HOMETOWN)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(KEY_BIRTH_YEAR)),
                    cursor.getString(cursor.getColumnIndexOrThrow(KEY_AVATAR))
            );
            cursor.close();
            db.close();
            return student;
        }
        if (cursor != null) {
            cursor.close();
        }
        db.close();
        return null;
    }
}