package com.example.android.bucketlist.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.bucketlist.model.DataItem;

import java.util.ArrayList;
import java.util.List;

import static com.example.android.bucketlist.Sample.SampleDataProvider.dataItemList;
import static com.example.android.bucketlist.database.ItemsTable.COLUMN_DONE;
import static com.example.android.bucketlist.database.ItemsTable.COLUMN_ID;


public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_FILE_NAME = "bucketlist.db";
    public static final int DB_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DB_FILE_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ItemsTable.SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        List<DataItem> dataItems1 = new ArrayList<>();
        Cursor cursor = db.query(ItemsTable.TABLE_ITEMS, ItemsTable.ALL_COLUMNS, null, null, null, null, ItemsTable.COLUMN_NAME);

        while (cursor.moveToNext()) {
            DataItem item = new DataItem();
            item.setItemId(cursor.getString(
                    cursor.getColumnIndex(COLUMN_ID)));
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
                    cursor.getColumnIndex(COLUMN_DONE)));
            dataItems1.add(item);
        }
        cursor.close();
        db.execSQL(ItemsTable.SQL_DELETE);
        onCreate(db);

        for (DataItem item :
                dataItemList) {
            try {
                ContentValues values = item.toValues();
                db.insert(ItemsTable.TABLE_ITEMS, null, values);
            } catch (SQLiteException e) {
                e.printStackTrace();
            }
        }
    }

    public void changeChecked(String _id, int newDone, int oldDone){

        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + ItemsTable.TABLE_ITEMS + " SET " + ItemsTable.COLUMN_DONE + " = '" + newDone + "' WHERE " + ItemsTable.COLUMN_ID + " = '" + _id + "'" + "AND " + ItemsTable.COLUMN_DONE + " = '" + oldDone + "'";
        db.execSQL(query);

    }

    public void delete(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ItemsTable.TABLE_ITEMS +" where " + ItemsTable.COLUMN_ID + " = '"+id+"'");
    }
}
