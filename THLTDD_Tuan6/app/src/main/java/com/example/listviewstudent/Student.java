package com.example.listviewstudent;

public class Student {
    private int id;
    private String name;
    private String mssv;
    private byte[] avatar; // Lưu ảnh dạng byte array

    public Student(int id, String name, String mssv, byte[] avatar) {
        this.id = id;
        this.name = name;
        this.mssv = mssv;
        this.avatar = avatar;
    }

    // Getter và Setter
    public int getId() { return id; }
    public String getName() { return name; }
    public String getMssv() { return mssv; }
    public byte[] getAvatar() { return avatar; }
}

