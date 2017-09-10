package com.example.android.bucketlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.android.bucketlist.database.DataSource;
import com.example.android.bucketlist.model.DataItem;

import java.util.ArrayList;
import java.util.List;

public class PriorityFilter extends AppCompatActivity {

    DataSource ds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_priority_filter);
        ds = new DataSource(this);
    }

    public void onSearchPriority(View view){
        boolean searchable = true;
        RadioButton Lthan = (RadioButton) findViewById(R.id.LThan);
        RadioButton eTo = (RadioButton) findViewById(R.id.ETo);
        RadioButton Gthan = (RadioButton) findViewById(R.id.GThan);

        double searchValue = 0.0;
        List<DataItem> queriedList = new ArrayList<>();

        List<DataItem> allItems = ds.getAllItems();

        if(Lthan.isChecked()){
            for (DataItem item:allItems) {
                if(item.getPriority() < searchValue ){
                    queriedList.add(item);
                }
            }
        }else if(eTo.isChecked()){
            for (DataItem item:allItems) {
                if(item.getPriority() == searchValue ){
                    queriedList.add(item);
                }
            }

        }else if(Gthan.isChecked()){
            for (DataItem item:allItems) {
                if(item.getPriority() > searchValue ){
                    queriedList.add(item);
                }
            }

        }else{
            Toast.makeText(this, "Must choose either less than, equal to, or greater than.", Toast.LENGTH_SHORT).show();
            searchable = false;
        }

        if(searchable) {
            Intent intent = new Intent(this, completedList.class);
            intent.putExtra("Source", "filter");
            intent.putExtra("list", (ArrayList<DataItem>) queriedList);
            startActivity(intent);
        }

    }




}
