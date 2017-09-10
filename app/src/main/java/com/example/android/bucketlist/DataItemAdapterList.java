package com.example.android.bucketlist;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.android.bucketlist.model.DataItem;

import java.util.List;


public class DataItemAdapterList extends ArrayAdapter<DataItem> {

    List<DataItem> mDataItems;
    LayoutInflater mInflater;
    public DataItemAdapterList(Context context, List<DataItem> objects) {
        super(context, R.layout.list_item, objects);
        mDataItems = objects;
        mInflater = LayoutInflater.from(context);
    }

    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = mInflater.inflate(R.layout.list_item, parent, false);
        }

        CheckBox tvName = (CheckBox) convertView.findViewById(R.id.ActNameCheck);
        TextView tvCat = (TextView) convertView.findViewById(R.id.category);
        TextView tvCost = (TextView) convertView.findViewById(R.id.Cost);
        TextView tvTime = (TextView) convertView.findViewById(R.id.Time);

        DataItem item = mDataItems.get(position);

        tvName.setText(item.getItemName());
        tvCat.setText("Category: " + item.getPriority());
        tvCost.setText("Cost: " + item.getCost());
        tvTime.setText("Time: " + item.getTime());

        return convertView;

    }
}
