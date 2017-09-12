package com.example.android.bucketlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.android.bucketlist.database.DataSource;
import com.example.android.bucketlist.model.DataItem;

import java.util.ArrayList;
import java.util.List;

public class TimeFilter extends AppCompatActivity {
    DataSource ds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_filter);
        ds= new DataSource(this);
    }

    public void onSearchTime(View view){
        boolean searchable = false;
        RadioButton Lthan = (RadioButton) findViewById(R.id.lessThan);
        RadioButton eTo = (RadioButton) findViewById(R.id.equalTo);
        RadioButton Gthan = (RadioButton) findViewById(R.id.greaterThan);
        Spinner tFilter = (Spinner) findViewById(R.id.timeSelection);
        int searchValue= -1;
        if(tFilter.getSelectedItem().toString().equals(futureList.TIME_OPTIONS[0])) {
            Toast.makeText(this, "A duration must be selected.", Toast.LENGTH_SHORT).show();
        }else{
            searchable =true;
            searchValue = tFilter.getSelectedItemPosition();
        }

        List<DataItem> queriedList = new ArrayList<>();

        List<DataItem> allItems = ds.getAllItems();

        if(Lthan.isChecked()){
            for (DataItem item:allItems) {
                if(item.getTime() != 0 && item.getTime() < searchValue ){
                    queriedList.add(item);
                }
            }
        }else if(eTo.isChecked()){
            for (DataItem item:allItems) {
                if(item.getTime() != 0 && item.getTime() == searchValue ){
                    queriedList.add(item);
                }
            }

        }else if(Gthan.isChecked()){
            for (DataItem item:allItems) {
                if(item.getTime() != 0 && item.getTime() > searchValue ){
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
