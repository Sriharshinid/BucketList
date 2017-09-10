package com.example.android.bucketlist.database;


import android.content.Context;

import com.example.android.bucketlist.model.DataItem;

import java.util.ArrayList;
import java.util.List;

public class dbManager {

    DataSource mDataSource;
    List<DataItem> mDataItemList;

    public dbManager(Context context){
        mDataSource = new DataSource(context);
        mDataItemList = new ArrayList<>();
    }


    public void insert(DataItem item){

    }

    public void delete(){

    }

    public void giveData(){

    }


}
