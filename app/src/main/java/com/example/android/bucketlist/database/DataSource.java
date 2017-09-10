package com.example.android.bucketlist.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.bucketlist.model.DataItem;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    private Context mContext;
    private SQLiteDatabase mDatabase;
    SQLiteOpenHelper mDbHelper;

    public DataSource(Context context){
        this.mContext = context;
        mDbHelper = new DBHelper((mContext));
        mDatabase = mDbHelper.getWritableDatabase();
    }

    public void open(){
        mDatabase = mDbHelper.getWritableDatabase();

    }

    public void close(){
        mDbHelper.close();
    }


    public DataItem createItem(DataItem item){
        ContentValues values = item.toValues();
        mDatabase.insert(ItemsTable.TABLE_ITEMS, null, values);
        return item;
    }

    public long getDataItemsCount(){
        return DatabaseUtils.queryNumEntries(mDatabase, ItemsTable.TABLE_ITEMS);
    }

    public void seedDatabase(List<DataItem> dataItemList){
        long numItems = getDataItemsCount();
        if(numItems==0) {
            for (DataItem item :
                    dataItemList) {
                try {
                    createItem(item);
                } catch (SQLiteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<DataItem> getAllItems(){
        List<DataItem> dataItems = new ArrayList<>();
        Cursor cursor =  mDatabase.query(ItemsTable.TABLE_ITEMS, ItemsTable.ALL_COLUMNS, null, null, null, null, ItemsTable.COLUMN_DONE);

        while(cursor.moveToNext()){
            DataItem item = new DataItem();
            item.setItemId(cursor.getString(
                    cursor.getColumnIndex(ItemsTable.COLUMN_ID)));
            item.setItemName(cursor.getString(
                    cursor.getColumnIndex(ItemsTable.COLUMN_NAME)));
            item.setDescription(cursor.getString(
                    cursor.getColumnIndex(ItemsTable.COLUMN_DESCRIPTION)));
            item.setPriority(cursor.getDouble(
                    cursor.getColumnIndex(ItemsTable.COLUMN_PRIORITY)));
            item.setpGrowth(cursor.getInt(
                    cursor.getColumnIndex(ItemsTable.COLUMN_PGROWTH)));
            item.setFoodDrink(cursor.getInt(
                    cursor.getColumnIndex(ItemsTable.COLUMN_FOOD)));
            item.setTravel(cursor.getInt(
                    cursor.getColumnIndex(ItemsTable.COLUMN_TRAVEL)));
            item.setEntertainment(cursor.getInt(
                    cursor.getColumnIndex(ItemsTable.COLUMN_ENTERTAINMENT)));
            item.setEvents(cursor.getInt(
                    cursor.getColumnIndex(ItemsTable.COLUMN_EVENTS)));
            item.setCareer(cursor.getInt(
                    cursor.getColumnIndex(ItemsTable.COLUMN_CAREER)));
            item.setRelationship(cursor.getInt(
                    cursor.getColumnIndex(ItemsTable.COLUMN_RELATIONSHIP)));
            item.setFamily(cursor.getInt(
                    cursor.getColumnIndex(ItemsTable.COLUMN_FAMILY)));
            item.setCharity(cursor.getInt(
                    cursor.getColumnIndex(ItemsTable.COLUMN_CHARITY)));
            item.setHealthFitness(cursor.getInt(
                    cursor.getColumnIndex(ItemsTable.COLUMN_HEALTH)));
            item.setCreative(cursor.getInt(
                    cursor.getColumnIndex(ItemsTable.COLUMN_CREATIVE)));
            item.setSports(cursor.getInt(
                    cursor.getColumnIndex(ItemsTable.COLUMN_SPORTS)));
            item.setCost(cursor.getInt(
                    cursor.getColumnIndex(ItemsTable.COLUMN_COST)));
            item.setTime(cursor.getInt(
                    cursor.getColumnIndex(ItemsTable.COLUMN_TIME)));
            item.setDone(cursor.getInt(
                    cursor.getColumnIndex(ItemsTable.COLUMN_DONE)));
            dataItems.add(item);
        }
        cursor.close();
        return dataItems;
    }



}
