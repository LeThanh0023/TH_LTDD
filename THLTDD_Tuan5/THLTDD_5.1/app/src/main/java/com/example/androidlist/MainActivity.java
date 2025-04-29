package com.example.androidlist;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private static final String TAG = "ListViewActivity";

    private AndroidArrayAdapter androidArrayAdapter;
    private ListView listView;

    private static int colorIndex;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        colorIndex = 0;
        listView = (ListView) findViewById(R.id.listView);
        androidArrayAdapter = new AndroidArrayAdapter(getApplicationContext(), R.layout.row_activity);
        listView.setAdapter(androidArrayAdapter);

        List<String[]> androidList = readData();
        for(String[] androidData:androidList ) {
            String versionImg = androidData[0];
            String versionName = androidData[1];
            String version = androidData[2];
            int androidImgResId = getResources().getIdentifier(versionImg, "drawable", "com.example.androidlist");

            Versions versions = new Versions(androidImgResId,versionName,version);
            androidArrayAdapter.add(versions);
        }
    }

    public List<String[]> readData(){
        List<String[]> resultList = new ArrayList<String[]>();

        String[] android1 = new String[3];
        android1[0] = "pie";
        android1[1] = "Android Pie";
        android1[2] = "Version 9";
        resultList.add(android1);

        String[] android2 = new String[3];
        android2[0] = "banana";
        android2[1] = "Android Banana Bread";
        android2[2] = "Version 4.0 - 4.0.4";
        resultList.add(android2);


        String[] android3 = new String[3];
        android3[0] = "cupcake";
        android3[1] = "Android Cupcake";
        android3[2] = "Version 1.5";
        resultList.add(android3);

        String[] android4 = new String[3];
        android4[0] = "donut";
        android4[1] = "Android Donut";
        android4[2] = "Version 1.6";
        resultList.add(android4);


        String[] android5 = new String[3];
        android5[0] = "eclair";
        android5[1] = "Android Eclair";
        android5[2] = "Version 2.0 - 2.1";
        resultList.add(android5);

        String[] android6 = new String[3];
        android6[0] = "froyo";
        android6[1] = "Android Froyo";
        android6[2] = "Version 2.2 - 2.2.3";
        resultList.add(android6);

        String[] android7 = new String[3];
        android7[0] = "gingerbread";
        android7[1] = "Android GingerBread";
        android7[2] = "Version 2.3 - 2.3.7";
        resultList.add(android7);

        String[] android8 = new String[3];
        android8[0] = "honeycomb";
        android8[1] = "Android Honeycomb";
        android8[2] = "Version 3.0 - 3.2.6";
        resultList.add(android8);


        return  resultList;
    }

}