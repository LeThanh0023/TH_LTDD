package com.example.danhsachsinhvien;

public class Student {
    private int id;
    private String name;
    private String mssv;
    private String phone;
    private String hometown;
    private int birthYear;
    private String avatar;

    public Student(int id, String name, String mssv, String phone, String hometown, int birthYear, String avatar) {
        this.id = id;
        this.name = name;
        this.mssv = mssv;
        this.phone = phone;
        this.hometown = hometown;
        this.birthYear = birthYear;
        this.avatar = avatar;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getMssv() { return mssv; }
    public String getPhone() { return phone; }
    public String getHometown() { return hometown; }
    public int getBirthYear() { return birthYear; }
    public String getAvatar() { return avatar; }
}