package com.example.android.bucketlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.android.bucketlist.model.DataItem;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }

    public void futureScreen(View view){
        Intent intent = new Intent(this, futureList.class);
        DataItem item = new DataItem();
        item.setItemId(null);
        intent.putExtra(futureList.ITEM_KEY, item);
        startActivity(intent);
    }

    public void completedScreen(View view){
        Intent intent = new Intent(this, completedList.class);
        intent.putExtra("Source", "homePage");
        startActivity(intent);
    }

}
