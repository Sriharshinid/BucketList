package com.example.android.bucketlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.android.bucketlist.database.DataSource;
import com.example.android.bucketlist.model.DataItem;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class completedList extends AppCompatActivity {

    List<String> itemNames = new ArrayList<>();
    DataSource mDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed_list);
        mDataSource = new DataSource(this);
        mDataSource.open();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        List<DataItem> displayList;
        String source = (getIntent().getStringExtra("Source"));
        if(source == null){
            source = "";
        }

        if(source.equals("filter")){
            displayList = getIntent().getParcelableArrayListExtra("list");
        }else{
            displayList = mDataSource.getAllItems();
        }

        if(mDataSource.getDataItemsCount() == 0){
            DataItem exampleItem = new DataItem();
            exampleItem.setItemId(UUID.randomUUID().toString());
            exampleItem.setItemName("Start Adding to Your Bucketlist");
            exampleItem.setCost(0);
            exampleItem.setTime(6);
            exampleItem.setDescription("Press the ADD ACTIVITY button to add your own goals and activities!");
            exampleItem.setPriority(5.0);
            displayList.add(exampleItem);
        }

        DataItemAdapter adapter = new DataItemAdapter(this, displayList);
        RecyclerView rView = (RecyclerView) findViewById(R.id.rvItems);
        rView.setAdapter(adapter);

    }

    @Override
    protected void onPause() {
        super.onPause();
        mDataSource.close();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mDataSource.open();
    }

    public void searchList(View view){
        Intent intent = new Intent(this, filter.class);
        startActivity(intent);

    }

    public void addActivity(View view){
        Intent intent = new Intent(this, futureList.class);
        DataItem item = new DataItem();
        item.setItemId(null);
        intent.putExtra(futureList.ITEM_KEY, item);
        startActivity(intent);
    }


}
