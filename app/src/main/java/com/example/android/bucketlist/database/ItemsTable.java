package com.example.android.bucketlist.database;



public class ItemsTable {
    public static final String TABLE_ITEMS = "items";
    public static final String COLUMN_ID = "itemId";
    public static final String COLUMN_NAME = "itemName";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_PRIORITY = "priority";
    public static final String COLUMN_PGROWTH = "personalGrowth";
    public static final String COLUMN_FOOD = "foodDrink";
    public static final String COLUMN_TRAVEL = "travel";
    public static final String COLUMN_ENTERTAINMENT = "entertainment";
    public static final String COLUMN_EVENTS = "events";
    public static final String COLUMN_CAREER = "career";
    public static final String COLUMN_RELATIONSHIP = "relationship";
    public static final String COLUMN_FAMILY = "family";
    public static final String COLUMN_CHARITY = "charity";
    public static final String COLUMN_HEALTH = "health";
    public static final String COLUMN_CREATIVE = "creative";
    public static final String COLUMN_SPORTS = "sports";
    public static final String COLUMN_COST = "cost";
    public static final String COLUMN_TIME = "time";
    public static final String COLUMN_DONE = "done";
    public static final String[] ALL_COLUMNS =
            {COLUMN_ID, COLUMN_NAME, COLUMN_DESCRIPTION,
                    COLUMN_PRIORITY, COLUMN_PGROWTH, COLUMN_FOOD, COLUMN_TRAVEL, COLUMN_ENTERTAINMENT,
                    COLUMN_EVENTS, COLUMN_CAREER, COLUMN_RELATIONSHIP, COLUMN_FAMILY, COLUMN_CHARITY,
                    COLUMN_HEALTH, COLUMN_CREATIVE, COLUMN_SPORTS, COLUMN_COST,
                    COLUMN_TIME, COLUMN_DONE};


    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_ITEMS + "(" +
                    COLUMN_ID + " TEXT PRIMARY KEY," +
                    COLUMN_NAME + " TEXT," +
                    COLUMN_DESCRIPTION + " TEXT," +
                    COLUMN_PRIORITY + " REAL," +
                    COLUMN_PGROWTH + " INTEGER," +
                    COLUMN_FOOD + " INTEGER," +
                    COLUMN_TRAVEL + " INTEGER," +
                    COLUMN_ENTERTAINMENT + " INTEGER," +
                    COLUMN_EVENTS + " INTEGER," +
                    COLUMN_CAREER + " INTEGER," +
                    COLUMN_RELATIONSHIP + " INTEGER," +
                    COLUMN_FAMILY + " INTEGER," +
                    COLUMN_CHARITY + " INTEGER," +
                    COLUMN_HEALTH + " INTEGER," +
                    COLUMN_CREATIVE + " INTEGER," +
                    COLUMN_SPORTS + " INTEGER," +
                    COLUMN_COST + " INTEGER," +
                    COLUMN_TIME + " INTEGER," +
                    COLUMN_DONE + " INTEGER" + ");";
    public static final String SQL_DELETE =
            "DROP TABLE " + TABLE_ITEMS;
}
