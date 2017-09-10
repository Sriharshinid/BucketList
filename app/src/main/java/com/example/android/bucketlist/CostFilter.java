package com.example.android.bucketlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.android.bucketlist.database.DataSource;
import com.example.android.bucketlist.model.DataItem;

import java.util.ArrayList;
import java.util.List;

public class CostFilter extends AppCompatActivity {

    DataSource ds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cost_filter);
        ds = new DataSource(this);
    }



    public void onSearchCost(View view){
        boolean searchable = false;


       RadioButton Lthan = (RadioButton) findViewById(R.id.lThan);
        RadioButton eTo = (RadioButton) findViewById(R.id.eTo);
        RadioButton Gthan = (RadioButton) findViewById(R.id.gThan);
        EditText cFilter = (EditText) findViewById(R.id.costSearch);
        int searchValue= -1;
        if(cFilter.getText().toString().equals("")) {
            Toast.makeText(this, "A numeric value must be entered", Toast.LENGTH_SHORT).show();
        }else{
            searchable =true;
            searchValue = Integer.parseInt(cFilter.getText().toString());
        }

        List<DataItem> queriedList = new ArrayList<>();

        List<DataItem> allItems = ds.getAllItems();

        if(Lthan.isChecked()){
                for (DataItem item:allItems) {
                    if(item.getCost()  != -1 && item.getCost() < searchValue ){
                        queriedList.add(item);
                    }
                }
        }else if(eTo.isChecked()){
            for (DataItem item:allItems) {
                if(item.getCost()  != -1 && item.getCost() == searchValue ){
                    queriedList.add(item);
                }
            }

        }else if(Gthan.isChecked()){
            for (DataItem item:allItems) {
                if(item.getCost()  != -1 && item.getCost() > searchValue ){
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


