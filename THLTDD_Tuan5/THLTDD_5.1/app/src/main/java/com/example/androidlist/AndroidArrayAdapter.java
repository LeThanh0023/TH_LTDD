package com.example.androidlist;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AndroidArrayAdapter extends ArrayAdapter<Versions> {
    private static final String TAG = "AndroidArrayAdapter";
    private List<Versions> androidList = new ArrayList<Versions>();

    static class VersionViewHolder {
        ImageView versionImg;
        TextView versionName;
        TextView version;
    }

    public AndroidArrayAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    @Override
    public void add(Versions object) {
        androidList.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return this.androidList.size();
    }

    @Override
    public Versions getItem(int index) {
        return this.androidList.get(index);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        VersionViewHolder viewHolder;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.row_activity, parent, false);
            viewHolder = new VersionViewHolder();
            viewHolder.versionImg = (ImageView) row.findViewById(R.id.versionImg);
            viewHolder.versionName = (TextView) row.findViewById(R.id.versionName);
            viewHolder.version = (TextView) row.findViewById(R.id.version);
            row.setTag(viewHolder);
        } else {
            viewHolder = (VersionViewHolder) row.getTag();
        }
        Versions versions = getItem(position);
        viewHolder.versionImg.setImageResource(versions.getVersionImg());
        viewHolder.versionName.setText(versions.getVersionName());
        viewHolder.version.setText(versions.getVersion());
        return row;
    }

    public Bitmap decodeToBitmap(byte[] decodedByte) {
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }
}