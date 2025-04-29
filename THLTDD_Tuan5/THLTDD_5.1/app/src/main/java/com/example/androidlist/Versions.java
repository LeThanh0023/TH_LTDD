package com.example.androidlist;

public class Versions {
    private static final String TAG = "Versions";

    private int versionImg;
    private String versionName;
    private String version;

    public Versions(int versionImg, String versionName,String version) {
        super();
        this.setVersionImg(versionImg);
        this.setVersionName(versionName);
        this.setVersion(version);
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public int getVersionImg() {
        return versionImg;
    }

    public void setVersionImg(int versionImg) {
        this.versionImg = versionImg;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}